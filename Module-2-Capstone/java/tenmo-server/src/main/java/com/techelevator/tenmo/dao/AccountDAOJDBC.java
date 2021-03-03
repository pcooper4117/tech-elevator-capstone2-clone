package com.techelevator.tenmo.dao;

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

	public Account updateAccount(Account accounts, long User_id) {
		return accounts;
		
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
