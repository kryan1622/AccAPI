package com.bae.service;
import org.springframework.stereotype.Service;

@Service
public class PrizegenService {
	
	public String prizeGen(String AccountNumber) {
			
			if (AccountNumber.contains("a") ) {
				return "You have won £50";
			} 
			if (AccountNumber.contains("b") ) {
				return "You have won £100";
			} else {
				return "Sorry you have not won";
		}
	}
}

