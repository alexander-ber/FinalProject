package com.project.coupon.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.coupon.entities.Company;
import com.project.coupon.entities.Coupon;
import com.project.coupon.entities.Customer;
import com.project.coupon.services.AdminFacade;

@RestController
public class CustomerController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
	private AdminFacade AdminFacadeDAO;	
    
    @GetMapping("/admin/get-all-customers")
    public List<Customer> getAllCustomers() {
    	return AdminFacadeDAO.getAllCustomers();
    }
    
    @GetMapping("/admin/get-customer-by-id/{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") Long customerId) {
    	System.out.println("Controller customerId = " + customerId);
    	return AdminFacadeDAO.getCustomerById(customerId);
    }
    
    @PostMapping("/admin/add-customer")
    public void createCustomer(@RequestBody Customer c) {
         AdminFacadeDAO.createCustomer(c);
    }

    @PostMapping("/admin/update-customer")
    public void updateCustomer(@RequestBody Customer c) {
    	AdminFacadeDAO.updateCustomer(c);
    }

    @GetMapping("/admin/delete-customer/{customerId}")
    public void removeCustomer(@PathVariable("customerId") Long customerId) {
    	AdminFacadeDAO.removeCustomer(customerId);
    }

}
