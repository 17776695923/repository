package com.gg.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gg.dao.INewDao;
import com.gg.pojo.News;
import com.gg.util.Page;

@Service
public class NewServiceImpl implements INewService {
	@Resource
	private INewDao newDao;

	@Override
	public Page<News> getNewByPage(int curPage) {
		Page<News> page = new Page<>();
		page.setCurPage(curPage);
		int rows = newDao.getNewRow();
		page.setRows(rows);
		page.setTotalPage((rows%5 == 0)?(rows/5):(rows/5+1));
		page.setData(newDao.getNewByPage(curPage));
		return page;
	}

	@Override
	public void addNews(News news) {
		newDao.addNews(news);
	}

	@Override
	public int updateNew(News news) {
		return newDao.updateNew(news);
	}

	@Override
	public int deleteNewById(int n_id) {
		return newDao.deleteNewById(n_id);
	}

	@Override
	public List<News> queryNew() {
		return newDao.getNewByPage(1);
	}

	@Override
	public List<News> queryHot() {
		return newDao.queryHotNews();
	}

	@Override
	public Page<News> findNewsByType(int t_id,int curPage) {
		return newDao.findNewsByType(t_id,curPage);
	}

	@Override
	public News findNewById(int n_id) {
		return newDao.findNewById(n_id);
	}

	@Override
	public Page<News> findNewsByKey(String select, String key, int curPage) {
		return newDao.findNewsByKey(select, key, curPage);
	}

}
