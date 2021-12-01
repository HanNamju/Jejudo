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
//board로 model 저장된 객체가 있으면 HttpSession 데이터 보관소에서 동일한 키 값(board)로 저장
@SessionAttributes("place")
public class PlaceController {
	@Autowired
	private PlaceService placeService;

	@RequestMapping(value = "/insertplace.do")
	// Command 객체 : 사용자가 전송한 데이터를 매핑한 VO를 바로 생성
	// 사용자 입력 값이 많아지면 코드가 길어지기 때문에 간략화 가능
	// 사용자 입력 input의 name 속성과 VO 멤버변수의 이름을 매핑해주는 것이 중요
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

		// 화면 네비게이션(게시글 등록 완료 후 게시글 목록으로 이동)
		return "redirect:getPlaceList.do?pCategory=" + vo.getpCategory();
	}

	// ModelAttribute로 세션에 board라는 이름으로 저장된 객체가 있는지 찾아서 Command객체에 담아줌
	@RequestMapping(value = "/updatePlace.do")
	public String updatePlace(PlaceVO vo, HttpServletRequest request, MultipartHttpServletRequest mhsr)
			throws IOException {
		System.out.println("글 수정 처리");
		System.out.println("카테고리 : " + vo.getpCategory());
		System.out.println("지역 : " + vo.getpArea());
		System.out.println("작성자 이름 : " + vo.getpName());
		System.out.println("주소: " + vo.getpAddress());
		System.out.println("전번 : " + vo.getpTell());
		System.out.println("정보 : " + vo.getpInfo());

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
		System.out.println("글 상세 조회 처리");

		// Model 객체는 RequestServlet 데이터 보관소에 저장
		// RequestServlet 데이터 보관소에 저장하는 것과 동일하게 동작
		// request.setAttribute("board", boardDAO.getPlace(vo)) ==
		// model.addAttribute("board", placeDAO.getPlace(vo))
		model.addAttribute("getPlace", placeService.getPlace(vo));
		model.addAttribute("fileList", placeService.getPlaceFileList(vo.getpSeq()));
		return "admin-Editpage.jsp";
	}

	@RequestMapping("/getPlaceList.do")
	public String getPlaceList(PlaceVO vo, Model model) {
		System.out.println("글 목록 검색 처리");
		System.out.println("cate================================" + vo.getpCategory());

		model.addAttribute("placeList", placeService.getPlaceList(vo));

		return "admin-RoomsList3.jsp";

	}

	//
	@RequestMapping("/getPlaceAllList.do")
	public String getPlaceAllList(PlaceVO vo, Model model) {
		System.out.println("글 목록 검색 처리");

		model.addAttribute("placeAllList", placeService.getPlaceAllList(vo));

		return "admin-RoomsList2.jsp";
	}

	@RequestMapping(value = "/deletePlace.do")
	public String deleteCafe(PlaceVO vo) throws IOException {
		System.out.println("글 삭제 처리");
		placeService.deletePlace(vo);
		System.out.println("pSeq" + vo.getpSeq());
		System.out.println(vo.getpCategory());

		return "redirect:getPlaceList.do?pCategory=" + vo.getpCategory();
	}

}
