package com.mvc.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.common.controller.Controller;

public class LogoutMemberController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		
		session.invalidate();
		return "/member/loginPage.do";
	}

}
