package com.mycompany.myapp.Helper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.mycompany.myapp.Mappers.userMapper;


	
public class EchoHelper extends TextWebSocketHandler {
	 
	 private Map<String,WebSocketSession> users = new HashMap<>(); // 유저들
	 private Map<String,String> targets = new HashMap<>(); //상대유저가 나를보고있는지 확인
	 @Autowired
	 userMapper uMapper;
	 timeHelper tHelper = new timeHelper();
	 
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {

		  Map<String,Object> map = session.getAttributes();
			 String principal = (String)map.get("principal"); //내 이메일
			 String target = (String)map.get("target"); // 상대 이메일
			 users.put(principal,session);
			 targets.put(principal,target);
			 System.out.println(users);
	}	
	
	@PreAuthorize("isAuthenticated()")
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		 Map<String,Object> map = session.getAttributes();
		 String principal = (String)map.get("principal"); ///내 이메일
		 String target = (String)map.get("target"); //상대 이메일
		 String myNickname = uMapper.getNickname(principal);
		 session.sendMessage(new TextMessage(myNickname+":"+message.getPayload()));			
		 if(users.containsKey(target)&&targets.get(target).equals(principal))  //상대가 접속했는지 확인 후 , 상대가 나를보고있으면 메세지 전달 및 db저장 아니면 db저장 및 알림
			users.get(target).sendMessage(new TextMessage(myNickname+":"+message.getPayload()));
		uMapper.setChat(myNickname+":"+message.getPayload(),tHelper.getTime() , principal, target);
	}
			

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

			users.remove(session.getId());
		}
}
