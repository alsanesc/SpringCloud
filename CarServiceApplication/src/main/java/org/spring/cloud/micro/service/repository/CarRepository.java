package org.spring.cloud.micro.service.repository;

import java.util.List;

import org.spring.cloud.micro.service.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
	
	public List<Car> findByUserId(Long userId);

}
