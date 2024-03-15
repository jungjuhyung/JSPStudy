<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>액션태그 : include, forward</title>
</head>
<body>
	<%--
		액션 태그 : jsp 페이지 간의 흐름 제어, 자바빈즈 컴포넌트 지원(자바 객체 제어하는 것)
		사용법 : <jsp: 액션태그>
		
		1. include : 현재 페이지에서 다른 페이지를 호출 또는
					 다른 페이지의 결과를 현재 페이지에 보여준다.
			1) 지시어 include : <%@ include file="가져올 파일의 경로" %>
				=> 다른 페이지 소스 전체를 가져와서 현재 페이지에서 한번에 처리
				=> 파라미터 전달 안됨, 잘 변경되지 않는 정적 페이지에 많이 사용된다.
				
			2) 액션 태그 include : <jsp:include page="가져올 파일의 경로"></jsp:include>
				=> 지정한 다른 페이지의 결과를 가져와서 현재 페이지에 결과를 표시
				=> 파라미터 전달 가능, 자주 변경되는 동적 페이지에 많이 사용된다.
				=> 파라미터 전달 형식
					<jsp:include page="">
						<jsp:param name="" value="">
						<jsp:param name="" value="">
					</jsp:include>
				
	--%>
	<%--
	<h2>include 지시어 사용하기(ex03)</h2>
	<%@ include file="ex03_request.jsp" %>
	
	<h2>include 액션태그 사용하기(ex03)</h2>
	<jsp:include page="ex03_request.jsp"></jsp:include>
	<hr>
	<h2>include 지시어 사용하기(ex05)</h2>
	<%@ include file="ex05_pagecontext.jsp" %>
	
	<h2>include 액션태그 사용하기(ex05)</h2>
	<jsp:include page="ex05_pagecontext.jsp"></jsp:include>
	--%>
	<h2>include 액션태그 사용하기(ex05)</h2>
	
	<jsp:include page="ex05_pagecontext.jsp">
		<jsp:param value="010-4444-5555" name="phone"/>
	</jsp:include>
	
</body>
</html>