package web;

import java.sql.Timestamp;

public class BoardVO {

	private int b_idx; 
	private int m_idx;
	private String b_title; 
	private String b_content; 
	private String b_name;
	public int getB_idx() {
		return b_idx;
	}
	public void setB_idx(int b_idx) {
		this.b_idx = b_idx;
	}
	public int getM_idx() {
		return m_idx;
	}
	public void setM_idx(int m_idx) {
		this.m_idx = m_idx;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	@Override
	public String toString() {
		return "BoardVO [b_idx=" + b_idx + ", m_idx=" + m_idx + ", b_title=" + b_title + ", b_content=" + b_content
				+ ", b_name=" + b_name + "]";
	}
	
	
	
}
