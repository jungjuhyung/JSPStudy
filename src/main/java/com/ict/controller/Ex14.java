package com.ict.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.model.guestbook.Command;
import com.ict.model.guestbook.Command04;
import com.ict.model.guestbook.Command05;

@WebServlet("/Ex14")
public class Ex14 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String cmd = request.getParameter("cmd");
		Command comm = null;
		switch (cmd) {
		case "4":
			comm = new Command04();
			break;
		case "5":
			comm = new Command05();
			break;
		}
		String path = comm.exec(request, response);
		request.getRequestDispatcher(path).forward(request, response);

	}
}
