package com.springbook.biz.place.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.place.PlaceFileVO;
import com.springbook.biz.place.PlaceService;
import com.springbook.biz.place.PlaceVO;

@Service("placeService")
/*
 * �������� ó���� ����ϴ� Ŭ����
 * ex) ������ü ��� ó���� �� DB�Է��� DAO �ϰ� �Ǵµ� 
 * 	   DB�Է� �� �ʿ��� �۾���(���¾�ȣȭ, �ݾ� �ĸ� �߰�...) �ϴ� �������� ServiceImplŬ�������� ó�����ָ� �� 
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

	
	public List<PlaceFileVO> getPlaceFileList(int pSeq) {
		return placeDAO.getPlaceFileList(pSeq);
	}
	
	@Override
	public List<PlaceVO> getPlacelist(PlaceVO vo) {
		return placeDAO.getPlaceList(vo);
	}
	
	@Override
	public List<PlaceVO> getCafeList(PlaceVO vo) {
		return placeDAO.getCafeList(vo);
	}
	
	@Override
	public List<PlaceVO> getRestaurantList(PlaceVO vo) {
		return placeDAO.getRestaurantList(vo);
	}
	
	@Override
	public List<PlaceVO> getRoomsList(PlaceVO vo) {
		return placeDAO.getRoomsList(vo);
	}
	
	@Override
	public List<PlaceVO> getTourList(PlaceVO vo) {
		return placeDAO.getTourList(vo);
	}


}
