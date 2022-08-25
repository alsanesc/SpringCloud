package org.spring.cloud.micro.service.service;

import java.util.List;

import org.spring.cloud.micro.service.entity.Car;
import org.spring.cloud.micro.service.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository carRepository;

	@Override
	public List<Car> getAll() {
		return carRepository.findAll();
	}

	@Override
	public Car getCarById(Long id) {
		return carRepository.findById(id).orElse(null);
	}

	@Override
	public Car createCar(Car user) {
		Car newCar = carRepository.save(user);
		
		return newCar;
	}

	@Override
	public List<Car> byUserId(Long id) {
		return carRepository.findByUserId(id);
	}
	
	
	
}
