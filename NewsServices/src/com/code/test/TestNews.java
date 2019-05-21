package com.code.test;

import java.sql.Connection;
import java.util.List;

import org.junit.Test;

import com.code.dao.ICategoriesDao;
import com.code.dao.impl.CategoriesDaoImpl;
import com.code.domain.Category;
import com.code.services.impl.CategoriesServicesImpl;
import com.code.utils.C3P0Utils;

public class TestNews {
	
	@Test
	public void testConn() {
		Connection conn = C3P0Utils.getConn();
		System.out.println(conn.toString());
	}
	
}
