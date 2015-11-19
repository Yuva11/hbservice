package com.hungrybell.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "merchantbranch")
public class MerchantBranch {

	@Id
	private Long id;

	@Column(name = "location_id")
	private Long location_id;
	@Column(name = "branch_name")
	private String branch_name;
	@Column(name = "address")
	private String address;
	@Column(name = "lattitue")
	public Double lattitue;
	@Column(name = "longitude")
	public Double longitude;
	@Column(name = "merchant_id")
	private Long merchant_id;
	@Column(name = "mobile_number")
	private Long mobile_number;
	@Column(name = "e_mail")
	private String e_mail;

	@Column(name = "min_order_value")
	private Long min_order_value;

	@Column(name = "operation_time")
	private String operation_time;
	
	
	@Column(name = "m_password")
	private String m_password;

	
	
	
	

	public String getM_password() {
		return m_password;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public Long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(Long mobile_number) {
		this.mobile_number = mobile_number;
	}

	public Long getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(Long merchant_id) {
		this.merchant_id = merchant_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLocation_id() {
		return location_id;
	}

	public void setLocation_id(Long location_id) {
		this.location_id = location_id;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getLattitue() {
		return lattitue;
	}

	public void setLattitue(Double lattitue) {
		this.lattitue = lattitue;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Long getMin_order_value() {
		return min_order_value;
	}

	public void setMin_order_value(Long min_order_value) {
		this.min_order_value = min_order_value;
	}

	public String getOperation_time() {
		return operation_time;
	}

	public void setOperation_time(String operation_time) {
		this.operation_time = operation_time;
	}

}
