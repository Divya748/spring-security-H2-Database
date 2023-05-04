package com.divya.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.divya.security.entity.UserInfo;
import com.divya.security.entity.UserInfoToUserDetails;
import com.divya.security.repository.UserDao;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userInfo =  userDao.findByName(username);
		return userInfo.map(UserInfoToUserDetails::new)
                .orElseThrow(() -> 
                new UsernameNotFoundException("user not found " + username));
	}

}
