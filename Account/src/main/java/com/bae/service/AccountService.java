package com.bae.service;
import java.util.List;
import com.bae.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bae.repository.AccountRepository;

@Service
public class AccountService implements AccountServiceInterface{
	
	
	public AccountRepository repository;

	@Autowired
	public AccountService(AccountRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<Account> getAllAccounts() {
		return repository.findAll();
	}

	@Override
	public Account createAccount(Account account) {
    return repository.save(account);
   
	}

	@Override
	public String deleteAccount(Account account) {
		repository.delete(account);
		return "Account successfully deleted";
	}

	@Override
	public String updateAccount(Account account) {
		repository.deleteById(account.getAccountId());
		repository.save(account);
		return "Account successfully updated";
	}

	@Override
	public Account getAnAccount(Long accountId) {
		return repository.findById(accountId).orElse(null);
	}
	
	@Override
	public String deleteAccountById(Long accountId) {
		repository.deleteById(accountId);
		return "Account Deleted";
	}


	
}
