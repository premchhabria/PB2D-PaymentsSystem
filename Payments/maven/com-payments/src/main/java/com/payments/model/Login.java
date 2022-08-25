package com.payments.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int login_id;
	private String password;
	
	
	
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(int login_id, String password) {
		super();
		
		this.login_id = login_id;
		this.password = password;
	}
	
	
	
	public int getLogin_id() {
		return login_id;
	}
	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

	
}