package com.springbook.biz.member.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.member.MemberVO;

@Repository
public class MemberDAOMybatis {

	@Autowired
	private SqlSessionTemplate mybatis;

	// �α���
	public MemberVO login(MemberVO vo) {
		System.out.println("==> Mybatis�� login() ��� ó��");
		return mybatis.selectOne("MemberDAO.login", vo);
	}

	// insert member (ȸ������)
	public void insertMember(MemberVO vo) {
		System.out.println("===>MyBatis�� insertMember ���ó��");
		mybatis.insert("MemberDAO.insertMember", vo);
	}

	// �ɹ������� ���
	public int getMemberSeq() {
		return mybatis.selectOne("MemberDAO.getMemberSeq");
	}

	// ���̵�ã��
	public MemberVO findId(MemberVO vo) {
		System.out.println("==> Mybatis�� findId() ��� ó��");
		return mybatis.selectOne("MemberDAO.findId", vo);
	}

	// ��й�ȣ ã��
	public MemberVO findPassword(MemberVO vo) {
		System.out.println("==> Mybatis�� findPassword() ��� ó��");
		return mybatis.selectOne("MemberDAO.findPassword", vo);
	}

	// ȸ������ ����
	public void updateMember(MemberVO vo) {
		System.out.println("====> Mybatis�� updateMember() ��� ó��");
		mybatis.update("MemberDAO.updateMember", vo);
	}

	// ȸ������ ��������
	public MemberVO getMember(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.getMember", vo);
	}
	
	//���̵� �ߺ� üũ
	public MemberVO idChk(String id) {
		System.out.println("====> Mybatis��idChk() ��� ó��");
		MemberVO member = mybatis.selectOne("MemberDAO.idChk", id);
		return member;
	}

	// ȸ�� Ż��
	public void Withdrawal(MemberVO vo) {
		System.out.println("===>MyBatis�� Withdrawal ���ó��");
		mybatis.update("MemberDAO.Withdrawal", vo);
	}

	//���̵� ���ϱ�
	public MemberVO existId(String mId) {
		System.out.println("====> Mybatis��existId() ��� ó��");
		MemberVO member = mybatis.selectOne("MemberDAO.existId", mId);
		return member;
	}

	// �ɹ��������ͽ� ���
	public int getMemberAccountStatus(String mId) {
		System.out.println("====> Mybatis��AccountStatus() ��� ó��");
		return mybatis.selectOne("MemberDAO.getMemberAccountStatus", mId);
	}


	// 11.24�� ������� ����
	public List<MemberVO> getMemberList(MemberVO vo) {
		System.out.println("====> Mybatis�� getMemberList() ��� ó��");
		return mybatis.selectList("MemberDAO.getMemberList", vo);
	}

	public void memberBan(MemberVO vo) {

		mybatis.update("MemberDAO.memberBan", vo);
	}

	public void memberKeep(MemberVO vo) {

		mybatis.update("MemberDAO.memberKeep", vo);
	}
}
