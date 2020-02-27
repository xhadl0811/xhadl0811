package com.mycompany.myapp.Controllers;

import java.security.Principal;
import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.myapp.Mappers.userMapper;

@Controller
public class UpdateController {
	
	@Autowired
	userMapper uMapper;
	@InitBinder
	public void InitBinder(WebDataBinder dataBinder) { // input 공백처리
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/mypage/changeEmail")
	public String changeIdPage() {
		return "update/changeEmail";
	}



	@PostMapping("/mypage/changeEmail/check")
	public String changeIdCheck(Model model,Principal pri ,RedirectAttributes flash ,
			@ModelAttribute(value="originalEmail")String originalEmail,
			@ModelAttribute("newEmail")String newEmail,
			@ModelAttribute("password")String password) {
		String realEmail = pri.getName();
		String realPassword =uMapper.getPassword(realEmail);
		if(realEmail.equals(originalEmail)&&realPassword.equals(password)) {
			
			@SuppressWarnings("unchecked") //이메일 변경에 따른 현재 시큐리티 정보 변경
			Collection<SimpleGrantedAuthority> nowAuthorities =(Collection<SimpleGrantedAuthority>)SecurityContextHolder.getContext().getAuthentication().getAuthorities();
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(newEmail, password, nowAuthorities);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			uMapper.updateEmailAUTHORITIES(newEmail, realEmail);
			uMapper.updateEmail(newEmail, realEmail);
			return "redirect:/mypage";
		}
		flash.addFlashAttribute("errorMSG" , "이메일 혹은 비밀번호가 맞지 않습니다.");
		return "redirect:/mypage/changeEmail";
	}
	
	
	@GetMapping("mypage/changePW")
		public String changePWPage() {
		
			return "update/changePW";
	}
	
	@PostMapping("/mypage/changePW/check")
	public String changePWcheck(Principal pri,RedirectAttributes flash,
			@ModelAttribute ("originalPW") String originalPW,
			@ModelAttribute ("newPW1") String newPW1,
			@ModelAttribute ("newPW2") String newPW2){ //기존비밀번호  - 새 비번 - 재확인
		if(newPW1==null) {
			flash.addFlashAttribute("errorMSG","변경할 비밀번호를 입력해주세요.");
			return "redirect:/mypage/changePW";
		}
		String realPW = uMapper.getPassword(pri.getName());
		if(realPW.equals(originalPW)&&newPW1.equals(newPW2)) {
			uMapper.updatePassword(newPW1,pri.getName());
			return "redirect:/mypage";
		}
	
		if(!realPW.equals(originalPW))
			flash.addFlashAttribute("errorMSG","기존의 비밀번호가 일치하지 않습니다.");
		else if(newPW1==null||!newPW1.equals(newPW2))
			flash.addFlashAttribute("errorMSG","비밀번호 재입력을 확인해주세요.");	
		return "redirect:/mypage/changePW";
	}
	
	@GetMapping("mypage/changeNickname") // 기존닉네임 띄워놓고 - 새 닉네임 - 비밀번호
	public String changeNicknamePage(Model model,Principal pri){
		model.addAttribute("originalNickname",uMapper.getNickname(pri.getName()));
		return "/update/changeNickname";
	}
	
	@PostMapping("/mypage/changeNickname/check")
	public String changeNicknameCheck(Principal pri ,RedirectAttributes flash,
			@ModelAttribute("newNickname")String newNickname , 
			@ModelAttribute("checkPW")String checkPW) {
		String realPW = uMapper.getPassword(pri.getName());
		System.out.println(checkPW+"  "+realPW);
		if(realPW.equals(checkPW)) {
			System.out.println("22");
			uMapper.updateNickname(newNickname,pri.getName());
			return "redirect:/mypage";
		}
		flash.addFlashAttribute("errorMSG","비밀번호가 일치하지 않습니다.");
		return "redirect:/mypage/changeNickname";
	}
	
	
	
	
	@GetMapping("mypage/withdraw")
	public String withdrawPage(Principal pri,HttpSession session) { //이메일 - 비밀번호 - 탈퇴
		uMapper.deleteUserByEmail(pri.getName());
		uMapper.deleteAuthorities(pri.getName());

		System.out.println(pri.getName()+" 	is withdraw");
		session.invalidate(); 
		return "redirect:/";
	}
}
