package org.spring.cloud.micro.service.service;

import java.util.List;

import org.spring.cloud.micro.service.entity.Car;

public interface CarService {
	
	public List<Car> getAll();
	public Car getCarById(Long id);
	public Car createCar(Car car);
	public List<Car> byUserId(Long id);

}
