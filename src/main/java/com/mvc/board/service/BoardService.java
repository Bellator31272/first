package com.mvc.board.service;

import java.util.ArrayList;
import java.util.List;

import com.mvc.board.dao.BoardDAO;
import com.mvc.board.vo.BoardVO;

public class BoardService {
	private static BoardService service = null;
	
	private BoardDAO dao = BoardDAO.getInstance();
	
	private BoardService() {}
	public static BoardService getInstance() {
		if(service == null) {
			service = new BoardService();
		}
		return service;
	}
	
	// 검색처리
	public List<BoardVO> boardList(BoardVO vo){
		ArrayList<BoardVO> list = dao.boardList(vo);
		return list;
	}
	
	public boolean boardInsert(BoardVO vo) {
		boolean result = dao.boardInsert(vo);
		return result;
	}
	
	public int boardPassChk(String num, String passwd) {
		int result = dao.boardPasswdChk(num, passwd);
		return result;
	}
	
	
	public void boardDelete(String num) {
		dao.boardDelete(num);
	}
	
	public void readCount(String num) {
		dao.readCount(num);
	}
	
	public BoardVO boardDetail(String num) {
		BoardVO vo = dao.boardDetail(num);
		vo.setContent(vo.getContent().toString().replaceAll("\n", "<br>"));
		return vo;
	}
	
	public boolean boardUpdate(BoardVO vo) {
		boolean result = dao.boardUpdate(vo);
		return result;
	}
}