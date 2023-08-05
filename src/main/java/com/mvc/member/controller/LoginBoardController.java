package com.mvc.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.common.controller.Controller;
import com.mvc.member.service.MemberService;
import com.mvc.member.vo.MemberVO;

public class LoginBoardController implements Controller {


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
//		HttpSession session = null;
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		
		MemberService service = MemberService.getInstance();
		MemberVO data = service.memberDetail(vo);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("data", data);
		return "/member/memberDetail.do";
	}

}
