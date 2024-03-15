package com.ict.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex11_sum")
public class Ex11_sum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String su1 = request.getParameter("su1");
		String su2 = request.getParameter("su2");
		String op = request.getParameter("op");
		long isu1 = Long.parseLong(su1);
		long isu2 = Long.parseLong(su2);
		try {
			long res = 0;
			switch (op) {
			case "+": res = isu1+isu2; break;
			case "-": res = isu1-isu2; break;
			case "*": res = isu1*isu2; break;
			case "/": res = isu1/isu2; break;
			}
			out.print("<h3>결과 : "+su1+op+su2+" = "+res+"</h3>");
		} catch (Exception e) {
			out.print("<h2> 0으로 나눌 수 없습니다.</h2>");
		}
	}


}
