package com.au.hibernate_demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class CarDTO {
	@Id
	@GenericGenerator(name="auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int cId;
	private String cName;
	
	@OneToOne(cascade = CascadeType.ALL)
	private EngineDTO enDTO;
	
	
	
}
