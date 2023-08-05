package com.mvc.board.service;

import java.util.List;

import com.mvc.board.dao.BoardMapperImpl;
import com.mvc.board.vo.BoardVO;

public class BoardServiceImpl {
	private static BoardServiceImpl service = null;
	
	private BoardMapperImpl mapper = new BoardMapperImpl();
	
	private BoardServiceImpl() {}
	public static BoardServiceImpl getInstance() {
		if(service == null) {
			service = new BoardServiceImpl();
		}
		return service;
	}
	
	public List<BoardVO> boardList(BoardVO vo){
		List<BoardVO> boardList = mapper.boardList(vo);
		return boardList;
	}
	
	public int boardInsert(BoardVO vo) {
		int result = mapper.boardInsert(vo);
		return result;
	}
		
	public void boardDelete(int num) {
		mapper.boardDelete(num);
	}
	
	public BoardVO boardDetail(int num) {
		BoardVO vo = mapper.boardDetail(num);
		vo.setContent(vo.getContent().toString().replaceAll("\n", "<br>"));
		return vo;
	}
	
	public BoardVO updateForm(int num) {
		BoardVO vo = mapper.updateForm(num);
		return vo;
	}
	
	public int boardUpdate(BoardVO vo) {
		int result = mapper.boardUpdate(vo);
		return result;
	}
	
	public void readcntUpdate(int num) {
		mapper.readcntUpdate(num);
	}
	
	public int boardPassChk(BoardVO vo) {
		int result = mapper.boardPassChk(vo);
		return result;
	}
	
}