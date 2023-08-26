package com.stackroute.EmployeeMongoRestApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.EmployeeMongoRestApp.DTO.EmployeeAccountDTO;
import com.stackroute.EmployeeMongoRestApp.exceptions.AccountAlreadyExistException;
import com.stackroute.EmployeeMongoRestApp.exceptions.EmployeeAccountNotPresentException;
import com.stackroute.EmployeeMongoRestApp.exceptions.EmployeeNotFoundException;
import com.stackroute.EmployeeMongoRestApp.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("")
	public String accountsHomeHandler() {
		return "Home Handler of accounts controller";
	}

	@PostMapping("")
	public ResponseEntity<?> addNewEmployeeAccount(@RequestBody EmployeeAccountDTO empAccDTO){
		
		ResponseEntity<?> responseEntity;
		
		try {
			EmployeeAccountDTO addedAccount = accountService.addNewEmployeeAccount(empAccDTO);
			responseEntity = new ResponseEntity<EmployeeAccountDTO>(addedAccount,HttpStatus.CREATED);
		} catch (EmployeeNotFoundException e) {
			responseEntity = new ResponseEntity<String>("Failed to Add Account. Employee Not Present",HttpStatus.NOT_FOUND);
		}catch(AccountAlreadyExistException e) {
			responseEntity = new ResponseEntity<String>("Failed to Create Account. Account Already Exist",HttpStatus.CONFLICT);

		} catch(Exception e) {
			responseEntity = new ResponseEntity<String>("AccountService Failed. Employee Service is not available",HttpStatus.BAD_GATEWAY);
		}
		
		return responseEntity;	
	}
	
//	@PutMapping("/{accNo}")
//	public ResponseEntity<?> updateEmployeeAccount(@RequestBody EmployeeAccountDTO empAccDTO, @PathVariable("accNo") int accNo){
//		
//		ResponseEntity<?> responseEntity;
//		
//		try {
//			empAccDTO.setAccountNumber(accNo);
//			EmployeeAccountDTO updatedAccount = accountService.updateEmployeeAccount(empAccDTO);
//			responseEntity = new ResponseEntity<EmployeeAccountDTO>(updatedAccount,HttpStatus.OK);
//		} catch (EmployeeNotFoundException e) {
//			responseEntity = new ResponseEntity<String>("Failed to update the Account. Employee Not Present",HttpStatus.NOT_FOUND);
//		} catch (EmployeeAccountNotPresentException e) {
//			responseEntity = new ResponseEntity<String>("Failed to update the Account. Employee Account Not Present",HttpStatus.NOT_FOUND);
//		}
//		
//		return responseEntity;	
//	}
	
}
