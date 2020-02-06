package com.gg.dao;

import java.util.List;

import com.gg.pojo.Type;

public interface ITypeDao {
	public int getTypeRows();
	
	public List<Type> getTypeByPage(int curPage);
	
	public void addType(Type type);
	
	public int updateType(Type type);
	
	public int deleteTypeById(int t_id);
	
	public List<Type> findAllType();
}
