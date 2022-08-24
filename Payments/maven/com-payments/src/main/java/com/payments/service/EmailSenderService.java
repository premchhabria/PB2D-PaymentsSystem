package com.payments.service;

import org.springframework.beans.factory.annotation.Autowired;

public interface EmailSenderService {
	@Autowired
    void sendEmail(String to, String subject, String message);
}