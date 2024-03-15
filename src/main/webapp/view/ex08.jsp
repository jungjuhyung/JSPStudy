<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		function send(f) {
			for (let i = 0; i < f.elements.length; i++) {
				// f.elements 는 from태그 안에 있는 요소들을 모두 선택한다.
				// fieldset 같은 것도 포함된다.
				console.log(f.elements)
				// 특정 input 제외
				if(i==2) continue;
				if (f.elements[i].value==="") {
					alert(f.elements[i].name + "을 입력해주세요.");
					f.elements[i].focus();
					return;
				}
			}
			f.submit();
		}
	</script>
</head>
<body>
	<h2>성적 계산기</h2>
	<form action="/01_servlet/Ex08" method="get">
		<fieldset>
			<legend>입력칸</legend>
			<div>
				<label for="uname">이름 : </label>
				<input type="text" id="uname" name="uname" placeholder="이름 입력">
			</div>
			<div>
				<label for="kor">국어 : </label>
				<input type="number" id="kor" name="kor">
			</div>
			<div>
				<label for="eng">영어 : </label>
				<input type="number" id="eng" name="eng">
			</div>
			<div>
				<label for="mat">수학 : </label>
				<input type="number" id="mat" name="mat">
			</div>
			<input type="button" value="결과 보기" onclick="send(this.form)">
		</fieldset>
	</form>
</body>
</html>