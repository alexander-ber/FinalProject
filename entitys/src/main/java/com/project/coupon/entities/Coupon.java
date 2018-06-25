package com.project.coupon.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "coupon")
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private LocalDate startDate;
	private LocalDate endDate;
	private Integer amount;
	private String message; 
	private Double price;
	private String image;
	
	//@Convert(converter=CouponTypeConverter.class)
	@Enumerated(EnumType.STRING)
	private CouponType type;
	
    @OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "company_coupon",
            joinColumns = @JoinColumn(name = "coupon_id"), // this class
            inverseJoinColumns = @JoinColumn(name = "comp_id") // the other class
    )
    private Company company; 
	
	
	public Coupon() {
		super();
	}



	public Coupon(String title, LocalDate startDate, LocalDate endDate, Integer amount, String message, Double price,
			String image) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amount = amount;
		this.message = message;
		this.price = price;
		this.image = image;
	}
	
	

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
	
} 
