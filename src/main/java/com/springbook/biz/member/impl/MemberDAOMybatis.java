package com.springbook.biz.member.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.member.MemberFileVO;
import com.springbook.biz.member.MemberVO;

@Repository
public class MemberDAOMybatis {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 로그인
	public MemberVO login(MemberVO vo) {
		System.out.println("==> Mybatis로 login() 기능 처리");
		return mybatis.selectOne("MemberDAO.login", vo);
	}
	
	
	// insert member (회원가입)
	public void insertMember(MemberVO vo) {
		System.out.println("===>MyBatis로 insertMember 기능처리");
		mybatis.insert("MemberDAO.insertMember", vo);		
	}		
	
	// insert file
	public void insertMemberFileList(List<MemberFileVO> fileList) {
		for(MemberFileVO MemberFile : fileList) {
			mybatis.insert("MemberDAO.insertMemberFileList", MemberFile);
		}
	}
	
	// 맴버시퀀스 얻기
		public int getMemberSeq() {
			return mybatis.selectOne("MemberDAO.getMemberSeq");
		}
	
	// 아이디찾기
	public MemberVO findId(MemberVO vo) {
		System.out.println("==> Mybatis로 findId() 기능 처리");
		return mybatis.selectOne("MemberDAO.findId", vo);
	}
	
	// 비밀번호 찾기
	public MemberVO findPassword(MemberVO vo) {
		System.out.println("==> Mybatis로 findPassword() 기능 처리");
		return mybatis.selectOne("MemberDAO.findPassword", vo);
	}
	
	// 회원정보 수정
	public void updateMember(MemberVO vo) {
		System.out.println("====> Mybatis로 updateMember() 기능 처리");
		mybatis.update("MemberDAO.updateMember", vo);
	}
	
	// 회원정보 가져오기
	public MemberVO getMember(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.getMember", vo);
	}


	
	
	
}
