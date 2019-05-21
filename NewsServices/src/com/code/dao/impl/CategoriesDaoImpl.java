package com.code.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.omg.PortableInterceptor.TRANSPORT_RETRY;

import com.code.dao.ICategoriesDao;
import com.code.domain.Category;
import com.code.domain.News;
import com.code.utils.C3P0Utils;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class CategoriesDaoImpl implements ICategoriesDao{
	List<News> list = null;
	@Override
	public List<News> getSpecifyCategoryNews(int tid, int startNid, int count) {
		try {
			QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSouce());
			String sql = "SELECT nid,cid,title,digest,source,ptime FROM t_news WHERE cid=? ORDER BY ptime desc LIMIT ?,?";
			Object[] params = new Object[]{ tid, startNid, count };
			 list = queryRunner.query(sql,new BeanListHandler<>(News.class), params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
