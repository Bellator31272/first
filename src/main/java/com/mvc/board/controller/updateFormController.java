package com.mvc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.board.service.BoardServiceImpl;
import com.mvc.board.vo.BoardVO;
import com.mvc.common.controller.Controller;

public class updateFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardServiceImpl service = BoardServiceImpl.getInstance();
		
		
		BoardVO data = service.updateForm(num);
		
		request.setAttribute("data", data);
		
		return "/board/updateForm";
	}

}
