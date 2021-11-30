package com.springbook.view.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springbook.biz.common.MemberFileUtils;
import com.springbook.biz.email.Email;
import com.springbook.biz.email.EmailSender;
import com.springbook.biz.member.MemberFileVO;
import com.springbook.biz.member.MemberService;
import com.springbook.biz.member.MemberVO;

@Controller
//board로 model 저장된 객체가 있으면 HttpSession 데이터 보관소에서 동일한 키 값(board)로 저장
@SessionAttributes("member")
public class MemberController {
	@Autowired
	private MemberService memberService;

	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		// 리턴 값은 ReqeustServlet 데이터 보관소에 저장
		// conditionMap이라는 키 값으로 데이터가 저장
		return conditionMap;
	}

	// 로그인
//		@RequestMapping(value="/login.do", method=RequestMethod.POST)
//		public String loginAction(MemberVO vo, Model model) {
//			MemberVO loginMember = memberService.login(vo);
//			
//			if(loginMember == null) {
//				model.addAttribute("check", 1);
//				model.addAttribute("message", "아이디와 비밀번호를 확인해주세요.");
//				return "login.jsp";
//			}else {
//				model.addAttribute("loginMember", loginMember);
//				return "index.jsp";
//			}
//		}

	// 의찬 로그인
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String Login(@RequestParam("mId") String mId, @RequestParam("mPassword") String mPassword,
			HttpSession session) throws Exception {

		String path = "";

		MemberVO vo = new MemberVO();

		vo.setmId(mId);
		vo.setmPassword(mPassword);

		MemberVO member = memberService.login(vo);

		if (member != null) {
			session.setAttribute("member", member);
			path = "index.jsp";
		} else {
			path = "login.jsp";
		}

		return path;

	}

	@RequestMapping(value = "/logout.do")
	// Commedn 객체로HttepSession을 선언하게 되면 스프링컨테이너가 브라우저와 매핑된 세션 객체를 담아서 넘겨줌
	public String logout(HttpSession session) {
		System.out.println("로그아웃 처리");
		session.invalidate();
		return "index.jsp";
	}

	@RequestMapping(value = "/insertMember.do")
	public String insertMember(MemberVO vo, HttpServletRequest request, MultipartHttpServletRequest mhsr)
			throws IOException {

		System.out.println("=====> insertMember.do 컨트롤러 탐");

		int seq = memberService.getMemberSeq();
		System.out.println("====>> 시퀀스값 : " + seq);

		MemberFileUtils memberfileUtils = new MemberFileUtils();
		List<MemberFileVO> fileList = MemberFileUtils.parseFileInfo(seq, request, mhsr);

		if (CollectionUtils.isEmpty(fileList) == false) {
			memberService.insertMemberFileList(fileList);
			System.out.println("======> check_1");
		}

		memberService.insertMember(vo);
		System.out.println("======> check_2");

		// 화면 네비게이션(게시글 등록 완료 후 게시글 목록으로 이동)
		return "redirect:index.jsp";
	}

	// 아이디 찾기 페이지 이동
	@RequestMapping(value = "findaccount.do")
	public String findIdView() {
		return "find-account.jsp";
	}

	// 아이디 찾기 실행
	@RequestMapping(value = "findId.do", method = RequestMethod.POST)
	public String findIdAction(MemberVO vo, Model model) {
		MemberVO member = memberService.findId(vo);

		if (member == null) {
			model.addAttribute("check", 1);
		} else {
			model.addAttribute("check", 0);
			model.addAttribute("id", member.getmId());
		}

		return "find-account.jsp";
	}

	// 회원정보 가져오기
	@RequestMapping(value = "/getMember.do")
	public String getMember(Model model, HttpServletRequest request) {

		System.out.println("======> getmember 컨트롤러 탐");

		// Model 객체는 RequestServlet 데이터 보관소에 저장
		// RequestServlet 데이터 보관소에 저장하는 것과 동일하게 동작
		// request.setAttribute("board", boardDAO.getBoard(vo)) ==
		// model.addAttribute("board", boardDAO.getBoard(vo))
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO) session.getAttribute("member");

		System.out.println("======> 세션가져왔어");

		System.out.println(memberService.getMember(vo).toString());
		model.addAttribute("memberInfo", memberService.getMember(vo));

		// model.addAttribute("mLicenseInfo",memberService.getMember(vo));

		return "changeinfo.jsp";
	}

	// 회원정보 수정
	@RequestMapping(value = "/updateMember.do")
	public String updateBoard(MemberVO vo, HttpServletRequest request, MultipartHttpServletRequest mhsr)
			throws IOException {
		System.out.println("회원 정보 수정 처리");
		System.out.println("닉네임 : " + vo.getmNickname());
		System.out.println("이메일 : " + vo.getmEmail());
		System.out.println("비밀번호 : " + vo.getmPassword());
		System.out.println("전화번호 : " + vo.getmTell());
		System.out.println("자기소개 : " + vo.getmIntroduce());
		System.out.println("운전면허 : " + vo.getmLicense());

		// int mSeq = vo.getmSeq();

		memberService.updateMember(vo);
		return "redirect:Mypage.jsp";
	}
	
	   // 비밀번호 email로 전송 받긔			
	   @Autowired
	   private EmailSender emailSender;
	   @Autowired
	   private Email email;
	    @RequestMapping("/findPWD.do")
	    public String sendEmailAction (MemberVO vo, Model model) throws Exception {
	    	
	    	System.out.println("====> 이메일 컨트롤러 탐");

	        if(memberService.findPassword(vo)==null) {	
	        	
	        	model.addAttribute("check", 3);
	        
	            return "find-account.jsp";
	            
	        }else {
	        	  
		       MemberVO memberPassword = memberService.findPassword(vo);
		       
		       String pw = memberPassword.getmPassword();  
		       
	        	model.addAttribute("check", 4);		        	
	        	String id=memberPassword.getmId();
			    String e_mail=memberPassword.getmEmail();
	        	
	            email.setContent("비밀번호는 "+pw+" 입니다.");
	            email.setReceiver(e_mail);
	            email.setSubject("랜덤제주" + id +"님 비밀번호 찾기 메일입니다.");
	            emailSender.SendEmail(email);
	            
	            return "redirect:login.jsp";	  
	    }
	    }

}
