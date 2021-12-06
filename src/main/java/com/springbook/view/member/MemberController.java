package com.springbook.view.member;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springbook.biz.email.Email;
import com.springbook.biz.email.EmailSender;
import com.springbook.biz.member.MemberService;
import com.springbook.biz.member.MemberVO;

@Controller

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

	// ���� �α���
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String Login(@RequestParam("mId") String mId, @RequestParam("mPassword") String mPassword,
			HttpSession session, HttpServletResponse response) throws Exception {

		String path = "";

		MemberVO vo = new MemberVO();

		vo.setmId(mId);
		vo.setmPassword(mPassword);

		MemberVO member = memberService.login(vo);

		if (member != null) {
			session.setAttribute("member", member);
			path = "index.jsp";
		} else {
			// �ִ� ���̵����� üũ
			MemberVO existId = memberService.existId(mId);

			if (existId != null && !existId.equals("")) {
				int status = memberService.getMemberAccountStatus(mId);
				if (status >= 3 && status < 99) {
					response.setContentType("text/html; charset=UTF-8");

					PrintWriter out = response.getWriter();
					out.println("<script>alert('�̿� ������ ȸ���Դϴ�. �����ڿ��� ���� ��Ź�帳�ϴ�.'); </script>");
					out.flush();
				} else {
					response.setContentType("text/html; charset=UTF-8");

					PrintWriter out = response.getWriter();
					out.println("<script>alert('ȸ�� Ż��� ���̵��Դϴ�. �����ڿ��� ���� ��Ź�帳�ϴ�.');</script>");
					out.flush();
				}
			} else {
				response.setContentType("text/html; charset=UTF-8");

				PrintWriter out = response.getWriter();
				out.println("<script>alert('ȸ�� ���� �� �α��� ��Ź�帳�ϴ�.');</script>");
				out.flush();
			}

			path = "login.jsp";
		}

		return path;

	}

	// �α׾ƿ�
	@RequestMapping(value = "/logout.do")
	// Commedn ��ü��HttepSession�� �����ϰ� �Ǹ� �����������̳ʰ� �������� ���ε� ���� ��ü�� ��Ƽ� �Ѱ���
	public String logout(HttpSession session) {
		System.out.println("�α׾ƿ� ó��");
		session.invalidate();
		return "index.jsp";
	}

	// ȸ�� ����
	//1206 ���� ����
	@RequestMapping(value = "/insertMember.do")
	public String insertMember(MemberVO vo, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		System.out.println("=====> insertMember.do ��Ʈ�ѷ� Ž");
		int seq = memberService.getMemberSeq();
		System.out.println("====>> �������� : " + seq);

		try {

			System.out.println("======> check_2");

			String root_path = request.getSession().getServletContext().getRealPath("/");
			String attach_path = "/upload/";

			File file = new File(root_path + attach_path);
			// File file = new File(attach_path);
			if (file.exists() == false) {
				file.mkdir();
			}

			MultipartFile uploadFile = vo.getUploadFile();

			if (!uploadFile.isEmpty()) {
				String fileName = uploadFile.getOriginalFilename();
				uploadFile.transferTo(new File(root_path + attach_path + fileName));

				vo.setmImgPath(root_path + attach_path);
				vo.setmImgName(uploadFile.getOriginalFilename());

			}
			memberService.insertMember(vo);
			// ȭ�� �׺���̼�(�Խñ� ��� �Ϸ� �� �Խñ� ������� �̵�)
			System.out.println("=========> check_3");
			return "redirect:index.jsp";

		} catch (DuplicateKeyException e) {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();
			out.println("<script> alert('�ߺ��� ���̵� �ƴ� �� ���̵�� ȸ������ ��Ź�帳�ϴ�.');</script>");
			out.flush();

		} catch (Exception e) {
			System.out.println("����ó�� ����");
			return "index.jsp";
		}

		return "join.jsp";
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
	public String getMember(Model model, HttpSession session) throws IOException {

		System.out.println("======> getmember ��Ʈ�ѷ� Ž");
		// Model ��ü�� RequestServlet ������ �����ҿ� ����
		// RequestServlet ������ �����ҿ� �����ϴ� �Ͱ� �����ϰ� ����
		// request.setAttribute("board", boardDAO.getBoard(vo)) ==
		// model.addAttribute("board", boardDAO.getBoard(vo))
		try {
			MemberVO vo = (MemberVO) session.getAttribute("member");
			System.out.println("======> ���ǰ����Ծ�");
			System.out.println(memberService.getMember(vo).toString());
			model.addAttribute("memberInfo", memberService.getMember(vo));
			// model.addAttribute("mLicenseInfo",memberService.getMember(vo));

			return "changeinfo.jsp";
		} catch (Exception e) {

		}
		return null;

	}

	// ȸ������ ����
	// ���� 1206����
	@RequestMapping(value = "/updateMember.do")
	public String updateBoard(MemberVO vo, HttpServletRequest request) throws IOException {
		System.out.println("ȸ�� ���� ���� ó��");
		System.out.println("�г��� : " + vo.getmNickname());
		System.out.println("�̸��� : " + vo.getmEmail());
		System.out.println("��й�ȣ : " + vo.getmPassword());
		System.out.println("��ȭ��ȣ : " + vo.getmTell());
		System.out.println("�ڱ�Ұ� : " + vo.getmIntroduce());
		System.out.println("�������� : " + vo.getmLicense());
		System.out.println("�̹����н� : " + vo.getmImgPath());
		System.out.println("�̹����̸� : " + vo.getmImgName());

		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "/upload/";

		File file = new File(root_path + attach_path);
		// File file = new File(attach_path);
		if (file.exists() == false) {
			file.mkdir();
		}

		MultipartFile uploadFile = vo.getUploadFile();

		if (!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File(root_path + attach_path + fileName));

			vo.setmImgPath(root_path + attach_path);
			vo.setmImgName(uploadFile.getOriginalFilename());

		}

		memberService.updateMember(vo);
		return "redirect:Mypage.jsp";
	}

	// ��й�ȣ email�� ���� �ޱ�
	@Autowired
	private EmailSender emailSender;
	@Autowired
	private Email email;

	@RequestMapping("/findPWD.do")
	public String sendEmailAction(MemberVO vo, Model model) throws Exception {

		System.out.println("====> �̸��� ��Ʈ�ѷ� Ž");

		if (memberService.findPassword(vo) == null) {

			model.addAttribute("check", 3);

			return "find-account.jsp";

		} else {

			MemberVO memberPassword = memberService.findPassword(vo);

			String pw = memberPassword.getmPassword();

			model.addAttribute("check", 4);
			String id = memberPassword.getmId();
			String e_mail = memberPassword.getmEmail();

			email.setContent("��й�ȣ�� " + pw + " �Դϴ�.");
			email.setReceiver(e_mail);
			email.setSubject("��������" + id + "�� ��й�ȣ ã�� �����Դϴ�.");
			emailSender.SendEmail(email);

			return "redirect:login.jsp";
		}
	}

	// ���̵� �ߺ� üũ
	@RequestMapping(value = "/id_check.do")
	@ResponseBody
	public String idCheck(@RequestParam("id") String id
	/* HttpServletResponse response */) throws IOException {
		MemberVO vo = memberService.idChk(id);

		// response.setContentType("text/html;charset=UTF-8");
		String msg = "";
		if (vo != null) {
			msg = "fail";
		} else {
			msg = "success";
		}
		return msg;
		// PrintWriter writer = response.getWriter();
		// writer.println(msg);
	}

	// ���������� ȸ�� Ż��
	// ȸ������ ����
	@RequestMapping(value = "/Withdrawal.do")
	public String Withdrawal(MemberVO vo, HttpServletRequest request, Model model, HttpSession session)
			throws IOException {
		System.out.println("ȸ�� Ż�� ó��");
		System.out.println("ī�װ� : " + vo.getmAccountStatus());

		int seq = vo.getmSeq();

		memberService.Withdrawal(vo);
		session.invalidate();
		return "index.jsp";
	}

	// ȸ������ ����
	@RequestMapping(value = "/memberBan.do")
	public String memberBan(MemberVO vo, HttpServletRequest request, Model model) throws IOException {
		System.out.println("MemberBan ��Ʈ�ѷ��� Ž");
		System.out.println("ȸ�� ���� ó��");
		System.out.println("ī�װ� : " + vo.getmAccountStatus());
		System.out.println(vo.getmEmail());
		System.out.println(vo.getmSeq());
		int seq = vo.getmSeq();

		// model.addAttribute("MemberBan", memberService.getMember(vo));

		memberService.memberBan(vo);
		return "getMemberList.do";
	}

	// ȸ������ ����
	@RequestMapping(value = "/memberKeep.do")
	public String memberKeep(MemberVO vo, HttpServletRequest request, Model model) throws IOException {
		System.out.println("MemberKeep ��Ʈ�ѷ��� Ž");
		System.out.println("ȸ�� ���� ó��");
		System.out.println("ī�װ� : " + vo.getmAccountStatus());
		System.out.println(vo.getmEmail());
		System.out.println(vo.getmSeq());
		int seq = vo.getmSeq();

		// model.addAttribute("MemberBan", memberService.getMember(vo));

		memberService.memberKeep(vo);
		return "getMemberList.do";
	}

	   // Member ��� �ҷ�����
    @RequestMapping(value="/getMemberList.do", method= RequestMethod.GET)
    public String getMemberList( 
                         MemberVO vo, Model model) {
       System.out.println("�� ��� �˻� ó��");
       String A = vo.getmAccountStatus();
       System.out.println("mAccountStatus =" + A);
       System.out.println(vo.getmGender());
       System.out.println(vo.getmId());
       System.out.println(vo.getmSeq());
    
       model.addAttribute("MemberList", memberService.getMemberList(vo));
       return "admin-MemberList.jsp";
    }
}
