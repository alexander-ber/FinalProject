package com.project.coupon.entities;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue
	private Long id;
	private String custName;
	private String password;
	private ArrayList<Coupon> coupons; 
	
	
	public Customer(String custName, String password) {
		super();
		this.custName = custName;
		this.password = password;
	}
	
	

	public ArrayList<Coupon> getCoupons() {
		return coupons;
	}



	public void setCoupons(ArrayList<Coupon> coupons) {
		this.coupons = coupons;
	}



	public Long getId() {
		return id;
	}

	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
