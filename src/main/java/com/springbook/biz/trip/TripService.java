package com.springbook.biz.trip;

import java.util.List;

import com.springbook.biz.trip.TripFileVO;
import com.springbook.biz.trip.TripVO;

public interface TripService {
	// CRUD ����� �޼ҵ� ����
	// ����
	void insertTrip(TripVO vo);

	// �� ����
//	void updateTrip(TripVO vo);

	// �� ����
	void deleteTrip(TripVO vo);

	// ���� �� ��ȸ
	TripVO getTrip(TripVO vo);

	// �� ��� ��ȸ
	List<TripVO> getTripList(TripVO vo);

	// �� ��� �� ��� �� �Ϸù�ȣ ȹ��
	int getTripSeq();

	// ��� ���� ����Ʈ ���
	void insertTripFileList(List<TripFileVO> fileList);

	// ���ϸ�� ����
	List<TripFileVO> getTripFileList(int seq);

	// ���ϻ���
	void deleteFile(TripFileVO vo);

	// �Խñ� ������ �ش� �Խñ��� ÷������ ��� ����
	void deleteFileList(int seq);

	// ����ɹ� ���
	void insertTripMembers(TripMemberVO vo);

	// ����� ���� �ο��� ��ȸ
	int countMember(TripMemberVO vo);

	// ����� �ο� �ߺ� �˻�
	int checkContain(TripMemberVO vo);

	// ######################## ���ִ� ���� ####################################

	// ��� �ҷ�����
	List<CommentVO> readComment(int seq);

	void insertComment(CommentVO vo);

}
