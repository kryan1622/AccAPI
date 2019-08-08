package com.bae.rest;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;

import com.bae.entities.Account;
import com.bae.entities.SentAccount;
import com.bae.service.AccountService;

@RestController
public class Controller {
	
	public AccountService service;
	
	@Autowired
	public Controller(AccountService service) {
		this.service = service;
	}
	
	@Autowired
    private JmsTemplate jmsTemplate;
	 
	
	@Autowired
	    private RestTemplate restTemplate;
	
	@GetMapping("/getAllAccounts")
	public List<Account> getAllAccounts(){
		return service.getAllAccounts();

}
	
	@PostMapping("/createAccount")
	public Account createAccount(@RequestBody Account account) {
		String AccountNumber = restTemplate.getForObject("http://localhost:8082/num", String.class);
		String prizeWon = restTemplate.getForObject("http://localhost:8081/prize", String.class);
		
		account.setPrize(prizeWon);
		account.setAccountNumber(AccountNumber);
		
		sendToQueue(account);
		
		return service.createAccount(account);
	
	}
	
	@DeleteMapping("/deleteAccount")
	public String deleteAccount(@RequestBody Account account) {
		return service.deleteAccount(account);
	}

	@PutMapping("/updateAccount")
	public String updateAccount(@RequestBody Account account) {
		return service.updateAccount(account);
	}
	
	@GetMapping("getAnAccount/{accountId}")
	public Account getAnAccount(@PathVariable("accountId") Long accountId) {
		return service.getAnAccount(accountId);
	}
	
	@DeleteMapping("deleteAnAccount/{accountId}")
	public String deleteAccountById(@PathVariable("accountId") Long accountId) {
		return service.deleteAccountById(accountId);
	}
	
	 private void sendToQueue(Account account){
	        SentAccount accountToStore =  new SentAccount(account);
	        jmsTemplate.convertAndSend("AccountQueue", accountToStore);
	    }
	
}
