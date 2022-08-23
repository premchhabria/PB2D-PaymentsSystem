package com.payments.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.payments.model.RegisteredBiller;
import com.payments.repository.RegisteredBillerRepository;

@Service
public class RegisteredBillerService {
	@Autowired
	RegisteredBillerRepository regBillerRepository;
	
	public List<RegisteredBiller> getAllRegisteredBiller() {
		return regBillerRepository.findAll();
	}
	
	public RegisteredBiller addRegBiller(RegisteredBiller regBiller) {
		return regBillerRepository.save(regBiller);
	}
	public RegisteredBiller deleteRegBiller(int billerId) {
		RegisteredBiller biller = this.getRegisteredBillerById(billerId);
		regBillerRepository.deleteById(billerId);
		return biller;
	}

	private RegisteredBiller getRegisteredBillerById(int billerId) {
		// TODO Auto-generated method stub
		return regBillerRepository.findById(billerId).get();
	}
	
}
