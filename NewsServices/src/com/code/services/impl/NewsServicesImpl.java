package com.code.services.impl;

import java.util.List;

import com.code.dao.INewsDao;
import com.code.dao.impl.NewsDaoImpl;
import com.code.domain.News;
import com.code.domain.PageBean;
import com.code.services.INewsServices;

public class NewsServicesImpl implements INewsServices {
	@Override
	public News getNews(int nid) {
		INewsDao daoImpl = new NewsDaoImpl();
		return daoImpl.getNews(nid);
	}

	@Override
	public void insertNews(News news) {
		INewsDao daoImpl = new NewsDaoImpl();
		daoImpl.insertNews(news);
	}
	@Override
	public PageBean<News> findByPage(int currPage, int pageSize) {
		INewsDao daoImpl = new NewsDaoImpl();
		List<News> list = daoImpl.findByPage(currPage, pageSize);
		int totalCount = daoImpl.getCount();
		return new PageBean<>(list, currPage, pageSize, totalCount); 
	}

	@Override
	public void updateNews(News news) {
		INewsDao daoImpl = new NewsDaoImpl();
		daoImpl.updateNews(news);
	}

	@Override
	public void deleteNews(int nid) {
		INewsDao daoImpl = new NewsDaoImpl();
		daoImpl.deleteNews(nid);
	}

}
