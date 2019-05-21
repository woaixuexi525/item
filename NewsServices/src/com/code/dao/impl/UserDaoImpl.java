package com.code.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.code.dao.IUserDao;
import com.code.domain.User;
import com.code.utils.C3P0Utils;

public class UserDaoImpl implements IUserDao{

	@Override
	public boolean check(User user) {
		try {
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSouce());
			String sql ="select * from t_user where name = ? and password = ?";
			Object[] params = {user.getName(),user.getPasswd()};
			List<User> list = qr.query(sql, new BeanListHandler<>(User.class),params);
			if(list.size() >0) {
				User u2 = list.get(0);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
