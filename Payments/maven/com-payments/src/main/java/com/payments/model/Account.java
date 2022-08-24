package com.payments.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int account_id;
	private int account_no;
	private String name;
	private String email_id;
	private double balance;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int account_id, int account_no, String name, String email_id, double balance) {
		super();
		this.account_id = account_id;
		this.account_no = account_no;
		this.name = name;
		this.email_id = email_id;
		this.balance = balance;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public int getAccount_no() {
		return account_no;
	}
	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", account_no=" + account_no + ", name=" + name + ", email_id="
				+ email_id + ", balance=" + balance + ", getAccount_id()=" + getAccount_id() + ", getAccount_no()="
				+ getAccount_no() + ", getName()=" + getName() + ", getEmail_id()=" + getEmail_id() + ", getBalance()="
				+ getBalance() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
