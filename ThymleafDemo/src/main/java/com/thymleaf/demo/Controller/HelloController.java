package com.thymleaf.demo.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thymleaf.demo.Model.Student;

@Controller
public class HelloController {

	@RequestMapping("/Hello")
	public String Hello() {
		return "Hello";
	}
	
	@RequestMapping("/senddata")
	public ModelAndView sendData() {
	 
		ModelAndView modelAndView = new ModelAndView("data");
		modelAndView.addObject("message","Follow your dreams");
		return modelAndView;
		
	}
	
	@RequestMapping("/student")
	public ModelAndView Student() {
		ModelAndView modelAndView = new ModelAndView("Student");
		
		Student attributeValue = new Student();
		attributeValue.setName("Myst");
		attributeValue.setScore(90);
		modelAndView.addObject("Student",attributeValue);
		
		return modelAndView;
	}
	
	
	@RequestMapping("/students")
	public ModelAndView Students() {
		ModelAndView modelAndView = new ModelAndView("Students");
		
		Student attributeValue = new Student();
		attributeValue.setName("Myst");
		attributeValue.setScore(90);
		
		Student attributeValue1 = new Student();
		attributeValue1.setName("Cyst");
		attributeValue1.setScore(80);
		
		List<com.thymleaf.demo.Model.Student> students = Arrays.asList(attributeValue,attributeValue1);
		modelAndView.addObject("Students",students);
		
		return modelAndView;
	}
	

	@RequestMapping("/studentform")
	public ModelAndView Studentform() {
		ModelAndView modelAndView = new ModelAndView("Studentform");
		
		Student attributeValue = new Student();
		attributeValue.setName("Myst");
		attributeValue.setScore(90);
		
		modelAndView.addObject("Student",attributeValue);
		
		return modelAndView;
	}
	
	
	@RequestMapping("/saveStudents")
	public ModelAndView saveStudents() {
		ModelAndView modelAndView = new ModelAndView("result");
		
		Student attributeValue = new Student();
		System.out.println(attributeValue.getName());
		System.out.println(attributeValue.getScore());
		
		
		return modelAndView;
	}
	
	
}


