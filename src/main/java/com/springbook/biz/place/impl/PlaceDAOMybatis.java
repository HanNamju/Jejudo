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
		System.out.println("====> Mybatis로 insertBoard() 기능 처리");
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
			System.out.println("====> Mybatis로 getPlacelist() 기능 처리");
			return mybatis.selectList("PlaceDAO.getPlaceList", vo);
			
		}
		
		public List<PlaceVO> getCafeList(PlaceVO vo) {
			System.out.println("====> Mybatis로 getCafeList() 기능 처리");
			return mybatis.selectList("PlaceDAO.getCafeList", vo);
		}
		
		public List<PlaceVO> getRestaurantList(PlaceVO vo) {
			System.out.println("====> Mybatis로 getRestaurantList() 기능 처리");
			return mybatis.selectList("PlaceDAO.getRestaurantList", vo);
		}
		
		public List<PlaceVO> getRoomsList(PlaceVO vo) {
			System.out.println("====> Mybatis로 getRoomsList() 기능 처리");
			return mybatis.selectList("PlaceDAO.getRoomsList", vo);
		}
		public List<PlaceVO> getTourList(PlaceVO vo) {
			System.out.println("====> Mybatis로 getTourList() 기능 처리");
			return mybatis.selectList("PlaceDAO.getTourList", vo);
		}
}
