package com.techelevator.tenmo.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.techelevator.tenmo.dao.AccountDAO;
import com.techelevator.tenmo.dao.AccountDAOJDBC;
import com.techelevator.tenmo.dao.UserDAO;
import com.techelevator.tenmo.model.Account;

/*******************************************************************************************************
 * This is where you code any API controllers you may create
********************************************************************************************************/
@RestController 
public class ApiController {
	
private AccountDAO accountDAO;
private UserDAO userDAO;

public ApiController(AccountDAOJDBC accountDAO, UserDAO userDAO) {
	this.accountDAO = accountDAO;
	this.userDAO = userDAO;
	
}

@RequestMapping(path = "/account/balance", method = RequestMethod.GET)
public double getAccountBalance(Principal userInfo) {
	long userId = userDAO.findIdByUsername(userInfo.getName());
    return accountDAO.getAccountBalance(userId);
    	
}
}
