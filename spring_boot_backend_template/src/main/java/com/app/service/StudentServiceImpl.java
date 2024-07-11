package com.app.service;

import java.security.InvalidAlgorithmParameterException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Student;
import com.app.exception.InvalidException;
import com.app.repository.StudentRepository;
 
@Service
@Transactional
public class StudentServiceImpl implements StudentServices {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllDetail() {
		// TODO Auto-generated method stub
		return  studentRepository.findAll();
	}

	@Override
	public Student addStudentDetails(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public Student getById(Long id) {
		Optional<Student> optional=studentRepository.findById(id);
		// TODO Auto-generated method stub
		return optional.orElseThrow(()-> new InvalidException("invalid id"));
	}

	@Override
	public Student updateStudentDetails(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public String DeleteStudentDetail(Long id) {
		// TODO Auto-generated method stub
		if(studentRepository.existsById(id)) {
			studentRepository.deleteById(id);
			return "stduent Deleted";
		}
		return "invalid id";
	}
 
	

}
