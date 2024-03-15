package com.ict.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.model.guestbook.Command;
import com.ict.model.guestbook.Command01;
import com.ict.model.guestbook.Command02;
import com.ict.model.guestbook.Command03;


@WebServlet("/Ex13")
public class Ex13 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String cmd = request.getParameter("cmd");
		/*
		switch (cmd) {
		case "1": 
			Command01 cmd01 = new Command01();
			String path01 = cmd01.exec(request, response);
			request.getRequestDispatcher(path01).forward(request, response);
			break;
		case "2": 
			Command02 cmd02 = new Command02();
			String path02 = cmd02.exec(request, response);
			request.getRequestDispatcher(path02).forward(request, response);
			break;
		case "3": 
			Command03 cmd03 = new Command03();
			String path03 = cmd03.exec(request, response);
			request.getRequestDispatcher(path03).forward(request, response);
			break;
		}
		*/
		// 위를 인터페이스를 사용해서 축약하기
		Command comm = null;
		switch (cmd) {
			case "1": comm = new Command01(); break;
			case "2": comm = new Command02(); break;
			case "3": comm = new Command03(); break;
		}
		String path03 = comm.exec(request, response);
		request.getRequestDispatcher(path03).forward(request, response);
	}
}
