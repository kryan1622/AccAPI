package com.bae.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class PrizegenService {
	
	public String prizeGen() {
			Random rand = new Random(); 
			int value = rand.nextInt(10); 
			if (value < 5 ) {
				return "You have won £50";
			} 
			if (value == 5 ) {
				return "You have won £100";
			} else {
				return "Sorry you have not won";
		}
	}
}

