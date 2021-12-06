package com.springbook.biz.board;

import java.util.List;

public interface BoardService {
	// CRUD ����� �޼ҵ� ����
	// �� ���
	void insertBoard(BoardVO vo);

	// �� ����
	void updateBoard(BoardVO vo);

	// �� ����
	void deleteBoard(BoardVO vo);

	// �� �� ��ȸ
	BoardVO getBoard(BoardVO vo);

	// �� ��� ��ȸ
	List<BoardVO> getBoardList(BoardVO vo);

	// �� ��� �� ��� �� �Ϸù�ȣ ȹ��
	int getBoardSeq();

	// ��� ���� ����Ʈ ���
	void insertBoardFileList(List<BoardFileVO> fileList);

	// ���ϸ�� ����
	BoardFileVO getBoardFileList(int seq);

	// ���ϻ���
	void deleteFile(BoardFileVO vo);

	// �Խñ� ���� �� �ش� �Խñ��� ÷������ ��� ����
	void deleteFileList(int seq);

	List<BoardVO> getMyBoardList(BoardVO vo);

	List<BoardVO> getBoardCategory(BoardVO vo);

	// �� ��� ��ȸ
	List<FreeCommentVO> freeCommentList(FreeCommentVO vo);

	// ��� ���
	void insertBoardComment(FreeCommentVO vo);

	// ��ȸ��
	void updateCnt(BoardVO vo);

	// ��� ����
	void deleteComment(FreeCommentVO vo);
}
