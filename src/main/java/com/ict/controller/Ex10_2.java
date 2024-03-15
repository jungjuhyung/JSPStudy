package com.ict.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex10_2")
public class Ex10_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 정보 잘 넘어오는지 확인용
		String name = request.getParameter("userName");
		String age = request.getParameter("userAge");
		
		out.print("<h2>현재 Ex10_2 페이지 입니다.</h2>");
		out.print("<h3><ul>");
		out.print("<li>"+name+"</li>");
		out.print("<li>"+age+"</li>");
		out.print("</ul></h3>");
	}
}
