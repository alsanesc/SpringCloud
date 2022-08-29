package org.spring.cloud.micro.service.controller;

import java.util.List;

import org.spring.cloud.micro.service.entity.Moto;
import org.spring.cloud.micro.service.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/moto")
public class MotoController {
	
	@Autowired
	private MotoService motoService;
	
	@GetMapping
	public ResponseEntity<List<Moto>> getAllMotos() {
		List<Moto> motoList = motoService.getAll();
		if (motoList.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(motoList);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Moto> getMotoById(@PathVariable("id") Long id) {
		Moto car = motoService.getMotoById(id);
		if (car == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(car);
	}
	
	@PostMapping
	public ResponseEntity<Moto> createMoto(@RequestBody Moto moto) {
		Moto newMoto = motoService.createMoto(moto);
		
		return ResponseEntity.ok(newMoto);
	}
	
	@GetMapping(value = "/user/{userId}")
	public ResponseEntity<List<Moto>> getMotosByUserId(@PathVariable("userId") Long id) {
		List<Moto> motoList = motoService.byUserId(id);
		if (motoList.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(motoList);
	}

}
