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

import com.springbook.biz.place.PlaceFileVO;

public class PlaceFileUtils {
	public List<PlaceFileVO> parseFileInfo(int seq, HttpServletRequest request, 
			MultipartHttpServletRequest mhsr) throws IOException {
		
		System.out.println(mhsr.toString());
		if(ObjectUtils.isEmpty(mhsr)) {
			return null;
		}
		
		List<PlaceFileVO> fileList = new ArrayList<PlaceFileVO>();
		
		//������ ���� ��� ���
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "/upload/";
		
		//�� ����� ������ ������ ���� ����
		File file = new File(root_path + attach_path);
		if(file.exists() == false) {
			file.mkdirs();
		}
		
		//���� �̸����� iteratro�� ����
		Iterator<String> iterator = mhsr.getFileNames();
		while(iterator.hasNext()) {
			//���ϸ����� ���� ����Ʈ ��������
			List<MultipartFile> list = mhsr.getFiles(iterator.next());
			System.out.println("list.size()======================" + list.size());
			//���� ����Ʈ ���� ��ŭ ������ ���� ����Ʈ�� ����ְ� ����
			for(MultipartFile mf : list) {
				if(mf.getSize() > 0) {
					PlaceFileVO placeFile = new PlaceFileVO();
					placeFile.setSeq(seq);
					placeFile.setFileSize(mf.getSize());
					placeFile.setOriginalFileName(mf.getOriginalFilename());
					placeFile.setFilePath(root_path + attach_path);
					fileList.add(placeFile);
					
					file = new File(root_path + attach_path + mf.getOriginalFilename());
					mf.transferTo(file);
				} else {
					fileList = null;
				}
			}
		}
		return fileList;
	}
}
