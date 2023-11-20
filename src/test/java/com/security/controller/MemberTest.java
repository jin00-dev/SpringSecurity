package com.security.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAOImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		{
		"file:src/main/webapp/WEB-INF/spring/security-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		})
public class MemberTest {

	private static final Logger logger = LoggerFactory.getLogger(MemberTest.class);
	
	//디비접속 
	@Autowired  // @inject와 같음 
	private DataSource ds;
	
	//암호화 처리 객체
	@Inject
	private PasswordEncoder passEncoder;
	
	//DAO객체 주입 
	@Inject
	private MemberDAOImpl dao;
	
//	@Test
	public void 객체확인()throws Exception{
		logger.debug("@@@@ds : " + ds);
		logger.debug("@@@@passEncoder : " + passEncoder );
	}
	
//	@Test 암호화 처리 해서 더미데이터 생성 
	public void 회원가입_암호화처리() throws Exception {
		
		// 디비 연결 
		Connection con = ds.getConnection();
		
		//SQL 작성 매퍼 안씀...
		String sql = "insert into tbl_member (userid, userpw, username) values(?,?,?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		//더미데이터 채우기  
		for(int i = 0; i < 100; i++) {
			
			// 비밀번호는 암호화 처리 
			pstmt.setString(2, passEncoder.encode("pw"+i));
			
			if(i < 80) {
				pstmt.setString(1, "user"+i);
				pstmt.setString(3, "일반사용자"+i);
			}else if (i < 90) {
				pstmt.setString(1, "manager"+i);
				pstmt.setString(3, "매니저"+i);
			}else {
				pstmt.setString(1, "admin"+i);
				pstmt.setString(3, "관리자"+i);
			}//else
			
			pstmt.executeUpdate();
		}//for
		logger.debug("@@@@ 회원 가입 완료");
	}//회원가입_암호화처리
	
//	@Test
	public void 회원가입_권한부여() throws Exception {
		
		// 디비 연결 
		Connection con = ds.getConnection();
		
		//SQL 작성 매퍼 안씀...
		String sql = "insert into tbl_member_auth (userid, auth) values(?,?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		//더미데이터 채우기  
		for(int i = 0; i < 100; i++) {
			
			// 비밀번호는 암호화 처리 
			
			if(i < 80) {
				pstmt.setString(1, "user"+i);
				pstmt.setString(2, "ROLE_USER");
			}else if (i < 90) {
				pstmt.setString(1, "manager"+i);
				pstmt.setString(2, "ROLE_MANAGER");
			}else {
				pstmt.setString(1, "admin"+i);
				pstmt.setString(2, "ROLE_ADMIN");
			}//else
			
			pstmt.executeUpdate();
		}//for
		logger.debug("@@@@ 회원 권한설정 완료");
	}//회원가입_권한부여
	
	@Test
	public void 회원정보_출력() throws Exception {
		
		MemberVO vo = dao.getMemberAuth("admin90");
		logger.debug("@@@@ vo : " + vo);
		
	}
	
	
	
	
}//MemberTest
