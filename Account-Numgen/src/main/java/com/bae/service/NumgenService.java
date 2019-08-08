package com.bae.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class NumgenService {
	
	public String getRandomNumberString() {
		List<String> chars = new ArrayList<>();
		 chars.add("a");
	        chars.add("b");
	        chars.add("c");
	        
	        Random rnd = new Random();
	        int number = rnd.nextInt(3);
	        
	    Random random = new Random();
	    int num = random.nextInt(999999);
	    return chars.get(number) + num;
	}

}
