package com.springbook.biz.member;

import java.util.List;

import com.springbook.biz.place.PlaceVO;



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
	
	// 11.24일 유저목록 구현
	List<MemberVO> getMemberList(MemberVO vo);
	
	//회원권한 정지
	void memberBan(MemberVO vo);
	
	//회원권한 복구
	void memberKeep(MemberVO vo);


}
