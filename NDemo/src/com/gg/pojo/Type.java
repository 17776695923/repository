package com.gg.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="nrc_type")
public class Type {
	private int t_id;
	private String t_name;	//类别名称
	private String t_memo;	//类别备注
	public Type() {
		super();
	}
	public Type(int t_id, String t_name, String t_memo) {
		super();
		this.t_id = t_id;
		this.t_name = t_name;
		this.t_memo = t_memo;
	}
	
	@Id
	@Column
	@GeneratedValue
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	
	@Column(length=20)
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	
	@Column(length=100)
	public String getT_memo() {
		return t_memo;
	}
	public void setT_memo(String t_memo) {
		this.t_memo = t_memo;
	}
	@Override
	public String toString() {
		return "Type [t_id=" + t_id + ", t_name=" + t_name + ", t_memo=" + t_memo + "]";
	}
}
