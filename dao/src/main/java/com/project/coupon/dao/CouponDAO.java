package com.project.coupon.dao;

import java.util.Collection;

import com.project.coupon.entities.Coupon;

public interface CouponDAO {
	void removeCoupon(Coupon coupon);
	void updateCoupon(Coupon coupon);
	Coupon getCoupon(Long id);
	
	Collection<Coupon> getAllCoupons();
	Collection<Coupon>getCouponByType(String couponType);

}
