package com.code.services;

import java.util.ArrayList;
import java.util.List;

import com.code.domain.News;
import com.code.domain.PageBean;

public interface INewsServices {
	//获取新闻内容
	public News getNews(int nid);
	public void insertNews(News news);
	public PageBean<News> findByPage(int currPage, int pageSize);
	public void updateNews(News news);
	public void deleteNews(int nid);
}
