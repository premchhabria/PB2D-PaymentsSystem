package com.payments.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int transaction_id; 
	private int account_id; 
	private String date_time; 
	private double amount;
	private String description;
	private int bill_id;
	
	@OneToOne
	@JoinColumn(name = "account_id", referencedColumnName = "account_id", insertable = false, updatable = false)
	private Account account;

	@OneToOne
	@JoinColumn(name = "bill_id", referencedColumnName = "bill_id", insertable = false, updatable = false)
	private Bill bill;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(int transaction_id, int account_id, String date_time, double amount, String description,
			int bill_id) {
		super();
		this.transaction_id = transaction_id;
		this.account_id = account_id;
		this.date_time = date_time;
		this.amount = amount;
		this.description = description;
		this.bill_id = bill_id;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getBill_id() {
		return bill_id;
	}

	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Transaction [transaction_id=" + transaction_id + ", account_id=" + account_id + ", date_time="
				+ date_time + ", amount=" + amount + ", description=" + description + ", bill_id=" + bill_id
				+ ", account=" + account + ", bill=" + bill + ", getTransaction_id()=" + getTransaction_id()
				+ ", getAccount_id()=" + getAccount_id() + ", getDate_time()=" + getDate_time() + ", getAmount()="
				+ getAmount() + ", getDescription()=" + getDescription() + ", getBill_id()=" + getBill_id()
				+ ", getAccount()=" + getAccount() + ", getBill()=" + getBill() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
