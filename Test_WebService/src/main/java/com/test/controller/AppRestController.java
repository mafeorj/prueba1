package com.test.controller;

import java.util.HashMap;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.test.entity.Customer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.test.service.AppTestService;
import org.springframework.web.bind.annotation.GetMapping;



//@Validated
@RestController
public class AppRestController {
	
	public AppRestController() {
		System.out.println("inside constructor");
	}

	
	@Autowired
	private AppTestService appTestService;

	
	


	
	/**
	 * Retrieve all festivities
	 * @return ResponseEntity<List<Festivities>> with all result of festivities
	 */
    @GetMapping("/customers1")
	//@PostMapping("/mensajes")
	public ResponseEntity<List<Customer>> listAllCustomers() {
		ResponseEntity<?> responseEntity = null;
		try {
			 List<Customer> listCustomer = appTestService.findAllCustomer();
			if (listCustomer.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				//responseEntity = new ResponseEntity<>(listCustomer, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Customer>>(listCustomer,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Customer>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}

