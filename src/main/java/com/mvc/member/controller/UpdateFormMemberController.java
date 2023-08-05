package com.mvc.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.controller.Controller;

public class UpdateFormMemberController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
//		String id = request.getParameter("id");
//		
//		
//		
//		BoardServiceImpl service = BoardServiceImpl.getInstance();
//		MemberdVO data = service.updateForm(id);
//		
//		request.setAttribute("data", data);
		
		return "/member/updateFormMember";
	}

}
