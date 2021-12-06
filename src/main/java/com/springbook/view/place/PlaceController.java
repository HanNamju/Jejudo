package com.springbook.view.place;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.springbook.biz.member.MemberVO;
import com.springbook.biz.place.PlaceReviewCmVO;
import com.springbook.biz.place.PlaceService;
import com.springbook.biz.place.PlaceVO;

@Controller
//board�� model ����� ��ü�� ������ HttpSession ������ �����ҿ��� ������ Ű ��(board)�� ����
@SessionAttributes("place")
public class PlaceController {
	@Autowired
	private PlaceService placeService;

	@RequestMapping(value = "/insertplace.do")
	// Command ��ü : ����ڰ� ������ �����͸� ������ VO�� �ٷ� ����
	// ����� �Է� ���� �������� �ڵ尡 ������� ������ ����ȭ ����
	// ����� �Է� input�� name �Ӽ��� VO ��������� �̸��� �������ִ� ���� �߿�
	public String insertPlace(PlaceVO vo, HttpServletRequest request, Model model, HttpSession session)
			throws IOException {

		int seq = placeService.getPlaceSeq();
		System.out.println("=====> seq= " + seq);

		/*
		 * PlaceFileUtils fileUtils = new PlaceFileUtils(); List<PlaceFileVO> fileList =
		 * fileUtils.parseFileInfo(seq, request, mhsr);
		 * 
		 * if (CollectionUtils.isEmpty(fileList) == false) {
		 * placeService.insertPlaceFileList(fileList); }
		 * 
		 * placeService.insertPlace(vo);
		 * 
		 * // ȭ�� �׺���̼�(�Խñ� ��� �Ϸ� �� �Խñ� ������� �̵�) return
		 * "redirect:getPlaceList.do?pCategory=" + vo.getpCategory();
		 */

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

			vo.setOriginalFileName(uploadFile.getOriginalFilename());
			vo.setFilePath(root_path + attach_path);
		}
		placeService.insertPlace(vo);

		System.out.println("======> check_2");
		// ȭ�� �׺���̼�(�Խñ� ��� �Ϸ� �� �Խñ� ������� �̵�)
		return "redirect:getPlaceList.do?pCategory=" + vo.getpCategory();
	}

	// ModelAttribute�� ���ǿ� board��� �̸����� ����� ��ü�� �ִ��� ã�Ƽ� Command��ü�� �����
	@RequestMapping(value = "/updatePlace.do")
	public String updatePlace(PlaceVO vo, HttpServletRequest request, MultipartHttpServletRequest mhsr)
			throws IOException {
		PlaceVO oldvo = placeService.getPlace(vo);
		String oldFileName = oldvo.getOriginalFileName();

		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "/upload/";

		if (oldFileName != null) {
			File file = new File(root_path + attach_path + oldFileName);
			// ���� ������ �����ϳ�.
			if (file.isFile()) {
				file.delete();
			}
		}

		MultipartFile uploadFile = vo.getUploadFile();

		if (!uploadFile.isEmpty()) {

			String fileName = uploadFile.getOriginalFilename();

			// uploadFile.transferTo(new File("D:/" + fileName));
			// uploadFile.transferTo(new File(file + fileName));
			uploadFile.transferTo(new File(root_path + attach_path + fileName));

			vo.setOriginalFileName(uploadFile.getOriginalFilename());
			vo.setFilePath(root_path + attach_path);
		}
		System.out.println("���� : " + vo.getOriginalFileName());
		System.out.println("�н� : " + vo.getFilePath());

		/*
		 * vo.getOriginalFileName(); vo.getFilePath();
		 */
		placeService.updatePlace(vo);

		return "redirect:getPlaceList.do?pCategory=" + vo.getpCategory();
	}

	@RequestMapping(value = "/getPlace.do")
	public String getPlace(PlaceVO vo, Model model) {
		System.out.println("�� �� ��ȸ ó��");

		// Model ��ü�� RequestServlet ������ �����ҿ� ����
		// RequestServlet ������ �����ҿ� �����ϴ� �Ͱ� �����ϰ� ����
		// request.setAttribute("board", boardDAO.getPlace(vo)) ==
		// model.addAttribute("board", placeDAO.getPlace(vo))
		model.addAttribute("getPlace", placeService.getPlace(vo));
		/*
		 * model.addAttribute("fileList", placeService.getPlaceFileList(vo.getpSeq()));
		 */
		return "admin-Editpage.jsp";
	}

	@RequestMapping("/getPlaceList.do")
	public String getPlaceList(PlaceVO vo, Model model) {
		System.out.println("�� ��� �˻� ó��");
		System.out.println("cate================================" + vo.getpCategory());

		model.addAttribute("placeList", placeService.getPlaceList(vo));

		return "admin-RoomsList3.jsp";

	}

	//
	@RequestMapping("/getPlaceAllList.do")
	public String getPlaceAllList(PlaceVO vo, Model model) {
		System.out.println("�� ��� �˻� ó��");

		model.addAttribute("placeAllList", placeService.getPlaceAllList(vo));

		return "admin-RoomsList2.jsp";
	}

	@RequestMapping(value = "/deletePlace.do")
	public String deleteCafe(PlaceVO vo) throws IOException {
		System.out.println("�� ���� ó��");
		placeService.deletePlace(vo);
		System.out.println("pSeq" + vo.getpSeq());
		System.out.println(vo.getpCategory());

		return "redirect:getPlaceList.do?pCategory=" + vo.getpCategory();
	}

	// ���� ReviewBoard.jsp
	@RequestMapping(value = "/getReviewBoardList.do")

	public String getReviewBoardList(PlaceVO vo, Model model) {
		System.out.println("��� ���� ��� �˻� ó��");

		model.addAttribute("reviewBoardList", placeService.getReviewBoardList(vo));
		return "ReviewBoard.jsp";
	}

	// ���� ReviewWrite.jsp
	@RequestMapping(value = "/getReviewWriteList.do")

	public String getReviewWriteList(PlaceVO vo, Model model) {
		System.out.println("=====> getReviewWrite ��Ʈ�ѷ� Ž");
		System.out.println("=====> Seq:" + vo.getpSeq());
		System.out.println("=====> Seq:" + vo.toString());

		model.addAttribute("place", placeService.getReviewWriteList(vo));
		return "ReviewWrite.jsp";
	}

	// ���� �Է�
	@RequestMapping(value = "/insertPlaceReview.do")
	public String insertPlaceReview(PlaceReviewCmVO vo, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, Model model) throws IOException {

		MemberVO mvo = (MemberVO) session.getAttribute("member");
		System.out.println("---->���ǿ��� ������ MemberVO" + mvo.toString());
		System.out.println("=====> insertPlaceReview.do ��Ʈ�ѷ� Ž");

		vo.setmSeq(mvo.getmSeq());

		System.out.println("======> check_2");

		placeService.insertPlaceReview(vo);
		// ȭ�� �׺���̼�(�Խñ� ��� �Ϸ� �� �Խñ� ������� �̵�)
		System.out.println("=========> check_3");
		return "redirect:ReviewWrite.jsp";

	}
}