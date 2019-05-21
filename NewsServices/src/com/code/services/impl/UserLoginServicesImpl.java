package com.code.services.impl;


import com.code.dao.IUserDao;
import com.code.dao.impl.UserDaoImpl;
import com.code.domain.User;
import com.code.services.IUserLoginServices;

public class UserLoginServicesImpl implements IUserLoginServices{

	@Override
	public boolean check(User user) {
		IUserDao daoImpl = new UserDaoImpl();
		return daoImpl.check(user);
	}

}
