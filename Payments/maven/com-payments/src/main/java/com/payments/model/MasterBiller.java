package com.payments.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MasterBiller")
public class MasterBiller {
	
	@Id
	private String biller_code;
	private int biller_account_id;
	private String name;
	
	public MasterBiller() {
		super();
	}

	public MasterBiller(String biller_code, int biller_account_id, String name) {
		super();
		this.biller_code = biller_code;
		this.biller_account_id = biller_account_id;
		this.name = name;
	}

	public String getBiller_code() {
		return biller_code;
	}

	public void setBiller_code(String biller_code) {
		this.biller_code = biller_code;
	}

	public int getBiller_account_id() {
		return biller_account_id;
	}

	public void setBiller_account_id(int biller_account_id) {
		this.biller_account_id = biller_account_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MasterBiller [biller_code=" + biller_code + ", biller_account_id=" + biller_account_id + ", name=" + name + "]";
	}
	
}
