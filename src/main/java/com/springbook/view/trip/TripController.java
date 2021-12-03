
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
import org.springframework.web.bind.annotation.ResponseBody;
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
		// >>>                                  ���� ����                                     							 |||
		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
			// 1) ���� ����� ������ �̵�
			@RequestMapping(value = "/createTrip.do")
			public String createTripView(Model model, HttpSession session) {  
				
				System.out.println("=====> createTrip ��Ʈ�ѷ� ����");
				
				MemberVO vo = (MemberVO)session.getAttribute("member");
				System.out.println("=====> �������� �������");
				
				memberService.getMember(vo);
				
				System.out.println("=====> host �̸� : " + vo.getmName());
				
				model.addAttribute("hostInfo", memberService.getMember(vo));   
				
				return "create_trip.jsp";
			}
	 		
	
			// 2) ���� ��� ����
		   @RequestMapping(value = "/insertTrip.do")
		   public String insertTrip(TripVO vo, TripMemberVO tvo, HttpServletRequest request, Model model, HttpSession session)
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
		      tripService.insertTripMembers(tvo);
		      
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
	// >>>                       ����� ����(ȣ���� ��� ���뺸�� �濡 ���� �� ����)                         |||
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	@RequestMapping(value = "/entranceRoom.do")
	
	public String getTrip(TripVO vo, Model model) {
		
		System.out.println("=====> getTrip ��Ʈ�ѷ� Ž");
		System.out.println("=====> trSeq:" + vo.getTrSeq()); 
		
		TripVO i = new TripVO();
		
		i = tripService.getTrip(vo);
		
		System.out.println(i.toString());
		
		model.addAttribute("trip", tripService.getTrip(vo));
		
		// ���ִ� �߰� �ڵ�
		List<CommentVO> commentList = tripService.readComment(vo.getTrSeq());
	      model.addAttribute("commentList", commentList);
	      System.out.println("=====> trSeq :" + model.toString());
	   // ���ִ� �߰� �ڵ� END 	
		
		if(i.getTrMode().equals("�Ϲݸ��")) {
			System.out.println(i.getTrMode());
			System.out.println("�Ϲݸ��Ž");
			
			return "room-normal.jsp";
			
		}else if(i.getTrMode().equals("������õ���")) {
			System.out.println(i.getTrMode());
			System.out.println("���߸��Ž");
			return "room-random.jsp";
			
		}else {
			System.out.println("���Ӹ��Ž");
			System.out.println(i.getTrMode());
			return "room-game.jsp";
		}
	
	}
	
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// >>>                       ���࿡ �����ϱ�									                     |||
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	//, produces = "application/text; charset=utf8"
	   @ResponseBody
	   @RequestMapping(value = "/attendTrip.do")
	   public String attendTrip(TripMemberVO tmvo, HttpServletRequest request, Model model, HttpSession session
			   ,HttpServletResponse response)
	         throws IOException {
	      System.out.println("======> 1) attendTrip ��Ʈ�ѷ� Ž");
	      
	      MemberVO vo = (MemberVO)session.getAttribute("member");
	      System.out.println("======> ���ǿ��� ������ MemberVO" + vo.toString());
	      
	      TripVO tvo = (TripVO)session.getAttribute("trip");
	      System.out.println("======> ���ǿ��� ������ TripVO" + tvo.toString());
	      
	      tmvo.setmSeq(vo.getmSeq());
	      tmvo.setTmName(vo.getmName());
	      tmvo.setTmId(vo.getmId());
	      tmvo.setTmRole("g");		      
	      
	      int trSeq = tvo.getTrSeq();
	      System.out.println("=====> ���� �Ϸù�ȣ:" + trSeq);
	      
	      int tcnt = tvo.getTrPersonnelSet();
	      System.out.println("=====> ������ �ο�:" + tcnt);
	      
	      int cnt = tripService.countMember();
	      System.out.println("=====> �������� �ο�:" + cnt);
	      	      
	      String resultmsg="";
	      if(tcnt > cnt) {
	    	  tripService.insertTripMembers(tmvo);	    	  
	    	  System.out.println("=====> ���� ����");
	    	  
	    	  response.setContentType("text/html; charset=utf-8");
	    	  resultmsg="<script>alert('���࿡ ���� �Ͽ����ϴ�.');location.href='getTripList.do'</script>";	    	  

	      } else {
	    	  session.setAttribute("trip", tvo);
	    	  System.out.println("=====> ���� ����");
	    	  
	    	  response.setContentType("text/html; charset=utf-8");
	    	  resultmsg="<script>alert('�ο��� �ʰ� �Ͽ����ϴ�.');location.href='getTripList.do'</script>";	 

	      }
	      
	      	return resultmsg;
	      	   	
	   }
	
	
	
	

}