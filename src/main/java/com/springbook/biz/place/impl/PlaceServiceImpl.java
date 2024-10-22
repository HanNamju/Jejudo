package com.springbook.biz.place.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.place.PlaceFileVO;
import com.springbook.biz.place.PlaceService;
import com.springbook.biz.place.PlaceVO;

@Service("placeService")
/*
 * 업무로직 처리를 담당하는 클래스
 * ex) 계좌이체 기능 처리할 때 DB입력은 DAO 하게 되는데 
 * 	   DB입력 전 필요한 작업들(계좌암호화, 금액 컴마 추가...) 하는 로직들을 ServiceImpl클래스에서 처리해주면 됨 
 * */
public class PlaceServiceImpl implements PlaceService{
	@Autowired
	private PlaceDAOMybatis placeDAO;
	
	public void insertPlace(PlaceVO vo) {

		placeDAO.insertPlace(vo);
	
	}
	
	public int getPlaceSeq() {
		return placeDAO.getPlaceSeq();
	}

	
	public void deletePlace(PlaceVO vo) {
		placeDAO.deletePlace(vo);
		
	}
	
	public void updatePlace(PlaceVO vo) {
		placeDAO.updatePlace(vo);
	}


	public void insertPlaceFileList(List<PlaceFileVO> fileList) {
		placeDAO.insertPlaceFileList(fileList);
		
	}

	
	public PlaceVO getPlace(PlaceVO vo) {
		return placeDAO.getPlace(vo);
	}

	
	public PlaceFileVO getPlaceFileList(int pSeq) {
		return placeDAO.getPlaceFileList(pSeq);
	}
	
	@Override
	public List<PlaceVO> getPlaceList(PlaceVO vo) {
		return placeDAO.getPlaceList(vo);
	}
	
	@Override
	public List<PlaceVO> getPlaceAllList(PlaceVO vo) {
		return placeDAO.getPlaceAllList(vo);
	}

	@Override
	public void updatePlaceFileList(List<PlaceFileVO> fileList) {
		// TODO Auto-generated method stub
		
	}


}
