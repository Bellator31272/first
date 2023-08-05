package com.mvc.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.controller.Controller;
import com.mvc.member.service.MemberService;
import com.mvc.member.vo.MemberVO;

public class IdCheckMemberController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		MemberVO vo = new MemberVO();
		vo.setId(id);
		
		MemberService service = MemberService.getInstance();
		int result = service.idCheckMember(vo);
		
		request.setAttribute("result",  result);
		
		return "/common/resultData";
	}

}
