package com.project.coupon.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String custName;
	private String password;

	//CascadeType.ALL - 
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "CUSTOMER_COUPON",
            joinColumns = @JoinColumn(name = "CUSTOMER_ID"), // this class
            inverseJoinColumns = @JoinColumn(name = "COUPON_ID") // the other class
    )
    private Set<Coupon> coupons = new HashSet<Coupon>();
	
    
	
	public Customer() {
		super();
	}



	public Customer(String custName, String password) {
		super();
		this.custName = custName;
		this.password = password;
	}
	
	

	public Set<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(Set<Coupon> coupons) {
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
