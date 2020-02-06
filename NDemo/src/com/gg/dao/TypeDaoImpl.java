package com.gg.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gg.pojo.Type;

@Repository
public class TypeDaoImpl implements ITypeDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Type> getTypeByPage(int curPage) {
		String hql = "FROM Type";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql).setFirstResult((curPage-1)*5).setMaxResults(curPage*5);
		List<Type> list = query.list();
		return list;
	}

	@Override
	public int getTypeRows() {
		String hql = "SELECT COUNT(t_id) FROM Type";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		Object object = query.uniqueResult();
		int rows = (int) ((long)object/1);
		return rows;
	}

	@Override
	public void addType(Type type) {
		Session session = sessionFactory.openSession();
		session.save(type);
	}

	@Override
	public int updateType(Type type) {
		Session session = sessionFactory.openSession();
		String hql = "UPDATE Type SET t_name = :t_name , t_memo = :t_memo WHERE t_id = :t_id";
		Query query = session.createQuery(hql).setString("t_name", type.getT_name()).setString("t_memo", type.getT_memo()).setInteger("t_id", type.getT_id());
		int result = query.executeUpdate();
		return result;
	}

	@Override
	public int deleteTypeById(int t_id) {
		Session session = sessionFactory.openSession();
		String hql = "DELETE FROM Type WHERE t_id = :t_id";
		Query query = session.createQuery(hql).setInteger("t_id", t_id);
		int result = query.executeUpdate();
		return result;
	}

	@Override
	public List<Type> findAllType() {
		Session session = sessionFactory.openSession();
		String hql = "FROM Type";
		Query query = session.createQuery(hql);
		List<Type> list = query.list();
		return list;
	}

}
