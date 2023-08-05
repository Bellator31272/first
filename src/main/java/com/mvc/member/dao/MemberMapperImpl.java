package com.mvc.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.mvc.member.vo.MemberVO;

import mybatis.SqlSessionTemplate;

public class MemberMapperImpl implements MemberMapper {
	private SqlSession session;
	
	public MemberMapperImpl() {
		session = SqlSessionTemplate.getSqlSession();
	}
	
	void close() {
		session.close();
	}
	
	@Override
	public int insertMember(MemberVO vo) {
		return session.insert("insertMember", vo);
	}
	
	@Override
	public int updateMember(MemberVO vo) {
		return session.update("updateMember", vo);
	}
	
	@Override
	public int passChkMember(MemberVO vo) {
		return session.selectOne("passChkMember", vo);
	}
	
	@Override
	public MemberVO memberDetail(MemberVO vo) {
		return session.selectOne("memberDetail", vo);
	}
	
	@Override
	public int deleteMember(MemberVO vo) {
		return session.delete("deleteMember", vo);
	}
	
	public int idCheckMember(MemberVO vo) {
		return session.selectOne("idCheckMember", vo);
	}
      
}
