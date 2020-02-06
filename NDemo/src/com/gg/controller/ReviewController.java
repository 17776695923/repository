package com.gg.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gg.pojo.News;
import com.gg.pojo.Review;
import com.gg.service.NewServiceImpl;
import com.gg.service.ReviewServiceImpl;

@Controller
@RequestMapping("/View")
public class ReviewController {
	@Resource
	private ReviewServiceImpl reviewService;
	@Resource
	private NewServiceImpl newService;
	
	@RequestMapping("/findReviewByNew")
	public String findReviewByNew(Integer n_id,HttpSession session) {
		List<Review> list = reviewService.findReviewById(n_id);
		session.setAttribute("ReviewByNew", list);
		News news = newService.findNewById(n_id);
		session.setAttribute("NEW", news);
		return "forward:Info.jsp";
	}
	
	@RequestMapping("/addReview")
	public void addReview(Review review,HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		Date date = new Date();
		Timestamp r_revtime = new Timestamp(date.getTime());
		review.setR_revtime(r_revtime);
		if(review.getN_id() <= 0)
			response.getWriter().print("<script>"
					+ "alert('系统故障，返还主页');"
					+ "window.location.href='http://localhost:8080/NDemo/View/Index.jsp';"
					+ "</script>");
		else if(review.getR_content() == null || review.getR_content().equals(""))
			response.getWriter().print("<script>"
					+ "alert('评论内容不能为空，请输入正确的评论');"
					+ "window.location.href='http://localhost:8080/NDemo/View/findReviewByNew.do?n_id="+review.getN_id()+"';"
					+ "</script>");
		else {
			reviewService.addReview(review);
			response.getWriter().print("<script>"
					+ "alert('提交评论成功');"
					+ "window.location.href='http://localhost:8080/NDemo/View/findReviewByNew.do?n_id="+review.getN_id()+"';"
					+ "</script>");
		}
	}
}
