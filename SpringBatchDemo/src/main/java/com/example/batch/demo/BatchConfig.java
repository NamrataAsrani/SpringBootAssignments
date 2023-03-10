package com.example.batch.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	
	@Autowired
	private StepBuilderFactory sbf;

	
	@Autowired
	private JobBuilderFactory jb;
	
	@Bean
	public Job job() {
		return jb.get("job1")
				.incrementer(new RunIdIncrementer())
				.listener(listener())
				.start(step())
				.build();
		
	}
	
	@Bean
	public Step step() {
		return  sbf.get("step1")
				.<String,String>chunk(1)
				.reader(reader())
				.processor(processor())
				.writer(Writer())
				.build();
		
	}
	
	@Bean
	public Reader reader() {
		return new Reader();
	}
	
	@Bean
	public Processor processor() {
		return new Processor();
	}
	
	@Bean
	public Writer Writer() {
		return new Writer();
	}
	
	@Bean
	public MyJobListener listener() {
		return new MyJobListener();
	}
	
	
	
}
