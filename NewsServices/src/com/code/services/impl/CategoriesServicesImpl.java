package com.code.services.impl;

import java.util.List;

import com.code.dao.ICategoriesDao;
import com.code.dao.impl.CategoriesDaoImpl;
import com.code.domain.Category;
import com.code.domain.News;
import com.code.services.ICategoriesServices;

public class CategoriesServicesImpl implements ICategoriesServices{

	@Override
	public List<News> getSpecifyCategoryNews(int tid, int startNid, int count) {
		ICategoriesDao daoImpl = new CategoriesDaoImpl();
		return daoImpl.getSpecifyCategoryNews(tid, startNid, count);
	}

	
	
}
