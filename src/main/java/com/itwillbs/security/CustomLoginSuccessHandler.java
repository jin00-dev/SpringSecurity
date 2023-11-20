package com.itwillbs.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	private static final Logger logger = LoggerFactory.getLogger(CustomLoginSuccessHandler.class);
	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		logger.debug("CustomLoginSuccessHandler_onAuthenticationSuccess() 호출");
		logger.debug("인증 성공 시 (로그인 성공)에 처리하는 동작 제어");
		
		// 사용자 아이디 권한에 따른 페이지 이동
		//
		//1. 사용자가 어떤 권한을 가지고 있는지 정보가 필요 함 
		List<String> roleNames =new ArrayList<String>();
		
		//인증정보 (+권한 정보) 저장 / 람다식 사용해봐써!!  
		authentication.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
		});
		
		logger.debug("인증(권한) 확인 : " + roleNames);
//		 위의 람다식과 의미는 같음 
//		ctrl + 1 하고 Convert to ~~ 누르면 익명 클래스로 바뀌고 다시 하면 람다로 돌아가고...
//		authentication.getAuthorities().forEach(new Consumer<GrantedAuthority>() {
//			@Override
//			public void accept(GrantedAuthority authority) {
//				roleNames.add(authority.getAuthority());
//			}
//		});
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/sec/admin");
			return;
		}//if
		
		if(roleNames.contains("ROLE_MANAGER")) {
			response.sendRedirect("/sec/member");
			return;
		}//if
		response.sendRedirect("/sec/all");
		
		// if else-if 써도 되지만 페이지 이동에는 위에거가 낫다.
	}

}//CustomLoginSuccessHandler
