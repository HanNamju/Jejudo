package com.springbook.biz.place;

import java.util.List;

public interface PlaceService {
	//CRUD 기능의 메소드 구현
	//글 등록
	void insertPlace(PlaceVO vo);

	//글 등록 전 등록 될 일련번호 획득
	int getPlaceSeq();
	
	//글 삭제
	void deletePlace(PlaceVO vo);
	
	//글 수정
	void updatePlace(PlaceVO vo);

	//디비에 파일 리스트 등록
	void insertPlaceFileList(List<PlaceFileVO> fileList);

	//글 상세 조회
	PlaceVO getPlace(PlaceVO vo);

	PlaceFileVO getPlaceFileList(int pSeq);
	
	// 11.25일 가게목록 구현
			List<PlaceVO> getPlaceAllList(PlaceVO vo);
			
			List<PlaceVO> getPlaceList(PlaceVO vo);
		
}
