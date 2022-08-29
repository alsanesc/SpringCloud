package org.spring.cloud.micro.service.feignclients;

import org.spring.cloud.micro.service.modelos.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "car-service", url = "http://localhost:8082", path = "/api/car")
public interface CarFeignClient {
	
	@PostMapping
	public Car createCar(@RequestBody Car car);

}
