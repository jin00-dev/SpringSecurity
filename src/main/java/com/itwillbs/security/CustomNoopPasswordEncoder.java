package com.itwillbs.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomNoopPasswordEncoder implements PasswordEncoder{
	//암호화를 할 수 있도록 틀이 만들어져 있는 것..? PasswordEncoder
	
	private static final Logger logger = LoggerFactory.getLogger(CustomNoopPasswordEncoder.class);
	
	@Override
	public String encode(CharSequence rawPassword) {
		// 비밀번호 암호화 처리하는 메서드
		logger.debug("암호화 처리 완료"); //메세지만 출력 
		//rawPassword => 암호화 전 패스워드 
		return rawPassword.toString(); //패스워드를 그냥 String으로 받는다.
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		// 암호화 된 비밀번호가 같은지 비교하는 메서드 
		logger.debug("rawPassword : "+ rawPassword );// 암호화 전의 패스워드 
		logger.debug("encodedPassword : " + encodedPassword);//암호화 된 패스워드 
		return rawPassword.toString().equals(encodedPassword);
	}

}//CustomNoopPasswordEncoder
