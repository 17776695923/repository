package com.gg.dao;

import java.util.List;

import com.gg.pojo.News;
import com.gg.util.Page;

public interface INewDao {
	public List<News> getNewByPage(int curPage);
	
	public int getNewRow();
	
	public void addNews(News news);
	
	public int updateNew(News news);
	
	public int deleteNewById(int n_id);
	
	public List<News> queryHotNews();
	
	public Page<News> findNewsByType(int t_id,int curPage);
	
	public News findNewById(int n_id);
	
	public Page<News> findNewsByKey(String select,String key,int curPage);
}
