<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 숫자와 날짜 포맷팅 --%>
	<h2>숫자만 받기: 천단위마다 ,구분자</h2>
	<h3>
		<ul>
			<%-- fmt:formatNumber 는 천단위마다 ,구분자로 구별해준다. --%>
  			<li><fmt:formatNumber value="123456.789"/> </li>
  			<%--
  			formatNumber는 숫자만 받기 때문에 문자가 들어가면 오류난다.
  			<li><fmt:formatNumber value="aa123456.789"/> </li>
  			<li><fmt:formatNumber value="123456.aa789"/> </li>
  			--%>
		</ul>
	</h3>
	<hr>
	<h2>숫자와 문자가 섞어있으면 숫자까지만 반환</h2>
	<h3>
		<ul>
			<%--
			fmt:parseNumber 는 숫자와 문자가 섞어있으면 숫자까지만 반환한다.
			문자가 먼저 나오면 오류
			--%>
  			<li><fmt:parseNumber value="123456.789"/> </li>
  			<li><fmt:parseNumber value="1234a56a.789"/> </li>
  			<%--
  			문자가 먼저 나와서 오류난다.
  			<li><fmt:parseNumber value="aa123456.789"/> </li>
  			--%>
		</ul>
	</h3>
	<hr>
	<h2>patten 속성</h2>
	<h3>
		<ul>
			<%--
			#은 해당 위치에 값이 없으면 생략되서 표현된다.
			0은 해당위치에 값이 없으면 0으로 채운다.
			,은 자리마다 ,으로 구분지어주는 것
			.은 해당 소숫점 자리까지 반올림해서 보여주는 것
			--%>
  			<li><fmt:formatNumber value="12345678.4449" pattern="#,###"/> </li>
  			<li><fmt:formatNumber value="12345678.4449" pattern="#,###.#"/> </li>
  			<li><fmt:formatNumber value="12345678.4549" pattern="#,###.#"/> </li>
  			<li><fmt:formatNumber value="12345678" pattern="#,###.0"/> </li>
  			<li><fmt:formatNumber value="123" pattern="0,000.0"/> </li>
		</ul>
	</h3>
	<hr>
	<h2>type="currency" 속성</h2>
	<h3>
		<ul>
			<%-- 해당 운영체제 국가의 화페단위로 변환해서 보여줌 안보이는 숫자는 반올림 표시 --%>
  			<li><fmt:formatNumber value="12345678.5449" type="currency"/> </li>
		</ul>
	</h3>
	<hr>
	<h2>type="percent" 속성</h2>
	<h3>
		<ul>
			<%-- value값에 *100해서 %를 붙여서 표시 --%>
  			<li><fmt:formatNumber value="12" type="percent"/> </li>
  			<li><fmt:formatNumber value="0.12" type="percent"/> </li>
		</ul>
	</h3>
	<hr>
	<h2>오늘 날짜구하기 fmt:formatDate</h2>
	<%-- 자바의 객체 생성과 같음 --%>
	<jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
	<h3>
		<ul>
  			<li>오늘 날짜 : ${now}</li>
  			<%--
  			dateStyle의 속성값에 따라 표현되는 날짜의 길이가 다르다.
  			날짜 형식은 시스템상의 설정된 나라의 형식을 따른다.
  			--%>
  			<li><fmt:formatDate value="${now}" dateStyle="short"/></li>
  			<li><fmt:formatDate value="${now}" dateStyle="medium"/></li>
  			<li><fmt:formatDate value="${now}" dateStyle="long"/></li>
  			<li><fmt:formatDate value="${now}" dateStyle="full"/></li>
		</ul>
		<ul>
			<%-- 시간을 보고 싶으면 type="time"과 timeStyle속성을 지정 --%>
  			<li><fmt:formatDate value="${now}" type="time" timeStyle="short"/></li>
  			<li><fmt:formatDate value="${now}" type="time" timeStyle="medium"/></li>
  			<li><fmt:formatDate value="${now}" type="time" timeStyle="long"/></li>
  			<li><fmt:formatDate value="${now}" type="time" timeStyle="full"/></li>
		</ul>
		<ul>
			<%-- 날짜, 시간을 보고 싶으면 type="both"과 dateStyle, timeStyle속성을 지정 --%>
  			<li><fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short"/></li>
  			<li><fmt:formatDate value="${now}" type="both" dateStyle="medium" timeStyle="medium"/></li>
  			<li><fmt:formatDate value="${now}" type="both" dateStyle="long" timeStyle="long"/></li>
  			<li><fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/></li>
		</ul>
	</h3>
</body>
</html>