package com.mvc.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.controller.Controller;

public class MemberDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		return "/member/memberDetail";
	}

}
