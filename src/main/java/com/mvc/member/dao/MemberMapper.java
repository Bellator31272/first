package com.mvc.member.dao;

import com.mvc.member.vo.MemberVO;

public interface MemberMapper {
	
	public int insertMember(MemberVO vo);
	public int passChkMember(MemberVO vo);
	public MemberVO memberDetail(MemberVO vo);
	public int deleteMember(MemberVO vo);
	public int updateMember(MemberVO vo);
	public int idCheckMember(MemberVO vo);
}
