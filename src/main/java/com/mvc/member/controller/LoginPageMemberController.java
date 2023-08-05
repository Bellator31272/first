package com.mvc.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.controller.Controller;

public class LoginPageMemberController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
//		String path=null;
//		HttpSession session = request.getSession(false);
//
//		
//		if(session == null) {
//			path = "/member/loginPage";
//		}
//		else {
//			path = "/member/memberDetail.do";
//		}
//		
//		return path;
		return "/member/loginPage";
	}

}
