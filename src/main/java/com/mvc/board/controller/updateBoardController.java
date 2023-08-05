package com.mvc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.board.service.BoardServiceImpl;
import com.mvc.board.vo.BoardVO;
import com.mvc.common.controller.Controller;

public class updateBoardController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String path=null;
//		int num = Integer.parseInt(request.getParameter("num"));
//		String pass = request.getParameter("pass");
		String passwd = request.getParameter("passwd");
		if(passwd.isEmpty()) {
			passwd=""; 
		} 
		
		BoardVO vo = new BoardVO();
		
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		vo.setTitle(request.getParameter("title"));
		vo.setAuthor(request.getParameter("author"));
		vo.setContent(request.getParameter("content"));
		vo.setPasswd(passwd);
		
		// 2. Service 객체의 메서드 호출
		BoardServiceImpl service = BoardServiceImpl.getInstance();
		int result = service.boardUpdate(vo);
		
		if(result==1) {
			path = "/board/getBoardList.do?num="+vo.getNum();
		} else {
			path = "/board/updateForm.do?num="+vo.getNum()+"&code=1";
		}
		return path;
	}
}