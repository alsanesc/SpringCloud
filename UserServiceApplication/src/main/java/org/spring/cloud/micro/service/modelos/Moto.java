package org.spring.cloud.micro.service.modelos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Moto {
	
	private String marca;
	private String modelo;
	
	private Long userId;

}
