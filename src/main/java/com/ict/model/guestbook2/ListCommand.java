package com.ict.model.guestbook2;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook2.Guest2DAO;
import com.ict.db.guestbook2.Guest2VO;


public class ListCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		// DB에서 전체 목록 가져오고
		List<Guest2VO> list = Guest2DAO.getList();
		request.setAttribute("list", list);
		return "guestbook2/list.jsp";
	}
}
