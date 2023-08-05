package com.mvc.board.vo;

public class BoardVO {
	private int num;
	private String author;
	private String title;
	private String content;
	private int readcnt;
	private String writeday;
	private int repRoot;		//게시판 답변글(원래글의 번호 참조 - 그룹번호)
	private int repStep;		//게시판 답변글(답변글의 위치번호 지정)
	private int repIndent;		//게시판 답변글(답변글의 계층번호 지정)
	private String passwd;
	
	private String search = "";		//기본값을 null 이 아니라 ""(빈문자)로 제어, 검색대상
	private String keyword = "";	//검색어
	
	public BoardVO() {}

	public BoardVO(int num, String author, String title, String content, int readcnt, String writeday, int repRoot,
			int repStep, int repIndent) {
		this.num = num;
		this.author = author;
		this.title = title;
		this.content = content;
		this.readcnt = readcnt;
		this.writeday = writeday;
		this.repRoot = repRoot;
		this.repStep = repStep;
		this.repIndent = repIndent;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	public String getWriteday() {
		return writeday;
	}

	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}

	public int getRepRoot() {
		return repRoot;
	}

	public void setRepRoot(int repRoot) {
		this.repRoot = repRoot;
	}

	public int getRepStep() {
		return repStep;
	}

	public void setRepStep(int repStep) {
		this.repStep = repStep;
	}

	public int getRepIndent() {
		return repIndent;
	}

	public void setRepIndent(int repIndent) {
		this.repIndent = repIndent;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String toString() {
		return "BoardVO [num=" + num + ", author=" + author + ", title=" + title + ", content=" + content + ", readcnt="
				+ readcnt + ", writeday=" + writeday + ", repRoot=" + repRoot + ", repStep=" + repStep + ", repIndent="
				+ repIndent + ", passwd=" + passwd + ", search=" + search + ", keyword=" + keyword + "]";
	}
}
