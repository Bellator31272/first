package com.mvc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.board.service.BoardServiceImpl;
import com.mvc.board.vo.BoardVO;
import com.mvc.common.controller.Controller;

public class PasswdCheckController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
//		int num = Integer.parseInt(request.getParameter("num"));	//게시글의 번호
//		
//		BoardServiceImpl service = BoardServiceImpl.getInstance();
//		
//		BoardVO data = service.boardDetail(num);
//		
//		int hd = Integer.parseInt(request.getParameter("hd")); 
//		String wd = "";
//		
//		if(hd==1) { wd = "수정";}
//		else if(hd==2) { wd = "삭제";}
//		
//		request.setAttribute("check", data);
//		
//		
//		request.setAttribute("hd", hd);
//		request.setAttribute("wd", wd);
//		return "/board/passwdCheck";
		
		String num = request.getParameter("num");
		String passwd = request.getParameter("passwd");
		BoardVO vo = new BoardVO();
		vo.setNum(Integer.parseInt(num));
		vo.setPasswd(passwd);
		
		BoardServiceImpl service = BoardServiceImpl.getInstance();
		int result = service.boardPassChk(vo);
		
		request.setAttribute("result",  result);
		
		return "/common/resultData";
	}

}
