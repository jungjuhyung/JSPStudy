package com.ict.model.guestbook2;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook2.Guest2DAO;


public class DeleteOkCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String idx = request.getParameter("idx");
		int result = Guest2DAO.getDelete(idx);
		if (result > 0) {
			System.out.println("삭제 성공");
			// 이미지 삭제 추가하기
			return "Guest2?cmd=list";
		}else {
			System.out.println("삭제 실패");
			return "guestbook2/error.jsp";
		}
	}
}
