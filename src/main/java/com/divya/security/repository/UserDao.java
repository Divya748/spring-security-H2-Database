package com.divya.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.divya.security.entity.UserInfo;

public interface UserDao extends JpaRepository<UserInfo, String>{

	Optional<UserInfo> findByName(String username);

}
