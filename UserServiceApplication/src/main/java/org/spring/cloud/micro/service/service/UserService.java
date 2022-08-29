package org.spring.cloud.micro.service.service;

import java.util.List;

import org.spring.cloud.micro.service.entity.User;
import org.spring.cloud.micro.service.modelos.Car;
import org.spring.cloud.micro.service.modelos.Moto;

public interface UserService {
	
	public List<User> getAll();
	public User getUserById(Long id);
	public User createUser(User user);
	
	public Car createCar(Long userId, Car car);
	public Moto createMoto(Long userId, Moto moto);

}
