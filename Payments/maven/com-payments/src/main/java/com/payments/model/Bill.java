package com.payments.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "User")
public class Bill {
	@Id
	private int bill_id;
	private int biller_code;
	private int consumer_no;
	private double amount;
	private String due_date;
	private int status;
}
