package org.spring.cloud.micro.service.feignclients;

import java.util.List;

import org.spring.cloud.micro.service.modelos.Moto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "moto-service", url = "http://localhost:8083", path = "/api/moto")
public interface MotoFeignClient {
	
	@PostMapping
	public Moto createMoto(@RequestBody Moto moto);

	@GetMapping(value = "/user/{userId}")
	public List<Moto> getMotos(@PathVariable("userId") Long userId);

}
