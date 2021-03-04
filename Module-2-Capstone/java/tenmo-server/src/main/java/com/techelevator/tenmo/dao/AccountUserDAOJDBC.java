package com.techelevator.tenmo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.tenmo.model.AccountUser;

@Component
public class AccountUserDAOJDBC implements AccountUserDAO {
	private JdbcTemplate jdbcTemplate;
	
	public List<AccountUser> listUsers(){
		List<AccountUser> listOfUsers = new ArrayList<AccountUser>();
		String getListOfUsers = "SELECT user_id, username FROM users";
		SqlRowSet userList = jdbcTemplate.queryForRowSet(getListOfUsers);
		if (userList.next()) {
			AccountUser aUser = new AccountUser();
			aUser = mapRowToAccountUser(userList);
			listOfUsers.add(aUser);
			}
		return listOfUsers;
		
	}
	
	private AccountUser mapRowToAccountUser(SqlRowSet results) {
		AccountUser theUser;
		theUser =  new AccountUser();
		theUser.setUser_id(results.getLong("user_id"));
		theUser.setUsername(results.getString("username"));
		return theUser;
	}

}
