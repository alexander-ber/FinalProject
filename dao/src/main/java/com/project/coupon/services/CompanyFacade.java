package com.project.coupon.services;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.coupon.dao.CompanyDAO;
import com.project.coupon.dao.CouponDAO;
import com.project.coupon.entities.Company;
import com.project.coupon.entities.Coupon;

@Service
public class CompanyFacade implements CouponClientFacade{
	private Boolean isLoggedIn = false;
	


	@Autowired
	private CouponDAO couponDAO;
	
	@Autowired
	private CompanyDAO companyDAO;
	@Autowired 
	private HttpSession httpSession;
	
	
	
	@Override
	public CouponClientFacade login(String name, String password, String clientType) {
		System.out.println("Start login ..");
		Company c = companyDAO.login(name, password);
		
		if(c !=null ) {
			httpSession.setAttribute("companyId", c.getId());
			System.out.println("session :" + httpSession.getAttribute("companyId"));
		}
		
		System.out.println("name: " + name + " password: " + password + " clientType: " + clientType);
//		if(name.equals(this.username) && password.equals(this.password) && clientType.equals("company")) {
//			this.isLoggedIn = true;
//			httpSession.setAttribute("user", name);
//			System.out.println("httpSession aaaaaaaaaa  " + httpSession.getAttribute("user"));
//		}
		System.out.println("End login ..");
		return null;
	}
	
	public void removeCoupon(Long couponId) {		
		try {
			couponDAO.removeCoupon(couponId);
			System.out.println("couponId" + couponId);
		} catch(Exception e) {
			System.out.println("SQL removeCoupon exception: " + e.getMessage());
		}	
	}
	
	public void createCoupon(Coupon c) {		
		try {
			couponDAO.createCoupon(c);
		} catch(Exception e) {
			System.out.println("SQL removeCoupon exception: " + e.getMessage());
		}	
	}
	
}
