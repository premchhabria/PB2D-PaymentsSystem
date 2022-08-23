package com.payments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.payments.model.User;
import com.payments.service.UserService;

@RestController
@RequestMapping("/login")
public class UserController {
	@Autowired
	UserService userService;

	// http://localhost:9999/add-user

	@RequestMapping(value = "/add-user", method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUser(@RequestBody User user) {
		HttpStatus status = HttpStatus.CREATED;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "user added successfully.");
		ResponseEntity<User> response = new ResponseEntity<>(userService.addUser(user), headers, status);
		return response;
	}
	
//	@RequestMapping(value = "/add-user", method = RequestMethod.POST, 
//			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public User addUser(@RequestBody User user) {
//		System.out.println(user.toString());
//		return user;
//	}
	
}
