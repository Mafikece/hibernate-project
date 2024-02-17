package com.au.hibernate_demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class TeacherDTO {
	@Id
	@GenericGenerator(name="auto", strategy ="increment")
	@GeneratedValue(generator = "auto")
	
	
	private int teacherId;
	private String teacherName;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "teacherId")
	private List<StudentDTO> listOfStudent;
	
	
	
	
	
	
	
}
