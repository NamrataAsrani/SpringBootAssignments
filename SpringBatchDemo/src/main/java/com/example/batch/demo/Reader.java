package com.example.batch.demo;

import java.util.Collection;

import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.job.flow.FlowExecution;
import org.springframework.batch.core.job.flow.FlowExecutionException;
import org.springframework.batch.core.job.flow.FlowExecutor;
import org.springframework.batch.core.job.flow.State;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class Reader implements ItemReader<String>, Flow {

	private String courses[] = {"Core Java","Springboot","Microservices"};
	private int count;
	
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		System.out.println("Inside Read ");
		if(count<courses.length) {
			return courses[count++];
		}
		
		else
		{
			count =0;
		}
		
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "step1";
	}

	@Override
	public State getState(String stateName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FlowExecution start(FlowExecutor executor) throws FlowExecutionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FlowExecution resume(String stateName, FlowExecutor executor) throws FlowExecutionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<State> getStates() {
		// TODO Auto-generated method stub
		return null;
	}

}
