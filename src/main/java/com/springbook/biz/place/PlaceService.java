package com.springbook.biz.place;

import java.util.List;

public interface PlaceService {
	//CRUD ����� �޼ҵ� ����
	//�� ���
	void insertPlace(PlaceVO vo);

	//�� ��� �� ��� �� �Ϸù�ȣ ȹ��
	int getPlaceSeq();
	
	//�� ����
	void deletePlace(PlaceVO vo);
	
	//�� ����
	void updatePlace(PlaceVO vo);

	//��� ���� ����Ʈ ���
	void insertPlaceFileList(List<PlaceFileVO> fileList);

	//�� �� ��ȸ
	PlaceVO getPlace(PlaceVO vo);

	PlaceFileVO getPlaceFileList(int pSeq);
	
	// 11.25�� ���Ը�� ����
			List<PlaceVO> getPlaceAllList(PlaceVO vo);
			
			List<PlaceVO> getPlaceList(PlaceVO vo);
		
}
