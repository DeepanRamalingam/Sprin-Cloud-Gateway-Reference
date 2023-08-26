package com.stackroute.NotificationService;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}
	
	@Bean
	public MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
//	
//	@Bean
//	public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
//		
//		RabbitTemplate template = new RabbitTemplate(connectionFactory);
//		template.setMessageConverter(messageConverter());
//		return template;
//		
//	}

}
