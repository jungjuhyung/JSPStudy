package com.ict.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex10")
public class Ex10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 정보 잘 넘어오는지 확인용
		String name = request.getParameter("userName");
		String age = request.getParameter("userAge");
		
		out.print("<h2>현재 Ex10 페이지 입니다.</h2>");
		out.print("<h3><ul>");
		out.print("<li>"+name+"</li>");
		out.print("<li>"+age+"</li>");
		out.print("</ul></h3>");
		
		// http에서 request와 response는 response하는 순간 둘다 사라진다.
		
		// 페이지 이동(리다이렉트, 포워딩)
		// => 현재 페이지에서 작업을 한 후 다른 페이지로 이동(현재페이지(servlet페이지)는 보이지 않음)
		// => 리다이렉트와 포워딩을 response 코드 밑에 작성해도 현재 페이지를 보여주지 않는다.
		
		// 리다이렉트 : 다른 페이지로 이동하면서 기존의 request와 response 정보가 사라진다.
		//			즉, 파라미터도 사라진다.
		//			새로운 request와 response가 만들어진다.
		//			주소창에는 Redirect한 최종 주소가 보인다.
		//			파라미터가 필요없는 페이지를 보여줄 때 사용한다.(로그인 실패 후 재로그인 페이지를 보여줄 때 사용)
		// 사용법 : response.sendRedirect("주소");
		// response.sendRedirect("Ex10_2"); // servlet으로 보내기
		// response.sendRedirect("view/Ex09.jsp"); // jsp로 보내기, 이때는 해당 폴더와 파일명만 설정해줘도 된다.
		
		// 포워드 : 다른 페이지로 이동하면서 기존의 request와 response 정보를 가지고 간다.
		//		  파라미터도 사용 가능하다.
		// 		  주소창에는 최초 주소가 보인다.
		// request.getRequestDispatcher("주소").forward(request, response);
		request.getRequestDispatcher("Ex10_2").forward(request, response);
	}
}
