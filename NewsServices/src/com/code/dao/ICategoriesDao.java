package com.code.dao;

import java.util.List;

import com.code.domain.Category;
import com.code.domain.News;

public interface ICategoriesDao {
	public List<News> getSpecifyCategoryNews(int tid, int startNid, int count);
}
