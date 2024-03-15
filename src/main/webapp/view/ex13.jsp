<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="/01_servlet/Ex13">
		<input type="submit" value="오늘 날짜 구하기">
		<!-- type="hidden"으로 각각의 submit을 구별해서 하나의 servlet으로 보내기  -->
		<!-- hidden타입은 클라이언트의 화면에만 안보이는 것이지 get방식일때는 주소창에 값이 보이게 된다. -->
		<input type="hidden" name="cmd" value="1">
	</form>
	<hr>
	<form action="/01_servlet/Ex13">
		<input type="submit" value="운세 구하기">
		<input type="hidden" name="cmd" value="2">
	</form>
	<hr>
	<form action="/01_servlet/Ex13" method="get">
		<fieldset>
			<legend>계산기</legend>
			<div>
				<label for="su1">수1 : </label>
				<input type="number" id="su1" name="su1" required>
			</div>
			<div>
				<label for="su2">수2 : </label>
				<input type="number" id="su2" name="su2" required>
			</div>
			<div>
				<label>연산자 : </label>
				<input type="radio" name="op" value="+" checked>+
				<input type="radio" name="op" value="-">-
				<input type="radio" name="op" value="*">*
				<input type="radio" name="op" value="/">/
			</div>
			<input type="submit" value="결과보기">
			<input type="hidden" name="cmd" value="3">
		</fieldset>
	</form>
</body>
</html>