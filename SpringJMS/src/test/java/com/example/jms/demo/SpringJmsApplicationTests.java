package com.example.jms.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.jms.demo.Sender.MessageSender;
@RunWith(SpringRunner.class)
@SpringBootTest

class SpringJmsApplicationTests {
	
	@Autowired
	MessageSender sender;

	@Test
	void testandrecieve() {
		
		sender.send("Hello JMS ");
	}

}
