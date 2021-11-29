package com.springbook.biz.trip;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement : �ش� ��ü�� RootElement�� �����ϰ� �̸���  tripList�� ����
@XmlRootElement(name = "tripList")
@XmlAccessorType(XmlAccessType.FIELD)
public class TripListVO {
	//@XmlElement : �� ���� ������Ʈ���� �̸� ����
	@XmlElement(name = "trip")
	private List<TripVO> tripList;

	public List<TripVO> getTripList() {
		return tripList;
	}

	public void setTripList(List<TripVO> tripList) {
		this.tripList = tripList;
	}
}
