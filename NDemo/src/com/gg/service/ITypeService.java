package com.gg.service;

import java.util.List;

import com.gg.pojo.Type;
import com.gg.util.Page;

public interface ITypeService {
	public Page<Type> getTypeByPage(int curPage);
	
	public void addType(Type type);
	
	public int updateType(Type type);
	
	public int deleteTypeById(int t_id);
	
	public List<Type> findAllType();
}
