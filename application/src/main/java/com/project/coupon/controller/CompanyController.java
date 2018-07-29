package com.project.coupon.controller;

import java.util.List;
import java.util.Set;

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
import com.project.coupon.services.AdminFacade;
import com.project.coupon.services.CompanyFacade;


@RestController
public class CompanyController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
		
    @Autowired
	private AdminFacade adminFacade;
    
    @Autowired
	private CompanyFacade companyFacade;
    
    @GetMapping("/error")
    public List<Company> error() {
        return adminFacade.getAllCompanies();
    }
    
    @GetMapping("/admin/get-all-companies")
    public List<Company> getAllCompanies() {       
    	return adminFacade.getAllCompanies();
    }
    
    @GetMapping("/admin/delete-company/{companyId}")
    public void deleteCompany(@PathVariable("companyId") Long companyId) {
    	adminFacade.removeCompany(companyId);
    }
    
    @GetMapping("/admin/get-company-by-id/{companyId}")
    public Company getCompanyById(@PathVariable("companyId") Long companyId) {
    	System.out.println("Controller companyId = " + companyId);
    	return adminFacade.getCompanyById(companyId);
    }
    
    @PostMapping("/admin/add-company")
    public void createCompany(@RequestBody Company c) {
    	adminFacade.createCompany(c);
    }
    
    @GetMapping("/login/{user}/{password}/{client_type}")
    public void login(@PathVariable("user") String userName, 
    		@PathVariable("password") String password,
    		@PathVariable("client_type") String clientType) {
    	if(clientType.equals("admin")) {
    		adminFacade.login(userName,password,clientType);
    	} else if (clientType.equals("company")) {
    		companyFacade.login(userName,password,clientType);
    	}
    }
    
    

    @PostMapping("/admin/update-company")
    public Company updateCompany(@RequestBody Company c) {
    	return adminFacade.updateCompany(c);
    }
    
    //------------------------
    @GetMapping("/delete-coupon/{couponId}")
    public void deleteCoupon(@PathVariable("couponId") Long couponId) {
    	companyFacade.removeCoupon(couponId);
    }
    
    @PostMapping("/add-coupon")
    public void createCoupon(@RequestBody Coupon c) {
    	companyFacade.createCoupon(c);
    }
}
