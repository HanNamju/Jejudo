
package com.springbook.view.trip;

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

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// >>> ���� ���� |||
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// 1) ���� ����� ������ �̵�
	@RequestMapping(value = "/createTrip.do")
	public String createTripView(Model model, HttpSession session) {

		System.out.println("=====> createTrip ��Ʈ�ѷ� ����");

		MemberVO vo = (MemberVO) session.getAttribute("member");
		System.out.println("=====> �������� �������");

		memberService.getMember(vo);

		System.out.println("=====> host �̸� : " + vo.getmName());

		model.addAttribute("hostInfo", memberService.getMember(vo));

		return "create_trip.jsp";
	}

	// 2) ���� ��� ����
	// 2) ���� ��� ����
    @RequestMapping(value = "/insertTrip.do")
    public String insertTrip(TripVO vo, TripMemberVO tvo, HttpServletRequest request, Model model,
          HttpSession session) throws IOException {
       System.out.println("======> insertTrip ��Ʈ�ѷ� Ž");

       int seq = tripService.getTripSeq();

       System.out.println("seq= " + seq);

       // ������ ���� ��� ���
       String root_path = request.getSession().getServletContext().getRealPath("/");
       String attach_path = "/upload/";

       // �� ����� ������ ������ ���� ����
       File file = new File(root_path + attach_path);
       // File file = new File(attach_path);

       // file.exists() ==> ������ �����ϸ� true �� ����
       if (file.exists() == false) {
          // file.mkdir() ==> ���丮 �������ִµ� mkdir�� ������� �ϴ� ���丮�� ���� ���丮�� �������� ���� ��� ���� �Ұ�
          file.mkdir();
       }

       // ���� ���ε� ó��
       MultipartFile uploadFile = vo.getUploadFile();
       if (!uploadFile.isEmpty()) {

          String fileName = uploadFile.getOriginalFilename();

          // uploadFile.transferTo(new File("D:/" + fileName));
          // uploadFile.transferTo(new File(file + fileName));
          uploadFile.transferTo(new File(root_path + attach_path + fileName));
          System.out.println("=========>1: " + fileName);
          System.out.println("===========>2: " + file + fileName);
          System.out.println("===============>3: " + root_path + attach_path + fileName);

          vo.setTrImgName(uploadFile.getOriginalFilename());
          vo.setTrImgPath(root_path + attach_path);

       }

       tripService.insertTrip(vo);
       tripService.insertTripMembers(tvo);

       System.out.println("======> check_2");
       // ȭ�� �׺���̼�(�Խñ� ��� �Ϸ� �� �Խñ� ������� �̵�)
       return "redirect:index.jsp";
    }

	// ----------------------------------- END ���� ���� END
	// -------------------------------------------

	// ���� roomcatagory.jsp
	@RequestMapping(value = "/getTripList.do")

	public String getTripList(TripVO vo, Model model) {
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
	// >>> ����� ����(ȣ���� ��� ���뺸�� �濡 ���� �� ����) |||
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@RequestMapping(value = "/entranceRoom.do")

	public String getTrip(TripVO vo, Model model) {

		System.out.println("=====> getTrip ��Ʈ�ѷ� Ž");
		System.out.println("=====> trSeq:" + vo.getTrSeq());

		TripVO i = new TripVO();

		i = tripService.getTrip(vo);

		System.out.println(i.toString());

		TripMemberVO tvo = new TripMemberVO();
		tvo.setTrSeq(i.getTrSeq());

		// int cnt = tripService.countMember(tvo);
		System.out.println("========> trSeq: " + i.getTrSeq() + " trName: " + i.getTrName() + " ���࿡ �������� �ο�:"
				+ tripService.countMember(tvo));

		model.addAttribute("trip", tripService.getTrip(vo));
		model.addAttribute("members", tripService.countMember(tvo));

		// ���ִ� �߰� �ڵ�
		List<CommentVO> commentList = tripService.readComment(vo.getTrSeq());
		model.addAttribute("commentList", commentList);
		System.out.println("=====> trSeq :" + model.toString());
		// ���ִ� �߰� �ڵ� END

		if (i.getTrMode().equals("�Ϲݸ��")) {
			System.out.println(i.getTrMode());
			System.out.println("�Ϲݸ��Ž");

			return "room-normal.jsp";

		} else if (i.getTrMode().equals("������õ���")) {
			System.out.println(i.getTrMode());
			System.out.println("���߸��Ž");
			return "room-random.jsp";

		} else {
			System.out.println("���Ӹ��Ž");
			System.out.println(i.getTrMode());
			return "room-game.jsp";
		}

	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// >>> ���࿡ �����ϱ� |||
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// , produces = "application/text; charset=utf8"

	@RequestMapping(value = "/attendTrip.do")
	public String attendTrip(TripMemberVO vo, HttpServletRequest request, Model model, HttpSession session,
			HttpServletResponse response) throws IOException, Exception {

		System.out.println("=====> 1) attendTrip ��Ʈ�ѷ� Ž");

		MemberVO mvo = (MemberVO) session.getAttribute("member");
		System.out.println("=====> 2) ���ǿ��� ������ MemberVO" + mvo.toString());

		TripVO tvo = (TripVO) session.getAttribute("trip");
		System.out.println("=====> 3) ���ǿ��� ������ TripVO" + tvo.toString());

		vo.setTrSeq(tvo.getTrSeq());
		vo.setmSeq(mvo.getmSeq());
		vo.setTmName(mvo.getmName());
		vo.setTmId(mvo.getmId());
		vo.setTmRole("g");

		int i = vo.getmSeq();

		System.out.println("=====> #1): " + vo.toString());
		System.out.println("=====> #2) ���ǿ��� ������ TripVO: " + i);

		int trSeq = tvo.getTrSeq();
		System.out.println("=====> 4) ���� �Ϸù�ȣ:" + trSeq);

		int tcnt = tvo.getTrPersonnelSet();
		System.out.println("=====> 5) ������ �ο�:" + tcnt);

		int cnt = tripService.countMember(vo);
		System.out.println("=====> 6) �������� �ο�:" + cnt);

		String trmode = "";

		// ���� ���� ���� ���� Ȯ��

		// 1) ���� �ߺ� üũ -> �����ϰ��� �ϴ� �濡 ������ ���� �ִ��� �ߺ� �˻�
		try {
			int check = 0;
			check = tripService.checkContain(vo);
			System.out.println("=====> 7) �ο��ߺ� ����:" + check);

			if (check != 0) {

				System.out.println("========> �̹������ؼ� ��������");

				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script> alert('�̹� ������ �����Դϴ�.');</script>");
				out.flush();
			}

			// 2) ���� ���� �ο� ��ȸ -> host �� ������ �����ο����� ������ �ο��� ���� ��� ���࿡ ���� ����
		} catch (NullPointerException e) {

			if (tcnt > cnt) {

				System.out.println("=====> ���� ����");

				tripService.insertTripMembers(vo);

				// �ݵ�� utf-8 ���� ���� �� PrintWriter out ��ü ���� �� ��.
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script> alert('���࿡ �����Ͽ����ϴ�.');</script>");
				out.flush();

			} else {

				System.out.println("========> �ο��� �������� ��������");

				// �ݵ�� utf-8 ���� ���� �� PrintWriter out ��ü ���� �� ��.
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script> alert('���� �����ο��� �ʰ� �Ͽ����ϴ�.');</script>");
				out.flush();
			}

		}

		return ("entranceRoom.do?trSeq=" + trSeq);
	}

	// ��� �߰��ϱ�
	@RequestMapping(value = "/insertComment.do")
	public String insertComment(CommentVO vo, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws IOException {
		System.out.println("********************************************");
		System.out.println("=====> insertComment.do ��Ʈ�ѷ� Ž");

		MemberVO mvo = (MemberVO) session.getAttribute("member");
		System.out.println("======> ���ǿ��� ������ MemberVO" + vo.toString());

		TripVO tvo = (TripVO) session.getAttribute("trip");
		System.out.println("======> ���ǿ��� ������ TripVO" + tvo.toString());

		vo.setTrSeq(tvo.getTrSeq());
		vo.setmSeq(mvo.getmSeq());
		tripService.insertComment(vo);

		return ("redirect: entranceRoom.do?trSeq=" + vo.getTrSeq());
	}
}