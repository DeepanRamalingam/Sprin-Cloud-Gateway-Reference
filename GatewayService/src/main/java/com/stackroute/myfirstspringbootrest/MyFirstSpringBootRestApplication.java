package com.stackroute.myfirstspringbootrest;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import com.stackroute.myfirstspringbootrest.filters.EmployeeAppGlobalFilter;


@SpringBootApplication
@EnableAspectJAutoProxy
@EnableDiscoveryClient
public class MyFirstSpringBootRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstSpringBootRestApplication.class, args);
	}
	
	
//	@Bean
//	public FilterRegistrationBean<JWTFilter> getJWTFilterRegistrationBean(){
//		
//		FilterRegistrationBean<JWTFilter> filterRegistrationBean = new FilterRegistrationBean<>();
//		filterRegistrationBean.setFilter(new JWTFilter());
//		filterRegistrationBean.setOrder(2);
//		filterRegistrationBean.addUrlPatterns("/test/*");
//		return filterRegistrationBean;
//	}
//	
//	@Bean
//	public FilterRegistrationBean<HandlerFilter> getHandlerFilterRegistrationBean(){
//		
//		FilterRegistrationBean<HandlerFilter> filterRegistrationBean = new FilterRegistrationBean<>();
//		filterRegistrationBean.setFilter(new HandlerFilter());
//		filterRegistrationBean.setOrder(1);
//		filterRegistrationBean.addUrlPatterns("/test/*");
//		return filterRegistrationBean;
//	}
	/*
	 * @Bean public RouteLocator getRouteLocator(RouteLocatorBuilder builder) {
	 * 
	 * return builder.routes() .route((r)->{return
	 * r.path("/employees/**").uri("lb://employee-service");}) .route((r)->{return
	 * r.path("/accounts/**").uri("lb://account-service");}) .build(); }
	 */
	
	
	@Bean
	public GlobalFilter getGlobalFilter() {
		return new EmployeeAppGlobalFilter();
	}
	
	@Bean
	public RouteLocator getRouteLocator(RouteLocatorBuilder builder) {
		
		return builder.routes()
				.route((r)->{return r.path("/employees/**").uri("lb://employee-service");})
				.route((r)->{return r.path("/accounts/**").uri("lb://account-service");})
				.build();
	}
	
	
//	this will be triggered before all the filters for the options request from the client
	@Bean
	public CorsWebFilter corsWebFilter() {
	   
	   System.out.println("cors invoked");
	
	    CorsConfiguration corsConfig = new CorsConfiguration();
	    corsConfig.setAllowedOrigins(Arrays.asList("*"));
	    corsConfig.setMaxAge(3600L);
	    corsConfig.setAllowedMethods(Arrays.asList("GET", "POST","PUT","DELETE"));
	    corsConfig.addAllowedHeader("*");
	
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", corsConfig);
	
	    return new CorsWebFilter(source);
	}

} 

//load test
//stress test
//break point --- 100,000

//jmeter


//http://localhost:9000/employees

//http://localhost:9000/accounts



//swagger
//RabbitMQ












