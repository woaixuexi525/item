package com.code.domain;
/**
 * 新闻Bean
 * @author Destiny
 *
 */
public class Category {
	private int cid;
	private String title;
	
	public Category() {
		super();
	}
	public Category(int cid, String title) {
		super();
		this.cid = cid;
		this.title = title;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", title=" + title + "]";
	}
	
}
