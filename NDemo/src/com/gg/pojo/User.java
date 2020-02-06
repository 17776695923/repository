package com.gg.pojo;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name="nrc_user")
public class User {
	private int u_id;
	private String u_username;	//
	private String u_userpwd;	//
	private String u_name;		//
	public User() {
		super();
	}
	public User(int u_id, String u_username, String u_userpwd, String u_name) {
		super();
		this.u_id = u_id;
		this.u_username = u_username;
		this.u_userpwd = u_userpwd;
		this.u_name = u_name;
	}
	
	@Id
	@Column
	@GeneratedValue
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	
	@Column(length=20)
	public String getU_username() {
		return u_username;
	}
	public void setU_username(String u_username) {
		this.u_username = u_username;
	}
	
	@Column(length=100)
	public String getU_userpwd() {
		return u_userpwd;
	}
	public void setU_userpwd(String u_userpwd) {
		this.u_userpwd = u_userpwd;
	}
	
	@Column(length=20)
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_username=" + u_username + ", u_userpwd=" + u_userpwd + ", u_name=" + u_name
				+ "]";
	}
}
