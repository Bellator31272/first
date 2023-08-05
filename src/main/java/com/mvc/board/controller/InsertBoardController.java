package com.mvc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.board.service.BoardServiceImpl;
import com.mvc.board.vo.BoardVO;
import com.mvc.common.controller.Controller;

public class InsertBoardController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String path=null;
		// 1. VO객체에 데이터 바인딩
		BoardVO vo = new BoardVO();
		vo.setTitle(request.getParameter("title"));
		vo.setAuthor(request.getParameter("author"));
		vo.setContent(request.getParameter("content"));
		vo.setPasswd(request.getParameter("passwd"));
		
		// 2. Service 객체의 메서드 호출
		BoardServiceImpl service = BoardServiceImpl.getInstance();
		int result = service.boardInsert(vo);
		
		if(result==1) {
			path = "/board/getBoardList.do";
		} else {
			path = "/board/insertForm";
			request.setAttribute("errorMsg", "등록 오류");
		}
		return path;
	}
}