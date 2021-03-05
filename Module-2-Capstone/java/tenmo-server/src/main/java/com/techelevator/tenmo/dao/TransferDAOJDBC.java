package com.techelevator.tenmo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.tenmo.model.Transfer;
@Component
public class TransferDAOJDBC implements TransferDAO {
	private JdbcTemplate jdbcTemplate;
	
	public TransferDAOJDBC (JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		
	}

//	public void makeTransfer(long transferTo, long transferFrom, double amount) throws Exception {
//			String SqlUpdateTransfers = "INSERT INTO transfers (transfer_status_id, transfer_type_id, account_to, account_from, amount) VALUES(2, 2, ?, ?, ?)";
//			if (amount > getAccountBalance(transferFrom)) {
//				throw new Exception("You cannot transfer more money than you have!");
//			} else
//			{ 
//			jdbcTemplate.update(SqlUpdateTransfers,transferTo,transferFrom,amount);
//			
//		
//			String SqlUpdateFromAccount = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
//			jdbcTemplate.update(SqlUpdateFromAccount, amount, transferFrom);
//			
//			
//			String SqlUpdateToAccount = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
//			jdbcTemplate.update(SqlUpdateToAccount, amount, transferTo);
//			
//			}
//			
//		}
//		
//	}
	public List<Transfer> getAllTransfers(){
		List<Transfer> listOfTransfers = new ArrayList<>();
		String sqlGetAllTransfers = "SELECT * FROM transfers";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllTransfers);
		while (results.next()) {
			Transfer aTransfer = mapRowToTransfer(results);
			listOfTransfers.add(aTransfer);
		}
		
		return listOfTransfers;
	}
	
	private Transfer mapRowToTransfer(SqlRowSet results) {
		Transfer theTransfer;
		theTransfer =  new Transfer();
		theTransfer.setTransfer_id(results.getLong("transfer_id"));
		theTransfer.setTransfer_type_id(results.getLong("transfer_type_id"));
		theTransfer.setTransfer_status_id(results.getLong("transfer_status_id"));
		theTransfer.setTransfer_from(results.getLong("account_from"));
		theTransfer.setTransfer_to(results.getLong("account_to"));
		theTransfer.setAmount(results.getDouble("amount"));
		return theTransfer;
	}
}
