package com.bae.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.bae.service.NumgenService;

@RestController
public class Controller {
	
public NumgenService service;

@Autowired
public Controller(NumgenService service) {
	this.service = service;
}


@GetMapping("/num")
public String getNumber() {
	return service.getRandomNumberString();
}

}
