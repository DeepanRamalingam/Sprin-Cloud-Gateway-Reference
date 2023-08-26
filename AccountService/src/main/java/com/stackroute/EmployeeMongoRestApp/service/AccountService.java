package com.stackroute.EmployeeMongoRestApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.stackroute.EmployeeMongoRestApp.DTO.EmployeeAccountDTO;
import com.stackroute.EmployeeMongoRestApp.exceptions.AccountAlreadyExistException;
import com.stackroute.EmployeeMongoRestApp.exceptions.EmployeeNotFoundException;
import com.stackroute.EmployeeMongoRestApp.model.Account;
import com.stackroute.EmployeeMongoRestApp.model.Employee;

@Service
public class AccountService {

//	@Autowired
//	private EmployeeRepository employeeRepository;

//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private EmployeeServiceClient employeeClient;
	
	public EmployeeAccountDTO addNewEmployeeAccount(EmployeeAccountDTO empAccDTO) throws EmployeeNotFoundException, AccountAlreadyExistException {

	
		
		List<Employee> employeesWithAccount = employeeClient.getEmployeesByAccounts(empAccDTO.getAccountNumber());
		if(employeesWithAccount.isEmpty()) 
		{
				try {
					
					Employee employee = employeeClient.getEmployeeById(empAccDTO.getEmpId());

					Account account = new Account(empAccDTO.getAccountNumber(), empAccDTO.getBankName(), empAccDTO.getAccountBalance());
//					Employee employee = optional.get();
					List<Account> accounts = employee.getAccounts();
					accounts.add(account);
					employee.setAccounts(accounts);
					employeeClient.updateEmployee(empAccDTO.getEmpId(), employee);
					return empAccDTO;
				} catch(Exception e) {
					throw new EmployeeNotFoundException();
				} 
		}

		throw new  AccountAlreadyExistException();		


	}

//	public EmployeeAccountDTO updateEmployeeAccount(EmployeeAccountDTO empAccDTO) throws EmployeeAccountNotPresentException, EmployeeNotFoundException {
//		// TODO Auto-generated method stub
//		Optional<Employee> optional = employeeRepository.findById(empAccDTO.getEmpId());
//		if(optional.isPresent()) {
//			Employee employee = optional.get();
//			List<Account> accounts = employee.getAccounts();
//			Account account = new Account(
//					empAccDTO.getAccountNumber(), 
//					empAccDTO.getBankName(), 
//					empAccDTO.getAccountBalance());
//			for(int i = 0; i<accounts.size();i++) {
//
//				if(accounts.get(i).getAccno() == account.getAccno()) {
//					accounts.set(i, account);
//					employee.setAccounts(accounts);
//					employeeRepository.save(employee);
//					return empAccDTO;
//				}
//			}
//			throw new EmployeeAccountNotPresentException();
//		}
//		throw new EmployeeNotFoundException();
//	}
}

//update account logic ---  put request
//for(int i = 0; i<accounts.size();i++) {
//	
//	if(accounts.get(i).getAccno() == account.getAccno()) {
//		accounts.set(i, account);
//		employee.setAccounts(accounts);
//		employeeRepository.save(employee);
//		return empAccDTO;
//	}
//}


//Rest Template
//FeignClient

//exchange, ===  url, request method, type of response object, headers
//getForEntity -----> returns ResponseEntity , url, object type,headers
//ForObject ----> Return Type would be the object that we are mapping

//


// adding new Account to an Existing employee using RestTemplate

//public EmployeeAccountDTO addNewEmployeeAccount(EmployeeAccountDTO empAccDTO) throws EmployeeNotFoundException, AccountAlreadyExistException {
//
//	String getUrlForEmployeeList = "http://localhost:9002/employees/byAccountNumber?accno="+empAccDTO.getAccountNumber();
//	String getUrlForEmployee = "http://localhost:9002/employees/"+empAccDTO.getEmpId();
//	String putUrlToUpdateEmployee = "http://localhost:9002/employees/"+empAccDTO.getEmpId();
//
////	List<Employee> employeesWithAccount = employeeRepository.findByAccounts_accno(empAccDTO.getAccountNumber());
//	ResponseEntity<?> responseEmployeeList = restTemplate.getForEntity(getUrlForEmployeeList, List.class );
//	List<Employee> employeesWithAccount = (List<Employee>) responseEmployeeList.getBody();
//	if(employeesWithAccount.isEmpty()) 
//	{
//			try {
//				ResponseEntity<Employee> employeeResponseEntity = restTemplate.getForEntity(getUrlForEmployee, Employee.class );
//				Employee employee = employeeResponseEntity.getBody();
//
//				Account account = new Account(empAccDTO.getAccountNumber(), empAccDTO.getBankName(), empAccDTO.getAccountBalance());
////				Employee employee = optional.get();
//				List<Account> accounts = employee.getAccounts();
//				accounts.add(account);
//				employee.setAccounts(accounts);
//				HttpEntity<Employee> entity = new HttpEntity<Employee>(employee);
//				restTemplate.put(putUrlToUpdateEmployee, entity);
//				return empAccDTO;
//			} catch(Exception e) {
//				throw new EmployeeNotFoundException();
//			} 
//	}
//
//	throw new  AccountAlreadyExistException();		
//
//
//}

