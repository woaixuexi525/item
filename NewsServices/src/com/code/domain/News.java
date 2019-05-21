package com.code.domain;

public class News {
	private int nid;
	private int cid;
	private String title;
	private String digest;
	private String body;
	private String source;
	private String ptime;
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	public News(int nid, int cid, String title, String digest, String body, String source, String ptime) {
		super();
		this.nid = nid;
		this.cid = cid;
		this.title = title;
		this.digest = digest;
		this.body = body;
		this.source = source;
		this.ptime = ptime;
	}
	public News(int cid, String title, String digest, String body, String source, String ptime) {
		super();
		this.cid = cid;
		this.title = title;
		this.digest = digest;
		this.body = body;
		this.source = source;
		this.ptime = ptime;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
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
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getPtime() {
		return ptime;
	}
	public void setPtime(String ptime) {
		this.ptime = ptime;
	}
	@Override
	public String toString() {
		return "News [nid=" + nid + ", cid=" + cid + ", title=" + title + ", digest=" + digest + ", body=" + body
				+ ", source=" + source + ", ptime=" + ptime + "]";
	}
	
	
}
