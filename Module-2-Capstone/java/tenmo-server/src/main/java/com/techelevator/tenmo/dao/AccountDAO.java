package com.techelevator.tenmo.dao;

import java.util.List;

import com.techelevator.tenmo.model.Account;

public interface AccountDAO {
	
	
void createAccount(Account accounts);

double getAccountBalance(long User_id);

List<Account> list();

void updateAccount(long transferTo, long transferFrom, double amount);

void deleteAccount (long User_id);
}
