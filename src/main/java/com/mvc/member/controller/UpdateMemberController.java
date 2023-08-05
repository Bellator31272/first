package com.mvc.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.common.controller.Controller;
import com.mvc.member.service.MemberService;
import com.mvc.member.vo.MemberVO;

public class UpdateMemberController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String path=null;
		HttpSession session = request.getSession(false);
		MemberVO vo1 =(MemberVO) session.getAttribute("data");
		MemberVO vo = new MemberVO();
		
		vo.setId(vo1.getId());
		vo.setPasswd(request.getParameter("nPasswd"));
		vo.setName(request.getParameter("nName"));
		vo.setEmail(request.getParameter("nEmail"));
		vo.setPhone(request.getParameter("nPhone"));
		
		MemberService service = MemberService.getInstance();
		int result = service.updateMember(vo);
		MemberVO data = service.memberDetail(vo);
		
		if(result==1) {
			session.setAttribute("data", data);
			path = "/member/memberDetail.do";
		} else {
			path = "/member/updateFormMember";
			request.setAttribute("errorMsg", "등록 오류");
		}
		return path;
	}
}