package com.techelevator.tenmo.dao;

import java.util.List;

import com.techelevator.tenmo.model.Account;

public interface AccountDAO {
	
	
void createAccount(Account accounts);

double getAccountBalance(long User_id);

List<Account> list();

Account updateAccount(Account accounts, long User_id);

void deleteAccount (long User_id);
}
