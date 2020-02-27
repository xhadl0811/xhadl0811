package com.mycompany.myapp.Controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myapp.Mappers.productMapper;
import com.mycompany.myapp.VO.Product;

@Controller
public class BuyController{
	
	@Autowired
	productMapper pMapper;

	public boolean checkisSelling(int id , String  pri) {
		return !pMapper.isSelling(id)||!pri.equals(pMapper.getAuthor(id));		
	}
	
	@PreAuthorize("this.checkisSelling(#id,authentication.principal.username)") //상품이 판매되었는지 , 자기 자신의 상품인지 확인
	@RequestMapping(value = "/buy/product/{id}",method=RequestMethod.GET)
	public String buyingPage(@PathVariable int id ,Model model,   //상품 구매 화면
			Principal principal) {		
		Product product = pMapper.getListById(id);
		model.addAttribute("product",product);
	    return "/noTiles/noTiles/buy";
	}
	
	@RequestMapping(value="/successPay" , method=RequestMethod.GET) //결제 성공 시 보여질 페이지(jquery에서 성공시 성공세션 줌)
	public String successPay(@ModelAttribute("id") int id , 
			Model model ,Principal pri , HttpServletRequest request)  {		
		Boolean isSuccess = (Boolean)request.getSession().getAttribute("isSuccess"); //
		if(isSuccess == null ) // 결제 미완료 
			return "redirect:/";		
		request.getSession().removeAttribute("isSuccess");
		Product product = pMapper.getListById(id);
		model.addAttribute("product",product); //결제완료된 상품 정보
		pMapper.successPay(id,pri.getName()); //판매완료 처리 및 구매자 저장
		return "/resultPay";
	}
	

	
	
	
}
