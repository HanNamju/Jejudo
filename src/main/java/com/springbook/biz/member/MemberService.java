package com.springbook.biz.member;

import java.util.List;

import com.springbook.biz.member.MemberVO;

public interface MemberService {
	// CRUD ����� �޼ҵ� ����

	// �α���
	MemberVO login(MemberVO vo);

	// ȸ������
	void insertMember(MemberVO vo);

	// �ɹ� ������ ��ȸ
	int getMemberSeq();

	// ���̵� ã��
	MemberVO findId(MemberVO vo);

	// ��й�ȣ ã��
	MemberVO findPassword(MemberVO vo);

	// ȸ�� ����
	void updateMember(MemberVO vo);

	// ȸ������ �޾ƿ���
	MemberVO getMember(MemberVO vo);

	// ���̵� �ߺ�üũ�ϱ�
	MemberVO idChk(String id);

	// ȸ�� Ż��
	void Withdrawal(MemberVO vo);
	
	//DB�� �ִ� ���̵����� Ȯ���ϱ�
	MemberVO existId(String mId);
	
	//DB�� AccountStatus Ȯ���ϱ�
	int getMemberAccountStatus(String mId);

	// 11.24�� ������� ����
	List<MemberVO> getMemberList(MemberVO vo);

	// ȸ������ ����
	void memberBan(MemberVO vo);

	// ȸ������ ����
	void memberKeep(MemberVO vo);

}
