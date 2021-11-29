package com.springbook.biz.place.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.place.PlaceFileVO;
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


		public void insertPlaceFileList(List<PlaceFileVO> fileList) {
		for(PlaceFileVO placeFile : fileList) {
			mybatis.insert("PlaceDAO.insertPlaceFileList", placeFile);
		}
	}


		public List<PlaceFileVO> getPlaceFileList(int pSeq) {
			return mybatis.selectList("PlaceDAO.getPlaceFileList", pSeq);
		}


		public PlaceVO getPlace(PlaceVO vo) {
			return (PlaceVO)mybatis.selectOne("PlaceDAO.getPlace", vo);
		}
		
		public List<PlaceVO> getPlaceList(PlaceVO vo) {
			System.out.println("====> Mybatis�� getPlacelist() ��� ó��");
			return mybatis.selectList("PlaceDAO.getPlaceList", vo);
			
		}
		
		public List<PlaceVO> getCafeList(PlaceVO vo) {
			System.out.println("====> Mybatis�� getCafeList() ��� ó��");
			return mybatis.selectList("PlaceDAO.getCafeList", vo);
		}
		
		public List<PlaceVO> getRestaurantList(PlaceVO vo) {
			System.out.println("====> Mybatis�� getRestaurantList() ��� ó��");
			return mybatis.selectList("PlaceDAO.getRestaurantList", vo);
		}
		
		public List<PlaceVO> getRoomsList(PlaceVO vo) {
			System.out.println("====> Mybatis�� getRoomsList() ��� ó��");
			return mybatis.selectList("PlaceDAO.getRoomsList", vo);
		}
		public List<PlaceVO> getTourList(PlaceVO vo) {
			System.out.println("====> Mybatis�� getTourList() ��� ó��");
			return mybatis.selectList("PlaceDAO.getTourList", vo);
		}
}
