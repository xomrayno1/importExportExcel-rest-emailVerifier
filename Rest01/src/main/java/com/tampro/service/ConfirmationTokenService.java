package com.tampro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.dao.ConfirmationTokenDAO;
import com.tampro.entity.ConfirmationToken;

@Service
public class ConfirmationTokenService {

	@Autowired
	ConfirmationTokenDAO confirmationTokenDAO;
	
	public void add(ConfirmationToken confirmationToken) throws Exception {
		confirmationTokenDAO.insert(confirmationToken);
	}
	public ConfirmationToken findById(int id) {
		return confirmationTokenDAO.findById(id);
	}
	public ConfirmationToken findByEmail(String email) {
		return confirmationTokenDAO.findByEmail(email);
	}
	public ConfirmationToken findByToken(String token) {
		return confirmationTokenDAO.findByToken(token);
	}
	public List<ConfirmationToken> findAll(){
		return confirmationTokenDAO.findAll(null, null);
	}
}
