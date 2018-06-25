package com.project.coupon.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.project.coupon.entities.Company;

public interface CompanyDAO extends JpaRepository<Company, Long> {
	
	
	default void createCompany(Company c) {
		this.save(c);
	}
 /*
	void removeCompany(Company c);
	void updateCompany(Company c);
*/	
	@Query("select c from Company c")
	Collection<Company> getAllCompanies();
	
/*	
	Company getCompanyId(Long id);
	
	Collection<Company> getCoupons();	

	boolean login(String compName, String password);
*/
}
