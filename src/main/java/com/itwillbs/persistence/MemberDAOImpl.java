package com.itwillbs.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

@Repository(value = "memberDAO")
public class MemberDAOImpl {
	
	@Inject
	private SqlSession sqlSession;
	
	// 회원정보 조회 (+권한정보 조회) 메서드 생성 
	public MemberVO getMemberAuth(String userid) {
		
		return sqlSession.selectOne("com.itwillbs.mapper.MemberMapper.getMemberAuth", userid);
	}
	
	
}
