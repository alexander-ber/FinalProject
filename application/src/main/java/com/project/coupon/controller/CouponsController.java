package com.project.coupon.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coupon.entities.Company;
import com.project.coupon.services.AdminFacade;


@RestController
public class CouponsController {
    @Autowired
	private AdminFacade AdminFacadeDAO;	

    
    @GetMapping("/get-all-companies")
    public List<Company> generateCoupons() {
        return AdminFacadeDAO.getAllCompanies();
    }	
    
}
