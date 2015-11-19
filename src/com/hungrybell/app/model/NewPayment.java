package com.hungrybell.app.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "newpayment")
public class NewPayment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "mihpayid")
	private String mihpayid;

	@Column(name = "mode")
	private String mode;

	@Column(name = "status")
	private String status;

	@Column(name = "Payu_key")
	private String key;

	@Column(name = "txnid")
	private String txnid;

	@Column(name = "amount")
	private String amount;

	@Column(name = "discount")
	private String discount;

	@Column(name = "productinfo")
	private String productinfo;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "address1")
	private String address1;

	@Column(name = "address2")
	private String address2;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;

	@Column(name = "zipcode")
	private String zipcode;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "udf1")
	private String udf1;

	@Column(name = "udf2")
	private String udf2;

	@Column(name = "udf3")
	private String udf3;

	@Column(name = "udf4")
	private String udf4;

	@Column(name = "udf5")
	private String udf5;

	@Column(name = "hash")
	private String hash;

	@Column(name = "Error")
	private String Error;

	@Column(name = "PG_TYPE")
	private String PG_TYPE;

	@Column(name = "bank_ref_num")
	private String bank_ref_num;

	@Column(name = "shipping_firstname")
	private String shipping_firstname;

	@Column(name = "shipping_lastname")
	private String shipping_lastname;

	@Column(name = "shipping_address1")
	private String shipping_address1;

	@Column(name = "shipping_address2")
	private String shipping_address2;

	@Column(name = "shipping_city")
	private String shipping_city;

	@Column(name = "shipping_state")
	private String shipping_state;

	@Column(name = "shipping_country")
	private String shipping_country;

	@Column(name = "shipping_zipcode")
	private String shipping_zipcode;

	@Column(name = "shipping_phone")
	private String shipping_phone;

	@Column(name = "shipping_phoneverified")
	private String shipping_phoneverified;

	@Column(name = "unmappedstatus")
	private String unmappedstatus;

	@Column(name = "payuMoneyId")
	private String payuMoneyId;
	
	@Column(name="payment_date")
	private String payment_date;
	
	@Column(name="card_merchant_param")
	private String card_merchant_param;
	
	
	
	

	public String getCard_merchant_param() {
		return card_merchant_param;
	}

	public void setCard_merchant_param(String card_merchant_param) {
		this.card_merchant_param = card_merchant_param;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMihpayid() {
		return mihpayid;
	}

	public void setMihpayid(String mihpayid) {
		this.mihpayid = mihpayid;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getTxnid() {
		return txnid;
	}

	public void setTxnid(String txnid) {
		this.txnid = txnid;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getProductinfo() {
		return productinfo;
	}

	public void setProductinfo(String productinfo) {
		this.productinfo = productinfo;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUdf1() {
		return udf1;
	}

	public void setUdf1(String udf1) {
		this.udf1 = udf1;
	}

	public String getUdf2() {
		return udf2;
	}

	public void setUdf2(String udf2) {
		this.udf2 = udf2;
	}

	public String getUdf3() {
		return udf3;
	}

	public void setUdf3(String udf3) {
		this.udf3 = udf3;
	}

	public String getUdf4() {
		return udf4;
	}

	public void setUdf4(String udf4) {
		this.udf4 = udf4;
	}

	public String getUdf5() {
		return udf5;
	}

	public void setUdf5(String udf5) {
		this.udf5 = udf5;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getError() {
		return Error;
	}

	public void setError(String error) {
		Error = error;
	}

	public String getPG_TYPE() {
		return PG_TYPE;
	}

	public void setPG_TYPE(String pG_TYPE) {
		PG_TYPE = pG_TYPE;
	}

	public String getBank_ref_num() {
		return bank_ref_num;
	}

	public void setBank_ref_num(String bank_ref_num) {
		this.bank_ref_num = bank_ref_num;
	}

	public String getShipping_firstname() {
		return shipping_firstname;
	}

	public void setShipping_firstname(String shipping_firstname) {
		this.shipping_firstname = shipping_firstname;
	}

	public String getShipping_lastname() {
		return shipping_lastname;
	}

	public void setShipping_lastname(String shipping_lastname) {
		this.shipping_lastname = shipping_lastname;
	}

	public String getShipping_address1() {
		return shipping_address1;
	}

	public void setShipping_address1(String shipping_address1) {
		this.shipping_address1 = shipping_address1;
	}

	public String getShipping_address2() {
		return shipping_address2;
	}

	public void setShipping_address2(String shipping_address2) {
		this.shipping_address2 = shipping_address2;
	}

	public String getShipping_city() {
		return shipping_city;
	}

	public void setShipping_city(String shipping_city) {
		this.shipping_city = shipping_city;
	}

	public String getShipping_state() {
		return shipping_state;
	}

	public void setShipping_state(String shipping_state) {
		this.shipping_state = shipping_state;
	}

	public String getShipping_country() {
		return shipping_country;
	}

	public void setShipping_country(String shipping_country) {
		this.shipping_country = shipping_country;
	}

	public String getShipping_zipcode() {
		return shipping_zipcode;
	}

	public void setShipping_zipcode(String shipping_zipcode) {
		this.shipping_zipcode = shipping_zipcode;
	}

	public String getShipping_phone() {
		return shipping_phone;
	}

	public void setShipping_phone(String shipping_phone) {
		this.shipping_phone = shipping_phone;
	}

	public String getShipping_phoneverified() {
		return shipping_phoneverified;
	}

	public void setShipping_phoneverified(String shipping_phoneverified) {
		this.shipping_phoneverified = shipping_phoneverified;
	}

	public String getUnmappedstatus() {
		return unmappedstatus;
	}

	public void setUnmappedstatus(String unmappedstatus) {
		this.unmappedstatus = unmappedstatus;
	}

	public String getPayuMoneyId() {
		return payuMoneyId;
	}

	public void setPayuMoneyId(String payuMoneyId) {
		this.payuMoneyId = payuMoneyId;
	}

	public String getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
