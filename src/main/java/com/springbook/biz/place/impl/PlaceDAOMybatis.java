package com.springbook.biz.place.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.place.PlaceReviewCmVO;
import com.springbook.biz.place.PlaceVO;

@Repository
public class PlaceDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertPlace(PlaceVO vo) {
		System.out.println("====> Mybatis�� insertBoard() ��� ó��");
		mybatis.insert("PlaceDAO.insertPlace", vo);
	}

	public int getPlaceSeq() {
		return mybatis.selectOne("PlaceDAO.getPlaceSeq");
	}

	public void deletePlace(PlaceVO vo) {
		mybatis.delete("PlaceDAO.deletePlace", vo);

	}

	public void updatePlace(PlaceVO vo) {

		mybatis.update("PlaceDAO.updatePlace", vo);
	}

	/*
	 * public void insertPlaceFileList(List<PlaceFileVO> fileList) { for(PlaceFileVO
	 * placeFile : fileList) { mybatis.insert("PlaceDAO.insertPlaceFileList",
	 * placeFile); } }
	 * 
	 * 
	 * public PlaceFileVO getPlaceFileList(int pSeq) {
	 * 
	 * return (PlaceFileVO)mybatis.selectOne("PlaceDAO.getPlaceFileList", pSeq); }
	 */

	public PlaceVO getPlace(PlaceVO vo) {
		return (PlaceVO) mybatis.selectOne("PlaceDAO.getPlace", vo);
	}

	public List<PlaceVO> getPlaceAllList(PlaceVO vo) {
		System.out.println("====> Mybatis�� getPlaceAllList() ��� ó��");
		return mybatis.selectList("PlaceDAO.getPlaceAllList", vo);

	}

	public List<PlaceVO> getPlaceList(PlaceVO vo) {
		System.out.println("====> Mybatis�� getPlaceListt() ��� ó��");
		return mybatis.selectList("PlaceDAO.getPlaceList", vo);
	}

	public void updatePlaceFile(PlaceVO vo) {
		mybatis.update("PlaceDAO.updatePlaceFile", vo);

	}

//		���� 1206 ����
	public List<PlaceVO> getReviewBoardList(PlaceVO vo) {
		System.out.println("====> Mybatis�� getReviewBoardList() ��� ó��");
		List<Map<String, Object>> Reviewlist = new ArrayList<Map<String, Object>>();
		Reviewlist = mybatis.selectList("PlaceDAO.getReviewBoardList", vo);
		for (int i = 0; i < Reviewlist.size(); i++) {
			System.out.println(Reviewlist.get(i).toString());
		}
		return mybatis.selectList("PlaceDAO.getReviewBoardList", vo);
	}

	public Map<String, Object> getReviewWriteList(PlaceVO vo) {
		System.out.println("====> Mybatis�� getReviewWriteList() ��� ó��");
		List<Map<String, Object>> ReviewWritelist = new ArrayList<Map<String, Object>>();
		ReviewWritelist = mybatis.selectList("PlaceDAO.getReviewWriteList", vo);
		System.out.println("------------------------------------------------");
		for (int i = 0; i < ReviewWritelist.size(); i++) {
			System.out.println(ReviewWritelist.get(i).toString());
		}
		return mybatis.selectOne("PlaceDAO.getReviewWriteList", vo);
	}

	// insertPlaceReview (�����Է�)
	public void insertPlaceReview(PlaceReviewCmVO vo) {
		System.out.println("===>MyBatis�� insertPlaceReview ���ó��");
		mybatis.insert("PlaceDAO.insertPlaceReview", vo);
	}

}
