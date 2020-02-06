package com.gg.dao;

import com.gg.pojo.User;

public interface IUserDao {
	public User login(String u_username,String u_userpwd);
}
