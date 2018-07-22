package com.project.coupon.dao;

import java.util.Collection;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.project.coupon.entities.Company;

public interface CompanyDAO extends JpaRepository<Company, Long> {
	
	
	default void createCompany(Company c) throws ConstraintViolationException{
		this.save(c);
	}
	
	default void updateCompany(Company c) throws ConstraintViolationException{
		this.save(c);
	}

	default void removeCompany(Long id) {
		this.deleteById(id);
	}
	
	@Query("select c from Company c")
	Collection<Company> getAllCompanies();
	
	
	default Company getCompanyById(Long id) {
		System.out.println("CompanyDAO companyId = " + id);
		return this.getOne(id);
	}

}
