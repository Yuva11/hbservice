package com.hungrybell.app.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="discountcoupon")
public class DiscountCoupon implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "coupon_code")
	private String coupon_code;
	
	@Column(name="percentage")
	private String percentage;
	
	@Column(name="max_value")
	private String max_value;

	@Column(name="start_date")
	private String start_date;
	
	@Column(name="end_date")
	private String end_date;

	@Column(name="city")
	private String city;
	
	@Column(name="merchantbranch_id")
	private long merchantbranch_id;

	@Column(name="min_order_value")
	private double min_order_value;
	
	@Column(name="usages")
	private long usages;
	
	@Column(name="max_usage")
	private int max_usage;
	
	@Column(name="coupon_type")
	private int coupon_type;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCoupon_code() {
		return coupon_code;
	}

	public void setCoupon_code(String coupon_code) {
		this.coupon_code = coupon_code;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getMax_value() {
		return max_value;
	}

	public void setMax_value(String max_value) {
		this.max_value = max_value;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getMerchantbranch_id() {
		return merchantbranch_id;
	}

	public void setMerchantbranch_id(long merchantbranch_id) {
		this.merchantbranch_id = merchantbranch_id;
	}

	public double getMin_order_value() {
		return min_order_value;
	}

	public void setMin_order_value(double min_order_value) {
		this.min_order_value = min_order_value;
	}

	

	public int getMax_usage() {
		return max_usage;
	}

	public void setMax_usage(int max_usage) {
		this.max_usage = max_usage;
	}

	public long getUsages() {
		return usages;
	}

	public void setUsages(long usages) {
		this.usages = usages;
	}

	public int getCoupon_type() {
		return coupon_type;
	}

	public void setCoupon_type(int coupon_type) {
		this.coupon_type = coupon_type;
	}

	
	
	
	
		
	
}
