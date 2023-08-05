package com.mvc.board.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.board.service.BoardServiceImpl;
import com.mvc.board.vo.BoardVO;
import com.mvc.common.controller.Controller;

public class DetailBoardController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));	//게시글의 번호
		
		BoardServiceImpl service = BoardServiceImpl.getInstance();
		service.readcntUpdate(num);		// 조회수 증가
		
		BoardVO data = service.boardDetail(num);
		
		request.setAttribute("detail", data);
		
		return "/board/detailBoard";
	}

}
