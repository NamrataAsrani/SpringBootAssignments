package com.jpa.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.demo.Model.Student;
import com.jpa.demo.repository.StudentRepository;

@Service
public class StudentService {

	
	@Autowired
	 StudentRepository repo;
	
	public Student saveStudent(Student stud) {
		return repo.save(stud);
	}
	
	
	public Student updateStudent(Student stud) {
		return repo.save(stud);
		
	}
	
	
	public String deleteStudent(Student stud) {
        repo.delete(stud);
        return "Studentid"+"deleted";
	}
	
	public Optional<Student> get(Long id) {
		return repo.findById(id);
	}
}
