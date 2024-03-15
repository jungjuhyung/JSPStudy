<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSP 내장 객체</title>
</head>
<body>
	<%--
	JSP 내장 객체 : JSP 페이지에서 사용할 수 있도록 지원하는 객체를 말한다.
		request, response, out, page, pageContext, 
		session, application, config, exception
	형식1 : 현재는 잘 안쓰는 형식
		해당 형식은 해당 형식끼리만 호환된다.
		ex) EL인 ${}와 <%= %>는 서로 호환되지 않는다.
		<% 자바코드; %>
		<%! 변수선언이나 메서드 선언할 때 사용; %> : JSTL로도 표현할 수 있다.
		<%= 변수결과값과 메서드 결과값을 출력 %> : EL(표현언어=${})로도 나타낼수 있어서 잘 안씀
		
		
		out : 화면에 출력할 때 사용하는 객체, servlet의 printWriter와 기능이 같다.
	--%>
	<% out.println("<h2>Hello JSP</h2>"); %>
	<%! String str = "Hello jsp2";  %>
	<h2><%= str %></h2>
	<h2>결과 : ${str}</h2>
</body>
</html>