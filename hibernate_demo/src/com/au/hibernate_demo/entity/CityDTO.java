package com.au.hibernate_demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class CityDTO {
	@Id
	@GenericGenerator(name="auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int cnid;
	private String cnName;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "cid")
	private CountryDTO countryDTO;
	
	
}
