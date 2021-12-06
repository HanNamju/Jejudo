package com.springbook.view.board;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springbook.biz.board.BoardFileVO;
import com.springbook.biz.board.BoardListVO;
import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.FreeCommentVO;
import com.springbook.biz.common.BoardFileUtils;
import com.springbook.biz.member.MemberVO;

@Controller
//board�� model ����� ��ü�� ������ HttpSession ������ �����ҿ��� ������ Ű ��(board)�� ����
@SessionAttributes("board")
public class BoardController {
   @Autowired
   private BoardService boardService;
   
   @RequestMapping("/dataTransform.do")
   //@ResponseBody : �޼ҵ� ���� ���� ���� �ٵ�� ����
   //                �޼ҵ� ��� �� ��ü�� ���� �ٵ� ��
   @ResponseBody
   public BoardListVO dataTransform(BoardVO vo) {
      vo.setSearchCondition("TITLE");
      vo.setSearchKeyword("");
      List<BoardVO> boardList = boardService.getBoardList(vo);
      BoardListVO boardListVO = new BoardListVO();
      boardListVO.setBoardList(boardList);
      return boardListVO;
   }   
   
   //@ModelAttribute : 1. Command ��ü �̸� ����
   //               2. View(JSP)���� ����� ������ ����
   @ModelAttribute("conditionMap")
   public Map<String, String> searchConditionMap() {
      Map<String, String> conditionMap = new HashMap<String, String>();
      conditionMap.put("����", "TITLE");
      conditionMap.put("����", "CONTENT");
      //���� ���� ReqeustServlet ������ �����ҿ� ����
      //conditionMap�̶�� Ű ������ �����Ͱ� ����
      return conditionMap;
   }
   
   @RequestMapping(value="/insertBoard.do")
   //Command ��ü : ����ڰ� ������ �����͸� ������ VO�� �ٷ� ����
   //            ����� �Է� ���� �������� �ڵ尡 ������� ������ ����ȭ ����
   //              ����� �Է� input�� name �Ӽ��� VO ��������� �̸��� �������ִ� ���� �߿�
   public String insertBoard(BoardVO vo, HttpServletRequest request,
         MultipartHttpServletRequest mhsr) throws IOException {
      
      
      int seq = boardService.getBoardSeq();
      
      BoardFileUtils fileUtils = new BoardFileUtils();
      List<BoardFileVO> fileList = fileUtils.parseFileInfo(seq, request, mhsr);
      
      if(CollectionUtils.isEmpty(fileList) == false) {
         boardService.insertBoardFileList(fileList);
      }
      
      HttpSession session = request.getSession();
      MemberVO member = (MemberVO)session.getAttribute("member");
      
      
      
      System.out.println(member.getmNickname());
         vo.setWriter(member.getmNickname()); 
      
      
      boardService.insertBoard(vo);
      
      
      System.out.println("�� ��� ó��");
      System.out.println("�Ϸù�ȣ : " + vo.getSeq());
      System.out.println("���� : " + vo.getTitle());
      System.out.println("�ۼ��� �̸� : " + vo.getWriter());
      System.out.println("���� : " + vo.getContent());
      System.out.println("����� : " + vo.getRegDate());
      System.out.println("��ȸ�� : " + vo.getCnt());
      
      
      //ȭ�� �׺���̼�(�Խñ� ��� �Ϸ� �� �Խñ� ������� �̵�)
      return "redirect:getBoardList.do";
   }
   
   //ModelAttribute�� ���ǿ� board��� �̸����� ����� ��ü�� �ִ��� ã�Ƽ� Command��ü�� �����
   @RequestMapping(value="/updateBoard.do")
   public String updateBoard( BoardVO vo, HttpServletRequest request,
         MultipartHttpServletRequest mhsr) throws IOException {
      System.out.println("�� ���� ó��");
      System.out.println("�Ϸù�ȣ : " + vo.getSeq());
      System.out.println("���� : " + vo.getTitle());
      System.out.println("�ۼ��� �̸� : " + vo.getWriter());
      System.out.println("���� : " + vo.getContent());
      System.out.println("����� : " + vo.getRegDate());
      System.out.println("��ȸ�� : " + vo.getCnt());
      
      int seq = vo.getSeq();
      
      BoardFileUtils fileUtils = new BoardFileUtils();
      List<BoardFileVO> fileList = fileUtils.parseFileInfo(seq, request, mhsr);
      
      if(CollectionUtils.isEmpty(fileList) == false) {
         boardService.insertBoardFileList(fileList);
      }
      
      HttpSession session = request.getSession();
      BoardVO board = (BoardVO)session.getAttribute("board");
      
         
      //�Ѱ����  BoardVO seq�� Comment DB�� seq�� �Ѱܹް���� ��Ȳ 
      System.out.println("board�� seq �Ѿ����? :" + board.getSeq());
      
         //commentseq = boardseq ó��
         vo.setSeq(board.getSeq());
        
      
      boardService.updateBoard(vo);
      
      return "redirect:getBoard.do?seq=" + board.getSeq();
      
      
   }
   
