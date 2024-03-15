package com.ict.controller.guestbook;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.model.guestbook.Command;
import com.ict.model.guestbook.DeleteCommand;
import com.ict.model.guestbook.DeleteOkCommand;
import com.ict.model.guestbook.ListCommand;
import com.ict.model.guestbook.OnelistCommand;
import com.ict.model.guestbook.SaveCommand;
import com.ict.model.guestbook.UpdateCommand;
import com.ict.model.guestbook.UpdateOkCommand;
import com.ict.model.guestbook.WriteCommand;


@WebServlet("/Guest")
public class Guest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String cmd = request.getParameter("cmd");
		Command comm = null;
		switch (cmd) {
		case "list":
			comm = new ListCommand();
			break;
		case "write":
			comm = new WriteCommand();			
			break;
		case "save":
			comm = new SaveCommand();			
			break;
		case "onelist":
			comm = new OnelistCommand();			
			break;
		case "delete":
			comm = new DeleteCommand();			
			break;
		case "delete_ok":
			comm = new DeleteOkCommand();			
			break;
		case "update":
			comm = new UpdateCommand();			
			break;
		case "update_ok":
			comm = new UpdateOkCommand();			
			break;
		default:
			break;
		}
		String path = comm.exec(request, response);
		request.getRequestDispatcher(path).forward(request, response);
	}

}
