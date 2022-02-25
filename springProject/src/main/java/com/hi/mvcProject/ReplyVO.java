package com.hi.mvcProject;

public class ReplyVO {
	private int id;
	private int bbsid;
	private String content;
	private String writer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBbsid() {
		return bbsid;
	}
	public void setBbsid(int bbsid) {
		this.bbsid = bbsid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	//alt+shift+s+r
	
	@Override
	public String toString() {
		return "ReplyVO [id=" + id + ", bbsid=" + bbsid + ", content=" + content + ", writer=" + writer + "]";
	}
	//자동완성 등록(toString): ctrl+shift+z
	
	
	
}
