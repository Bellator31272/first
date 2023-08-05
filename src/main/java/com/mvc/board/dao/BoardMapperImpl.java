package com.mvc.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mvc.board.vo.BoardVO;

import mybatis.SqlSessionTemplate;

public class BoardMapperImpl implements BoardMapper{
	private SqlSession session;
	
	public BoardMapperImpl() {
		session = SqlSessionTemplate.getSqlSession();
	}
	
	public List<BoardVO> boardList(BoardVO vo){
		return session.selectList("boardList", vo);
	}
	
	void close() {
		session.close();
	}
		
	public int boardInsert(BoardVO vo) {
		return session.insert("boardInsert", vo);
	}

	@Override
	public int boardDelete(int vo) {
		return session.delete("boardDelete", vo);
	}
	
	@Override
	public BoardVO boardDetail(int vo) {
		return session.selectOne("boardDetail", vo);
	}
	
	@Override
	public BoardVO updateForm(int vo) {
		return session.selectOne("updateForm", vo);
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		return session.insert("boardUpdate", vo);
	}

	@Override
	public int readcntUpdate(int vo) {
		return session.update("readcntUpdate", vo);
	}

	@Override
	public int boardPassChk(BoardVO vo) {
		return session.selectOne("boardPassChk", vo);
	}
	






}
