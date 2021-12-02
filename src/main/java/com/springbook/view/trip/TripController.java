package com.springbook.view.trip;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springbook.biz.trip.CommentVO;
import com.springbook.biz.trip.TripFileVO;
import com.springbook.biz.trip.TripMemberVO;
import com.springbook.biz.trip.TripService;
import com.springbook.biz.trip.TripVO;
import com.springbook.biz.common.FileUtils;
import com.springbook.biz.member.MemberService;
import com.springbook.biz.member.MemberVO;

@Controller
@SessionAttributes("trip")
public class TripController {
	@Autowired
	private TripService tripService;
	@Autowired
	private MemberService memberService;

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
		// >>>                                  여행 생성                                     							 |||
		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
			// 1) 여행 만들기 페이지 이동
			@RequestMapping(value = "/createTrip.do")
			public String createTripView(Model model, HttpSession session) {  
				
				System.out.println("=====> createTrip 컨트롤러 진입");
				
				MemberVO vo = (MemberVO)session.getAttribute("member");
				System.out.println("=====> 세션정보 가지고옴");
				
				memberService.getMember(vo);
				
				System.out.println("=====> host 이름 : " + vo.getmName());
				
				model.addAttribute("hostInfo", memberService.getMember(vo));   
				
				return "create_trip.jsp";
			}
	 		
	
			// 2) 여행 등록 실행
		   @RequestMapping(value = "/insertTrip.do")
		   public String insertTrip(TripVO vo, TripMemberVO tvo, HttpServletRequest request, Model model, HttpSession session)
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
		      tripService.insertTripMembers(tvo);
		      
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
	// >>>                       여행방 입장(호버로 요약 내용보고 방에 들어가서 상세 보기)                         |||
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	@RequestMapping(value = "/entranceRoom.do")
	
	public String getTrip(TripVO vo, Model model) {
		
		System.out.println("=====> getTrip 컨트롤러 탐");
		System.out.println("=====> trSeq:" + vo.getTrSeq()); 
		
		TripVO i = new TripVO();
		
		i = tripService.getTrip(vo);
		
		System.out.println(i.toString());
		
		model.addAttribute("trip", tripService.getTrip(vo));
		
		// 남주님 추가 코드
		List<CommentVO> commentList = tripService.readComment(vo.getTrSeq());
	      model.addAttribute("commentList", commentList);
	      System.out.println("=====> trSeq :" + model.toString());
	   // 남주님 추가 코드 END 	
		
		if(i.getTrMode().equals("일반모드")) {
			System.out.println(i.getTrMode());
			System.out.println("일반모드탐");
			
			return "room-normal.jsp";
			
		}else if(i.getTrMode().equals("랜덤추천모드")) {
			System.out.println(i.getTrMode());
			System.out.println("랜추모드탐");
			return "room-random.jsp";
			
		}else {
			System.out.println("게임모드탐");
			System.out.println(i.getTrMode());
			return "room-game.jsp";
		}
	
	}
	
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// >>>                       여행에 참여하기									                     |||
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	   @RequestMapping(value = "/attendTrip.do")
	   public String attendTrip(TripMemberVO tmvo, HttpServletRequest request, Model model, HttpSession session
			   ,HttpServletResponse response)
	         throws IOException {
	      System.out.println("======> attendTrip 컨트롤러 탐");
	      
	      MemberVO vo = (MemberVO)session.getAttribute("member");
	           
	      tmvo.setmSeq(vo.getmSeq());
	      tmvo.setTmName(vo.getmName());
	      tmvo.setTmId(vo.getmId());
	      tmvo.setTmRole("g");

	      int cnt = tripService.countMember();
	      
	      System.out.println("======참가중인 인원:" + cnt);
	      PrintWriter out = response.getWriter();
	      // 설정한 인원보다 참가한 사람수가 적을 경우 참가 가능
	    	  
	    tripService.insertTripMembers(tmvo);
	    	  
	    	  
	    	 // out.println("<script>alert('참가 가능 인원을 초과 하였습니다.');</script>");
	 
	      
	      return "redirect:index.jsp";
	   }
	
	
	
	

}