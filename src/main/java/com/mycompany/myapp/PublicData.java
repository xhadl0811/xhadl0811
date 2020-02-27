package com.mycompany.myapp;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.cxf.io.CachedOutputStream;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class PublicData
 */
@WebServlet("/PublicData.do")
public class PublicData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/x-json; charset=UTF-8");
        
        String addr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival?ServiceKey=";
        String serviceKey = "ykWOt0vYadmIuXAWWQk1wpIeam5z190h91AvAVQpkKJtTP%2BaN%2FW7T04Jc8%2Bbw5SGSQewlAyaOU8DpA%2FQTS%2FmwA%3D%3D"
        		+ "";
        String parameter = "";
        PrintWriter out = response.getWriter();
        parameter = parameter + "&" + "areaCode=1";
        parameter = parameter + "&" + "eventStartDate=20190401";
        parameter = parameter + "&" + "eventEndDate=20191231";
        parameter = parameter + "&" + "pageNo=1&numOfRows=10";
        parameter = parameter + "&" + "MobileOS=ETC";
        parameter = parameter + "&" + "MobileApp=aa";
        parameter = parameter + "&" + "_type=json";
        
        
        addr = addr + serviceKey + parameter;
        URL url = new URL(addr);
        InputStream in = url.openStream(); 
        CachedOutputStream bos = new CachedOutputStream();
        IOUtils.copy(in, bos);
        in.close();
        bos.close();
        System.out.println(bos.getOut());   
        String data = bos.getOut().toString();         //url -> stream -> json
        out.println(data);        
        JSONObject json = new JSONObject();
        json.put("data", data);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        
        String addr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival?ServiceKey=";
        String serviceKey = "ykWOt0vYadmIuXAWWQk1wpIeam5z190h91AvAVQpkKJtTP%2BaN%2FW7T04Jc8%2Bbw5SGSQewlAyaOU8DpA%2FQTS%2FmwA%3D%3D";
        String parameter = "";
//        serviceKey = URLEncoder.encode(serviceKey,"utf-8");
        PrintWriter out = response.getWriter();
        parameter = parameter + "&" + "areaCode=1";
        parameter = parameter + "&" + "eventStartDate=20190401";
        parameter = parameter + "&" + "eventEndDate=20191231"; 
        parameter = parameter + "&" + "pageNo=1&numOfRows=10";
        parameter = parameter + "&" + "MobileOS=ETC";
        parameter = parameter + "&" + "MobileApp=aa";
        parameter = parameter + "&" + "_type=json";
        
        
        addr = addr + serviceKey + parameter;
        URL url = new URL(addr);
        
        InputStream in = url.openStream(); 
        CachedOutputStream bos = new CachedOutputStream();
        IOUtils.copy(in, bos);
        in.close();
        bos.close();
        
//        out.println(addr);
        
        String data = bos.getOut().toString();        
        out.println(data);
        
        JSONObject json = new JSONObject();
        json.put("data", data);
        
    }

}
