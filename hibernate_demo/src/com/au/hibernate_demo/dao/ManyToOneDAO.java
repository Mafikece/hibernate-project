package com.au.hibernate_demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.au.hibernate_demo.entity.CityDTO;
import com.au.hibernate_demo.entity.CountryDTO;

public class ManyToOneDAO {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		CountryDTO countryDTO=new CountryDTO();
		countryDTO.setCName("India");
		
		CityDTO city1=new CityDTO();
		city1.setCnName("Delhi");
		city1.setCountryDTO(countryDTO);
		session.save(city1);
		
		
		CityDTO city2=new CityDTO();
		city2.setCnName("Kolkata");
		city2.setCountryDTO(countryDTO);
		session.save(city2);
		
		session.beginTransaction().commit();
		
	}

}

