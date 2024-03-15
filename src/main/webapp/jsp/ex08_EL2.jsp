<%@page import="com.ict.db.guestbook.VO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		VO vo1 = new VO("1", "둘리", "24", "서울");
		request.setAttribute("vo", vo1);
	%>
	<h2>
		<ul>
			<!--
			VO의 필드값은 private라서 java라면 vo.필드명으로 접근을 못한다.
			그러나 jsp에서는 자동으로 getter에 접근해서 가져오기 때문에 getter를 만들지 않으면 접근 못한다.
			 -->
  			<li>${vo}</li>
  			<li>${vo.idx}</li>
  			<li>${vo.name}</li>
  			<li>${vo.age}</li>
  			<li>${vo.addr}</li>
		</ul>
	</h2>
</body>
</html>