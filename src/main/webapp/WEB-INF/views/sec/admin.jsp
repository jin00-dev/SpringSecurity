<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>admin.jsp</h1>
	
	<a href="/sec/all"> all 페이지 </a> <hr>
	<a href="/sec/member"> member 페이지 </a> <hr>
	
	
	<a href="/customLogout"> 로그아웃 </a>
	
	<hr>
	principal : <sec:authentication property="principal"/><br>
	principal.username : <sec:authentication property="principal.username"/>
	
</body>
</html>