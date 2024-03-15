<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		function send_go(f) {
			// form에 action속성이 없으면 함수에서 정의 가능
			let name = f.userName.value;
			
			// required 속성을 대신하는 조건문 작성
			if (name === "") {
				alert("이름을 입력하세요");
				f.userName.fucus();
				// return은 자신을 호출한 곳으로 돌아간다.
				// 값이 있으면 값을 가지고 돌아가는 것이다.
				return;
			}
			f.action="/01_servlet/Ex06";
			f.submit();
		}
	</script>
</head>
<body>
	<h2>HTML을 활용한 서버(servlet)에게 정보 보내기</h2>
	<form action="/01_servlet/Ex06" method="get">
		<div>
		<label for="uname">이름 : </label>
		<input type="text" id="uname" name="userName" placeholder="이름을 입력해 주세요" required>
		</div>
		<div>
		<label for="uage">나이 : </label>
		<input type="number" id="uage" name="userAge" required>
		</div>
		<input type="submit" value="서버에게 보내기">
		<input type="reset" value="취소">
	</form>
	
	<h2>JS를 활용한 서버(servlet)에게 정보 보내기</h2>
	<!-- form의 action속성과, submit을 쓰지 않는다. -->
	<!-- 단점 : required 속성이 적용되지 않고 버튼을 누르면 무조건 서버에 보내진다. -->
	<form  method="get">
		<div>
		<label for="uname">이름 : </label>
		<input type="text" id="uname" name="userName" placeholder="이름을 입력해 주세요" required>
		</div>
		<div>
		<label for="uage">나이 : </label>
		<input type="number" id="uage" name="userAge" required>
		</div>
		<input type="button" value="서버에 보내기" onclick="send_go(this.form)">
		<input type="reset" value="취소">
	</form>
</body>
</html>