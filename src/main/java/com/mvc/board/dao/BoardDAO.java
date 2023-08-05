package com.mvc.board.dao;

import static com.mvc.common.util.JDBCTemplate.close;
import static com.mvc.common.util.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mvc.board.vo.BoardVO;

public class BoardDAO {
	private static BoardDAO instance = null;
	
	public static BoardDAO getInstance() {
		if(instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}
	
	private BoardDAO() {}
	/***********************************************************
	 * boardList() 메서드: 게시판 목록 조회(검색 처리 제외)
	 * @return ArrayList<BoardVO> 리턴.
	 ***********************************************************/
	public ArrayList<BoardVO> boardList(BoardVO vo){
		ArrayList<BoardVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			StringBuffer qr = new StringBuffer();
			qr.append("select num, author, title, to_char(writeday, 'YYYY/MM/DD') writeday, ");
			qr.append(" readcnt, repRoot, repStep, repIndent from board ");
			
			if("title".equals(vo.getSearch())) {
				qr.append(" where title like ? " );
			} else if("author".equals(vo.getSearch())) {
				qr.append(" where author like ? " );
			} else if("content".equals(vo.getSearch())) {
				qr.append(" where content like ? " );
			}
			qr.append(" order by repRoot desc, repStep asc");
			
			pstmt = conn.prepareStatement(qr.toString());
			
			if(!"all".equals(vo.getSearch())) {
				pstmt.setString(1, "%"+vo.getKeyword()+"%");
			}
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO data = new BoardVO();
				data.setNum(rs.getInt("num"));
				data.setAuthor(rs.getString("author"));
				data.setTitle(rs.getString("title"));
				data.setWriteday(rs.getString("writeday"));
				data.setReadcnt(rs.getInt("readcnt"));
				data.setRepRoot(rs.getInt("repRoot"));
				data.setRepStep(rs.getInt("repStep"));
				data.setRepIndent(rs.getInt("repIndent"));
				
				list.add(data);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return list;
	}
	
	
	public boolean boardInsert(BoardVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			conn = getConnection();
			StringBuffer qr = new StringBuffer();
			qr.append("INSERT INTO board( num, author, title, content, reproot, repstep, repindent, passwd ) ");
			qr.append("VALUES( board_seq.nextval , ?, ? , ? , board_seq.currval, 0 , 0 , ? )");
			
			pstmt = conn.prepareStatement(qr.toString());
			pstmt.setString(1, vo.getAuthor());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getPasswd());
			int value = pstmt.executeUpdate();
			
			if(value==1) {
				result = true;
//				commit(conn);
			}
		}catch(Exception e) {
			e.printStackTrace();
//			rollback(conn);
		}finally {
			close(pstmt);
			close(conn);
		}
		return result;
	}
	
	public boolean boardUpdate(BoardVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try {
			conn = getConnection();
			StringBuffer qr = new StringBuffer();
			qr.append("update board set title=?, content=? ");
			if(vo.getPasswd() !="") qr.append(", passwd=? ");
			qr.append(" where num = ? ");
			
			pstmt = conn.prepareStatement(qr.toString());
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			if(vo.getPasswd() != "") {
				pstmt.setString(3, vo.getPasswd());
				pstmt.setInt(4, vo.getNum());
			} else {
				pstmt.setInt(3, vo.getNum());
			}
			
			int value = pstmt.executeUpdate();
			
			if(value==1) {
				result = true;
//				commit(conn);
			}
		}catch(Exception e) {
			e.printStackTrace();
//			rollback(conn);
		}finally {
			close(pstmt);
			close(conn);
		}
		return result;
	}
	
	public int boardPasswdChk(String num, String passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			conn = getConnection();
			StringBuffer qr = new StringBuffer();
			qr.append("select nvl((select 1 from board where num= ? ");
			qr.append(" and passwd = ?), 0) as result from dual");
			
			pstmt = conn.prepareStatement(qr.toString());
			pstmt.setInt(1, Integer.parseInt(num));
			pstmt.setString(2, passwd);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("result");	//비밀번호 일치 = 1 / 불일치 = 0 반환
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return result;
	}
	
//	public boolean boardDelete(BoardVO vo) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		boolean result = false;
//		
//		try {
//			conn = getConnection();
//			StringBuffer qr = new StringBuffer();
//			qr.append("delete from board where num = ?");
//			
//			pstmt = conn.prepareStatement(qr.toString());
//			pstmt.setInt(1, vo.getNum());
//			int value = pstmt.executeUpdate();
//			
//			if(value==1) {
//				result = true;
////				commit(conn);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
////			rollback(conn);
//		}finally {
//			close(pstmt);
//			close(conn);
//		}
//		return result;
//	}
	
	public void boardDelete(String num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			StringBuffer qr = new StringBuffer();
			qr.append("delete from board where num = ?");
			
			pstmt = conn.prepareStatement(qr.toString());
			pstmt.setInt(1, Integer.parseInt(num));
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
	}
	public void readCount(String num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			StringBuffer qr = new StringBuffer();
			qr.append("update board set readcnt = readcnt +1 ");
			qr.append(" where num = ?");
			
			pstmt = conn.prepareStatement(qr.toString());
			pstmt.setInt(1, Integer.parseInt(num));
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
	}
	
	public BoardVO boardDetail(String num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO data = new BoardVO();
		
		try {
			conn = getConnection();
			StringBuffer qr = new StringBuffer();
			qr.append("SELECT num, author, title,  content,  ");
			qr.append("TO_CHAR(writeday,'YYYY-MM-DD HH24:MI:SS') writeday, ");
			qr.append("readcnt, repRoot, repIndent, ");
			qr.append("repStep FROM board WHERE num = ?");
			
			pstmt = conn.prepareStatement(qr.toString());
			pstmt.setInt(1, Integer.parseInt(num));
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				data.setNum(rs.getInt("num"));
				data.setTitle(rs.getString("title"));
				data.setAuthor(rs.getString("author"));
				data.setContent(rs.getString("content"));
				data.setWriteday(rs.getString("writeday"));
				data.setReadcnt(rs.getInt("readcnt"));
				data.setRepRoot(rs.getInt("repRoot"));
				data.setRepStep(rs.getInt("repStep"));
				data.setRepIndent(rs.getInt("repIndent"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
}