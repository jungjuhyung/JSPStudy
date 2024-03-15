package com.ict.model.guestbook;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 인터페이스 : 추상메서드와 상수로 이루어진 클래스
public interface Command {
	// 요청사항을 처리할 Model들이 사용할 메서드를 가지고 있음
	
	public String exec(HttpServletRequest request, HttpServletResponse response);
	
}
