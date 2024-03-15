package com.ict.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// servlet 생성시 URL mapping => 프로젝트명/@WebServlet명으로 mapping하게 된다.
@WebServlet("/Ex01")
public class Ex01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 생성자는 거의 필요없기 때문에 다음부터는 생략
    public Ex01() {
    	System.out.println("생성자");
    }

	public void init(ServletConfig config) throws ServletException {
		// 생성자를 대신해서 맴버 초기화를 할 수 있다.
		// init이 끝나면 자동으로 service메서드로 넘어간다.
		System.out.println("init()");
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트의 요청방식(get, post)에 따라 알맞는 메서드를 호출하는 역할을 한다.
		// 디폴트값 get
		// request  => 요청정보를 가지고 있는 객체(클라이언트 -> 서버)
		// response => 응답정보를 가지고 있는 객체(서버 -> 클라이언트)
		// get 요청방식  => doGet()으로 이동
		// post 요청방식 => doPost()로 이동
		System.out.println("service()");
		if (request.getMethod().equalsIgnoreCase("get")) {
			doGet(request, response);
		}else if (request.getMethod().equalsIgnoreCase("post")) {
			doPost(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get()");
		// getWriter() => response에 있는 내용을 HTML로 작성
		// .append를 통해 <body> 안에 추가로 작성
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post()");
		// post방식으로 요청하면 doGet()에서 처리해서 두번 치는 것을 방지
		doGet(request, response);
	}
	
	public void destroy() {
		System.out.println("destroy()");
	}

}
