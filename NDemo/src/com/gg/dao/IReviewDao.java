package com.gg.dao;

import java.util.List;

import com.gg.pojo.Review;

public interface IReviewDao {
	public List<Review> findReviewById(int n_id);
	
	public void addReview(Review review);
}
