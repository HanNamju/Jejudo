package com.springbook.biz.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.member.MemberService;
import com.springbook.biz.member.MemberVO;

@Service("memberService")

public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAOMybatis memberDAO;

	// �α���
	@Override
	public MemberVO login(MemberVO vo) {
		return memberDAO.login(vo);
	}

	// ȸ������
	@Override
	public void insertMember(MemberVO vo) {
		memberDAO.insertMember(vo);
	}


	// MEMBER TABLE ���� ��������ȣ ��������
	@Override
	public int getMemberSeq() {
		return memberDAO.getMemberSeq();
	}

	// IDã��
	@Override
	public MemberVO findId(MemberVO vo) {
		return memberDAO.findId(vo);
	}

	// password ã��
	@Override
	public MemberVO findPassword(MemberVO vo) {

		return memberDAO.findPassword(vo);
	}

	// ȸ������ ����
	@Override
	public void updateMember(MemberVO vo) {
		memberDAO.updateMember(vo);

	}

	// ȸ������ ��������
	@Override
	public MemberVO getMember(MemberVO vo) {
		return memberDAO.getMember(vo);

	}

	// ���̵� �ߺ� üũ�ϱ�
	@Override
	public MemberVO idChk(String id) {
		return memberDAO.idChk(id);
	}

	// ȸ�� Ż��
	@Override
	public void Withdrawal(MemberVO vo) {
		memberDAO.Withdrawal(vo);

	}
	
	//DB�� �ִ� ���̵����� Ȯ���ϱ�
	@Override
	public MemberVO existId(String mId) {
		return memberDAO.existId(mId);
	}
	
	//DB�� AccountStatus Ȯ���ϱ�
	@Override
	public int getMemberAccountStatus(String mId) {
		return memberDAO.getMemberAccountStatus(mId);
	}

	// ȸ����� ��������
	public List<MemberVO> getMemberList(MemberVO vo) {
		return memberDAO.getMemberList(vo);
	}

	// ȸ������ ����
	public void memberBan(MemberVO vo) {
		memberDAO.memberBan(vo);
	}

	// ȸ������ ����
	public void memberKeep(MemberVO vo) {
		memberDAO.memberKeep(vo);
	}

}
