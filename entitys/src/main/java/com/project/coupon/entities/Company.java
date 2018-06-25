package com.project.coupon.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "company", uniqueConstraints = {@UniqueConstraint(columnNames = {"compName"})} )
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	private String compName;
	
	private String password;
	private String email;
	
	
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "company_coupon",
            joinColumns = @JoinColumn(name = "comp_id"), // this class
            inverseJoinColumns = @JoinColumn(name = "coupon_id") // the other class
    )
    
	private List<Coupon> coupons; 
    
	public Company() {
		super();
	}

	public Company(String compName, String password, String email) {
		super();
		this.compName = compName;
		this.password = password;
		this.email = email;
	}
	
	public List<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(ArrayList<Coupon> coupons) {
		this.coupons = coupons;
	}
	
	public Long getId() {
		return id;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	
}
