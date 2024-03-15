package com.ict.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex08")
public class Ex08 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String uname = request.getParameter("uname");
		String kor = request.getParameter("kor");
		String eng = request.getParameter("eng");
		String mat = request.getParameter("mat");
		
		int ikor = Integer.parseInt(kor);
		int ieng = Integer.parseInt(eng);
		int imat = Integer.parseInt(mat);
		int sum = ikor+ieng+imat;
		double avg = ((int)(10*sum/3))/10.0;
		String hak;
		if (avg>=90) {
			hak = "A학점";
		}else if (avg>=80) {
			hak = "B학점";
		}else if (avg>=70) {
			hak = "C학점";
		}else {
			hak="F학점";
		}
		out.print("<h3>이름 : "+uname+"</h3>");
		out.print("<h3>총점 : "+sum+"</h3>");
		out.print("<h3>평균 : "+avg+"</h3>");
		out.print("<h3>학점 : "+hak+"</h3>");
	}


}
