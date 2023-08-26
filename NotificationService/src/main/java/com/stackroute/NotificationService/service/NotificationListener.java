package com.stackroute.NotificationService.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.NotificationService.model.EmployeeDTO;

@Service
public class NotificationListener {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@RabbitListener(queues = {"cgi-team-1"})
	public void getFromEmployeeService(EmployeeDTO employee) {
		
		System.out.println("Message received Employee Service");
		System.out.println(employee);
		
		rabbitTemplate.convertAndSend("amq.direct","stack", "Employee with ID "+employee.getEmployeeId()+" received");
	}

}
