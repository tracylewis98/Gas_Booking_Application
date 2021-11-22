package com.gasbooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bank {
	@Id
	@GeneratedValue
	private int bankId;
	private String bankName;
	private String address;
	
	public Bank() {
		super();
	}
	
	public Bank(int bankId, String bankName, String address) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.address = address;
	}
    
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", address=" + address + "]";
	}
	
	
}
