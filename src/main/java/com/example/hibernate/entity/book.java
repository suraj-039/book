package com.example.hibernate.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.Data;

@Entity
@Data
public class book {
	@Id
	@GeneratedValue
	private Integer id;
	private String name; 
	private Double price;
	private long code;
	private Date publishdate;
	@ManyToOne()
	@JoinColumn(name="aid")
	private author Author;
	
	public book()
	{
		
	}
	public book(Integer id, String name, Double price, long code, Date publishdate) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.code = code;
		this.publishdate = publishdate;
	}

	

}
