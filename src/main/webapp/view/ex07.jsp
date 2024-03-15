<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		function send(f) {
			f.action="/01_servlet/Ex07";
			let su1 = f.su1.value;
			let su2 = f.su2.value;
			if (su1==="") {
				alert("이름을 입력하세요");
				f.su1.fucus();
				return;
			}else if (su2==="") {
				alert("이름을 입력하세요");
				f.su2.fucus();
				return;
			}
			f.submit()
		}
	</script>
</head>
<body>
	<h3>Form version</h3>
	<form action="/01_servlet/Ex07" method="get">
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
	<hr>
	<h3>JS version</h3>
	<form action="" method="get">
		<fieldset>
			<legend>계산기</legend>
			<div>
				<label for="su1">수1 : </label>
				<input type="text" id="su1" name="su1" required>
			</div>
			<div>
				<label for="su2">수2 : </label>
				<input type="text" id="su2" name="su2" required>
			</div>
			<div>
				<label>연산자 : </label>
				<input type="radio" name="yun" value="+" checked>+
				<input type="radio" name="yun" value="-">-
				<input type="radio" name="yun" value="*">*
				<input type="radio" name="yun" value="/">/
			</div>
			<input type="button" value="결과보기" onclick="send(this.form)">
		</fieldset>
	</form>
</body>
</html>