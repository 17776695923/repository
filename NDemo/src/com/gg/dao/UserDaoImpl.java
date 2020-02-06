package com.gg.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gg.pojo.User;

@Repository
public class UserDaoImpl implements IUserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User login(String u_username, String u_userpwd) {
		String sql = "from User WHERE u_username = :u_username AND u_userpwd = :u_userpwd";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(sql).setString("u_username", u_username).setString("u_userpwd", u_userpwd);
		User user = (User) query.uniqueResult();
		return user;
	}

}
