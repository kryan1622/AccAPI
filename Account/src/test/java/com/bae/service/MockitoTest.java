package com.bae.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.entities.Account;
import com.bae.repository.AccountRepository;
import com.bae.service.AccountService;

@RunWith(SpringRunner.class)
public class MockitoTest {
	
	@InjectMocks
	AccountService service;
	
	@Mock
	AccountRepository repository;
	
	private static final Account ACCOUNT_1 = new Account(new Long(1), "Krystal", "Ryan", "JZ96", "you won");
	Optional<Account> accountOptional = Optional.of(ACCOUNT_1);
	private static final Account ACCOUNT_2 = new Account(new Long(2), "Rich", "Harris", "JZ95", "you won");
	
	@Test
	public void getAllAccountsTest() {
		List<Account> MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(ACCOUNT_1);
		MOCK_LIST.add(ACCOUNT_2);
		Mockito.when(repository.findAll()).thenReturn(MOCK_LIST);
		assertEquals(MOCK_LIST, service.getAllAccounts());
		Mockito.verify(repository).findAll();
	}
	
	@Test
	public void getAnAccountTest() {
		List<Account> MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(ACCOUNT_1);
		Mockito.when(repository.findById(1L)).thenReturn(accountOptional);
		assertEquals(ACCOUNT_1, service.getAnAccount(1L));
	}
	
	@Test
	public void deleteAccountTest() {
		assertEquals("Account successfully deleted", service.deleteAccount(ACCOUNT_1));
		Mockito.verify(repository).delete(ACCOUNT_1);
		
		
		}
	
	@Test
	public void deleteAccountByIdTest() {
		assertEquals("Account Deleted",service.deleteAccountById(1L));
		Mockito.verify(repository).deleteById(1L);
	}
			

	@Test
	public void createAccountTest() {
		Mockito.when(repository.save(ACCOUNT_1)).thenReturn(ACCOUNT_1);
		assertEquals(ACCOUNT_1, service.createAccount(ACCOUNT_1));
		Mockito.verify(repository).save(ACCOUNT_1);
	}
	
	@Test
	public void updateAccountTest() {
	doNothing().when(repository).deleteById(ACCOUNT_1.getAccountId());
	Mockito.when(repository.save(ACCOUNT_2)).thenReturn(ACCOUNT_2);
	assertEquals("Account successfully updated", service.updateAccount(ACCOUNT_2));
	Mockito.verify(repository).save(ACCOUNT_2);
	Mockito.verify(repository).deleteById(2L);;
	}
}
