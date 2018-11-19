package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

@Service("userService")
public class UserService {
	
	@Autowired
    private UserDao userDao;

	public boolean addUser(User record) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<User> getUsers(Map<String, Object> params) {
		return userDao.getUsers(params);
	}

}
