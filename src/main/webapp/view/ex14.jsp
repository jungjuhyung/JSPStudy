<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form action="/01_servlet/Ex14" method="get">
		<fieldset>
			<legend>성적 계산기</legend>
			<ul>
				<li>
					<label for="uname">이름 : </label>
					<input type="text" id="uname" name="uname" placeholder="이름" required>
				</li>
				<li>
					<label for="kor">국어 점수 : </label>
					<input type="number" id="kor" name="kor" required>
				</li>
				<li>
					<label for="eng">영어 점수 : </label>
					<input type="number" id="eng" name="eng" required>
				</li>
				<li>
					<label for="math">수학 점수 : </label>
					<input type="number" id="math" name="math" required>
				</li>
			</ul>
			<input type="hidden" name="cmd" value="4">
			<input type="submit" value="결과 확인">
		</fieldset>
	</form>
	<hr>
	<form action="/01_servlet/Ex14" method="get">
		<p>
			<input type="checkbox" name="hobby" value="운동">운동
			<input type="checkbox" name="hobby" value="게임">게임
			<input type="checkbox" name="hobby" value="영화">영화
			<input type="checkbox" name="hobby" value="독서">독서
		</p>
		<input type="hidden" name="cmd" value="5">
		<input type="submit" value="결과 확인">
	</form>
</body>
</html>