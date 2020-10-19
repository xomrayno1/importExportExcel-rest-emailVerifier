package com.tampro.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tampro.dao.UserDAO;
import com.tampro.entity.User;

@Repository
@Transactional(rollbackFor = Exception.class)
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	SessionFactory factory;

	public void insert(User user) throws Exception {
		// TODO Auto-generated method stub
		factory.getCurrentSession().persist(user);
	}

	public void update(User user) throws Exception {
		// TODO Auto-generated method stub
		//Session session = 	factory.openSession();
		
		factory.getCurrentSession().merge(user);
	}

	public void delete(User user) throws Exception {
		// TODO Auto-generated method stub
		factory.getCurrentSession().merge(user);
	}

	public List<User> findAll(String stringStr ,Map<String, Object> mapParam) {
		// TODO Auto-generated method stub
		StringBuilder  sql  = new StringBuilder(" FROM  User as us where  1 = 1  ");
		if(!stringStr.isEmpty() && !mapParam.isEmpty()) {
			sql.append(stringStr);
		}
		Query query = 	factory.getCurrentSession().createQuery(sql.toString());
		if(!stringStr.isEmpty() && !mapParam.isEmpty()) {
			for(String key : mapParam.keySet()) {
				query.setParameter(key, mapParam.get(key));
			}
		}
		return query.getResultList();
	}

	public List<User> findAllByProperty(String property, Object object) {
		// TODO Auto-generated method stub
		StringBuilder sql  = new StringBuilder("SELECT * FROM  User	as us where  1 = 1 ");
		if(!property.isEmpty() && object != null) {
			sql.append(" and  us.").append(property + "=:").append(object);
		}
		Query query = 	factory.getCurrentSession().createQuery(sql.toString());
		if(!property.isEmpty() && object != null) {
			query.setParameter(property, object);
		}
		return query.getResultList();
	}

	public User findById(int id) {
		// TODO Auto-generated method stub
		return factory.getCurrentSession().get(User.class, id);
	}
	
}
