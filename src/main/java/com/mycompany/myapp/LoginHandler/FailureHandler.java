package com.mycompany.myapp.LoginHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.mycompany.myapp.Mappers.userMapper;

public class FailureHandler implements AuthenticationFailureHandler{
	 	private String loginidname;
	    private String loginpwdname;
	    private String errormsgname;
	    private String defaultFailureUrl;
	    @Autowired 
    	userMapper uMapper ;
	 
	    @Override
	    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
	            throws IOException, ServletException {
	    	String username = request.getParameter(loginidname); //email 파라미터
	    	String password = request.getParameter(loginpwdname);//password 파라미터
	    	String errormsg = null;
	   
	
	    	
	        if(exception instanceof  InternalAuthenticationServiceException || 
	        		exception instanceof BadCredentialsException) 
	        	errormsg = "아이디나 비밀번호가 맞지 않습니다.";            	        
	        else if(exception instanceof DisabledException)
	        	errormsg = "비활성화된 계정입니다. 관리자에게 문의하세요.";
	        
	        
	    	request.setAttribute(loginidname, username);
	    	request.setAttribute(loginpwdname, password);
	    	request.setAttribute(errormsgname, errormsg);
	    	System.out.println("※Login Failed\n"+"username = "+username+"\n"+"password = "+password+"\n"+"errorMSG = "+errormsg);	    	
	    	
	    	
	   
	    	request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
	    	
	    }

   
	    
	    public String getLoginidname() {
	        return loginidname;
	    }
	 
	    public void setLoginidname(String loginidname) {
	        this.loginidname = loginidname;
	    }
	 
	    public String getLoginpwdname() {
	        return loginpwdname;
	    }
	 
	    public void setLoginpwdname(String loginpwdname) {
	        this.loginpwdname = loginpwdname;
	    }
	 
	    public String getErrormsgname() {
	        return errormsgname;
	    }
	 
	    public void setErrormsgname(String errormsgname) {
	        this.errormsgname = errormsgname;
	    }
	 
	    public String getDefaultFailureUrl() {
	        return defaultFailureUrl;
	    }
	 
	    public void setDefaultFailureUrl(String defaultFailureUrl) {
	        this.defaultFailureUrl = defaultFailureUrl;
	    }
	 
	}


