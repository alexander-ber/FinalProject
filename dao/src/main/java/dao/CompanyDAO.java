package dao;

import java.util.Collection;


import com.project.coupon.entities.Company;


public interface CompanyDAO {
	
	void createCompany(Company c);
	void removeCompany(Company c);
	void updateCompany(Company c);
	
	Company getCompanyId(Long id);
	Collection<Company> getAllCompanies();
	Collection<Company> getCoupons();	
	boolean login(String compName, String password);
}
