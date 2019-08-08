package com.bae.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bae.service.PrizegenService;

@RestController
public class Controller {

	public PrizegenService service;
	
	@Autowired
	public Controller(PrizegenService service) {
		this.service = service;
	}
	
	
	
	
	@GetMapping("/prize")
	public String getPrizes() {
		return service.prizeGen();
	}
	
}
