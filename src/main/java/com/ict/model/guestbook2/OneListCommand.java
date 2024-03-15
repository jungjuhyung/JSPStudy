package com.ict.model.guestbook2;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook2.Guest2DAO;
import com.ict.db.guestbook2.Guest2VO;


public class OneListCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String idx = request.getParameter("idx");
		Guest2VO g2vo = Guest2DAO.getOne(idx);
		if (g2vo != null) {
			request.setAttribute("g2vo", g2vo);
			return "guestbook2/onelist.jsp";
		}else
		return "guestbook2/error.jsp";
	}
}
