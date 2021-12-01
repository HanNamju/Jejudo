package com.springbook.view.trip;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springbook.biz.trip.TripFileVO;
import com.springbook.biz.trip.TripService;
import com.springbook.biz.trip.TripVO;
import com.springbook.biz.common.FileUtils;

@Controller
@SessionAttributes("trip")
public class TripController {
	@Autowired
	private TripService tripService;

//	@ModelAttribute("conditionMap")
//	public Map<String, String> searchConditionMap() {
//		Map<String, String> conditionMap = new HashMap<String, String>();
//		conditionMap.put("����", "TITLE");
//		conditionMap.put("����", "CONTENT");
//		return conditionMap;
//	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// >>>                             ���� ����                                     >>>
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
/*
	   @RequestMapping(value = "/insertTrip.do")
	   public String insertTrip(TripVO vo, HttpServletRequest request, MultipartHttpServletRequest mhsr)
	         throws IOException {
	      System.out.println("======> insertTrip ��Ʈ�ѷ� Ž");

	      int seq = tripService.getTripSeq();
	      
	      System.out.println("seq= " + seq);

	      FileUtils fileUtils = new FileUtils();
	      List<TripFileVO> fileList = fileUtils.parseFileInfo(seq, request, mhsr);

	      if (CollectionUtils.isEmpty(fileList) == false) {
	         tripService.insertTripFileList(fileList);
	         System.out.println("======> check_1");
	      }

	      tripService.insertTrip(vo);
	      System.out.println("======> check_2");
	      // ȭ�� �׺���̼�(�Խñ� ��� �Ϸ� �� �Խñ� ������� �̵�)
	      return "redirect:index.jsp";
	   }
*/	   
	// ----------------------------------- END ���� ���� END -------------------------------------------  
	   
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		// >>>                             ���� ����                                     >>>
		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

		   @RequestMapping(value = "/insertTrip.do")
		   public String insertTrip(TripVO vo, HttpServletRequest request)
		         throws IOException {
		      System.out.println("======> insertTrip ��Ʈ�ѷ� Ž");

		      int seq = tripService.getTripSeq();
		      
		      System.out.println("seq= " + seq);
		      
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
		      
		      	// ���� ���ε� ó��
				MultipartFile uploadFile = vo.getUploadFile();
				if(!uploadFile.isEmpty()) {
					
					String fileName = uploadFile.getOriginalFilename();
					
					//uploadFile.transferTo(new File("D:/" + fileName));
					  //uploadFile.transferTo(new File(file + fileName));
					  uploadFile.transferTo(new File(root_path+attach_path+fileName));
					  System.out.println("=========>1: " + fileName);
					  System.out.println("===========>2: " + file + fileName);
					  System.out.println("===============>3: "+root_path+attach_path+fileName);
					  
					  vo.setTrImgName(uploadFile.getOriginalFilename());
					  vo.setTrImgPath(root_path + attach_path);
					
				}
		    
		      tripService.insertTrip(vo);
		      
		      System.out.println("======> check_2");
		      // ȭ�� �׺���̼�(�Խñ� ��� �Ϸ� �� �Խñ� ������� �̵�)
		      return "redirect:index.jsp";
		   }
		   
		// ----------------------------------- END ���� ���� END -------------------------------------------
	
	//���� roomcatagory.jsp 
	@RequestMapping(value = "/getTripList.do")
	
	public String getTripList( 
			TripVO vo, Model model) {
		System.out.println("�� ��� �˻� ó��");

//		List<TripVO> tripList = tripService.getTripList(vo);
//
//		for (int i = 0; i < tripList.size(); i++) {
//			System.out.println(tripList.get(i).toString());
//		}
		model.addAttribute("tripList", tripService.getTripList(vo));
		return "RoomCatagory.jsp";
	}
	
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// >>>                             ������                                   									 |||
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	@RequestMapping(value = "/entranceRoom.do")
	
	public String getTrip(TripVO vo, Model model) {
		
		System.out.println("=====> getTrip ��Ʈ�ѷ� Ž");
		System.out.println("=====> trSeq:" + vo.getTrSeq()); 
		
		model.addAttribute("trip", tripService.getTrip(vo));
	
		System.out.println("=====> trSeq :" + model.toString());
		
		if(vo.getTrMode() == "�Ϲݸ��") {
			
			return "room-normal.jsp";
			
		}else if(vo.getTrMode() == "������÷���") {
			
			return "room-random.jsp";
			
		}else {
			
			return "room-game.jsp";
		}
			
		
		
	}
	
	
	
	
	
	

}