package com.gg.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gg.dao.ReviewDaoImpl;
import com.gg.pojo.Review;

@Service
public class ReviewServiceImpl implements IReviewService {
	@Resource
	private ReviewDaoImpl reviewDao;

	@Override
	public List<Review> findReviewById(int n_id) {
		return reviewDao.findReviewById(n_id);
	}

	@Override
	public void addReview(Review review) {
		reviewDao.addReview(review);
	}

}
