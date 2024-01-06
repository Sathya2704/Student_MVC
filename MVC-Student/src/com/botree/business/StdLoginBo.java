package com.botree.business;

import com.botree.bean.StdUser;
import com.botree.dao.StdLoginDao;
import com.botree.exception.InvalidStdUserException;

public class StdLoginBo {

	public boolean validateUser(StdUser user) throws InvalidStdUserException{
		
		var loginDao = new StdLoginDao();
		
		loginDao.getUser(user);
		
		StdUser u = loginDao.getUser(user);
		
		if(u!=null && u.username().equals(user.username()) && u.password().equals(user.password())){   
			return true;
		}
		
		throw new InvalidStdUserException("Invalid username or password");
	}
}
