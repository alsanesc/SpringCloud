package org.spring.cloud.micro.service.service;

import java.util.List;

import org.spring.cloud.micro.service.entity.Moto;
import org.spring.cloud.micro.service.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotoServiceImpl implements MotoService {

	@Autowired
	private MotoRepository motoRepository;

	@Override
	public List<Moto> getAll() {
		return motoRepository.findAll();
	}

	@Override
	public Moto getMotoById(Long id) {
		return motoRepository.findById(id).orElse(null);
	}

	@Override
	public Moto createMoto(Moto moto) {
		Moto newMoto = motoRepository.save(moto);
		return newMoto;
	}

	@Override
	public List<Moto> byUserId(Long id) {
		return motoRepository.findByUserId(id);
	}
	
	
	
}
