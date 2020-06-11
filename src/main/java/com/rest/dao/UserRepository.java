package com.rest.dao;

import org.springframework.data.repository.CrudRepository;

import com.rest.entity.UserDao;

public interface UserRepository extends CrudRepository<UserDao, Integer> {
	UserDao findByUsername(String username);
}
