package org.spring.cloud.micro.service.repository;

import java.util.List;

import org.spring.cloud.micro.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public List<User> findByName(String name);
	public List<User> findByEmail(String email);
	
}
