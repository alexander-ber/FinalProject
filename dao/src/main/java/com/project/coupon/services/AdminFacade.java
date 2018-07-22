package com.project.coupon.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.coupon.dao.CompanyDAO;
import com.project.coupon.entities.Company;

@Service
public class AdminFacade implements CouponClientFacade{

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	public CouponClientFacade login(String name, String password, String clientType) {
		// TODO Auto-generated method stub
		return null;
	}
	
	void AdminFacade() {
	}
	
	@Autowired
	private CompanyDAO cDAO;	

	public void createCompany(Company c) {
		
		try {
			cDAO.createCompany(c);
		} catch(Exception e) {
			System.out.println("SQL aaaaaaa  exception: " + e.getMessage());
		}	
	}

	public void removeCompany(Long companyId) {		
		try {
			cDAO.deleteById(companyId);
			System.out.println("companyId" + companyId);
		} catch(Exception e) {
			System.out.println("SQL exception: " + e.getMessage());
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
			System.out.println("SQL exception: " + e.getMessage());
		}	
		return null;
	}
	
	public Company getCompanyById(Long companyId) {		
		try {
			System.out.println("AdminFacade companyId = " + companyId);
			return cDAO.getCompanyById(companyId);
		} catch(Exception e) {
			System.out.println("SQL exception: " + e.getMessage());
		}	
		return null;
	}
	
	public ArrayList<Company> getAllCompanies(){
		
		try {
			return (ArrayList<Company>) cDAO.getAllCompanies();
		} catch(Exception e) {
			System.out.println("SQL exception: " + e.getMessage());
		}
		return null;		
	}
	





	
	

	

}
