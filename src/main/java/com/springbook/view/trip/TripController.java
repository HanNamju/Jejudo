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
//		conditionMap.put("제목", "TITLE");
//		conditionMap.put("내용", "CONTENT");
//		return conditionMap;
//	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// >>>                             여행 생성                                     >>>
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
/*
	   @RequestMapping(value = "/insertTrip.do")
	   public String insertTrip(TripVO vo, HttpServletRequest request, MultipartHttpServletRequest mhsr)
	         throws IOException {
	      System.out.println("======> insertTrip 컨트롤러 탐");

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
	      // 화면 네비게이션(게시글 등록 완료 후 게시글 목록으로 이동)
	      return "redirect:index.jsp";
	   }
*/	   
	// ----------------------------------- END 여행 생성 END -------------------------------------------  
	   
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		// >>>                             여행 생성                                     >>>
		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

		   @RequestMapping(value = "/insertTrip.do")
		   public String insertTrip(TripVO vo, HttpServletRequest request)
		         throws IOException {
		      System.out.println("======> insertTrip 컨트롤러 탐");

		      int seq = tripService.getTripSeq();
		      
		      System.out.println("seq= " + seq);
		      
		  	//서버의 절대 경로 얻기
				String root_path = request.getSession().getServletContext().getRealPath("/");
				String attach_path = "/upload/";
				
				//위 경로의 폴더가 없으면 폴더 생성
				File file = new File(root_path + attach_path);
				//File file = new File(attach_path);
				
				//file.exists() ==> 파일이 존재하면 true 를 리턴
				if(file.exists() == false) {
					//file.mkdir() ==> 디렉토리 생성해주는데 mkdir은 만들고자 하는 디렉토리의 상위 디렉토리가 존재하지 않을 경우 생성 불가
					file.mkdir();
				}
		      
		      	// 파일 업로드 처리
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
		      // 화면 네비게이션(게시글 등록 완료 후 게시글 목록으로 이동)
		      return "redirect:index.jsp";
		   }
		   
		// ----------------------------------- END 여행 생성 END -------------------------------------------
	
	//남주 roomcatagory.jsp 
	@RequestMapping(value = "/getTripList.do")
	
	public String getTripList( 
			TripVO vo, Model model) {
		System.out.println("글 목록 검색 처리");

//		List<TripVO> tripList = tripService.getTripList(vo);
//
//		for (int i = 0; i < tripList.size(); i++) {
//			System.out.println(tripList.get(i).toString());
//		}
		model.addAttribute("tripList", tripService.getTripList(vo));
		return "RoomCatagory.jsp";
	}
	
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// >>>                             방입장                                   									 |||
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	@RequestMapping(value = "/entranceRoom.do")
	
	public String getTrip(TripVO vo, Model model) {
		
		System.out.println("=====> getTrip 컨트롤러 탐");
		System.out.println("=====> trSeq:" + vo.getTrSeq()); 
		
		model.addAttribute("trip", tripService.getTrip(vo));
	
		System.out.println("=====> trSeq :" + model.toString());
		
		if(vo.getTrMode() == "일반모드") {
			
			return "room-normal.jsp";
			
		}else if(vo.getTrMode() == "랜덤추첨모드") {
			
			return "room-random.jsp";
			
		}else {
			
			return "room-game.jsp";
		}
			
		
		
	}
	
	
	
	
	
	

}