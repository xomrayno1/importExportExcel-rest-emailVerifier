package com.tampro.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tampro.dao.ConfirmationTokenDAO;
import com.tampro.entity.ConfirmationToken;

@Repository
@Transactional(rollbackFor = Exception.class)
public class ConfirmationTokenImpl implements ConfirmationTokenDAO {
	
	@Autowired
	SessionFactory sessionFactory ;

	@Override
	public void insert(ConfirmationToken confirmationToken) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();	
		Transaction transaction =	session.beginTransaction();
		session.save(confirmationToken);
		transaction.commit();
		session.close();
	}

	@Override
	public ConfirmationToken findById(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().find(ConfirmationToken.class, id);
	}

	@Override
	public List<ConfirmationToken> findAll(String sql, Map<String, Object> mapParam) {
		// TODO Auto-generated method stub
		Session session = 	sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("	FROM ConfirmationToken	");
		
		return (List<ConfirmationToken>) query.getResultList();
	}

	@Override
	public ConfirmationToken findByEmail(String email) {
		// TODO Auto-generated method stub
		Session session = 	sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("	FROM ConfirmationToken where email = :email	");
		query.setParameter("email", email);
		return (ConfirmationToken) query.getSingleResult();
	}

	@Override
	public ConfirmationToken findByToken(String token) {
		// TODO Auto-generated method stub
		Session session = 	sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("	FROM ConfirmationToken where confirmationToken = :confirmationToken	");
		query.setParameter("confirmationToken", token);
		return (ConfirmationToken) query.getSingleResult();
	}

}
