package com.mycompany.myapp.LoginHandler;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

public class SuccessHandler implements AuthenticationSuccessHandler {
    
	private RequestCache requestCache = new HttpSessionRequestCache();
    private RedirectStrategy redirectStratgy = new DefaultRedirectStrategy();



    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {   
    	resultRedirectStrategy(request, response, authentication);     
    }
 
 
    protected void resultRedirectStrategy(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
       if(request.getSession()!=null) {  	 
    	   String referer=(String) request.getSession().getAttribute("referer");
    	if(request.getSession().getAttribute("need")=="true") {
    		 SavedRequest savedRequest = requestCache.getRequest(request, response); 
             String targetUrl = savedRequest.getRedirectUrl();
             System.out.println(targetUrl);
             redirectStratgy.sendRedirect(request, response, targetUrl);
    	}
        else if(referer!=null) {
        	redirectStratgy.sendRedirect(request, response, referer);
        	request.getSession().removeAttribute("referer");
        }
        else 
        	redirectStratgy.sendRedirect(request, response, "/");   	
         
    }
   }
}



