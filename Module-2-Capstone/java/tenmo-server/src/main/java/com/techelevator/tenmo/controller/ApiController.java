package com.techelevator.tenmo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.techelevator.tenmo.dao.AccountDAO;
import com.techelevator.tenmo.dao.AccountDAOJDBC;
import com.techelevator.tenmo.model.Account;

/*******************************************************************************************************
 * This is where you code any API controllers you may create
********************************************************************************************************/
@RestController 
public class ApiController {
	
private AccountDAO accountDAO;

public ApiController(AccountDAOJDBC accountDAO) {
	this.accountDAO = accountDAO;
}

@RequestMapping(path = "/accounts/{id}", method = RequestMethod.GET)
public Account getAccount(@PathVariable long id) {
    return accountDAO.getAccount(id);
    	
}
}
