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
@Table(name = "car")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Car implements Serializable {

	private static final long serialVersionUID = 1190384702108632177L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String marca;
	private String modelo;
	private Long userId;

}
