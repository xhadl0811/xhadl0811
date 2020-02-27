package com.mycompany.myapp.Helper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class alertHelper {
	public void cantBuy(int id,	HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('자신의 상품은 구매할 수 없습니다.');"+
				"location.replace('http://localhost:8085/myapp/product/"+id+"')</script>");
		out.flush();
	}
}
