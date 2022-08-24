package com.payments.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "bill")
public class Bill implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int bill_id;
	private String biller_code;
	private int consumer_no;
	private double amount;
	private String due_date;
	private String status;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumns({
		@JoinColumn(name = "biller_code", referencedColumnName = "biller_code", insertable = false, updatable = false),
		@JoinColumn(name = "consumer_no", referencedColumnName = "consumer_no", insertable = false, updatable = false)
	})
	private RegisteredBiller registeredBiller;

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBill_id() {
		return bill_id;
	}

	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public RegisteredBiller getRegisteredBiller() {
		return registeredBiller;
	}

	public void setRegisteredBiller(RegisteredBiller registeredBiller) {
		this.registeredBiller = registeredBiller;
	}

	public Bill(int bill_id, String biller_code, int consumer_no, double amount, String due_date, String status) {
		super();
		this.bill_id = bill_id;
		this.biller_code = biller_code;
		this.consumer_no = consumer_no;
		this.amount = amount;
		this.due_date = due_date;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Bill [bill_id=" + bill_id + ", biller_code=" + biller_code + ", consumer_no=" + consumer_no
				+ ", amount=" + amount + ", due_date=" + due_date + ", status=" + status + ", registeredBiller="
				+ registeredBiller + ", getBill_id()=" + getBill_id() + ", getBiller_code()=" + getBiller_code()
				+ ", getConsumer_no()=" + getConsumer_no() + ", getAmount()=" + getAmount() + ", getDue_date()="
				+ getDue_date() + ", getStatus()=" + getStatus() + ", getRegisteredBiller()=" + getRegisteredBiller()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
