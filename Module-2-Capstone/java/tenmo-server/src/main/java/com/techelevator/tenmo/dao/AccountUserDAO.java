package com.techelevator.tenmo.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.techelevator.tenmo.model.AccountUser;

@Component
public interface AccountUserDAO {
	
	List<AccountUser> listUsers();

}
