package com.ict.model.guestbook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook.GuestDAO;
import com.ict.db.guestbook.GuestVO;


public class SaveCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		GuestVO gvo = new GuestVO();
		gvo.setName(request.getParameter("name"));
		gvo.setSubject(request.getParameter("subject"));
		gvo.setEmail(request.getParameter("email"));
		gvo.setPwd(request.getParameter("pwd"));
		gvo.setContent(request.getParameter("content"));
		
		int su = GuestDAO.getInsert(gvo);

		return "Guest?cmd=list";
	}
}
