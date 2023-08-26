package com.stackroute.EmployeeMongoRestApp.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.stackroute.EmployeeMongoRestApp.model.Employee;

@FeignClient("employee-service")
@Service
public interface EmployeeServiceClient {
	
	@GetMapping("/employees/byAccountNumber")
	public List<Employee> getEmployeesByAccounts(@RequestParam("accno") int accNo);
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable("id") int id);
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee);

}
