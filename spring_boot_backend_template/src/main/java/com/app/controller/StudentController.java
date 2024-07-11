package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Student;
import com.app.service.StudentServices;

@RestController
@RequestMapping("/student")
public class StudentController {
	

	@Autowired
	private StudentServices studentServices;
	
	@GetMapping
	public List<Student> getallStudent(){
		return studentServices.getAllDetail();
	
	}
	
	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return studentServices.addStudentDetails(student);
	}
		
	@GetMapping("/{id}")
	public Student getByStudentId(@PathVariable Long id) {
		return studentServices.getById(id);
		
	}
	
	@PutMapping
	public Student updateStudent(@RequestBody Student student ) {
		return studentServices.updateStudentDetails(student);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable Long id){
		String student=studentServices.DeleteStudentDetail(id);
		if(student==null) {
			return new ResponseEntity<>("Id not Found",HttpStatus.BAD_REQUEST);
			
		}
		
		return ResponseEntity.ok(student);
	}


	
}
