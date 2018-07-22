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
import com.project.coupon.services.AdminFacade;


@RestController
public class CompanyController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
	private AdminFacade AdminFacadeDAO;	
    
    @GetMapping("/error")
    public List<Company> error() {
        return AdminFacadeDAO.getAllCompanies();
    }
    
    @GetMapping("/admin/get-all-companies")
    public List<Company> getAllCompanies() {
    	
		LOGGER.debug("This is a debug message");
		LOGGER.info("This is an info message");
		LOGGER.warn("This is a warn message");
		LOGGER.error("This is an error message");
    	 
    	       
    	return AdminFacadeDAO.getAllCompanies();
    }
    
    @GetMapping("/admin/delete-company/{companyId}")
    public void deleteCompany(@PathVariable("companyId") Long companyId) {
        AdminFacadeDAO.removeCompany(companyId);
    }
    
    @GetMapping("/admin/get-company-by-id/{companyId}")
    public Company getCompanyById(@PathVariable("companyId") Long companyId) {
    	System.out.println("Controller companyId = " + companyId);
    	return AdminFacadeDAO.getCompanyById(companyId);
    }
    
    @PostMapping("/admin/add-company")
    public void createCompany(@RequestBody Company c) {
         AdminFacadeDAO.createCompany(c);
    }

    @PostMapping("/admin/update-company")
    public Company updateCompany(@RequestBody Company c) {
    	return AdminFacadeDAO.updateCompany(c);
    }
    
}
