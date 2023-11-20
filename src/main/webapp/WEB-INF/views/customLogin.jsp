<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>customLogin.jsp</h1>
	
	<h2>ITWILL 로그인 페이지</h2>
	
	${_csrf }
	
	<form action="/login" method="post">
		아이디 : <input type="text" name="username"> <br>
		비밀번호 : <input type="password" name="password"> <br>
		<input type="submit" value="로그인">
		<!-- CSRF 토큰정보 생성 (상용 서비스에서는 절대로!!! 여기에 쓰면 안됨..!!)/ 인증매니저가 확인~ -->
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
	</form>

</body>
</html>