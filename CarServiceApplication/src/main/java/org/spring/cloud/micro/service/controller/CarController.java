package org.spring.cloud.micro.service.controller;

import java.util.List;

import org.spring.cloud.micro.service.entity.Car;
import org.spring.cloud.micro.service.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/car")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@GetMapping
	public ResponseEntity<List<Car>> getAllCars() {
		List<Car> carList = carService.getAll();
		if (carList.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(carList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Car> getCarById(@PathVariable("id") Long id) {
		Car car = carService.getCarById(id);
		if (car == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(car);
	}
	
	@PostMapping
	public ResponseEntity<Car> createCar(@RequestBody Car car) {
		Car newCar = carService.createCar(car);
		
		return ResponseEntity.ok(newCar);
	}
	
	@GetMapping(value = "/user/{userId}")
	public ResponseEntity<List<Car>> getCarsByUserId(@PathVariable("userId") Long id) {
		List<Car> carList = carService.byUserId(id);
		if (carList.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(carList);
	}

}
