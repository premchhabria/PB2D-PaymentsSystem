package com.payments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.payments.model.Bill;
import com.payments.service.BillService;

@RestController
@RequestMapping("/bill")
public class BillController {
	@Autowired
	BillService billService;
	@RequestMapping(value = "/get-all-bills", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<List<Bill>> getAllMBills() {
		List<Bill> billList = billService.getAllBill();
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "All Bills returned successfully.");
		ResponseEntity<List<Bill>> response = new ResponseEntity<>(billList, headers, status);
		return response;
	}
	
	@RequestMapping(value = "/update-bill/{bill_id}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bill> updateBill(@PathVariable(name = "bill_id") int billId) {
		HttpStatus status = HttpStatus.CREATED;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Bill updated successfully.");
		ResponseEntity<Bill> response = new ResponseEntity<>(billService.setStatusPaid(billId), headers, status);
		return response;
	}
	
	@RequestMapping(value = "/add-bill", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Bill> addBill(@RequestBody Bill bill) {
		HttpStatus status = HttpStatus.CREATED;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", " bill added successfully.");
		ResponseEntity<Bill> response = new ResponseEntity<>(billService.addBill(bill), headers, status);
		return response;
	}
}
