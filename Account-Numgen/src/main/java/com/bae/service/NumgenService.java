package com.bae.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class NumgenService {
	
	public int getRandomNumberString() {
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);
	    return number;
	}

}
