package com.springbook.biz.member;

import java.util.List;

import com.springbook.biz.member.MemberFileVO;
import com.springbook.biz.member.MemberVO;



public interface MemberService {
	//CRUD 기능의 메소드 구현
	
	// 로그인
	MemberVO login(MemberVO vo);
	
	// 회원가입
	void insertMember(MemberVO vo);
	
	// 맴버 스퀀스 조회
	int getMemberSeq();

	void insertMemberFileList(List<MemberFileVO> fileList);
	
	// 아이디 찾기
	MemberVO findId(MemberVO vo);
	
	// 비밀번호 찾기
	MemberVO findPassword(MemberVO vo);
	
	//회원 수정
	void updateMember(MemberVO vo);
	
	//회원정보 받아오기
	MemberVO getMember(MemberVO vo);

	
}
