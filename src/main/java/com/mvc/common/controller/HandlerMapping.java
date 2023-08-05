package com.mvc.common.controller;

import java.util.HashMap;
import java.util.Map;

import com.mvc.board.controller.DeleteBoardController;
import com.mvc.board.controller.DetailBoardController;
import com.mvc.board.controller.GetBoardListController;
import com.mvc.board.controller.InsertBoardController;
import com.mvc.board.controller.InsertFormController;
import com.mvc.board.controller.PasswdCheckController;
import com.mvc.board.controller.updateBoardController;
import com.mvc.board.controller.updateFormController;
import com.mvc.member.controller.DeleteMemberController;
import com.mvc.member.controller.IdCheckMemberController;
import com.mvc.member.controller.InsertFormMemberController;
import com.mvc.member.controller.InsertMemberController;
import com.mvc.member.controller.LoginBoardController;
import com.mvc.member.controller.LoginPageMemberController;
import com.mvc.member.controller.LogoutMemberController;
import com.mvc.member.controller.MemberDetailController;
import com.mvc.member.controller.PassCheckMemberController;
import com.mvc.member.controller.UpdateFormMemberController;
import com.mvc.member.controller.UpdateMemberController;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<>();
		
		/* 답변형 게시판 처리 */
		mappings.put("/board/getBoardList.do", new GetBoardListController());
		
		mappings.put("/board/insertForm.do", new InsertFormController());
		mappings.put("/board/insertBoard.do", new InsertBoardController());
		
		mappings.put("/board/detailBoard.do", new DetailBoardController());
		
		mappings.put("/board/passwdCheck.do", new PasswdCheckController());
		
		mappings.put("/board/updateForm.do", new updateFormController());
		mappings.put("/board/updateBoard.do", new updateBoardController());
		
		mappings.put("/board/deleteBoard.do", new DeleteBoardController());
		
		
		
		
		mappings.put("/member/insertMember.do" , new InsertMemberController());
		mappings.put("/member/insertForm.do" , new InsertFormMemberController());
		mappings.put("/member/deleteMember.do" , new DeleteMemberController());
		mappings.put("/member/updateMember.do" , new UpdateMemberController());
		mappings.put("/member/updateForm.do" , new UpdateFormMemberController());
		mappings.put("/member/loginPage.do" , new LoginPageMemberController());
		mappings.put("/member/passCheck.do" , new PassCheckMemberController());
		mappings.put("/member/memberDetail.do" , new MemberDetailController());
		mappings.put("/member/loginBoard.do" , new LoginBoardController());
		mappings.put("/member/idCheck.do" , new IdCheckMemberController());
		mappings.put("/member/logout.do" , new LogoutMemberController());
		
		
		
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
