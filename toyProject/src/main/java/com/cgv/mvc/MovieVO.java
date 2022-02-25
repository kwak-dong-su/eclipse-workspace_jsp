package com.cgv.mvc;

public class MovieVO {

	private int mvId;
	private String mvTitle;
	private String mvTime;
	private String mvSection;
	private double mvRating;
	private String mvSummary;
	private String mvImg;
	public int getMvId() {
		return mvId;
	}
	public void setMvId(int mvId) {
		this.mvId = mvId;
	}
	public String getMvTitle() {
		return mvTitle;
	}
	public void setMvTitle(String mvTitle) {
		this.mvTitle = mvTitle;
	}
	public String getMvTime() {
		return mvTime;
	}
	public void setMvTime(String mvTime) {
		this.mvTime = mvTime;
	}
	public String getMvSection() {
		return mvSection;
	}
	public void setMvSection(String mvSection) {
		this.mvSection = mvSection;
	}
	public double getMvRating() {
		return mvRating;
	}
	public void setMvRating(double mvRating) {
		this.mvRating = mvRating;
	}
	public String getMvSummary() {
		return mvSummary;
	}
	public void setMvSummary(String mvSummary) {
		this.mvSummary = mvSummary;
	}
	public String getMvImg() {
		return mvImg;
	}
	public void setMvImg(String mvImg) {
		this.mvImg = mvImg;
	}
	@Override
	public String toString() {
		return "MovieVO [mvId=" + mvId + ", mvTitle=" + mvTitle + ", mvTime=" + mvTime + ", mvSection=" + mvSection
				+ ", mvRating=" + mvRating + ", mvSummary=" + mvSummary + ", mvImg=" + mvImg + "]";
	}
	
	
}
