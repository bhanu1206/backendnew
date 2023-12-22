package com.infinite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.model.Restaurant;
import com.infinite.service.IRestaurantService;

@RestController

@CrossOrigin("http://localhost:3000/")
public class RestaurantController {

	@Autowired
	IRestaurantService rservice;
	
	@RequestMapping(value="/restaurant",method=RequestMethod.GET)
	public List<Restaurant> getRestaurant(){
		
		return rservice.getRestaurant();
		
	}
	
	@RequestMapping(value = "/restaurant/register", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> addrestaurant(@RequestBody Restaurant rest) {
		try {
			rservice.addrestaurant(rest);
			return ResponseEntity.ok("Registration successful");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
		}
	}
	
	@RequestMapping(value = "/restaurant/login",  method = RequestMethod.POST)
	public ResponseEntity<String> loginRestaurant(@RequestBody Restaurant rest) {
		String username = rest.getUsername();
		String password = rest.getPassword();
		Restaurant validaterest = rservice.validateRestaurant(username, password);
		if (validaterest != null) {

			// returns status code 200
			return ResponseEntity.ok("Login successfull");
		} else { // returns status code 401unauthorized
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid credintials");

		}

	}

}
