package org.spring.cloud.micro.service.service;

import java.util.List;

import org.spring.cloud.micro.service.entity.User;
import org.spring.cloud.micro.service.modelos.Car;

public interface UserService {
	
	public List<User> getAll();
	public User getUserById(Long id);
	public User createUser(User user);
	
	public Car createCar(Long userId, Car car);

}
