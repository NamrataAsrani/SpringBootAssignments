package com.example.jms.demo.Sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
	
	@Autowired
	JmsTemplate jms;
	
	@Value("${springjms.myQueue}")
	private String myqueue;
	
	public void send(String msg) {
		System.out.println("message sent:"+msg);
		jms.convertAndSend(myqueue, msg);
	}

}
