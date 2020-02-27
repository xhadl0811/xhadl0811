package com.mycompany.myapp.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.myapp.Mappers.userMapper;
import com.mycompany.myapp.VO.User;

@Controller
public class UserController {
	@Autowired
	userMapper uMapper;
	
	@InitBinder
	public void InitBinder(WebDataBinder dataBinder) { // input 공백처리
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping(value="login")
	public String loginPage(HttpServletRequest request ,HttpServletResponse response,
			@RequestParam(value="need",defaultValue="false	") Boolean need) throws IOException {		
		if(need==true) {
			request.getSession().setAttribute("need","true");
	        response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("<script>alert('로그인이 필요한 서비스입니다.');</script>");
	        out.flush();
	        return "/login";
		}
			String referer=request.getHeader("REFERER");	
			if(referer==null||referer.contains("/login")) 
				return "/login";
			request.getSession().removeAttribute("need");
			request.getSession().setAttribute("referer",referer);
		
		return "/login";
	}
	
	@RequestMapping(value="signup", method=RequestMethod.GET)
	public String signupPage(Model model) {
		if(!model.containsAttribute("user")) 
			model.addAttribute("user",new User());
		return "/signup";
	}
	
	@RequestMapping(value="signup" , method=RequestMethod.POST)
	public String processSignup(@Valid @ModelAttribute User user ,
			BindingResult result , RedirectAttributes flash) {
		if(result.hasErrors()) { //에러발생
			flash.addFlashAttribute("user",user);
			flash.addFlashAttribute("org.springframework.validation.BindingResult.user",result);
			return "redirect:/signup";
		}
		System.out.println(user.toString());
		uMapper.insertUser(user);
		uMapper.insertAuthorities(user.getEmail(),"ROLE_USER");
		return "/login";
	}
	
	@RequestMapping(value="/mypage" , method=RequestMethod.GET)
	public String myPage(Model model,Principal pri,HttpServletRequest req) {
			String nickname = uMapper.getNickname(pri.getName());
			model.addAttribute("nickname",nickname);
			System.out.println(req.getSession().getAttribute("isSuccess"));
		return "/mypage";
	}
	
	

}
