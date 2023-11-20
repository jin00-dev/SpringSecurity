package com.itwillbs.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccessDeniedHandler implements AccessDeniedHandler{
	// 접근 권한 없는 페이지 접근 시 처리하는 동작 
	// 추가적인 동작 => 세션정보수정, 쿠키 값 변경 등 
	
	// AccessDeniedHandler => 접근 거부할 때 다루는 것..?! 

	private static final Logger logger = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		//request => 세션 정보 및 쿠키값 등 작업 가능...?!? 

		logger.debug("AccessDeniedHandler_handle() 실행");
		logger.debug("접근 권한이 없는 페이지 접근시에 실행 됩니다.");
		
		logger.debug(request.getRemoteAddr()+ "주소에서 접속!");
		
		//세션 초기화 (예시임 뭐 할지는 정의 하면 됨~~) 
		HttpSession session = request.getSession();
		session.invalidate();
		
		//페이지 강제 이동
		logger.debug("페이지 강제 이동!");
		response.sendRedirect("/accessErr");
		
		// 기존에는 에러페이지 보여주고 페이지 이동만 하게 함 이제는 세션도 뺏고 강제 이동도 함
		
	}
	
	
}
