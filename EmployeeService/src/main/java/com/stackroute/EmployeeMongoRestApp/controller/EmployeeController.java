package com.stackroute.EmployeeMongoRestApp.controller;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.EmployeeMongoRestApp.DTO.EmployeeDTO;
import com.stackroute.EmployeeMongoRestApp.exceptions.EmployeeAlreadyExistException;
import com.stackroute.EmployeeMongoRestApp.exceptions.EmployeeNotFoundException;
import com.stackroute.EmployeeMongoRestApp.model.Employee;
import com.stackroute.EmployeeMongoRestApp.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Value("${server.port}")
	private String port;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@GetMapping("")
	public String employeeHomeHandler() {
		return "Employee Home Handler";
	}
	
	@PostMapping("")
	public ResponseEntity<?> addNewEmployeeHandler(@RequestBody EmployeeDTO employeeDTO){
		
		ResponseEntity<?> responseEntity;
		
		try {
			EmployeeDTO addedEmployee = employeeService.addNewEmployee(employeeDTO);
			responseEntity = new ResponseEntity<EmployeeDTO>(addedEmployee,HttpStatus.CREATED);
			rabbitTemplate.convertAndSend("amq.direct", "cgi", addedEmployee);
		} catch (EmployeeAlreadyExistException e) {
			responseEntity = new ResponseEntity<String>("Failed to create new Employee. Employee Already Exist: ",HttpStatus.CONFLICT);
		}
		
		return responseEntity;
	}
	
	@GetMapping("/byAccountNumber")
	public ResponseEntity<?> getEmployeesByAccountHandler(@RequestParam("accno") int accNo){
		System.out.println("Employee Service running in port: "+port);
		List<EmployeeDTO> employeesDTO = employeeService.getEmployeesByAccount(accNo);
		return new ResponseEntity<List<EmployeeDTO>>(employeesDTO,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeByIDHandler(@PathVariable("id") int id ){
		
		ResponseEntity<?> responseEntity;
		
		try {
			Employee employee = employeeService.findEmployeeById(id);
			responseEntity = new ResponseEntity<Employee>(employee,HttpStatus.OK);
			
		} catch (EmployeeNotFoundException e) {
			responseEntity = new ResponseEntity<String>("Employee Not Found",HttpStatus.NOT_FOUND);
		}
		
		return responseEntity;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateEmployeeHandler(@PathVariable("id") int id, @RequestBody Employee employee){
		
		ResponseEntity<?> responseEntity;
		employee.setId(id);
		try {
			Employee updatedEmployee = employeeService.updateEmployee(employee);
			responseEntity = new ResponseEntity<Employee>(updatedEmployee,HttpStatus.OK);
		} catch (EmployeeNotFoundException e) {
			responseEntity = new ResponseEntity<String>("Failed to update. Employee Not Present",HttpStatus.NOT_FOUND);
		}
		
		return responseEntity;
	}
}
