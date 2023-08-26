package com.stackroute.EmployeeMongoRestApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.EmployeeMongoRestApp.DTO.EmployeeDTO;
import com.stackroute.EmployeeMongoRestApp.exceptions.EmployeeAlreadyExistException;
import com.stackroute.EmployeeMongoRestApp.exceptions.EmployeeNotFoundException;
import com.stackroute.EmployeeMongoRestApp.model.Account;
import com.stackroute.EmployeeMongoRestApp.model.Employee;
import com.stackroute.EmployeeMongoRestApp.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee findEmployeeById(int id) throws EmployeeNotFoundException {
		
		Optional<Employee> optional = employeeRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		throw new EmployeeNotFoundException();
	}

	public EmployeeDTO addNewEmployee(EmployeeDTO employeeDTO) throws EmployeeAlreadyExistException {
		// TODO Auto-generated method stub
		Optional<Employee> optional = employeeRepository.findById(employeeDTO.getEmployeeId());
		
		if(!optional.isPresent()) {
			Employee employee = new Employee(
					employeeDTO.getEmployeeId(),
					employeeDTO.getEmployeeName(),
					employeeDTO.getEmployeeSalary(),
					employeeDTO.getEmployeeRole());
			List<Account> accounts = new ArrayList<>();
			employee.setAccounts(accounts);
			employeeRepository.save(employee);
			return employeeDTO;
		}
		
		throw new EmployeeAlreadyExistException();
	}

	public List<EmployeeDTO> getEmployeesByAccount(int accNo) {
		// TODO Auto-generated method stub
		List<Employee> employees = employeeRepository.findByAccounts_accno(accNo);
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
		
		for(Employee employee: employees) {
			employeeDTOs.add(new EmployeeDTO(employee.getId(), employee.getFname(), 
					employee.getSalary(), employee.getRole()));
			
		}
		
		return employeeDTOs;
	}
	
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException {
		
		Optional<Employee> optional = employeeRepository.findById(employee.getId());
		if(optional.isPresent()) {
			
		return employeeRepository.save(employee);
	
		}
		throw new EmployeeNotFoundException();
	}
}
