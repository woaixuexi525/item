package com.code.services;

import java.util.List;

import com.code.domain.News;

public interface ICategoriesServices {
	public List<News> getSpecifyCategoryNews(int tid, int startNid, int count);
}
