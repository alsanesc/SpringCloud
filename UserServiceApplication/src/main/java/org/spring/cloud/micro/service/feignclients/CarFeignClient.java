package org.spring.cloud.micro.service.feignclients;

import java.util.List;

import org.spring.cloud.micro.service.modelos.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "car-service", url = "http://localhost:8082", path = "/api/car")
public interface CarFeignClient {
	
	@PostMapping
	public Car createCar(@RequestBody Car car);
	
	@GetMapping(value = "/user/{userId}")
	public List<Car> getCars(@PathVariable("userId") Long userId);

}