   @RequestMapping(value="/deleteBoard.do")
   public String deleteBoard(BoardVO vo , HttpServletRequest request) {
      System.out.println("�� ���� ó��");
      
      
      HttpSession session = request.getSession();
      BoardVO board = (BoardVO)session.getAttribute("board");
      
         
      //�Ѱ����  BoardVO seq�� Comment DB�� seq�� �Ѱܹް���� ��Ȳ 
      System.out.println("board�� seq �Ѿ����? :" + board.getSeq());
      
         //commentseq = boardseq ó��
         vo.setSeq(board.getSeq());
        
      
      boardService.deleteBoard(vo);
   
      return "getBoardList.do";
   }
   
   @RequestMapping(value="/getBoard.do")
   public String getBoard(BoardVO vo, Model model  , HttpServletRequest request,FreeCommentVO fvo) {
      System.out.println("�� �� ��ȸ ó��");
      
      //Model ��ü�� RequestServlet ������ �����ҿ� ����
      //RequestServlet ������ �����ҿ� �����ϴ� �Ͱ� �����ϰ� ����
      //request.setAttribute("board", boardDAO.getBoard(vo)) == model.addAttribute("board", boardDAO.getBoard(vo))
      boardService.updateCnt(vo);
      
      model.addAttribute("freeCommentList", boardService.freeCommentList(fvo));
      model.addAttribute("board", boardService.getBoard(vo));
      model.addAttribute("fileList", boardService.getBoardFileList(vo.getSeq()));   
      /*
       * model.addAttribute("commentlist", boardService.getCommentList(vo.getSeq()));
       */
      
   
        
      
      return "admin-freeBoardcomment.jsp";
   }
   @RequestMapping(value="/getUpdateBoard.do")
   public String getUpdateBoard(BoardVO vo, HttpServletRequest request, Model model) {
      System.out.println("�� �� ��ȸ ó��");
   
      model.addAttribute("board", boardService.getBoard(vo));
      model.addAttribute("fileList", boardService.getBoardFileList(vo.getSeq()));      
      
   
      
      
      System.out.println("�Ϸù�ȣ : " + vo.getSeq());
      return "admin-writeupdate.jsp";
   }
   
   @RequestMapping(value="/getBoardList.do")
   //@RequestParam : Command ��ü�� VO�� ���ΰ��� ���� ����� �Է������� ���� �޾Ƽ� ó��
   //              value = ȭ�����κ��� ���޵� �Ķ���� �̸�(jsp�� input�� name�Ӽ� ��)
   //              required = ���� ���� ����
   public String getBoardList( /*
                         * @RequestParam(value="searchCondition", defaultValue="TITLE", required=false)
                         * String condition,
                         * 
                         * @RequestParam(value="searchKeyword", defaultValue="", required=false) String
                         * keyword,
                         */
                        BoardVO vo, Model model) {
      System.out.println("�� ��� �˻� ó��");
      
      System.out.println("�Ϸù�ȣ : " + vo.getSeq());
      System.out.println("���� : " + vo.getTitle());
      System.out.println("�ۼ��� �̸� : " + vo.getWriter());
      System.out.println("���� : " + vo.getContent());
      System.out.println("����� : " + vo.getRegDate());
      System.out.println("��ȸ�� : " + vo.getCnt());
      //Null check
      //�α��� ȭ�鿡�� �α��μ��� �� getBoardList.do ȣ�� �� �� searchKeyword, searchCondition ���� null ���� 
      //if(vo.getSearchCondition() == null) {
      //   vo.setSearchCondition("TITLE");
      //}
      //if(vo.getSearchKeyword() == null) {
      //   vo.setSearchKeyword("");
      //}
      
      model.addAttribute("boardList", boardService.getBoardList(vo));

      return "admin-freeBoard.jsp";
   }
   
   
   @RequestMapping(value="/getBoardCategory.do")
   
