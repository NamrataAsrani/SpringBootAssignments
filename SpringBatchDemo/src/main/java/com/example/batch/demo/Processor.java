package com.example.batch.demo;

import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<String,String> {

	@Override
	public String process(String item) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Inside Process");
		return "Processed"+item.toUpperCase();
	}

}
