package com.techelevator.tenmo.dao;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.tenmo.model.Account;

public class TransferDAOJDBC implements TransferDAO{

	public long getAccountTo() {
	
		String SqlGetAccountTO = "SELECT account_to FROM transfers  = ?";
		SqlRowSet accountBalance = jdbcTemplate.queryForRowSet(SqlGetAccountBalance, User_id);
		if (accountBalance.next()) {
			anAccount = mapRowToAccount(accountBalance);
		}
		return anAccount.getAccountBalance();
	return null;
}
	
	public long getAccountFrom() {
		return null;
	}
	
	public double getAmount() {
		return null;
	}
}
