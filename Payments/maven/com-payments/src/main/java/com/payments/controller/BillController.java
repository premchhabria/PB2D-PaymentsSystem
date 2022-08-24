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
	public ResponseEntity<List<Bill>> getAllBills() {
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
	
	@RequestMapping(value = "/get-by-consumer/{consumer_no}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<List<Bill>> getByConsumer(@PathVariable(name = "consumer_no")int cons) {
		List<Bill> billList = billService.getByConsumer(cons);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "All Bills Filter by consumer returned successfully.");
		ResponseEntity<List<Bill>> response = new ResponseEntity<>(billList, headers, status);
		return response;
	}
	
	@RequestMapping(value = "/get-scheduled-bill/{consumer_no}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<List<Bill>> getScheduleBill(@PathVariable(name = "consumer_no")int cons) {
		List<Bill> billList = billService.getScheduledBill(cons);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "All Scheduled Bills returned successfully.");
		ResponseEntity<List<Bill>> response = new ResponseEntity<>(billList, headers, status);
		return response;
	}
	
	@RequestMapping(value = "/get-unscheduled-bill/{consumer_no}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<List<Bill>> getUnscheduledBill(@PathVariable(name = "consumer_no")int cons) {
		List<Bill> billList = billService.getUnscheduledBill(cons);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "All UnScheduled Bills returned successfully.");
		ResponseEntity<List<Bill>> response = new ResponseEntity<>(billList, headers, status);
		return response;
	}
	
	@RequestMapping(value = "/get-by-due/{due}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<List<Bill>> getByDue(@PathVariable(name = "due")String due) {
		List<Bill> billList = billService.filterByDue(due);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "All Bills Filter by due returned successfully.");
		ResponseEntity<List<Bill>> response = new ResponseEntity<>(billList, headers, status);
		return response;
	}
	
}
