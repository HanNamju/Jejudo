package com.springbook.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardFileVO;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.FreeCommentVO;

@Repository
public class BoardDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertBoard(BoardVO vo) {
		System.out.println("====> Mybatis�� insertBoard() ��� ó��");
		mybatis.insert("BoardDAO.insertBoard", vo);
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("====> Mybatis�� updateBoard() ��� ó��");
		mybatis.update("BoardDAO.updateBoard", vo);
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("====> Mybatis�� deleteBoard() ��� ó��");
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("====> Mybatis�� getBoard() ��� ó��");
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("====> Mybatis�� getBoardList() ��� ó��");
		return mybatis.selectList("BoardDAO.getBoardList", vo);
	}

	public int getBoardSeq() {
		return mybatis.selectOne("BoardDAO.getBoardSeq");
	}

	public void insertBoardFileList(List<BoardFileVO> fileList) {
		for (BoardFileVO boardFile : fileList) {
			mybatis.insert("BoardDAO.insertBoardFileList", boardFile);
		}
	}

	public BoardFileVO getBoardFileList(int seq) {
		return mybatis.selectOne("BoardDAO.getBoardFileList", seq);
	}

	public void deleteFile(BoardFileVO vo) {
		mybatis.delete("BoardDAO.deleteFile", vo);
	}

	public void deleteFileList(int seq) {
		mybatis.delete("deleteFileList", seq);
	}

	public List<BoardVO> getMyBoardList(BoardVO vo) {
		return mybatis.selectList("BoardDAO.getMyBoardList", vo);
	}

	public List<BoardVO> getBoardCategory(BoardVO vo) {
		return mybatis.selectList("BoardDAO.getBoardCategory", vo);
	}

	// ��� ��� ����
	public List<FreeCommentVO> freeCommentList(FreeCommentVO vo) {
		System.out.println("====> Mybatis�� getBoardList() ��� ó��");
		return mybatis.selectList("BoardDAO.freeCommentList", vo);
	}

	public void insertBoardComment(FreeCommentVO vo) {
		System.out.println("====> Mybatis�� insertBoard() ��� ó��");
		mybatis.insert("BoardDAO.insertBoardComment", vo);
	}

	public void updateCnt(BoardVO vo) {
		mybatis.update("BoardDAO.updateCnt", vo);

	}

	public void deleteComment(FreeCommentVO vo) {
		mybatis.delete("BoardDAO.deleteComment", vo);
	}
}
