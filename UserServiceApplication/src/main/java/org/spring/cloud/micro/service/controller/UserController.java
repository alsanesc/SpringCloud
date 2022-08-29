package org.spring.cloud.micro.service.controller;

import java.util.List;
import java.util.Map;

import org.spring.cloud.micro.service.entity.User;
import org.spring.cloud.micro.service.modelos.Car;
import org.spring.cloud.micro.service.modelos.Moto;
import org.spring.cloud.micro.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> userList = userService.getAll();
		if (userList.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(userList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		User user = userService.getUserById(id);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User newUser = userService.createUser(user);
		
		return ResponseEntity.ok(newUser);
	}
	
	@PostMapping(value = "/car/{userId}")
	public ResponseEntity<Car> createCar(@PathVariable("userId") Long id, @RequestBody Car car) {
		Car newCar = userService.createCar(id, car);
		return ResponseEntity.ok(newCar);
	}
	
	@PostMapping(value = "/moto/{userId}")
	public ResponseEntity<Moto> createMoto(@PathVariable("userId") Long id, @RequestBody Moto moto) {
		Moto newMoto = userService.createMoto(id, moto);
		return ResponseEntity.ok(newMoto);
	}
	
	@GetMapping(value = "/car/moto/{userId}")
	public ResponseEntity<Map<String, Object>> getUserAndVehicles(@PathVariable("userId") Long userId) {
		Map<String, Object> mapResult = userService.getUserAndVehicles(userId);
		
		return ResponseEntity.ok(mapResult);
	}
	
}
