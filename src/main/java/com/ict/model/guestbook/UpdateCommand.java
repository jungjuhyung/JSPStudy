package com.ict.model.guestbook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook.GuestDAO;
import com.ict.db.guestbook.GuestVO;


public class UpdateCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String idx = request.getParameter("idx");
		GuestVO gvo = GuestDAO.getOne(idx);
		request.setAttribute("gvo", gvo);
		return "guestbook/update.jsp";
	}
}
