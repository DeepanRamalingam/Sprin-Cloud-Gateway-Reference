package com.stackroute.EmployeeAppServiceRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EmployeeAppServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAppServiceRegistryApplication.class, args);
	}

}
