package com.gg.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="nrc_news")
public class News {
	private int n_id;
	private String n_title;		//新闻标题
	private String n_content;	//新闻内容
	private int t_id;			//类别ID
	private Timestamp n_publishtime;//新闻发布时间
	public News(int n_id, String n_title, String n_content, int t_id, Timestamp n_publishtime) {
		super();
		this.n_id = n_id;
		this.n_title = n_title;
		this.n_content = n_content;
		this.t_id = t_id;
		this.n_publishtime = n_publishtime;
	}
	public News() {
		super();
	}
	
	@Id
	@Column
	@GeneratedValue
	public int getN_id() {
		return n_id;
	}
	public void setN_id(int n_id) {
		this.n_id = n_id;
	}
	
	@Column(length=200)
	public String getN_title() {
		return n_title;
	}
	public void setN_title(String n_title) {
		this.n_title = n_title;
	}
	
	@Column(length=5000)
	public String getN_content() {
		return n_content;
	}
	public void setN_content(String n_content) {
		this.n_content = n_content;
	}
	
	@Column
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	
	@Column
	public Timestamp getN_publishtime() {
		return n_publishtime;
	}
	public void setN_publishtime(Timestamp n_publishtime) {
		this.n_publishtime = n_publishtime;
	}
	@Override
	public String toString() {
		return "News [n_id=" + n_id + ", n_title=" + n_title + ", n_content=" + n_content + ", t_id=" + t_id
				+ ", n_publishtime=" + n_publishtime + "]";
	}
}
