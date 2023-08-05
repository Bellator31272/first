package com.mvc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.board.service.BoardServiceImpl;
import com.mvc.common.controller.Controller;

public class DeleteBoardController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardServiceImpl service = BoardServiceImpl.getInstance();
		service.boardDelete(num);
//		request.setAttribute("delete", data);
		
		
		return "/board/getBoardList.do";
	}
	

}
