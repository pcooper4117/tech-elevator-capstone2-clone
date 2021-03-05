package com.techelevator.tenmo.services;
import com.techelevator.tenmo.model.AccountUser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import com.techelevator.tenmo.models.AuthenticatedUser;
import com.techelevator.tenmo.models.Transfer;
import com.techelevator.tenmo.models.AuthenticatedUser;




/*******************************************************************************************************
 * This is where you code Application Services required by your solution
 * 
 * Remember:  theApp ==> ApplicationServices  ==>  Controller  ==>  DAO
 ********************************************************************************************************/

public class TenmoApplicationServices {
	private final RestTemplate restTemplate = new RestTemplate();
	private static final String API_BASE_URL = "http://localhost:8080/";
	private AuthenticatedUser currentUser;



	public double getAccountBalance(String authToken)  {
		
		double accountBalance;
		accountBalance = restTemplate.exchange(API_BASE_URL + "account/balance", HttpMethod.GET, makeAuthEntity(authToken), double.class).getBody();

		return accountBalance;
	}
	
	public List<AccountUser> listUsers(String authToken) {
		List<AccountUser> theUsers = new ArrayList();
		
		theUsers = restTemplate.exchange(API_BASE_URL + "/users", HttpMethod.GET, makeAuthEntity(authToken), List.class).getBody();
		
		return theUsers;
		
	}
	public void makeTransfer(String authToken, Transfer aTransfer) throws Exception {
		aTransfer.getAmount();
		aTransfer.getTransfer_to();
		aTransfer.getTransfer_from();
		aTransfer.getTransfer_status_id();
		aTransfer.getTransfer_type_id();
		try { 
	 restTemplate.exchange(API_BASE_URL + "/transfer", HttpMethod.POST, makeTransferEntity(aTransfer, authToken), Transfer.class);
		} catch(Exception Ex) {
			throw new Exception("You cannot transfer more money than you have!");
		}
		
		
	
	}
	  private HttpEntity makeAuthEntity(String authToken) {
		    HttpHeaders headers = new HttpHeaders();						// Instantiate a header object for request
		    headers.setBearerAuth(authToken);								// Set the "bearer" attribute in the header to the JWT																// the "bearer" attribute in a request header holds JWT
		    HttpEntity entity = new HttpEntity<>(headers);					// Create a properly formatted request by instantiating an entity
		    return entity;
		  }
	  private HttpEntity<Transfer> makeTransferEntity(Transfer transfer, String authToken) {
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        headers.setBearerAuth(authToken);
	        HttpEntity<Transfer> entity = new HttpEntity<>(transfer, headers);
	        return entity;
	        
	    }
	  //TO DO : add second helper method to add to the body add the transfer object into the body also including everything in makeAuthEntity()
}
