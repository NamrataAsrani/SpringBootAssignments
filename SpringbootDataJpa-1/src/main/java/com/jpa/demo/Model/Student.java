package com.jpa.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
	Long id;
	String name;
	int testscore;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTestscore() {
		return testscore;
	}
	public void setTestscore(int testscore) {
		this.testscore = testscore;
	}
	
	

}
