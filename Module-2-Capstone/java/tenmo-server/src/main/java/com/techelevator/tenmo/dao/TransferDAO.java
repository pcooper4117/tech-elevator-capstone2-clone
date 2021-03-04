package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;

public interface TransferDAO {

	long getAccountFrom();
	long getAccountTo();
	double getAmount();
}
