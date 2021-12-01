package com.springbook.view.place;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springbook.biz.common.PlaceFileUtils;
import com.springbook.biz.place.PlaceFileVO;
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
	public String insertPlace(PlaceVO vo, HttpServletRequest request, MultipartHttpServletRequest mhsr)
			throws IOException {

		int seq = placeService.getPlaceSeq();
		System.out.println("=====> seq= " + seq);
		

		PlaceFileUtils fileUtils = new PlaceFileUtils();
		List<PlaceFileVO> fileList = fileUtils.parseFileInfo(seq, request, mhsr);

		if (CollectionUtils.isEmpty(fileList) == false) {
			placeService.insertPlaceFileList(fileList);
		}

		placeService.insertPlace(vo);

		// ȭ�� �׺���̼�(�Խñ� ��� �Ϸ� �� �Խñ� ������� �̵�)
		return "redirect:getPlaceList.do?pCategory=" + vo.getpCategory();
	}

	// ModelAttribute�� ���ǿ� board��� �̸����� ����� ��ü�� �ִ��� ã�Ƽ� Command��ü�� �����
	@RequestMapping(value = "/updatePlace.do")
	public String updatePlace(PlaceVO vo, HttpServletRequest request, MultipartHttpServletRequest mhsr)
			throws IOException {
		System.out.println("�� ���� ó��");
		System.out.println("ī�װ� : " + vo.getpCategory());
		System.out.println("���� : " + vo.getpArea());
		System.out.println("�ۼ��� �̸� : " + vo.getpName());
		System.out.println("�ּ�: " + vo.getpAddress());
		System.out.println("���� : " + vo.getpTell());
		System.out.println("���� : " + vo.getpInfo());

		int seq = vo.getpSeq();

		PlaceFileUtils fileUtils = new PlaceFileUtils();
		List<PlaceFileVO> fileList = fileUtils.parseFileInfo(seq, request, mhsr);

		if (CollectionUtils.isEmpty(fileList) == false) {
			placeService.insertPlaceFileList(fileList);
		}
		
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
		model.addAttribute("fileList", placeService.getPlaceFileList(vo.getpSeq()));
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

}
