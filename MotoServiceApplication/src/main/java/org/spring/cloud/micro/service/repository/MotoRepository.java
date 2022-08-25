package org.spring.cloud.micro.service.repository;

import java.util.List;

import org.spring.cloud.micro.service.entity.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {
	
	public List<Moto> findByUserId(Long userId);

}
