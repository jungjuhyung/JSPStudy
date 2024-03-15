package com.ict.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex09")
public class Ex09 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 같은 이름으로 여러개가 넘어오면 배열 처리
		String[] hobby = request.getParameterValues("hobby");
		String[] web = request.getParameterValues("web");
		
		out.print("<h2>결과보기</h2>");
		out.print("<h3><ul>");
		for (String k : hobby) {
			out.print("<li>"+k+"</li>");
		}
		out.print("</ul></h3>");
		out.print("<hr>");
		out.print("<h2>결과보기</h2>");
		out.print("<h3><ul>");
		for (String k : web) {
			out.print("<li>"+k+"</li>");
		}
		out.print("</ul></h3>");
	}


}
