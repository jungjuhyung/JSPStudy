package com.ict.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex05")
public class Ex05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// sevlet의 첫 번째 역할은 클라이언트에게 요청을 받는 것이다.
		// 요청에 따른 한글 처리, 응답에 따른 한글처리, PrintWriter 이 3개가 serviet의 기본 구성이다.
		
		// 요청에 따른 한글 처리(해당 내용은 tomcat 같은 서버가 인식한다.)
		// view의 jsp에서 pageEncoding="UTF-8" 과 같은 기능
		request.setCharacterEncoding("UTF-8");
		
		// 응답에 따른 한글 처리(해당 내용은 tomcat 같은 서버가 인식한다.)
		// view의 jsp에서 아래와 같은 기능
		// page language="java" contentType="text/html; charset=UTF-8"
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// 클라이언트가 서버에게 정보를 요청하면서 필요한 정보를 보낼 수 있다.
		// 이렇게 요청을 처리하기 위해서 함께 전달되는 정보를 파라미터라고 한다.
		
		// 파라미터의 자료형은 기본적 String이거나 String[]이다.
		
		// 클라이언트가 요청할 때 사용하는 방식은 get 방식, post 방식 이다.
		// get 방식 : 주소창에 정보가 보인다. (정보를 헤더에 담아서 보낸다.)
				//  (url~~?name1=value1&name2=value2)
		// post 방식 : 주소창에 정보가 보이지 않는다. (정보를 body에 담아서 보낸다.)
		
		// 파라미터를 받아서 처리하는 메서드들
		// 1. request.getParameter("name")       : String
		// 2. request.getParameterValues("name") : String[]
		
		// 파라미터 형식이 Map 형식일 때 사용 
		// 3. request.getParameterMap() : Map<String, String[]>
		
		// 파라미터 형식이 열거형(enum)일 때 사용
		// 4. request.getParameterNames() : Enumeration<String>
		
		// 만약에 이름(userName)과 나이(userAge)가 파라미터로 넘어왔을 때 처리하는 방법
		String uname = request.getParameter("userName");
		String uage = request.getParameter("userAge");
		
		out.print("<h3>");
		out.print("<p> 이름 : "+uname+"</p>");
		out.print("<p> 나이 : "+uage+"</p>");
		out.print("</h3>");
		
		// 만약에 s1이라는 이름으로 숫자, s2라는 이름으로 숫자
		// op라는 이름으로 +,-,*,/ 중 하나가 넘어온다고 가정하자
		String su1 = request.getParameter("s1");
		String su2 = request.getParameter("s2");
		String yun = request.getParameter("op");
		// +는 연결자 취급이기 때문에 %2b 엔티티 문자로 value에 넣어줘야한다.
		if (yun.equalsIgnoreCase("+")) {
			out.print(su1+"+"+su2+"="+(Long.parseLong(su1)+Long.parseLong(su2)));
		}else if (yun.equalsIgnoreCase("-")) {
			out.print(su1+"-"+su2+"="+(Long.parseLong(su1)-Long.parseLong(su2)));
		}else if (yun.equalsIgnoreCase("*")) {
			out.print(su1+"*"+su2+"="+(Long.parseLong(su1)*Long.parseLong(su2)));
		}else if (yun.equalsIgnoreCase("/")) {
			out.print(su1+"/"+su2+"="+(Long.parseLong(su1)/Long.parseLong(su2)));
		}
		
	}
}
