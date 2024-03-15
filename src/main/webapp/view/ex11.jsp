<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="/01_servlet/Ex11_day">
		<input type="submit" value="오늘 날짜 구하기">
	</form>
	<hr>
	<form action="/01_servlet/Ex11_luck">
		<input type="submit" value="운세 구하기">
	</form>
	<hr>
	<form action="/01_servlet/Ex11_sum" method="get">
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
		</fieldset>
	</form>
</body>
</html>