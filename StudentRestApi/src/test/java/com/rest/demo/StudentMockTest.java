package com.rest.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.rest.demo.Model.StudentModel;
import com.rest.demo.Repository.StudentRepo;

@RunWith(SpringRunner.class)
@WebMvcTest
class StudentMockTest {
	
	private static final String STUDENT_API_STUDENTS = "/StudentApi/Students/";

	private static final String STUDENT_API = "/StudentApi";

	private static final int Student_score = 90;

	private static final String Student_name = "maria";

	private static final int Student_ID = 4;

	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private StudentRepo repo;

	@Test
	void testfindAll() throws Exception {
		StudentModel student = build();
		List<StudentModel> students=Arrays.asList(student);
		
		when(repo.findAll()).thenReturn(students );
		mockmvc.perform(get(STUDENT_API_STUDENTS).contextPath(STUDENT_API)).andExpect(status().isOk());
	}

	private StudentModel build() {
		StudentModel student = new StudentModel();
		student.setId(Student_ID);
		student.setName(Student_name);
		student.setTestscore(Student_score);
		return student;
	}
	
	

	
	
	
	

}
