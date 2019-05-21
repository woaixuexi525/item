package com.code.dao.impl;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.code.dao.INewsDao;
import com.code.domain.News;
import com.code.utils.C3P0Utils;

public class NewsDaoImpl implements INewsDao{
	
	/**
	 * 获取新闻内容
	 */
	@Override
	public News getNews(int nid) {
		News news = new News();
		try {
			QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSouce());
			//String sql = "SELECT nid,cid,title,,digest,body,source,ptime FROM t_news WHERE nid=? ";
			String sql = "SELECT * FROM t_news WHERE nid=? ";
			Object[] params ={nid};
			news = queryRunner.query(sql, new BeanHandler<>(News.class), params);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return news;
	}
	
	/**
	 * 插入数据
	 */
	@Override
	public void insertNews(News news) {
		try {
			QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSouce());
			//insert  into `t_news`(`nid`,`cid`,`title`,`digest`,`body`,`source`,`ptime`)
			//INSERT  INTO `t_news`(`cid`,`title`,`digest`,`body`,`source`,`ptime`) VALUES (1,'title','digest','body','腾讯','2019-04-20 10:36');
			String sql = "insert into t_news (cid,title,digest,body,source,ptime) values(?,?,?,?,?,?)";
			Object[] params = {news.getCid(),news.getTitle(),news.getDigest(),news.getBody(),news.getSource(),news.getPtime()};
			queryRunner.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		try {
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSouce());
			String sql = "select count(*) from t_news";
			return ((Long)qr.query(sql, new ScalarHandler())).intValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<News> findByPage(int currPage, int pageSize) {
		try {
			//System.out.println(currPage);
			//System.out.println(pageSize);
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSouce());
			String sql="select * from t_news limit ?,?";
			return qr.query(sql, new BeanListHandler<>(News.class), (currPage-1)*pageSize,pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateNews(News news) {
		try {
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSouce());
			String sql="update t_news  set title =?,digest=?,body=? where nid = ? ";
			Object[] params = {news.getTitle(),news.getDigest(),news.getBody(),news.getNid()};
			qr.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteNews(int nid) {
		try {
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSouce());
			String sql ="delete from t_news where nid = ?";
			Object[] params = {nid};
			qr.update(sql, params);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
