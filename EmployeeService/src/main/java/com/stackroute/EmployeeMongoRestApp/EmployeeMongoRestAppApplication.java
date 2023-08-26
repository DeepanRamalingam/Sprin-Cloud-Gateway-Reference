package com.stackroute.EmployeeMongoRestApp;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeMongoRestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMongoRestAppApplication.class, args);
	}
	
//	@Bean
//	public Queue getQueue() {
//		return new Queue("user_queue");
//	}
//	
//	@Bean
//	public TopicExchange getExchange() {
//		return new TopicExchange("user_exchange");
//	}
//	
//	@Bean
//	public Binding getBinding(Queue queue, TopicExchange exchange) {
//		
//		return BindingBuilder
//				.bind(queue)
//				.to(exchange)
//				.with("user_key");
//	}

	@Bean
	public MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
		
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setMessageConverter(messageConverter());
		return template;
		
	}
	
}


//RabbitTemplate to send the messages to the message broker exchange

//listeners
