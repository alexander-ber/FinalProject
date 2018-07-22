package com.project.coupon.dao;

import java.util.Collection;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.project.coupon.entities.Coupon;

public interface CouponDAO  extends JpaRepository<Coupon, Long> {
	//void removeCoupon(Coupon coupon);
	//void updateCoupon(Coupon coupon);
	//Coupon getCoupon(Long id);
	
	@Query("select c from Coupon c")
	Collection<Coupon> getAllCoupons();
	
	//Collection<Coupon>getCouponByType(String couponType);
}
