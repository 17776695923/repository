package com.gg.service;

import java.util.List;

import com.gg.pojo.Review;

public interface IReviewService {
	public List<Review> findReviewById(int n_id);
	
	public void addReview(Review review);
}
