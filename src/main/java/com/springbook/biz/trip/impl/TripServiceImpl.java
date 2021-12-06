package com.springbook.biz.trip.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.trip.CommentVO;
import com.springbook.biz.trip.TripFileVO;
import com.springbook.biz.trip.TripMemberVO;
import com.springbook.biz.trip.TripService;
import com.springbook.biz.trip.TripVO;

@Service("tripService")
public class TripServiceImpl implements TripService {

	@Autowired
	private TripDAOMybatis tripDAO;

	@Override
	public void insertTrip(TripVO vo) {
		tripDAO.insertTrip(vo);
	}

	@Override
	public void deleteTrip(TripVO vo) {
		tripDAO.deleteTrip(vo);
	}

	// ���� �� ��ȸ
	@Override
	public TripVO getTrip(TripVO vo) {
		// TODO Auto-generated method stub
		return tripDAO.getTrip(vo);
	}

	@Override
	public List<TripVO> getTripList(TripVO vo) {
		// TODO Auto-generated method stub
		return tripDAO.getTripList(vo);
	}

	@Override
	public int getTripSeq() {
		// TODO Auto-generated method stub
		return tripDAO.getTripSeq();
	}

	@Override
	public void insertTripFileList(List<TripFileVO> fileList) {
		tripDAO.insertTripFileList(fileList);

	}

	@Override
	public List<TripFileVO> getTripFileList(int seq) {
		return tripDAO.getTripFileList(seq);
	}

	@Override
	public void deleteFile(TripFileVO vo) {
		tripDAO.deleteFile(vo);

	}

	@Override
	public void deleteFileList(int seq) {
		tripDAO.deleteFileList(seq);

	}

	@Override
	public void insertTripMembers(TripMemberVO vo) {
		tripDAO.insertTripMembers(vo);

	}

	// ����� ���� �ο��� ��ȸ
	@Override
	public int countMember(TripMemberVO vo) {
		return tripDAO.countMember(vo);
	}

	// ����� �ο� �ߺ� �˻�
	@Override
	public int checkContain(TripMemberVO vo) {
		return tripDAO.checkContain(vo);
	}

	// ################################ ���ִ� ���� ##################################

	@Override
	public List<CommentVO> readComment(int seq) {
		return tripDAO.readComment(seq);
	}

	@Override
	public void insertComment(CommentVO vo) {
		tripDAO.insertComment(vo);
	}

}
