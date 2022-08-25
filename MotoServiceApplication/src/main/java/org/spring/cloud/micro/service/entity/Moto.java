package org.spring.cloud.micro.service.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "moto")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Moto implements Serializable {

	private static final long serialVersionUID = 5494192604132267425L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String marca;
	private String modelo;
	private Long userId;
	
}
