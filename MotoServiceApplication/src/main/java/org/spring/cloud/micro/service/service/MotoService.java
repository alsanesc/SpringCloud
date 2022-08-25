package org.spring.cloud.micro.service.service;

import java.util.List;

import org.spring.cloud.micro.service.entity.Moto;

public interface MotoService {
	
	public List<Moto> getAll();
	public Moto getMotoById(Long id);
	public Moto createMoto(Moto user);
	public List<Moto> byUserId(Long id);

}
