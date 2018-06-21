package com.project.coupon.entities;

public enum CouponType {
	RESTURANS("REST"),
	ELECTRICITY("ELEC"),
	FOOD("FOOD"),
	HEALTH("HEALTH"),
	SPORTS("SPORTS"),
	CAMPING("CAMPING"),
	TRAVELLING("TRAVELLING");
	
	private final String code;
	
	
	CouponType(String code){
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
}
