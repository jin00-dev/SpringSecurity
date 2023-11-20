package com.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonsController {

	private static final Logger logger = LoggerFactory.getLogger(CommonsController.class);

	// 권한 없이 접근하는 경우 처리하는 메서드 (403에러 시 사용)
	@RequestMapping(value = "/accessErr", method = RequestMethod.GET)
	public void accessDenide(Authentication auth,Model model) throws Exception {
		logger.debug("accessDenide() 호출");
		logger.debug("접근권한 없는 페이지 접근 시도!!");
		
		logger.debug(""+auth);
		model.addAttribute("auth", auth);
	}
	
	//로그인 페이지 설정 
	@RequestMapping(value = "/customLogin", method = RequestMethod.GET)
	public void LoginGET() throws Exception{
		logger.debug("LoginGET() 실행");
		logger.debug(" 시큐리티 기본 Login페이지가 아닌 사용자 정의 Login 페이지");
		// /view/customLogin.jsp 연결 후 이동
		
	}
	
	// 로그아웃 설정 /customLogout
	@RequestMapping(value = "/customLogout", method = RequestMethod.GET)
	public void logoutGET() throws Exception{
		logger.debug("logoutGET() 실행");
		logger.debug("로그아웃 처리 + 세션 초기화");
		
		
	}
	
	
}//CommonsController
