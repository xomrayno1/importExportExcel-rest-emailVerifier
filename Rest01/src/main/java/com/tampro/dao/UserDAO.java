package com.tampro.dao;

import java.util.List;
import java.util.Map;

import com.tampro.entity.User;

public interface UserDAO {
	
	void insert(User user) throws Exception;
	void update(User user) throws Exception;
	void delete(User user) throws Exception;
	List<User> findAll(String sql , Map<String, Object> mapParam);
	List<User> findAllByProperty(String property , Object object);
	User findById(int id);
}
