package com.project.coupon.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.coupon.dao.CompanyDAO;
import com.project.coupon.dao.CouponDAO;
import com.project.coupon.dao.CustomerDAO;

import com.project.coupon.entities.Company;
import com.project.coupon.entities.Coupon;
import com.project.coupon.entities.Customer;

@Service
public class AdminFacade implements CouponClientFacade {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	private final String username = "admin"; 
	private final String password = "1234"; 
	private Boolean isLoggedIn = false; 
	
	@Autowired 
	private HttpSession httpSession;

	
	void AdminFacade() {
	}
	

	
	//@Autowired 
	//private HttpServletRequest request;
	
	@Autowired
	private CompanyDAO cDAO;	

	@Autowired
	private CouponDAO couponDAO;	
	
	@Autowired
	private CustomerDAO customerDAO;	
	
	
	public CouponClientFacade login(String name, String password, String clientType) {
		System.out.println("Start login ..");
		System.out.println("name: " + name + " password: " + password + " clientType: " + clientType);
		if(name.equals(this.username) && password.equals(this.password) && clientType.equals("admin")) {
			this.isLoggedIn = true;
			httpSession.setAttribute("user", name);
			System.out.println("httpSession aaaaaaaaaa  " + httpSession.getAttribute("user"));
		}
		System.out.println("End login ..");
		return null;
	}

	public void createCompany(Company c) {
		
		try {
			cDAO.createCompany(c);
		} catch(Exception e) {
			System.out.println("SQL createCompany  exception: " + e.getMessage());
		}	
	}

	public void removeCompany(Long companyId) {		
		try {
			cDAO.removeCompany(companyId);
			System.out.println("companyId" + companyId);
		} catch(Exception e) {
			System.out.println("SQL removeCompany exception: " + e.getMessage());
		}	
	}
	
	public Company updateCompany(Company c) {
		try {
			Company cc = this.getCompanyById(c.getId());
			if(c.getCompName() != cc.getCompName()) {
				LOGGER.info("You can't change company name from : " + cc.getCompName() + " to " + c.getCompName());
				c.setCompName(cc.getCompName());
			}
			cDAO.updateCompany(c);
			return this.getCompanyById(c.getId());
		} catch(Exception e) {
			System.out.println("SQL updateCompany exception: " + e.getMessage());
		}	
		return null;
	}
	
	public Company getCompanyById(Long companyId) {		
		try {
			System.out.println("AdminFacade companyId = " + companyId);
			return cDAO.getCompanyById(companyId);
		} catch(Exception e) {
			System.out.println("SQL getCompanyById exception: " + e.getMessage());
		}	
		return null;
	}
	
	public ArrayList<Company> getAllCompanies(){
		System.out.println("httpSession aaaaaaaaaa" + httpSession.getAttribute("user"));
		try {
			return (ArrayList<Company>) cDAO.getAllCompanies();
		} catch(Exception e) {
			System.out.println("SQL getAllCompanies exception: " + e.getMessage());
		}
		return null;		
	}
	
	/*************** Coupons **********************/
	public ArrayList<Coupon> getAllCoupons() {
		try {
			return (ArrayList<Coupon>) couponDAO.getAllCoupons();
		} catch(Exception e) {
			System.out.println("SQL getAllCoupons exception: " + e.getMessage());
		}
		return null;
	}

	/************** Customers **********************/
	public ArrayList<Customer> getAllCustomers() {
		try {
			return (ArrayList<Customer>) customerDAO.getAllCustomers();
		} catch(Exception e) {
			System.out.println("SQL getAllCustomers exception: " + e.getMessage());
		}
		return null;
	}

	public void createCustomer(Customer c) {
		try {
			customerDAO.createCustomer(c);
		} catch(Exception e) {
			System.out.println("SQL createCustomer  exception: " + e.getMessage());
		}	
		
	}

	public void updateCustomer(Customer c) {
		try {
			customerDAO.updateCustomer(c);
		} catch(Exception e) {
			System.out.println("SQL updateCustomer  exception: " + e.getMessage());
		}	
		
	}

	public void removeCustomer(Long customerId) {
		try {
			customerDAO.removeCustomer(customerId);
			System.out.println("customerId" + customerId);
		} catch(Exception e) {
			System.out.println("SQL removeCustomer: " + e.getMessage());
		}	
		
	}

	public Customer getCustomerById(Long customerId) {
		try {
			System.out.println("AdminFacade companyId = " + customerId);
			return customerDAO.getCustomerById(customerId);
		} catch(Exception e) {
			System.out.println("SQL getCustomerById exception: " + e.getMessage());
		}	
		return null;
	}








	
	

	

}
