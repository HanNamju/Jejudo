package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardFileVO;
import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.FreeCommentVO;

@Service("boardService")
/*
 * �������� ó���� ����ϴ� Ŭ���� ex) ������ü ��� ó���� �� DB�Է��� DAO �ϰ� �Ǵµ� DB�Է� �� �ʿ��� �۾���(���¾�ȣȭ, �ݾ�
 * �ĸ� �߰�...) �ϴ� �������� ServiceImplŬ�������� ó�����ָ� ��
 */
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAOMybatis boardDAO;

	public void insertBoard(BoardVO vo) {
		// ��ü ���� �ÿ� �ʵ� ������ intŸ�Ե��� 0���� �ʱ�ȭ ��
//		if(vo.getSeq() == 0) { 
//			throw new IllegalArgumentException("0�� ���� ����� �� �����ϴ�."); 
//		}
		boardDAO.insertBoard(vo);
		/* boardDAO.insertBoard(vo); */
	}

	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

	public int getBoardSeq() {
		return boardDAO.getBoardSeq();
	}

	public void insertBoardFileList(List<BoardFileVO> fileList) {
		boardDAO.insertBoardFileList(fileList);
	}

	public BoardFileVO getBoardFileList(int seq) {
		return boardDAO.getBoardFileList(seq);
	}

	public void deleteFile(BoardFileVO vo) {
		boardDAO.deleteFile(vo);
	}

	public void deleteFileList(int seq) {
		boardDAO.deleteFileList(seq);
	}

	@Override
	public List<BoardVO> getMyBoardList(BoardVO vo) {
		return boardDAO.getMyBoardList(vo);
	}

	@Override
	public List<BoardVO> getBoardCategory(BoardVO vo) {
		return boardDAO.getBoardCategory(vo);
	}

	@Override
	public List<FreeCommentVO> freeCommentList(FreeCommentVO vo) {
		return boardDAO.freeCommentList(vo);
	}

	public void insertBoardComment(FreeCommentVO vo) {

		boardDAO.insertBoardComment(vo);
	}

	public void updateCnt(BoardVO vo) {
		boardDAO.updateCnt(vo);

	}

	public void deleteComment(FreeCommentVO vo) {
		boardDAO.deleteComment(vo);
	}
}
