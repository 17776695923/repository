package com.gg.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.gg.pojo.News;
import com.gg.util.Page;

@Repository
public class NewDaoImpl implements INewDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<News> getNewByPage(int curPage) {
		Session session = sessionFactory.openSession();
		String hql = "FROM News ORDER BY n_publishtime DESC ";
		Query query = session.createQuery(hql).setFirstResult((curPage-1)*5).setMaxResults(curPage*5);
		List<News> list = query.list();
		return list;
	}

	@Override
	public int getNewRow() {
		Session session  = sessionFactory.openSession();
		String hql = "SELECT COUNT(n_id) FROM News";
		Query query = session.createQuery(hql);
		long num = (long) query.uniqueResult();
		int rows = (int)(num/1);
		return rows;
	}

	@Override
	public void addNews(News news) {
		Session session  = sessionFactory.openSession();
		Date date = new Date();
		Timestamp n_publishtime = new Timestamp(date.getTime());
		news.setN_publishtime(n_publishtime);
		session.save(news);
	}

	@Override
	public int updateNew(News news) {
		Session session  = sessionFactory.openSession();
		Date date = new Date();
		Timestamp n_publishtime = new Timestamp(date.getTime());
		String hql = "UPDATE News SET n_title = :n_title,n_content = :n_content ,n_publishtime = :n_publishtime,t_id = :t_id WHERE n_id = :n_id";
		Query query = session.createQuery(hql);
		query.setString("n_title", news.getN_title());
		query.setString("n_content", news.getN_content());
		query.setTimestamp("n_publishtime", n_publishtime);
		query.setInteger("t_id", news.getT_id());
		query.setInteger("n_id", news.getN_id());
		int result = query.executeUpdate();
		return result;
	}

	@Override
	public int deleteNewById(int n_id) {
		String hql = "DELETE FROM News WHERE n_id = :n_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql).setInteger("n_id", n_id);
		int result = query.executeUpdate();
		return result;
	}

	@Override
	public List<News> queryHotNews() {
		Session session = sessionFactory.openSession();
		String hql = "SELECT nrc_news.* FROM nrc_news " + 
				"LEFT JOIN nrc_review ON nrc_news.n_id = nrc_review.n_id " + 
				"GROUP BY nrc_review.n_id " + 
				"ORDER BY COUNT(nrc_review.n_id) DESC " + 
				"LIMIT 0,5";
		SQLQuery query = session.createSQLQuery(hql).addEntity(News.class);
		List<News> list = query.list();
		return list;
	}

	@Override
	public Page<News> findNewsByType(int t_id,int curPage) {
		String hql = "FROM News WHERE t_id = :t_id";
		String hql1= "SELECT COUNT(n_id) FROM News WHERE t_id = :t_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql).setInteger("t_id", t_id).setFirstResult((curPage-1)*5).setMaxResults(curPage*5);
		Query query1= session.createQuery(hql1).setInteger("t_id", t_id);
		List<News> list = query.list();
		long get = (long) query1.uniqueResult();
		int rows = (int)(get/1);
		Page<News> page = new Page<>();
		page.setRows(rows);
		page.setCurPage(curPage);
		page.setTotalPage((rows%5==0)?(rows/5):(rows/5+1));
		page.setData(list);
		return page;
	}

	@Override
	public News findNewById(int n_id) {
		String hql = "FROM News WHERE n_id = :n_id";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql).setInteger("n_id", n_id);
		News news = (News) query.uniqueResult();
		return news;
	}

	@Override
	public Page<News> findNewsByKey(String select, String key,int curPage) {
		Session session = sessionFactory.openSession();
		String hql1 = "FROM News WHERE "+select+" LIKE '%"+key+"%'";
		String hql2 = "SELECT COUNT(n_id) FROM News WHERE "+select+" LIKE '%"+key+"%'";
		Query query1= session.createQuery(hql1);
		Query query2= session.createQuery(hql2);
		Page<News> page = new Page<>();
		page.setCurPage(curPage);
		int rows = (int)((long)query2.uniqueResult()/1);
		page.setRows(rows);
		page.setTotalPage((rows%5==0)?(rows/5):(rows/5+1));
		page.setData(query1.list());
		return page;
	}

}
