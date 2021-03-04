package com.techelevator.tenmo.services;
import com.techelevator.tenmo.model.Account;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import com.techelevator.tenmo.models.AuthenticatedUser;



/*******************************************************************************************************
 * This is where you code Application Services required by your solution
 * 
 * Remember:  theApp ==> ApplicationServices  ==>  Controller  ==>  DAO
 ********************************************************************************************************/

public class TenmoApplicationServices {
	private final RestTemplate restTemplate = new RestTemplate();
	private static final String API_BASE_URL = "http://localhost:8080/";
	

	public double getAccountBalance(String authToken)  {
		double accountBalance;
		accountBalance = restTemplate.exchange(API_BASE_URL + "account/balance", HttpMethod.GET, makeAuthEntity(authToken), double.class).getBody();

		return accountBalance;
	}
	
	public List<Account> getAccountList(){
		
	}
	
	  private HttpEntity makeAuthEntity(String authToken) {
		    HttpHeaders headers = new HttpHeaders();						// Instantiate a header object for request
		    headers.setBearerAuth(authToken);								// Set the "bearer" attribute in the header to the JWT																// the "bearer" attribute in a request header holds JWT
		    HttpEntity entity = new HttpEntity<>(headers);					// Create a properly formatted request by instantiating an entity
		    return entity;
		  }

}
