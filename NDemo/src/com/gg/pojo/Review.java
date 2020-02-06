package com.gg.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="nrc_review")
public class Review {
	private int r_id;
	private String r_content;	//评论内容
	private String r_username;	//评论者昵称
	private Timestamp r_revtime;//评论时间
	private int n_id;			//新闻编号
	public Review() {
		super();
	}
	public Review(int r_id, String r_content, String r_username, Timestamp r_revtime, int n_id) {
		super();
		this.r_id = r_id;
		this.r_content = r_content;
		this.r_username = r_username;
		this.r_revtime = r_revtime;
		this.n_id = n_id;
	}
	
	@Id
	@Column
	@GeneratedValue
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	
	@Column(length=200)
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	
	@Column(length=20)
	public String getR_username() {
		return r_username;
	}
	public void setR_username(String r_username) {
		this.r_username = r_username;
	}
	
	@Column
	public Timestamp getR_revtime() {
		return r_revtime;
	}
	public void setR_revtime(Timestamp r_revtime) {
		this.r_revtime = r_revtime;
	}
	
	@Column
	public int getN_id() {
		return n_id;
	}
	public void setN_id(int n_id) {
		this.n_id = n_id;
	}
	@Override
	public String toString() {
		return "Review [r_id=" + r_id + ", r_content=" + r_content + ", r_username=" + r_username + ", r_revtime="
				+ r_revtime + ", n_id=" + n_id + "]";
	}
}
