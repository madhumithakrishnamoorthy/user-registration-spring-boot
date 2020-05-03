package com.example.UserRepo.service;

import java.util.List;
import java.util.Map;

import com.example.UserRepo.model.User;

public interface UserService {

	public List<User> getAllUsers();
	
	public User updateUser(User user, Integer id);
	
	public Map<String, String> deleteUser(Integer id);
	
	public User saveUser(User user);
	
	public boolean isUserAlreadyPresent(User user);

	public User getUser(Integer id);
}
