package com.example.batch.demo;


import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

public class Writer implements ItemWriter<String> {

	
	@Override
	public void write(Chunk<? extends String> chunk) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Inside Write");
		System.out.println("Writing Data:"+chunk);
		
	}



}
