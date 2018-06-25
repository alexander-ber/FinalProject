package com.project.coupon.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.coupon.dao.CompanyDAO;
import com.project.coupon.entities.Company;

@Service
public class AdminFacade implements CouponClientFacade{

	public CouponClientFacade login(String name, String password, String clientType) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Autowired
	private CompanyDAO cDAO;	
	
	public ArrayList<Company> getAllCompanies(){
		
		try {
			return (ArrayList<Company>) cDAO.getAllCompanies();
		} catch(Exception e) {
			System.out.println("SQL exception: " + e.getMessage());
		}
		return null;		
	}
	
	public void createCompany(Company c){
		
		try {
			cDAO.createCompany(c);
		} catch(Exception e) {
			System.out.println("SQL exception: " + e.getMessage());
		}	
	}
	
	public void deleteCompany(Long companyId) {		
		try {
			cDAO.deleteById(companyId);
		} catch(Exception e) {
			System.out.println("SQL exception: " + e.getMessage());
		}	
	}
	
	
	
	
	

	

}
