package com.payments.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payments.model.MasterBiller;
import com.payments.repository.MasterBillerRepository;

@Service
public class MasterBillerService {

	@Autowired
	MasterBillerRepository mbillRepository;
	
	public List<MasterBiller> getAllMasterBillers() {
		return mbillRepository.findAll();
	}
	
	public MasterBiller addMasterBiller(MasterBiller mbill) {
		return mbillRepository.save(mbill);
	}

	
}
