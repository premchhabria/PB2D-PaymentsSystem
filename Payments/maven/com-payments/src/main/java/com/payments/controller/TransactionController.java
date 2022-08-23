package com.payments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.payments.model.Transaction;
import com.payments.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	TransactionService transactionService;
	
	// http://localhost:9999/mbill/get-all-mbills

		@RequestMapping(value = "/get-all-transaction", method = RequestMethod.GET, produces = { "application/json" })
//		@GetMapping("/get-all-mbills")
		public ResponseEntity<List<Transaction>> getAllMBills() {
			List<Transaction> transactionList = transactionService.getAllTransaction();
			HttpStatus status = HttpStatus.OK;
			HttpHeaders headers = new HttpHeaders();
			headers.add("message", "All Transaction returned successfully.");
			ResponseEntity<List<Transaction>> response = new ResponseEntity<>(transactionList, headers, status);
			return response;
		}
		
		@RequestMapping(value = "/add-transaction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
			HttpStatus status = HttpStatus.CREATED;
			HttpHeaders headers = new HttpHeaders();
			headers.add("message", "Transaction added successfully.");
			ResponseEntity<Transaction> response = new ResponseEntity<>(transactionService.addTransaction(transaction), headers, status);
			return response;
		}
	
}