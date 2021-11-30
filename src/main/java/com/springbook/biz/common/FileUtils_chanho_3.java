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

public class FileUtils {
	public List<TripFileVO> parseFileInfo(int seq, HttpServletRequest request, 
			MultipartHttpServletRequest mhsr) throws IOException {
		if(ObjectUtils.isEmpty(mhsr)) {
			return null;
		}
		
		List<TripFileVO> fileList = new ArrayList<TripFileVO>();
		
		//������ ���� ��� ���
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "/upload/";
		
		//�� ����� ������ ������ ���� ����
		File file = new File(root_path + attach_path);
		//File file = new File(attach_path);
		if(file.exists() == false) {
			file.mkdir();
		}
		
		//���� �̸����� iterator�� ����
		Iterator<String> iterator = mhsr.getFileNames();
		
		// ��ȯ�� ������ true ������ false
		while(iterator.hasNext()) {
			//���ϸ����� ���� ����Ʈ ��������
			List<MultipartFile> list = mhsr.getFiles(iterator.next());
			
			//���� ����Ʈ ���� ��ŭ ������ ���� ����Ʈ�� ����ְ� ����
			for(MultipartFile mf : list) {
				if(mf.getSize() > 0) {
					TripFileVO tripFile = new TripFileVO();
					tripFile.setSeq(seq);
					tripFile.setFileSize(mf.getSize());
					tripFile.setOriginalFileName(mf.getOriginalFilename());
					tripFile.setFilePath(root_path + attach_path);
					//tripFile.setFilePath(attach_path);
					fileList.add(tripFile);
					
					file = new File(root_path + attach_path + mf.getOriginalFilename());
					//file = new File(attach_path + mf.getOriginalFilename());
					mf.transferTo(file);
				} else {
					fileList = null;
				}
			}
		}
		return fileList;
	}
}
