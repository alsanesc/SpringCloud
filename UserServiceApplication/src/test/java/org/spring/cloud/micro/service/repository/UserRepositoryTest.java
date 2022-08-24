package org.spring.cloud.micro.service.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.spring.cloud.micro.service.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void whenFindByName_thenReturnUserList() {
		List<User> userList = userRepository.findByName("Juan");
		Assertions.assertThat(userList.size()).isEqualTo(0);
	}
	
	@Test
	public void whenFindByEmail_thenReturnUserList() {
		List<User> userList = userRepository.findByEmail("pedro@pedro.es");
		Assertions.assertThat(userList.size()).isEqualTo(0);
	}

}
