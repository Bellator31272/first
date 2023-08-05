package com.mvc.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.common.controller.Controller;
import com.mvc.member.service.MemberService;
import com.mvc.member.vo.MemberVO;

public class DeleteMemberController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		MemberService service = MemberService.getInstance();
		service.deleteMember(vo);
		
		HttpSession session = request.getSession(false);
		session.invalidate();
		
		return "/member/loginPage.do";
	}

}
