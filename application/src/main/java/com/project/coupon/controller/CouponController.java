package com.project.coupon.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coupon.entities.Coupon;
import com.project.coupon.services.AdminFacade;

@RestController
public class CouponController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
	private AdminFacade AdminFacadeDAO;	
    
    @GetMapping("/admin/get-all-coupons")
    public List<Coupon> getAllCoupons() {
    	
		LOGGER.debug("This is a debug message");
		LOGGER.info("This is an info message");
		LOGGER.warn("This is a warn message");
		LOGGER.error("This is an error message");
    	 
    	       
    	return AdminFacadeDAO.getAllCoupons();
    }
}
