package com.payments.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payments.model.Bill;
import com.payments.repository.BillRepository;

@Service
public class BillService {
	@Autowired
	BillRepository billRepository;
	
	public List<Bill> getAllBill() {
		return billRepository.findAll();
	}
	
	public Bill addBill(Bill bill) {
		return billRepository.save(bill);
	}
	public Bill getBillById(int billId) {
		return billRepository.findById(billId).get();
	}
	public Bill setStatusPaid(int billId) {
		Bill bill = this.getBillById(billId);
		bill.setStatus("PAID");
		return billRepository.save(bill);
	}
}
