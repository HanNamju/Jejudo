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
//board�� model ����� ��ü�� ������ HttpSession ������ �����ҿ��� ������ Ű ��(board)�� ����
@SessionAttributes("member")
public class MemberController {
	@Autowired
	private MemberService memberService;

	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("����", "TITLE");
		conditionMap.put("����", "CONTENT");
		// ���� ���� ReqeustServlet ������ �����ҿ� ����
		// conditionMap�̶�� Ű ������ �����Ͱ� ����
		return conditionMap;
	}

	// �α���
//		@RequestMapping(value="/login.do", method=RequestMethod.POST)
//		public String loginAction(MemberVO vo, Model model) {
//			MemberVO loginMember = memberService.login(vo);
//			
//			if(loginMember == null) {
//				model.addAttribute("check", 1);
//				model.addAttribute("message", "���̵�� ��й�ȣ�� Ȯ�����ּ���.");
//				return "login.jsp";
//			}else {
//				model.addAttribute("loginMember", loginMember);
//				return "index.jsp";
//			}
//		}

	// ���� �α���
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
	// Commedn ��ü��HttepSession�� �����ϰ� �Ǹ� �����������̳ʰ� �������� ���ε� ���� ��ü�� ��Ƽ� �Ѱ���
	public String logout(HttpSession session) {
		System.out.println("�α׾ƿ� ó��");
		session.invalidate();
		return "index.jsp";
	}

	@RequestMapping(value = "/insertMember.do")
	public String insertMember(MemberVO vo, HttpServletRequest request, MultipartHttpServletRequest mhsr)
			throws IOException {

		System.out.println("=====> insertMember.do ��Ʈ�ѷ� Ž");

		int seq = memberService.getMemberSeq();
		System.out.println("====>> �������� : " + seq);

		MemberFileUtils memberfileUtils = new MemberFileUtils();
		List<MemberFileVO> fileList = MemberFileUtils.parseFileInfo(seq, request, mhsr);

		if (CollectionUtils.isEmpty(fileList) == false) {
			memberService.insertMemberFileList(fileList);
			System.out.println("======> check_1");
		}

		memberService.insertMember(vo);
		System.out.println("======> check_2");

		// ȭ�� �׺���̼�(�Խñ� ��� �Ϸ� �� �Խñ� ������� �̵�)
		return "redirect:index.jsp";
	}

	// ���̵� ã�� ������ �̵�
	@RequestMapping(value = "findaccount.do")
	public String findIdView() {
		return "find-account.jsp";
	}

	// ���̵� ã�� ����
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

	// ȸ������ ��������
	@RequestMapping(value = "/getMember.do")
	public String getMember(Model model, HttpServletRequest request) {

		System.out.println("======> getmember ��Ʈ�ѷ� Ž");

		// Model ��ü�� RequestServlet ������ �����ҿ� ����
		// RequestServlet ������ �����ҿ� �����ϴ� �Ͱ� �����ϰ� ����
		// request.setAttribute("board", boardDAO.getBoard(vo)) ==
		// model.addAttribute("board", boardDAO.getBoard(vo))
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO) session.getAttribute("member");

		System.out.println("======> ���ǰ����Ծ�");

		System.out.println(memberService.getMember(vo).toString());
		model.addAttribute("memberInfo", memberService.getMember(vo));

		// model.addAttribute("mLicenseInfo",memberService.getMember(vo));

		return "changeinfo.jsp";
	}

	// ȸ������ ����
	@RequestMapping(value = "/updateMember.do")
	public String updateBoard(MemberVO vo, HttpServletRequest request, MultipartHttpServletRequest mhsr)
			throws IOException {
		System.out.println("ȸ�� ���� ���� ó��");
		System.out.println("�г��� : " + vo.getmNickname());
		System.out.println("�̸��� : " + vo.getmEmail());
		System.out.println("��й�ȣ : " + vo.getmPassword());
		System.out.println("��ȭ��ȣ : " + vo.getmTell());
		System.out.println("�ڱ�Ұ� : " + vo.getmIntroduce());
		System.out.println("�������� : " + vo.getmLicense());

		// int mSeq = vo.getmSeq();

		memberService.updateMember(vo);
		return "redirect:Mypage.jsp";
	}
	
	   // ��й�ȣ email�� ���� �ޱ�			
	   @Autowired
	   private EmailSender emailSender;
	   @Autowired
	   private Email email;
	    @RequestMapping("/findPWD.do")
	    public String sendEmailAction (MemberVO vo, Model model) throws Exception {
	    	
	    	System.out.println("====> �̸��� ��Ʈ�ѷ� Ž");

	        if(memberService.findPassword(vo)==null) {	
	        	
	        	model.addAttribute("check", 3);
	        
	            return "find-account.jsp";
	            
	        }else {
	        	  
		       MemberVO memberPassword = memberService.findPassword(vo);
		       
		       String pw = memberPassword.getmPassword();  
		       
	        	model.addAttribute("check", 4);		        	
	        	String id=memberPassword.getmId();
			    String e_mail=memberPassword.getmEmail();
	        	
	            email.setContent("��й�ȣ�� "+pw+" �Դϴ�.");
	            email.setReceiver(e_mail);
	            email.setSubject("��������" + id +"�� ��й�ȣ ã�� �����Դϴ�.");
	            emailSender.SendEmail(email);
	            
	            return "redirect:login.jsp";	  
	    }
	    }

}
