package com.techelevator.tenmo.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import com.techelevator.tenmo.model.Account;

@Component
public class AccountDAOJDBC implements AccountDAO {
	
private JdbcTemplate jdbcTemplate;


public AccountDAOJDBC (JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
	
}


	public void createAccount(Account accounts) {
		
	}

	public double getAccountBalance(long User_id) {
		Account anAccount = new Account();
		String SqlGetAccountBalance = "SELECT * FROM accounts WHERE user_id = ?";
		SqlRowSet accountBalance = jdbcTemplate.queryForRowSet(SqlGetAccountBalance, User_id);
		if (accountBalance.next()) {
			anAccount = mapRowToAccount(accountBalance);
		}
		return anAccount.getAccountBalance();
	}

	public List<Account> list(){
		return null;
		
	}

	public void updateAccount(long transferTo, long transferFrom, double amount) throws Exception {
		String SqlUpdateTransfers = "INSERT INTO transfers (transfer_status_id, transfer_type_id, account_to, account_from, amount) VALUES(2, 2, ?, ?, ?)";
		if (amount > getAccountBalance(transferFrom)) {
			throw new Exception("You cannot transfer more money than you have!");
		} else
		{ 
		jdbcTemplate.update(SqlUpdateTransfers,transferTo,transferFrom,amount);
		
	
		String SqlUpdateFromAccount = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
		jdbcTemplate.update(SqlUpdateFromAccount, amount, transferFrom);
		
		
		String SqlUpdateToAccount = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
		jdbcTemplate.update(SqlUpdateToAccount, amount, transferTo);
		
		}
		
	}

	public void deleteAccount (long User_id) {
		
	}
	
	
	private Account mapRowToAccount(SqlRowSet results) {
		Account theAccount;
		theAccount =  new Account();
		theAccount.setAccount_id(results.getLong("account_id"));
		theAccount.setUser_id(results.getLong("user_id"));
		theAccount.setBalance(results.getDouble("balance"));
		return theAccount;
	}
	
	
	private long getNextAccountId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_account_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		}
		else {
			throw new RuntimeException("Something went wrong while getting an Id");
		}
	}
}
