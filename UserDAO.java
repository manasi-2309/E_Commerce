package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<User> getAllUsers() {
		return sessionFactory.openSession().createQuery("from User", User.class).list();
	}

	public User getUserById(Long id) {
		return sessionFactory.openSession().get(User.class, id);
	}

	public void saveUser(User user) {
		sessionFactory.openSession().saveOrUpdate(user);
	}

	public void deleteUser(Long id) {
		Session session = sessionFactory.openSession();
		User user = session.get(User.class, id);
		if (user != null) {
			session.delete(user);
			session.beginTransaction().commit();
		}
	}
}
