package com.payments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.payments.model.MasterBiller;
import com.payments.service.MasterBillerService;

@RestController
@RequestMapping("/mbill")
public class MasterBillerController {

	@Autowired
	MasterBillerService mbillService;
	
	// http://localhost:9999/mbill/get-all-mbills

		@RequestMapping(value = "/get-all-mbills", method = RequestMethod.GET, produces = { "application/json" })
//		@GetMapping("/get-all-mbills")
		public ResponseEntity<List<MasterBiller>> getAllMBills() {
			List<MasterBiller> mbillList = mbillService.getAllMasterBillers();
			HttpStatus status = HttpStatus.OK;
			HttpHeaders headers = new HttpHeaders();
			headers.add("message", "All MasterBillers returned successfully.");
			ResponseEntity<List<MasterBiller>> response = new ResponseEntity<>(mbillList, headers, status);
			return response;
		}
		
		@RequestMapping(value = "/add-mbill", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<MasterBiller> addMBill(@RequestBody MasterBiller mbill) {
			HttpStatus status = HttpStatus.CREATED;
			HttpHeaders headers = new HttpHeaders();
			headers.add("message", "m bill added successfully.");
			ResponseEntity<MasterBiller> response = new ResponseEntity<>(mbillService.addMasterBiller(mbill), headers, status);
			return response;
		}
	
}
