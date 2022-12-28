package com.jpa.demo;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.demo.Model.Student;
import com.jpa.demo.Service.StudentService;

@SpringBootTest
class SpringbootDataJpaApplicationTests {

	@Autowired
	private StudentService service;
	
	@Test
	void saveStudent() {
		
		Student student = new Student();
		student.setId(1l);
		student.setName("namrata");
		student.setTestscore(90);
		
		System.out.print(service.saveStudent(student));
		
		
		//assertNotNull(student);
		
	}
	
	@Test
	void updateStudent() {
		Student student = new Student();
		student.setId(1l);
		student.setName("namrata");
		student.setTestscore(90);
		
		System.out.print(service.saveStudent(student));
		Student savedStudent=service.saveStudent(student);
		
	Student studdata=	service.get(1l).get();
	    
		System.out.print(studdata.getId());
		
		Student updateStudent = studdata;
		updateStudent.setName("Asrani");
		
		Student save=service.updateStudent(updateStudent);
		System.out.print(save);

		
	}
	
	
	@Test
	void deleteStudent() {
		Student student = new Student();
		student.setId(1l);
		student.setName("namrata");
		student.setTestscore(90);
		
		
		System.out.print(service.deleteStudent(student));
	
		
		
	
	
		
		
		
	}
	
	
}
