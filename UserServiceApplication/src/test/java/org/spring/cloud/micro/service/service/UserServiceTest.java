package org.spring.cloud.micro.service.service;

import org.mockito.Mock;
import org.spring.cloud.micro.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
	
	@Mock
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;

	
}
