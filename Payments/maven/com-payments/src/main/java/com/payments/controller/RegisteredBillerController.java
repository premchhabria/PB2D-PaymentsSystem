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
import com.payments.model.RegisteredBiller;
import com.payments.service.RegisteredBillerService;



@RestController
@RequestMapping("/regbiller")
public class RegisteredBillerController {

	@Autowired
	RegisteredBillerService regBillerService;

	// http://localhost:9999/regbill/get-all-regbiller

	@RequestMapping(value = "/get-all-regbiller", method = RequestMethod.GET, produces = { "application/json" })
//			@GetMapping("/get-all-regbiller")
	public ResponseEntity<List<RegisteredBiller>> getAllRegBiller() {
		List<RegisteredBiller> regbillerList = regBillerService.getAllRegisteredBiller();
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "All RegisteredBiller returned successfully.");
		ResponseEntity<List<RegisteredBiller>> response = new ResponseEntity<>(regbillerList, headers, status);
		return response;
	}

	@RequestMapping(value = "/add-regbiller", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RegisteredBiller> addRegBiller(@RequestBody RegisteredBiller regbiller) {
		HttpStatus status = HttpStatus.CREATED;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "m biller added successfully.");
		ResponseEntity<RegisteredBiller> response = new ResponseEntity<>(regBillerService.addRegBiller(regbiller), headers,
				status);
		return response;
	}
	// http://localhost:9999/emp/delete-emp/{eid}

	@RequestMapping(value = "/delete-regbiller/{biller_id}", method = RequestMethod.DELETE, produces = { "application/json" })
	public ResponseEntity<RegisteredBiller> deleteEmp(@PathVariable(name = "biller_id") int billerId) {
		RegisteredBiller biller = regBillerService.deleteRegBiller(billerId);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "biller with id " + billerId + " deleted successfully.");
		ResponseEntity<RegisteredBiller> response = new ResponseEntity<>(biller, headers, status);
		return response;
	}

}

