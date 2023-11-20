package com.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/sec")
public class SecurityController {

	private static final Logger logger = LoggerFactory.getLogger(SecurityController.class); // = @log4j 같은 의미
	
	//http://localhost:8088/sec/all
	
	@RequestMapping(value = "/all" ,method = RequestMethod.GET)
	public void doAll() {
		logger.debug("doAll() 실행");
		logger.debug("/sec/all.jsp 뷰페이지 출력");
		logger.debug("아무나 접근 가능한 페이지");
	}
	
	//http://localhost:8088/sec/member
	@RequestMapping(value = "/member" , method = RequestMethod.GET)
	public void doMember() {
		logger.debug("doMember() 실행");
		logger.debug("/sec/member.jsp 뷰페이지 출력");
		logger.debug("회원(member)만 접근 가능한 페이지");
	}

	//http://localhost:8088/sec/admin
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public void doAdmin() {
		logger.debug("doAdmin() 실행");
		logger.debug("/sec/admin.jsp 뷰페이지 출력");
		logger.debug("관리자(admin)만 접근 가능한 페이지");
	}
	
	
	
}
