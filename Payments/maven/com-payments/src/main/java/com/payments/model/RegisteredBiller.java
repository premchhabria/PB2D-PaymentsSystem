package com.payments.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="registeredbiller")
public class RegisteredBiller implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int biller_id;
	private String biller_code;
	private int consumer_no;
	private int account_no;
	private boolean autopay;
	private double autopay_limit;
	
	
	@OneToOne
	@JoinColumn(name = "account_no", referencedColumnName = "account_no", insertable = false, updatable = false)
	private Account account;


	public RegisteredBiller() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RegisteredBiller(int biller_id, String biller_code, int consumer_no, int account_no, boolean autopay,
			double autopay_limit) {
		super();
		this.biller_id = biller_id;
		this.biller_code = biller_code;
		this.consumer_no = consumer_no;
		this.account_no = account_no;
		this.autopay = autopay;
		this.autopay_limit = autopay_limit;
	}


	public int getBiller_id() {
		return biller_id;
	}


	public void setBiller_id(int biller_id) {
		this.biller_id = biller_id;
	}


	public String getBiller_code() {
		return biller_code;
	}


	public void setBiller_code(String biller_code) {
		this.biller_code = biller_code;
	}


	public int getConsumer_no() {
		return consumer_no;
	}


	public void setConsumer_no(int consumer_no) {
		this.consumer_no = consumer_no;
	}


	public int getAccount_no() {
		return account_no;
	}


	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}


	public boolean isAutopay() {
		return autopay;
	}


	public void setAutopay(boolean autopay) {
		this.autopay = autopay;
	}


	public double getAutopay_limit() {
		return autopay_limit;
	}


	public void setAutopay_limit(double autopay_limit) {
		this.autopay_limit = autopay_limit;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "RegisteredBiller [biller_id=" + biller_id + ", biller_code=" + biller_code + ", consumer_no="
				+ consumer_no + ", account_no=" + account_no + ", autopay=" + autopay + ", autopay_limit="
				+ autopay_limit + ", account=" + account + ", getBiller_id()=" + getBiller_id() + ", getBiller_code()="
				+ getBiller_code() + ", getConsumer_no()=" + getConsumer_no() + ", getAccount_no()=" + getAccount_no()
				+ ", isAutopay()=" + isAutopay() + ", getAutopay_limit()=" + getAutopay_limit() + ", getAccount()="
				+ getAccount() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
