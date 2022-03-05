package com.bel.training;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@GetMapping(value="/accounts/{empId}") 
	  public List<Account>getAccountsByEmpId(@PathVariable int empId) { 
	    System.out.println("EmpId------" + empId);
	    List<Account> empAccountList = accountService.findAccountsByEmpId(empId);
	    return empAccountList; 
	  }
	
}
