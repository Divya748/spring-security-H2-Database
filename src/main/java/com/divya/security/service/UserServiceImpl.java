package com.divya.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.divya.security.entity.UserInfo;
import com.divya.security.repository.UserDao;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	UserDao userDao;

	@Override
	public void saveUser(UserInfo userInfo) {
		
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		userDao.save(userInfo);
		
	}

}
