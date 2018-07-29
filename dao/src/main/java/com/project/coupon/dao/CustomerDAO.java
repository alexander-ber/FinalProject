package com.project.coupon.dao;

import java.util.Collection;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.project.coupon.entities.Company;
import com.project.coupon.entities.Coupon;
import com.project.coupon.entities.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Long> {
	//void createCustomer(Customer customer);
   // void removeCustomer(Customer customer);
    //void updateCustomer(Customer customer);
   // Customer getCustomer(Long id);
    
    @Query("select c from Customer c")
    Collection<Customer> getAllCustomers();

	default void createCustomer(Customer c) throws ConstraintViolationException{
		this.save(c);
	}

	default void updateCustomer(Customer c) throws ConstraintViolationException{
		this.save(c);
	}
    
	default void removeCustomer(Long id) {
		this.deleteById(id);
	}

	default Customer getCustomerById(Long customerId) {
		System.out.println("CustomerDAO customerId = " + customerId);
		return this.getOne(customerId);
	}
	

   // boolean login(String custName, String password);

}
