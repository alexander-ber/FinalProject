package com.project.coupon.dao;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.project.coupon.entities.Company;
import com.project.coupon.entities.Coupon;
import com.project.coupon.entities.Customer;

public interface CouponDAO  extends JpaRepository<Coupon, Long> {
	
	default void removeCoupon(Long couponId) {
		System.out.println("Delete coupon.....");
		this.deleteById(couponId);
	}
	
	default void createCoupon(Coupon c) {
		this.save(c);
	}
	
	
	//void updateCoupon(Coupon coupon);
	//Coupon getCoupon(Long id);
	
	@Query("select c from Coupon c")
	Collection<Coupon> getAllCoupons();


	//Collection<Coupon>getCouponByType(String couponType);
}
