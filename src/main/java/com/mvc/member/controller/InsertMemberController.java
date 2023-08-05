package com.mvc.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.controller.Controller;
import com.mvc.member.service.MemberService;
import com.mvc.member.vo.MemberVO;

public class InsertMemberController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String path=null;
		
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPasswd(request.getParameter("passwd"));
		vo.setName(request.getParameter("name"));
		vo.setEmail(request.getParameter("email"));
		vo.setPhone(request.getParameter("phone"));
		
		// 2. Service 객체의 메서드 호출
		MemberService service = MemberService.getInstance();
		int result = service.insertMember(vo);
		
		if(result==1) {
			path = "/member/loginPage.do";
		} else {
			path = "/member/insertForm";
			request.setAttribute("errorMsg", "등록 오류");
		}
		return path;
	}

}
