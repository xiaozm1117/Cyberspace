package cn.jt.pojo;

import java.io.Serializable;
import java.util.Date;

public class Video implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int adminId;	
	private String type;  //"video" "picture"
	private String content;
	private Date createTime;
	private int dianZan;
	private int shouCang;
	private int pingLun;
	private String text;
	private String title;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getDianZan() {
		return dianZan;
	}
	public void setDianZan(int dianZan) {
		this.dianZan = dianZan;
	}
	public int getShouCang() {
		return shouCang;
	}
	public void setShouCang(int shouCang) {
		this.shouCang = shouCang;
	}
	public int getPingLun() {
		return pingLun;
	}
	public void setPingLun(int pingLun) {
		this.pingLun = pingLun;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date string) {
		this.createTime = string;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
