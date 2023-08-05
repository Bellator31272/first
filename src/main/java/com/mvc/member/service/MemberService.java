package com.mvc.member.service;

import com.mvc.member.dao.MemberMapperImpl;
import com.mvc.member.vo.MemberVO;

public class MemberService {
private static MemberService service = null;
	
	private MemberMapperImpl mapper = new MemberMapperImpl();
	
	private MemberService() {}
	public static MemberService getInstance() {
		if(service == null) {
			service = new MemberService();
		}
		return service;
	}
	
	public int insertMember(MemberVO vo) {
		int result = mapper.insertMember(vo);
		return result;
	}
	
	public int updateMember(MemberVO vo) {
		int result = mapper.updateMember(vo);
		return result;
	}
	
	public int passChkMember(MemberVO vo) {
		int result = mapper.passChkMember(vo);
		return result;
	}
	
	public MemberVO memberDetail(MemberVO vo) {
		MemberVO data = mapper.memberDetail(vo);
		return data;
	}
	
	public int deleteMember(MemberVO vo) {
		int result = mapper.deleteMember(vo);
		return result;
	}
	
	public int idCheckMember(MemberVO vo) {
		int result = mapper.idCheckMember(vo);
		return result;
	}
}
