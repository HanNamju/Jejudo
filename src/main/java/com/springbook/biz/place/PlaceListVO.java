package com.springbook.biz.place;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement : �ش� ��ü�� RootElement�� �����ϰ� �̸���  boardList�� ����
@XmlRootElement(name = "placeList")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlaceListVO {
	//@XmlElement : �� ���� ������Ʈ���� �̸� ����
	@XmlElement(name = "place")
	private List<PlaceVO> placeList;

	public List<PlaceVO> getPlaceList() {
		return placeList;
	}

	public void setPlaceList(List<PlaceVO> placeList) {
		this.placeList = placeList;
	}
}
