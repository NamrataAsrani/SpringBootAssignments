package com.example.jms.demo.Listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MyListener {
	
	@JmsListener(destination = "${springjms.myQueue}")
	public void recieve(String msg) {
		System.out.println("Message recived:"+msg);
	}

}
