package com.stackroute.EmployeeMongoRestApp.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class AcknowledmentListener {
	
	
	@RabbitListener(queues = {"cgi-team-2"})
	public void receiveAcknowledgement(String message) {
		
		System.out.println("Acknowledgement Received from Notification Recieved as: "+message);
	}
}
