package com.techelevator.tenmo.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.techelevator.tenmo.dao.AccountDAO;
import com.techelevator.tenmo.dao.AccountDAOJDBC;
import com.techelevator.tenmo.dao.AccountUserDAO;
import com.techelevator.tenmo.dao.TransferDAO;
import com.techelevator.tenmo.dao.UserDAO;
import com.techelevator.tenmo.model.AccountUser;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;

/*******************************************************************************************************
 * This is where you code any API controllers you may create
********************************************************************************************************/
@RestController 
public class ApiController {
	
private AccountDAO accountDAO;
private UserDAO userDAO;
private AccountUserDAO accountUserDAO;
private TransferDAO transferDAO;


public ApiController(AccountDAOJDBC accountDAO, UserDAO userDAO, AccountUserDAO accountUserDAO, TransferDAO transferDAO) {
	this.accountDAO = accountDAO;
	this.userDAO = userDAO;
	this.accountUserDAO = accountUserDAO;
	this.transferDAO = transferDAO;

}

@RequestMapping(path = "/account/balance", method = RequestMethod.GET)
public double getAccountBalance(Principal userInfo) {
	long userId = userDAO.findIdByUsername(userInfo.getName());
    return accountDAO.getAccountBalance(userId);
    	
}
@RequestMapping (path = "/users", method = RequestMethod.GET)
public List<AccountUser> listUsers(){
	List<AccountUser> theUsers = new ArrayList();
	theUsers = accountUserDAO.listUsers();
	return theUsers;
}

@RequestMapping (path = "/transfer", method = RequestMethod.POST)
public void update(Principal userInfo, @RequestBody Transfer aTransfer) throws Exception {
	long transferFrom = userDAO.findIdByUsername(userInfo.getName());
	 accountDAO.updateAccount(aTransfer.getTransfer_to(), transferFrom, aTransfer.getAmount());
	
}
@RequestMapping (path = "/transfer/list", method = RequestMethod.GET)
public List<Transfer> getAllTransfers(){
	List<Transfer> results = transferDAO.getAllTransfers();
	return results;
}

}
