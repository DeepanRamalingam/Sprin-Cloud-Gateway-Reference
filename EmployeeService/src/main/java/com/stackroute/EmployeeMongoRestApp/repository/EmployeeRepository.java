package com.stackroute.EmployeeMongoRestApp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.EmployeeMongoRestApp.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer> {
	
//	find all the employee based on the acc number
	List<Employee> findByAccounts_accno(int accNumber);

}
