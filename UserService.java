package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDAO;
import com.model.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	public User getUserById(Long id) {
		return userDAO.getUserById(id);
	}

	public void saveUser(User user) {
		userDAO.saveUser(user);
	}

	public void deleteUser(Long id) {
		userDAO.deleteUser(id);
	}
}
