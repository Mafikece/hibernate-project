package com.au.hibernate_demo.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.au.hibernate_demo.entity.StudentDTO;
import com.au.hibernate_demo.entity.TeacherDTO;

public class OneToManyDAO {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		StudentDTO st1 =new StudentDTO();
		st1.setStudentName("Bijoy");
		
		StudentDTO st2 = new StudentDTO();
		st2.setStudentName("Harsh");
		
		StudentDTO st3 = new StudentDTO();
		st3.setStudentName("Zaid");
		
		
		ArrayList<StudentDTO> ListStudentDTOs  = new ArrayList<>();
		ListStudentDTOs.add(st1);
		ListStudentDTOs.add(st2);
		ListStudentDTOs.add(st3);
		
		TeacherDTO teacherDTO = new TeacherDTO();
		teacherDTO.setTeacherName("Azam");
		teacherDTO.setListOfStudent(ListStudentDTOs);
		
		session.save(teacherDTO);
		session.beginTransaction().commit();
		
		
	}

}
