package com.rest.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.rest.demo.Model.StudentModel;
import com.rest.demo.Repository.StudentRepo;

@SpringBootTest
class StudentRestApiApplicationTests {

	@Value("${StudentRestApi.services.url}")
	private String baseUrl;
	
	
	@Test
	public void testgetStudent() {
		RestTemplate Studenttemplate = new RestTemplate();

		StudentModel studenttest=Studenttemplate.getForObject(baseUrl+"1", StudentModel.class);
		assertNotNull(studenttest);
		assertEquals("Namrata", studenttest.getName());
	   
	}
	
	
	@Test
	public void testcreateStudent() {
		RestTemplate Studenttemplate = new RestTemplate();

		StudentModel studentmodel = new StudentModel();
		studentmodel.setName("rihana");
		studentmodel.setTestscore(80);
		String studenttest = Studenttemplate.postForObject(baseUrl,studentmodel , String.class);
	  
		
		assertNotNull(studenttest);
		assertEquals(80, studentmodel.getTestscore());
	 //   assertNotNull(studenttest.);
	   // assertEquals(80, studenttest.getTestscore());
	}
	
	
	@Test
	public void testupdateStudent() {
		RestTemplate Studenttemplate = new RestTemplate();
		StudentModel studenttest=Studenttemplate.getForObject(baseUrl+"14", StudentModel.class);
       
		studenttest.setTestscore(87);
		
		Studenttemplate.put("http://localhost:8086/StudentApi/Students/", studenttest);


	}
	
	
	@Test
	public void testdeleteStudent() {
		RestTemplate Studenttemplate = new RestTemplate();
		StudentModel studenttest=Studenttemplate.getForObject(baseUrl+"14", StudentModel.class);
		
		Studenttemplate.delete(baseUrl+"14", studenttest);
       
	}
	
	

}
