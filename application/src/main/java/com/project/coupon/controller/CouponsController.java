package com.project.coupon.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.coupon.entities.Company;
import com.project.coupon.services.AdminFacade;


@RestController
public class CouponsController {
    @Autowired
	private AdminFacade AdminFacadeDAO;	

    
    @GetMapping("/admin/get-all-companies")
    public List<Company> getAllCompanies() {
        return AdminFacadeDAO.getAllCompanies();
    }
    
    @PostMapping("/admin/add-company")
    public void generateCoupons(@RequestBody Company c) {
         AdminFacadeDAO.createCompany(c);
    }
    
}
