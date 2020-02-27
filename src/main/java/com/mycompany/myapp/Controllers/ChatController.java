package com.mycompany.myapp.Controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.myapp.Mappers.userMapper;
import com.mycompany.myapp.VO.Chat;

@Controller
public class ChatController {
	@Autowired
	userMapper uMapper;
	
	public boolean isExist(String target) {
		return uMapper.getEmail(target)!=null;
	}
	
	
	@PreAuthorize("this.isExist(#target) and (authentication.principal.username!=#target)") //대화상대가 존재하는지 , 대화 상대가 본인이 아닌지 확인 
	@RequestMapping("/chat")
	public String chat(@RequestParam(value="target", required=true) String target,  //채팅 페이지로 넘어감
			HttpServletRequest request , Principal principal,Model model) {
		List<String> room = uMapper.getRoom(principal.getName());
		if (!room.contains(target))
			uMapper.setRoom(principal.getName(), target);	
		request.getSession().setAttribute("principal",principal.getName());
		request.getSession().setAttribute("target",target);
		List<Chat> chat = uMapper.getChat(target,principal.getName());
		if(!chat.isEmpty())
			model.addAttribute("chat",chat);
		return "/chat";
	}
	
	@RequestMapping("/chatList") // 채팅중인 채팅방 목록
	public String chatList(Principal pri,Model model) {
		List<String> emailList = uMapper.getRoom(pri.getName()); 
		List<String> nicknameList = new ArrayList<>();  //이메일은 채팅페이지로 넘어가기 위함, 닉네임은 
		for(String room: emailList) {
			nicknameList.add(uMapper.getNickname(room));
		}
		model.addAttribute("emailList",emailList);
		model.addAttribute("nicknameList",nicknameList);
		return "/userList";
		
	}
}
