package com.au.hibernate_demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.cfgxml.spi.CfgXmlAccessService;
import org.hibernate.cfg.Configuration;

import com.au.hibernate_demo.entity.CarDTO;
import com.au.hibernate_demo.entity.EngineDTO;

public class OneToneDAO {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		EngineDTO engineDTO = new EngineDTO();
		engineDTO.setEnName("Power Engine");
		
		CarDTO carDTO = new CarDTO();
		carDTO.setCName("BMW");
		carDTO.setEnDTO(engineDTO);
		
		session.save(carDTO);
		session.beginTransaction().commit();
	}

}
