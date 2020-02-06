package com.gg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.dao.UserDaoImpl;
import com.gg.pojo.User;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserDaoImpl userdao;

	@Override
	public User login(String u_username, String u_userpwd) {
		return userdao.login(u_username, u_userpwd);
	}

}
