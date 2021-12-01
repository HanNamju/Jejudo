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


		public PlaceFileVO getPlaceFileList(int pSeq) {
			return (PlaceFileVO)mybatis.selectOne("PlaceDAO.getPlaceFileList", pSeq);
		}

		public PlaceVO getPlace(PlaceVO vo) {
			return (PlaceVO)mybatis.selectOne("PlaceDAO.getPlace", vo);
		}
		
		public List<PlaceVO> getPlaceAllList(PlaceVO vo) {
			System.out.println("====> Mybatis로 getPlaceAllList() 기능 처리");
			return mybatis.selectList("PlaceDAO.getPlaceAllList", vo);
			
		}
		
		public List<PlaceVO> getPlaceList(PlaceVO vo) {
			System.out.println("====> Mybatis로 getPlaceListt() 기능 처리");
			return mybatis.selectList("PlaceDAO.getPlaceList", vo);
		}
		

}
