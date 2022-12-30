package com.rest.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.demo.Model.StudentModel;
import com.rest.demo.Repository.StudentRepo;

@RestController
public class StudentController {
	
 private static final Logger  Log =LoggerFactory.getLogger(StudentController.class);
	@Autowired
	private StudentRepo repo;
	
	
	@GetMapping("/Students/")
	public List<StudentModel> FindStudents() {
		return (List<StudentModel>) repo.findAll();
		
	}
	
	
	@GetMapping("/Students/{id}")
	public Optional<StudentModel> getstudent(@PathVariable("id")  int id) {
		Log.info("finding student by id :" + id);

		return repo.findById(id);
		
	}
	
	
	@PostMapping("/Students/")
	public String saveStudents(@RequestBody StudentModel student) {
		 repo.save(student);
		 return "student record saved";
		
	}
	
	
	@PutMapping("/Students/")
	public String updateStudents(@RequestBody StudentModel student) {
		
		
		repo.save(student);
		return "Student record updated";

		 
	}
	
	
	@DeleteMapping("/Students/{id}")
	public String deleteStudent(@PathVariable("id") int id)
	{
		repo.deleteById(id);
		return "Student record deleted"+id;
	}
	
}
