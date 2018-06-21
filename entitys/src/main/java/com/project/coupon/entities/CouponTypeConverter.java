package com.project.coupon.entities;

import java.util.Iterator;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class CouponTypeConverter implements AttributeConverter<CouponType, String> {

	public String convertToDatabaseColumn(CouponType type) {
		return type.getCode();
	}

	public CouponType convertToEntityAttribute(String dbData) {
		final CouponType[] values = CouponType.values();
		
		for(CouponType type : values) {
			if(type.getCode().equals(dbData)) {
				return type;
			}
		}

		return null;
	}
	
	
}
