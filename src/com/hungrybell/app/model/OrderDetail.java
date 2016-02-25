package com.hungrybell.app.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "neworderdetails")
public class OrderDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "longitude")
	private Double longitude;

	@Column(name = "latitude")
	private Double latitude;

	@Column(name = "landmark")
	private String landmark;

	@Column(name = "delivery_address")
	private String delivery_address;

	@Column(name = "order_type")
	private String order_type;

	@Column(name = "order_quantity")
	private Long order_quantity;

	@Column(name = "order_amount")
	private Double order_amount;

	@Column(name = "deal_id")
	private Long deal_id;

	@Column(name = "order_date_time")
	private Timestamp order_date_time;

	@Column(name = "delivery_status")
	private String delivery_status;

	@Column(name = "order_status")
	private String order_status;

	@Column(name = "user_id")
	private Long user_id;

	@Column(name = "merchantbranch_id")
	private Long merchantbranch_id;

	@Column(name = "order_id")
	private String order_id;

	@Column(name = "delivery_time")
	private Date delivery_time;

	public Date getDelivery_time() {
		return delivery_time;
	}

	public void setDelivery_time(Date delivery_time) {
		this.delivery_time = delivery_time;
	}

	public String getDiscount_method() {
		return discount_method;
	}

	public void setDiscount_method(String discount_method) {
		this.discount_method = discount_method;
	}

	public double getDiscount_amount() {
		return discount_amount;
	}

	public void setDiscount_amount(double discount_amount) {
		this.discount_amount = discount_amount;
	}

	@Column(name = "discount_method")
	private String discount_method;
	@Column(name = "coupan_code")
	private String coupan_code;

	@Column(name = "discount_amount")
	private double discount_amount;

	@Column(name = "feedback_received")
	private String feedback_received;

	public String getCoupan_code() {
		return coupan_code;
	}

	public void setCoupan_code(String coupan_code) {
		this.coupan_code = coupan_code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getDelivery_address() {
		return delivery_address;
	}

	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}

	public String getOrder_type() {
		return order_type;
	}

	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}

	public Long getOrder_quantity() {
		return order_quantity;
	}

	public void setOrder_quantity(Long order_quantity) {
		this.order_quantity = order_quantity;
	}

	public Double getOrder_amount() {
		return order_amount;
	}

	public void setOrder_amount(Double order_amount) {
		this.order_amount = order_amount;
	}

	public Long getDeal_id() {
		return deal_id;
	}

	public void setDeal_id(Long deal_id) {
		this.deal_id = deal_id;
	}

	public Timestamp getOrder_date_time() {
		return order_date_time;
	}

	public void setOrder_date_time(Timestamp order_date_time) {
		this.order_date_time = order_date_time;
	}

	public String getDelivery_status() {
		return delivery_status;
	}

	public void setDelivery_status(String delivery_status) {
		this.delivery_status = delivery_status;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getMerchantbranch_id() {
		return merchantbranch_id;
	}

	public void setMerchantbranch_id(Long merchantbranch_id) {
		this.merchantbranch_id = merchantbranch_id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFeedback_received() {
		return feedback_received;
	}

	public void setFeedback_received(String feedback_received) {
		this.feedback_received = feedback_received;
	}

}
