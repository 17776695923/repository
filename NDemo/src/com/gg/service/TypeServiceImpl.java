package com.gg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.dao.TypeDaoImpl;
import com.gg.pojo.Type;
import com.gg.util.Page;

@Service
public class TypeServiceImpl implements ITypeService {
	@Autowired
	private TypeDaoImpl typeDao;

	@Override
	public Page<Type> getTypeByPage(int curPage) {
		Page<Type> page = new Page<>();
		int rows = typeDao.getTypeRows();
		page.setCurPage(curPage);
		page.setRows(rows);
		page.setTotalPage((rows%5==0)?(rows/5):(rows/5+1));
		page.setData(typeDao.getTypeByPage(curPage));
		return page;
	}

	@Override
	public void addType(Type type) {
		typeDao.addType(type);
	}

	@Override
	public int updateType(Type type) {
		return typeDao.updateType(type);
	}

	@Override
	public int deleteTypeById(int t_id) {
		return typeDao.deleteTypeById(t_id);
	}

	@Override
	public List<Type> findAllType() {
		return typeDao.findAllType();
	}

}
