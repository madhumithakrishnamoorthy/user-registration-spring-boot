package com.example.UserRepo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserRepo.model.User;
import com.example.UserRepo.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public User updateUser(User user, Integer id) {
		Optional<User> userObj = userRepository.findById(id);
		if (userObj.isPresent()) {
			User userData = userObj.get();
			if (user.getFirstName() != null) {
				userData.setFirstName(user.getFirstName());
			}
			if (user.getLastName() != null) {
				userData.setLastName(user.getLastName());
			}
			if (user.getUserName() != null) {
				userData.setUserName(user.getUserName());
			}
			if (user.getEmailId() != null) {
				userData.setEmailId(user.getEmailId());
			}
			if (user.getPassword() != null) {
				userData.setPassword(user.getPassword());
			}
			return userRepository.save(userData);
		}
		else {
			user.setUserId(id);
			return userRepository.save(user);
		}
	}
	
	@Override
	public User getUser(Integer id) {
		Optional<User> userObj = userRepository.findById(id);
		return userObj.get();
	}

	@Override
	public Map<String, String> deleteUser(Integer id) {
		Optional<User> user = userRepository.findById(id);
		Map<String, String> response = new HashMap<>();
		if (user.isPresent()) {
			userRepository.deleteById(id);
			response.put("message", "Deleted Successfully");
		}
		else {
			response.put("message", "Employee id '" + id + "' does not exist");
		}
		return response;
	}

	@Override
	public boolean isUserAlreadyPresent(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
