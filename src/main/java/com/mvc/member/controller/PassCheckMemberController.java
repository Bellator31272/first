package com.mvc.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.controller.Controller;
import com.mvc.member.service.MemberService;
import com.mvc.member.vo.MemberVO;

public class PassCheckMemberController implements Controller {
//  /member/passCheck.do  //
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPasswd(passwd);
		
		MemberService service = MemberService.getInstance();
		int result = service.passChkMember(vo);
		
		request.setAttribute("result1",  result);
		
		return "/common/resultData";
//		return "/member/loginPage";
	}

}
