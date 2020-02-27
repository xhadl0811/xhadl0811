	package com.mycompany.myapp.Controllers;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.myapp.Helper.FileHelper;
import com.mycompany.myapp.Helper.pageHelper;
import com.mycompany.myapp.Helper.timeHelper;
import com.mycompany.myapp.Mappers.pagingMapper;
import com.mycompany.myapp.Mappers.productMapper;
import com.mycompany.myapp.Mappers.userMapper;
import com.mycompany.myapp.VO.Product;

@Controller
public class MainController {
	
	@Autowired
	productMapper pMapper;
	
	@Autowired
	userMapper uMapper;
	
	@Autowired 
	pagingMapper pageMapper;
	
	public boolean checkAuthor(int id,String pri) {
		if(pMapper.getEmail(id).equals(pri))
			return true;
		return false;
	}
	
	@InitBinder
	public void InitBinder(WebDataBinder dataBinder) { // input 공백처리
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	
	@RequestMapping(value="/" , method=RequestMethod.GET)
	public String index(Model model,@RequestParam(value = "page" , defaultValue = "1" ) int nowPage) {
		pageHelper pHelper = new pageHelper(pageMapper.getAllproduct(),nowPage);//페이징
		int startPage=pHelper.getStartPage();
		int endPage=pHelper.getEndPage();
			model.addAttribute("nowPage",nowPage);
			model.addAttribute("startPage",startPage);
			model.addAttribute("endPage",endPage);
			model.addAttribute("allPage",pHelper.getAllPage());
		List<Product> products = pageMapper.getProduct(pHelper.getStartPost()-1);
		model.addAttribute("products",products);
		return "/index";
	}
	
	
	
	
	@RequestMapping(value="/addProduct" , method=RequestMethod.GET)
	public String addProduct(Model model) {
			if(!model.containsAttribute("pd")) {
				model.addAttribute("product",new Product());
			}
			
		return "/addProduct";
	}
	
	

	@RequestMapping(value="/addProduct" , method=RequestMethod.POST)
	public String successAddProduct( @Valid@ModelAttribute Product product ,BindingResult result,
			 RedirectAttributes flash,Principal principal,
			 @RequestParam("file11") MultipartFile file1,
			 @RequestParam("file22") MultipartFile file2,
			 @RequestParam("file33") MultipartFile file3) {	
		
		if(result.hasErrors()) { //에러발생
			flash.addFlashAttribute("org.springframework.validation.BindingResult.product",result);
			flash.addFlashAttribute("pd",product);
			return "redirect:/addProduct";
		}
		
		FileHelper fHelper=new FileHelper(file1,file2,file3); //파일 업로드
			product.setFile1(fHelper.getFiles(1));
			product.setFile2(fHelper.getFiles(2));
			product.setFile3(fHelper.getFiles(3));
		
		product.setAuthor(principal.getName());
		product.setNickname(uMapper.getNickname(principal.getName()));
		
		timeHelper tHelper = new timeHelper();
		product.setTime(tHelper.getTime());
			
		System.out.println(product.toString());
		pMapper.addProduct(product);
		
		int authorId=pMapper.getId(product.getAuthor());
		return"redirect:/product/"+authorId;
	}
	
	
	

	@RequestMapping(value="/product/{id}" , method=RequestMethod.GET)
	public String productInfo(@PathVariable int id , Model model) {
		Product product = pMapper.getListById(id);
		if(product.getDescription()!=null) { // db에서 view로 뿌려줄때 줄바꿈처리
			product.setDescription(product.getDescription().replace("\r\n","<br/>"));
		}
		model.addAttribute("product",product);
		pMapper.addSee(id);
		return "/product";
	}
	
	

	
	@PreAuthorize("hasRole('ADMIN') or (this.checkAuthor(#id , authentication.principal.username))")
	@RequestMapping(value="/product/edit/{id}" , method=RequestMethod.GET)
	public String editProduct(@PathVariable int id,Model model) {		
		if(!model.containsAttribute("pd")) {	
			Product product=pMapper.getListById(id);
			model.addAttribute("product",product);
		}		
		return "/editProduct";
	}

	@RequestMapping(value="/product/completeEdit" , method=RequestMethod.POST)
	public String successEditProduct (@Valid@ModelAttribute Product product ,
			BindingResult result,RedirectAttributes flash,
			@RequestParam("file11") MultipartFile file1, //view의 multipart와 vo의 객체명이 같아서 file11 
			@RequestParam("file22") MultipartFile file2,
			@RequestParam("file33") MultipartFile file3) {
		
		if(result.hasErrors()) { // 에러발생
			flash.addFlashAttribute("org.springframework.validation.BindingResult.product",result);
			flash.addFlashAttribute("pd",product);
			return "redirect:/product/edit/"+product.getId();
		}
		product.setAuthor("woojin");
		System.out.println("Edited product id : "+product.getId());
		
		FileHelper fHelper=new FileHelper(file1,file2,file3);
		
		if(!file1.isEmpty()) 		
			product.setFile1(fHelper.getFiles(1));
		
		if(!file2.isEmpty())  
			product.setFile2(fHelper.getFiles(2));
		
		if(!file3.isEmpty()) 
			product.setFile3(fHelper.getFiles(3));

		pMapper.editProduct(product);
		
				
		return "redirect:/product/"+product.getId();
	} //edit without
	
	
	
	@PreAuthorize("hasRole('ADMIN') or (this.checkAuthor(#id , authentication.principal.username))")
	@RequestMapping(value="/product/delete/{id}" , method=RequestMethod.GET)
	public String deleteProduct(@PathVariable int id,Principal principal,HttpServletRequest request) {
		pMapper.deleteProduct(id);
		System.out.println("Deleted product id : "+id);
		return "redirect:/";
	}
	
	
} 



