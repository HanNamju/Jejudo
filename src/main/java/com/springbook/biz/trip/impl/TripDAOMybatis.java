package com.springbook.biz.trip.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.trip.TripFileVO;
import com.springbook.biz.trip.TripFileVO;
import com.springbook.biz.trip.TripVO;

@Repository
public class TripDAOMybatis {
	@Autowired
	private SqlSessionTemplate mybatis;	

	
	public void insertTrip(TripVO vo) {
		System.out.println("====> Mybatis로 insertTrip() 기능 처리");
		mybatis.insert("TripDAO.insertTrip", vo);
	}
	
	public void updateTrip(TripVO vo) {
		System.out.println("====> Mybatis로 updateTrip() 기능 처리");
		mybatis.update("TripDAO.updateTrip", vo);
	}
	
	public void deleteTrip(TripVO vo) {
		System.out.println("====> Mybatis로 deleteTrip() 기능 처리");
		mybatis.delete("TripDAO.deleteTrip", vo);
	}
	
	//여행 상세 조회
	public TripVO getTrip(TripVO vo) {
		System.out.println("====> Mybatis로 getTrip() 기능 처리");
		return (TripVO)mybatis.selectOne("TripDAO.getTrip", vo);
	}

	
	public List<TripVO> getTripList(TripVO vo) {
		System.out.println("====> Mybatis로 getTripList() 기능 처리");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = mybatis.selectList("TripDAO.getTripList", vo);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		return mybatis.selectList("TripDAO.getTripList", vo);
	}
	
	public int getTripSeq() {
		System.out.println("====> Mybatis로 getTripSeq() 기능 처리");
		return mybatis.selectOne("TripDAO.getTripSeq");
	}
	
	public void insertTripFileList(List<TripFileVO> fileList) {
		for(TripFileVO tripFile : fileList) {
			mybatis.insert("TripDAO.insertTripFileList", tripFile);
		}
	}
	
	public List<TripFileVO> getTripFileList(int seq) {
		return mybatis.selectList("TripDAO.getTripFileList", seq);
	}
	
	public void deleteFile(TripFileVO vo) {
		mybatis.delete("TripDAO.deleteFile", vo);
	}
	
	
	public void deleteFileList(int seq) {
		mybatis.delete("TripDAO.deleteFileList", seq);
		
	}



	
	
	

	
	
}
