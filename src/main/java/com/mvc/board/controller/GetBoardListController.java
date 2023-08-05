package com.mvc.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.board.service.BoardServiceImpl;
import com.mvc.board.vo.BoardVO;
import com.mvc.common.controller.Controller;
import com.mvc.member.vo.MemberVO;

public class GetBoardListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		MemberVO data = new MemberVO();
		if(session != null) {
			data = (MemberVO) session.getAttribute("data");
			session.setAttribute("data", data);
		} 
		
		BoardServiceImpl service = BoardServiceImpl.getInstance();
		
		String search = request.getParameter("search");
		
		if(search==null) {
			search="all";
		}
		
		BoardVO vo = new BoardVO();
		vo.setSearch(search);
		vo.setKeyword(request.getParameter("keyword"));
		
		List<BoardVO> list = service.boardList(vo);
		
		request.setAttribute("list", list);
		
		
		
		return "/board/getBoardList";
	}
}