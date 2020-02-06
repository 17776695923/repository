package com.gg.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.gg.pojo.Review;

@Repository
public class ReviewDaoImpl implements IReviewDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<Review> findReviewById(int n_id) {
		String hql = "FROM Review WHERE n_id = :n_id ORDER BY r_revtime DESC";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql).setInteger("n_id", n_id);
		List<Review> list = query.list();
		return list;
	}

	@Override
	public void addReview(Review review) {
		Session session = sessionFactory.openSession();
		session.save(review);
	}

}
