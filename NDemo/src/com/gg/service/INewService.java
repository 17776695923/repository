package com.gg.service;

import java.util.List;

import com.gg.pojo.News;
import com.gg.util.Page;

public interface INewService {
	public Page<News> getNewByPage(int curPage);
	
	public void addNews(News news);
	
	public int updateNew(News news);
	
	public int deleteNewById(int n_id);
	
	public List<News> queryNew();
	
	public List<News> queryHot();
	
	public Page<News> findNewsByType(int t_id,int curPage);
	
	public News findNewById(int n_id);
	
	public Page<News> findNewsByKey(String select, String key,int curPage);
}
