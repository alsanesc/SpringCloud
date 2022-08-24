package org.spring.cloud.micro.service.service;

import java.util.List;

import org.spring.cloud.micro.service.entity.User;
import org.spring.cloud.micro.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	@Override
	public User createUser(User user) {
		User newUser = userRepository.save(user);
		
		return newUser;
	}
	
}