<%@page import="com.ict.db.guestbook.VO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
	<%--
		JSTL : JSP Standard Tag Library
		1. 라이브러리 다운받아서 해당 프로젝트에 넣기(tomcat.apache.org)
		 	=> tomcat페이지 -> download의 tagliv 선택 -> jar file 4개 전부 다운로드
		2. 다운 받은 4개의 파일을 WEB-INF 안에 lib 폴더에 넣어주자
		3. JSTL을 사용하기 위해서는 지시어 중 taglib 지시어를 선언하고 사용한다.(보통은 page 지시어 밑에 사용한다.)
			코어 : <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			포맷팅 : <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
		4. 사용법 : 
			코어 => <c:사용명령어/>
			포멧팅 => <fmt:사용명령어/>
	--%>
	
	<%-- 1. 변수생성 및 데이터 자장 : 디폴트 저장소는 pageContext에 저장 --%>
	<%-- 변수 생성(set명령어) => <c:set var="변수명" value="값" [scope="저장소"]/> --%>
	<c:set var="str" value="Hello JSTL" />
	
	<%-- 변수값 출력(out명령어) --%>
	<c:out value="str" /> <%-- value에 있는 문자열 자체를 출력 --%>
	<br>
	<c:out value="${str}" /> <%-- value에 있는 변수 안의 값을 출력 --%>
	${str}
	
	<%-- 변수 삭제(remove) --%>
	<c:remove var="str"/> <%-- 여거의 var은 변수명이다 --%>
	<c:out value="${str}" />
	${str}
	
	<%--
		if문 : else가 없다. 조건식이 참일때만 실행
		형식)
		<c:if test="조건식(관계연산,비교연산,논리연산)=>EL방식으로 작성" var="변수">
			조건식이 참일 때 실행할 문장
		</c:if>>
	--%>
	<c:if test="${4>3}">
		<h2>결과 : 참이면 실행</h2>
	</c:if>
	<hr>
	
	<c:if test="${4<3}">
		<h2>결과 : 거짓이라서 실행 안되야함</h2>
	</c:if>
	
	<%-- avg가 80이상이면 합격 --%>
	<c:set var="avg" value="87"/>
	<c:if test="${avg >= 80}">
		<h3>결과 : 합격</h3>
	</c:if>
	<hr>
	<%-- ge(>=), le(<=), eq(==) 로 표현 가능하다, 태그의 <>와 구분하기 위해 나온 것 --%>
	<c:if test="${avg ge 80}">
		<h3>결과 : ge(>=) 사용한 것</h3>
	</c:if>
	
	<%--
		if문은 else가 없어서 불편하다.
		그래서 대신 choose문 사용한다.
		switch문과 비슷하다.
		형식)
		<c:choose>
			<c:when test="조건식=>EL로 작성">실행문</c:when> => elseif 또는 case 와 비슷하다.
			<c:when test="조건식=>EL로 작성">실행문</c:when>
			<c:when test="조건식=>EL로 작성">실행문</c:when>
			<c:otherwise>실행문</c:otherwise> => else 또는 default 와 비슷하다.
		</c:choose>
	--%>
	<%-- avg가 80 이상이면 합격 아니면 불합격 --%>
	<c:choose>
		<c:when test="${avg>=80}"><h3>합격</h3></c:when>
		<c:otherwise><h3>불합격</h3></c:otherwise>
	</c:choose>
	
	<%-- avg2가 90이상이면 a, 80이상이면 b, 70이상이면 c, 그외 f --%>
	<%-- 주의할점, 정수는 정수와 비교, 실수는 실수와 비교 --%>
	<c:set var="avg2" value="89.4"/>
	<c:choose>
		<c:when test="${avg2>=90.0}"><h3>A학점</h3></c:when>
		<c:when test="${avg2>=80.0}"><h3>B학점</h3></c:when>
		<c:when test="${avg2>=70.0}"><h3>C학점</h3></c:when>
		<c:otherwise><h3>F학점</h3></c:otherwise>
	</c:choose>
	
	<%--
		for문
		1. 일반적인 for문
		
		<c:forEach begin="시작값" end="끝값" step="증가/감소" 
		var="for문 지역변수" varStatus="변수 상태값"></c:forEach>
		
		** JSTL의 일반적은 for문은 끝값을 포함해서 반복한다.
		** varStatus="객체명" 은 사용하는 변수의 상태값을 저장해놓은 객체를 뜻한다.
		** 객체명.index => 지역변수값과 동일
		** 객체명.count => 반복된 사이클의 횟수를 표시
		** 객체명.first => 첫 반복 사이클 값이면 true 그외는 false
		** 객체명.last => 마지막 반복 사이클 값이면 true 그외는 false
		
		
		2. 개선된 for문
		
		<c:forEach var="사용할 변수" items="배열이나 ArrayList를 EL형식으로 표현"></c:forEach>
		
		3. forTokens문
			=>
		<c:forTokens items="${배열이나 컬랙션}" delims="구분지" var="변수명"></c:forTokens>
	--%>
	<h2>10~20까지 출력</h2>
	<c:forEach begin="10" end="20" step="1" var="k" varStatus="vs">
		${k} : ${vs.index} : ${vs.count} : ${vs.first} : ${vs.last}<br>
	</c:forEach>
	
	<h2>10~20까지 짝수만 출력</h2>
	<c:forEach begin="10" end="20" step="1" var="k" varStatus="vs">
		<c:if test="${k%2==0}">
			${k}<br>
		</c:if>
	</c:forEach>
	
	<%-- 배열 생성 --%>
	<c:set var="arr_1" value="둘리, 도우너, 마이콜, 희동이, 고길동"/>
	<c:forEach var="k" items="${arr_1}">
		<h3>${k}님, 환영합니다.</h3>
	</c:forEach>
	
	<%-- 리스트 컬렉션으로 받은 객체를 for문 돌리기 --%>
	<%
		VO vo2 = new VO("2", "도우너", "2", "경기");
		VO vo3 = new VO("3", "마이콜", "34", "대구");
		VO vo4 = new VO("4", "희동이", "15", "대전");
		List<VO> list = new ArrayList<VO>();
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);
		request.setAttribute("list", list);
	%>
	<hr>
	<c:forEach var="k" items="${list}">
		<h3>${k.name}님, 환영해요</h3>
	</c:forEach>
	
	<hr>
	<c:set var="arr_2" value="둘리, 도우너, 마이콜/홍길동,장길산,임꺽정/태권브이,마징가,짱가"/>
	
	<%-- /구분자 --%>
	<c:forTokens items="${arr_2}" delims="/" var="k">
		<h3>${k}님 /구분자</h3>
	</c:forTokens>
	<hr>
	
	<%-- ,구분자 --%>
	<c:forTokens items="${arr_2}" delims="," var="k">
		<h3>${k}님 ,구분자</h3>
	</c:forTokens>
	<hr>
	
	<%-- / , 둘다 사용 --%>
	<c:forTokens items="${arr_2}" delims=", /" var="k">
		<h3>${k}님 ,/구분자</h3>
	</c:forTokens>
	
	<%-- c:redirect : 페이지이동(requesr, response가 새로 만들어짐) --%>
	<%-- <c:redirect url="ex07_EL.jsp"></c:redirect> --%>
	
	<%-- c:import --%>
	<%-- include 지시어와 비슷하다. --%>
	<c:import url="ex07_EL.jsp"></c:import>
</body>
</html>