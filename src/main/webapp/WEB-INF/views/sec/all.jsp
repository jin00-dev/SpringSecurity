<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>all.jsp</h1>
	
	<!-- 로그인 여부에 따른 페이지 이동 로직 추가 -->
	<!-- 로그인 상태 => 로그아웃 버튼 / 로그아웃 => 로그인 페이지 -->
	<!-- access="isAnonymous()" => 익명 사용자가 로그인 했을 때 = 로그인 안했을 때 / 시큐리티 내부 함수 -->
	<sec:authorize access="isAnonymous()">
	<h3><a href="/customLogin"> 로그인 </a></h3>
	</sec:authorize>
	
	<!-- access="isAuthenticated()" 인증된 사용자라면 true 리턴 = 로그인 했을 때  -->
	<sec:authorize access="isAuthenticated()">
	<h3><a href="/customLogout"> 로그아웃 </a></h3>
	</sec:authorize>
	
</body>
</html>