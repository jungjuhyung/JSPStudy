<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>지시어 : Directive</title>
</head>
<body>
	<!-- html 주석 : 소스보기에서 보인다. -->
	
	<%-- jsp 주석 : 소스보기에서 보이지 않는다.--%>
	<%-- jsp는 모두 <% %> 로 시작한다. --%>
	<%--
		지시어(Directive) : JSP 파일의 속성을 기술하는 곳이다.
						  컨테이너(웹컨테이너=우리는 tomcat 사용)에게 해당 파일을 어떻게 처리해야 하는지 전달하는 내용을 담고 있다.
		1. 형태 : <%@ %>
			1-1. <%@ page %>    => 해당 페이지를 컨테이너가 처리하는데 필요한 정보를 기술하는 지시어
			1-2. <%@ include %> => 해당 파일 안에 다른 html이나 jsp 파일을 삽입할 수 있도록 도와주는 기능을 하는 지시어
								 HTML의 <iframe>과 비슷하다.
			1-3. <%@ taglib %>  => JSP 기능을 확장하기 위해 만들어진 라이브러리를 
								 해당 페이지에서 사용할 수 있도록 도와주는 기능을 하는 지시어
		
		2. 각 형태의 속성 및 설명 : 속성은 자주색으로 표시된다.
			2-1. <%@ page %> 속성들
				- language="값" 			    => script 코드에서 사용하는 언어 지정 속성
				- contentType="값"   	    => 해당 페이지의 문서 타입과 문자셋 지정(charactor Encoding)
					- 인코딩(암호화, 부호화) : 정보형태를 변환
					- 디코딩(복호화)		  : 인코딩으로 변환된 정보를 원래대로 되돌리는 것
				- pageEncoding= "값" 	    => 해당 페이지의 인코딩 형식을 지정해주는 속성
				- session="true or false"   => session(저장공간) 사용 여부, 디폴트값 true
				- buffer="값"		        => 출력에 사용되는 임시저장 공간(session과 다르다), 디폴트값 8kb
				- autoFlush="true or false" => 출력 buffer가 다 채워지지 않아도 바로 출력 시켜준다, 디폴트 true
				- errorPage="값"				=> 해당 페이지에서 오류가 발생하면 오류를 처리할 페이지를 지정
				- isErrorPage="true or flase" => 해당 페이지가 오류를 처리하면 페이지이면 true, 아니면 false
			
			2-2. <%@ include file="삽입할 파일위치와 이름" %>
			** include는 지시어를 사용하는 방법과 action태그를 사용하는 방법 두가지가 있다.
			
			2-3. <%@ tagliv %> : 해당 페이지에서 사용할 태그 라이브러리 지정
								 나중에 JSTL 할 때 필요(JSTL이 있어야 반복문 처리가 가능하다.)
			
	--%>
	
	<%@ %>
</body>
</html>