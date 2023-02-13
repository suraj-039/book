package com.example.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class author {
	@Id
	@GeneratedValue
	
	private Integer id;
	private String name;
	private long phone;
	
}
