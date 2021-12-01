package com.springbook.biz.common;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springbook.biz.trip.TripFileVO;
import com.springbook.biz.trip.TripVO;

public class FileUtils2 {
	public String parseFileInfo(HttpServletRequest request, 
			MultipartHttpServletRequest mhsr) throws IOException {

		
		//������ ���� ��� ���
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "/upload/";
		
		//�� ����� ������ ������ ���� ����
		File file = new File(root_path + attach_path);
		//File file = new File(attach_path);
		
		//file.exists() ==> ������ �����ϸ� true �� ����
		if(file.exists() == false) {
			//file.mkdir() ==> ���丮 �������ִµ� mkdir�� ������� �ϴ� ���丮�� ���� ���丮�� �������� ���� ��� ���� �Ұ�
			file.mkdir();
		}
		
		MultipartFile mf = mhsr.getFile("file");
		
		TripVO vo = new TripVO();
		vo.setTrImgName(mf.getOriginalFilename());
		vo.setTrImgPath(root_path + attach_path);
		
		file = new File(root_path + attach_path + mf.getOriginalFilename());
		mf.transferTo(file);
		
		return "file";
	}
}
