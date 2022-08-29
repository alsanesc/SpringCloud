package org.spring.cloud.micro.service.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.spring.cloud.micro.service.entity.User;
import org.spring.cloud.micro.service.feignclients.CarFeignClient;
import org.spring.cloud.micro.service.feignclients.MotoFeignClient;
import org.spring.cloud.micro.service.modelos.Car;
import org.spring.cloud.micro.service.modelos.Moto;
import org.spring.cloud.micro.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CarFeignClient carFeignClient;
	
	@Autowired
	private MotoFeignClient motoFeignClient;
	
	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	@Override
	public User createUser(User user) {
		User newUser = userRepository.save(user);
		
		return newUser;
	}
	
	public Car createCar(Long userId, Car car) {
		car.setUserId(userId);
		Car newCar = carFeignClient.createCar(car);
		return newCar;
	}

	@Override
	public Moto createMoto(Long userId, Moto moto) {
		moto.setUserId(userId);
		Moto newMoto = motoFeignClient.createMoto(moto);
		return newMoto;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Car> getCars(Long userId) {
		List<Car> carList = restTemplate.getForObject("http://localhost:8082/api/car/" + userId, List.class);
		
		return carList;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Moto> getMotos(Long userId) {
		List<Moto> motoList = restTemplate.getForObject("http://localhost:8083/api/moto/" + userId, List.class);
		return motoList;
	}

	@Override
	public Map<String, Object> getUserAndVehicles(Long userId) {
		Map<String, Object> result = new HashMap<>();
		User user = userRepository.findById(userId).orElse(null);
		
		if (user == null) {
			result.put("Mensaje", "El usuario no existe");
			return result;
		}
		
		result.put("User", user);
		List<Car> carList = carFeignClient.getCars(userId);
		
		if (carList.isEmpty()) {
			result.put("Coches", "El usuario no tiene coches");
		} else {
			result.put("Coches", carList);
		}
		
		List<Moto> motoList = motoFeignClient.getMotos(userId);
		
		if (motoList.isEmpty()) {
			result.put("Motos", "El usuario no tiene motos");
		} else {
			result.put("Motos", carList);
		}
		
		return result;
	}

}
