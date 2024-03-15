<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>ex13_res01</h1>
	<!-- Command01 메서드에서 처리하고 저장한 결과를 불러오자 -->
	<!-- 결과를 받기 호출하기 위해서는 request.setAttribute("이름", 변수);에서 지정한 이름을 써야한다.
	${이름} -->
	<h2>오늘 날짜 : ${res}</h2>
</body>
</html>