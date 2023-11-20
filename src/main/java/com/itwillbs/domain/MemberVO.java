package com.itwillbs.domain;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class MemberVO {

	private String userid;
	private String userpw;
	private String username;
	private String useremail;
	
	private boolean enabled;
	
	private Timestamp regdate;
	private Timestamp updatedate;
	
	private List<AuthVO> authList; 
	// 회원정보는 권한을 가질 수 있는데 권한이 여러개 생길 수 있으므로 한번에 저장 할 수 있는 list 생성 
	
	// get,set 메서드 , toString 메서드 만들었는데 우리는 안만들거야 롬복이 알아서 만들었어
	
	
	
	
	
}
