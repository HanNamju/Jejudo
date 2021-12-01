package com.springbook.biz.member;

import java.util.List;

import com.springbook.biz.place.PlaceVO;



public interface MemberService {
	//CRUD ����� �޼ҵ� ����
	
	// �α���
	MemberVO login(MemberVO vo);
	
	// ȸ������
	void insertMember(MemberVO vo);
	
	// �ɹ� ������ ��ȸ
	int getMemberSeq();

	void insertMemberFileList(List<MemberFileVO> fileList);
	
	// ���̵� ã��
	MemberVO findId(MemberVO vo);
	
	// ��й�ȣ ã��
	MemberVO findPassword(MemberVO vo);
	
	//ȸ�� ����
	void updateMember(MemberVO vo);
	
	//ȸ������ �޾ƿ���
	MemberVO getMember(MemberVO vo);
	
	// 11.24�� ������� ����
	List<MemberVO> getMemberList(MemberVO vo);
	
	//ȸ������ ����
	void memberBan(MemberVO vo);
	
	//ȸ������ ����
	void memberKeep(MemberVO vo);


}
