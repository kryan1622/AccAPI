package com.bae.rest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import com.bae.entities.Account;
import com.bae.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(Controller.class)
@AutoConfigureMockMvc
public class IntegrationTesting {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AccountService service;

	@MockBean
	 private RestTemplate restTemplate;
	
	private static final Account ACCOUNT_1 = new Account(new Long(1), "Krystal", "Ryan", "JZ96", "you won");
	Optional<Account> accountOptional = Optional.of(ACCOUNT_1);
	private static final Account ACCOUNT_2 = new Account(new Long(2), "Rich", "Harris", "JZ95", "you won");
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

@Test
public void getAllAccountsTest() throws Exception{
	List<Account> MOCK_LIST = new ArrayList<>();
	MOCK_LIST.add(ACCOUNT_1);
	when(service.getAllAccounts()).thenReturn(MOCK_LIST);
	mockMvc.perform(get("/getAllAccounts")).andExpect(content().string(containsString("{\"accountId\":1,\"firstName\":\"Krystal\",\"lastName\":\"Ryan\",\"accountNumber\":\"JZ96\"}")));
}

@Test
public void createAccount() throws Exception {
String postValue = OBJECT_MAPPER.writeValueAsString(ACCOUNT_1);
doReturn(ACCOUNT_1).when(service).createAccount(ACCOUNT_1);
mockMvc.perform(MockMvcRequestBuilders
		.post("/createAccount")
		.contentType(MediaType.APPLICATION_JSON).content(postValue))
        .andExpect(status().isOk())
        .andDo(print())
        .andReturn();
}

@Test
public void deleteByAccount() throws Exception{
	String postValue = OBJECT_MAPPER.writeValueAsString(ACCOUNT_1);
	doReturn("Account successfully deleted").when(service).deleteAccount(ACCOUNT_1);
	mockMvc.perform(MockMvcRequestBuilders
			.delete("/deleteAccount")
	.contentType(MediaType.APPLICATION_JSON).content(postValue))
	.andExpect(content().string(containsString("")))
	.andExpect(status().isOk())
	.andDo(print());

	
	
}

@Test
public void updateByAccount() throws Exception{
	String postValue = OBJECT_MAPPER.writeValueAsString(ACCOUNT_1);
	doReturn("Account successfully updated").when(service).updateAccount(ACCOUNT_1);
	mockMvc.perform(MockMvcRequestBuilders
			.put("/updateAccount")
	.contentType(MediaType.APPLICATION_JSON).content(postValue))
	.andExpect(content().string(containsString("")))
	.andExpect(status().isOk());
	
	
	
}
}

