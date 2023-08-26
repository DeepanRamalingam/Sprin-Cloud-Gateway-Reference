package com.stackroute.EmployeeMongoRestApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class EmployeeMongoRestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMongoRestAppApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}




//@Bean
//public CorsWebFilter corsWebFilter() {
//   
//   System.out.println("cors invoked");
//
//    CorsConfiguration corsConfig = new CorsConfiguration();
//    corsConfig.setAllowedOrigins(Collections.singletonList("*"));
//    corsConfig.setMaxAge(3600L);
//    corsConfig.setAllowedMethods(Arrays.asList("GET", "POST"));
//    corsConfig.addAllowedHeader("*");
//
//    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//    source.registerCorsConfiguration("/**", corsConfig);
//
//    return new CorsWebFilter(source);
//}



