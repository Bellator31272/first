package com.mvc.board.dao;

import java.util.List;

import com.mvc.board.vo.BoardVO;

public interface BoardMapper {
	public List<BoardVO> boardList(BoardVO vo);
	public int boardInsert(BoardVO vo);
	public int boardDelete(int vo);
	public BoardVO updateForm(int vo);
	public int boardUpdate(BoardVO vo);
	public BoardVO boardDetail(int vo);
	public int readcntUpdate(int vo);
	public int boardPassChk(BoardVO vo);
}