   public String getBoardCategory( BoardVO vo, Model model) {
      
      model.addAttribute("boardList", boardService.getBoardCategory(vo));

      return "admin-freeBoard.jsp";
   }
   @RequestMapping(value="/getMyBoardList.do")
   //@RequestParam : Command ��ü�� VO�� ���ΰ��� ���� ����� �Է������� ���� �޾Ƽ� ó��
   //              value = ȭ�����κ��� ���޵� �Ķ���� �̸�(jsp�� input�� name�Ӽ� ��)
   //              required = ���� ���� ����
   public String getMyBoardList(BoardVO vo, Model model,HttpServletRequest request) {
      System.out.println("�� ��� �˻� ó��");
      
      System.out.println("�Ϸù�ȣ : " + vo.getSeq());
      System.out.println("���� : " + vo.getTitle());
      System.out.println("�ۼ��� �̸� : " + vo.getWriter());
      System.out.println("���� : " + vo.getContent());
      System.out.println("����� : " + vo.getRegDate());
      System.out.println("��ȸ�� : " + vo.getCnt());
      
      HttpSession session = request.getSession();
      MemberVO member = (MemberVO)session.getAttribute("member");
      
      
      System.out.println(member.getmNickname());
         vo.setWriter(member.getmNickname()); 
      
      
      model.addAttribute("boardList", boardService.getMyBoardList(vo));

      return "admin-freeBoard.jsp";
   }
   
   @RequestMapping(value="/deleteFile.do")
   @ResponseBody
   public void deleteFile(BoardFileVO vo) {
      boardService.deleteFile(vo);
   }
   
   @RequestMapping(value="insertBoardComment.do")
   public String insertBoardComment(FreeCommentVO vo, HttpServletRequest request
         ) throws IOException {
      
      System.out.println(vo.getFmNickname());
      System.out.println(vo.getFmComment());
      
      //������ �������� ���� ��
      HttpSession session = request.getSession();
      
      //���ǿ� memberVO�� ����
      MemberVO member = (MemberVO)session.getAttribute("member");
      System.out.println(member.getmNickname());
      
      //boardVO �� ���ǿ� ����
      BoardVO board = (BoardVO)session.getAttribute("board");
      
         
      //�Ѱ����  BoardVO seq�� Comment DB�� seq�� �Ѱܹް���� ��Ȳ 
      System.out.println("board�� seq �Ѿ����? :" + board.getSeq());
      
         //commentVO�� fm�г��ӿ� memberVO ������ �г����� ����
         vo.setFmNickname(member.getmNickname());
         
         //commentseq = boardseq ó��
         vo.setSeq(board.getSeq());
        
         
         
         boardService.insertBoardComment(vo);
         
         
      
      
      //ȭ�� �׺���̼�(�Խñ� ��� �Ϸ� �� �Խñ� ������� �̵�)
//      return "getBoard.do";
      return "redirect:getBoard.do?seq=" + board.getSeq();
   }
   
   @RequestMapping(value="/deleteComment.do")
      public String deleteComment(BoardVO vo ,FreeCommentVO fvo,MemberVO mvo, HttpServletRequest request) {
         System.out.println("�� ���� ó��");
         
         
         HttpSession session = request.getSession();
         BoardVO board = (BoardVO)session.getAttribute("board");
         
         //�α��� ���� ȣ��
         MemberVO member = (MemberVO)session.getAttribute("member");
         
         if(fvo.getFmNickname() == member.getmNickname()) {
            boardService.deleteComment(fvo);
         }
         
         
            
         //�Ѱ����  BoardVO seq�� Comment DB�� seq�� �Ѱܹް���� ��Ȳ 
         System.out.println("board�� seq �Ѿ����? :" + board.getSeq());
         System.out.println(mvo.getmSeq());
         System.out.println(member.getmSeq());
            //commentseq = boardseq ó��
            vo.setSeq(board.getSeq());
            
           
         
         
           /* if((mvo.getmSeq()) == member.getmSeq()) {
               System.out.println("���� ó�� �Ǿ����ϴ�.");
            }else {
               System.out.println("�ۼ��ڸ� ���� ������");
            } */
            boardService.deleteComment(fvo);
         return "redirect:getBoard.do?seq=" + board.getSeq(); 
      }
}