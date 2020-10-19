package com.tampro.dao;

import java.util.List;
import java.util.Map;

import com.tampro.entity.ConfirmationToken;

public interface ConfirmationTokenDAO {
	void insert(ConfirmationToken confirmationToken) throws Exception;
	ConfirmationToken findById(int id);
	ConfirmationToken findByEmail(String email);
	ConfirmationToken findByToken(String token);
	List<ConfirmationToken> findAll(String sql , Map<String, Object> mapParam);

}
