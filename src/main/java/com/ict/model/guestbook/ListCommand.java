package com.ict.model.guestbook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook.GuestDAO;
import com.ict.db.guestbook.GuestVO;


public class ListCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// DB의 guest book의 모든 정보를 다 가져와야한다.
		// DB 처리는 MyBatis 이다.
		// 오라클 라이브러리와 Mybatis 라이브러리를 WEB-INF 안에 lib에 넣자.
		
		List<GuestVO> list = GuestDAO.getList();
		request.setAttribute("list", list);
		return "guestbook/list.jsp";
	}
}
