package com.payments.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.payments.model.Transaction;
import com.payments.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	TransactionRepository transactionRepository;
	
	public List<Transaction> getAllTransaction() {
		return transactionRepository.findAll();
	}
	
	public Transaction addTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}
	
	public List<Transaction> getPaymentsWithAllFilters(int consumerId, String billerCode, String startDate, String endDate) {
		if(!billerCode .equalsIgnoreCase("null")) {
			if(!startDate .equalsIgnoreCase("null")) {
				return transactionRepository.findPaymentsWithAllFilters(consumerId, billerCode, startDate, endDate);
			}
			else return transactionRepository.findPaymentsWithoutDate(consumerId, billerCode);
		}
		else {
			if(!startDate.equalsIgnoreCase("null"))
				return transactionRepository.findPaymentsWithoutBiller(consumerId, startDate, endDate);
			
			else return transactionRepository.findPaymentsWithoutFilters(consumerId );
		}
	}
	
	
}
