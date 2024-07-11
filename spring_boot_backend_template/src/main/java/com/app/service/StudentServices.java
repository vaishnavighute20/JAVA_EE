package com.app.service;

import java.util.List;

import com.app.entities.Student;

public interface StudentServices {

	List<Student> getAllDetail();
	
	Student addStudentDetails(Student student);

	Student getById(Long id);

	Student updateStudentDetails(Student student);

	String DeleteStudentDetail(Long id);
	
}
