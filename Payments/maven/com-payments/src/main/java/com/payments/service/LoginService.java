package com.payments.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payments.model.Login;
import com.payments.model.User;
import com.payments.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository loginRepository;
	
	
//	
//	public User login(Login user) {
//		return loginRepository.login(user);
//	}

	public Login login(int login_id, String password) {
		Login user = loginRepository.findUserByStatusAndNameNamedParamsNative(login_id, password);
//		Login user = loginRepository.findByUsernameAndPassword(login_id, password);
		return user;
	}

}