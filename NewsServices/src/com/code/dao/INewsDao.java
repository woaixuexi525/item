package com.code.dao;

import java.util.ArrayList;
import java.util.List;

import com.code.domain.News;
import com.code.domain.PageBean;


public interface INewsDao {
	public News getNews(int nid);
	public void insertNews(News news);
	public List<News> findByPage(int currPage, int pageSize);
	public int getCount();
	public void updateNews(News news);
	public void deleteNews(int nid);
}
