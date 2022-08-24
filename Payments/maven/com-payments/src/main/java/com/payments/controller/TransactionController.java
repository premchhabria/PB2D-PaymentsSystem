package com.payments.controller;

import java.io.IOException;import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

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

import com.payments.model.Transaction;
import com.payments.service.CsvExportService;
import com.payments.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	CsvExportService csvExportService;
	
	// http://localhost:9999/mbill/get-all-mbills

		@RequestMapping(value = "/get-all-transaction", method = RequestMethod.GET, produces = { "application/json" })
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
		
		@RequestMapping(value = "/get-transaction/{consumer_no}/{biller_code}/{start_date}/{end_date}", method = RequestMethod.GET, produces = { "application/json" })
		public ResponseEntity<List<Transaction>> getPaymentsWithAllFilters(HttpServletResponse servletResponse, @PathVariable(name = "consumer_no")int cons, 
				@PathVariable(name = "biller_code")String biller,
				@PathVariable(name = "start_date")String startDate,
				@PathVariable(name = "end_date")String endDate) throws IOException {
			List<Transaction> transactionList = transactionService.getPaymentsWithAllFilters(cons, biller, startDate, endDate);
			HttpStatus status = HttpStatus.OK;
			HttpHeaders headers = new HttpHeaders();
			headers.add("message", "All Filtered Transaction returned successfully.");
			ResponseEntity<List<Transaction>> response = new ResponseEntity<>(transactionList, headers, status);
			this.getAllTransactionInCsv(servletResponse, cons, biller, startDate, endDate);
			return response;
		}
		
		@RequestMapping(path = "/export")
	    public void getAllTransactionInCsv(HttpServletResponse servletResponse, int consumerId, String billerCode, String startDate, String endDate) throws IOException {
	        servletResponse.setContentType("text/csv");
	        servletResponse.addHeader("Content-Disposition","attachment; filename=\"payments.csv\"");
	        csvExportService.writeEmployeesToCsv(servletResponse.getWriter(), consumerId, billerCode, startDate, endDate);
	    }
	
}