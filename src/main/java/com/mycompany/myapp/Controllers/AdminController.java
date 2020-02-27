package com.mycompany.myapp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.myapp.Helper.pageHelper;
import com.mycompany.myapp.Mappers.pagingMapper;
import com.mycompany.myapp.Mappers.productMapper;
import com.mycompany.myapp.Mappers.userMapper;
import com.mycompany.myapp.VO.Product;
import com.mycompany.myapp.VO.User;

@Controller
public class AdminController {
	@Autowired 
	userMapper uMapper;
	@Autowired
	productMapper pMapper;
	@Autowired
	pagingMapper pageMapper;
	
	@RequestMapping(value="/admin" , method=RequestMethod.GET)
	public String adminPage() {
		return "/admin/admin";
	}
	
	/////
	@RequestMapping(value="/admin/userList" , method=RequestMethod.GET)
	public String userList(@RequestParam(value="page" , defaultValue= "1" , required=false) int nowPage ,Model model) {
		pageHelper pHelper = new pageHelper(pageMapper.getAllproduct(),nowPage);//페이징
		int startPage=pHelper.getStartPage();
		int endPage=pHelper.getEndPage();
		List<User> user = pageMapper.getUser(pHelper.getStartPost()-1);	
			model.addAttribute("nowPage",nowPage);
			model.addAttribute("startPage",startPage);
			model.addAttribute("endPage",endPage);
			model.addAttribute("allPage",pHelper.getAllPage());		
			model.addAttribute("user",user);	
		return "/admin/userList";
	}
	@RequestMapping(value="/admin/userList/delete" , method=RequestMethod.GET)
	public String deleteUser(@RequestParam(value="id") int id , @RequestParam("email") String email) { //유저 삭제
		uMapper.deleteUser(id);
		uMapper.deleteAuthorities(email);
		System.out.println("Delete User email\n\t "+email+"\n\t id = "+id);
		return "redirect:/admin/userList";
	}
	////////상품관리
	@RequestMapping(value="/admin/userList/enabled") // 계정 활성 및 비활성화
	public String changeEnabled(@RequestParam("enabled")Boolean enabled,@RequestParam("id")int id) {
		uMapper.changeEnabled(enabled, id);
		return "redirect:/admin/userList";
	}
	
	@RequestMapping("/admin/productList")
	public String productList(@RequestParam(value="page",defaultValue="1",required=false) int nowPage,Model model) {
		pageHelper pHelper = new pageHelper(pageMapper.getAllproduct(),nowPage);//페이징
		int startPage=pHelper.getStartPage();
		int endPage=pHelper.getEndPage();
		List<Product> products = pageMapper.getProduct(pHelper.getStartPost()-1);
			model.addAttribute("nowPage",nowPage);
			model.addAttribute("startPage",startPage);
			model.addAttribute("endPage",endPage);
			model.addAttribute("allPage",pHelper.getAllPage());		
			model.addAttribute("products",products);
		return "/admin/productList";
	}
	
	@RequestMapping("/admin/productList/delete") //상품삭제
	public String deleteProduct(@RequestParam int id) {
		pMapper.deleteProduct(id);
		return "redirect:/admin/productList";
	}
	
}
