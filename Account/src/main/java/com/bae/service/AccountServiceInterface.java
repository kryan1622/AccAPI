package com.bae.service;
import java.util.List;

import com.bae.entities.Account;

public interface AccountServiceInterface {
	
	List<Account> getAllAccounts();
	Account createAccount(Account account);
    String deleteAccount(Account account);
    String updateAccount(Account account);
    Account getAnAccount(Long accountId);
    String deleteAccountById(Long accountId);
}
