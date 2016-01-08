package com.hungrybell.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="orders")
public class DealOrders implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "order_id")
	private String order_id;
    @Column(name = "deal_id")
	private long deal_id;
	@Column(name="quantity")
	private long quantity;
	@Column(name="amount")
	private float amount;
	
	@Column(name="deal_name")
	private String deal_name;
	
	@Column(name="merchant_name")
	private String merchant_name;
	
	@Column(name="deleted")
	private int deleted;
	
	
	
	
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public String getDeal_name() {
		return deal_name;
	}
	public void setDeal_name(String deal_name) {
		this.deal_name = deal_name;
	}
	public String getMerchant_name() {
		return merchant_name;
	}
	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public long getDeal_id() {
		return deal_id;
	}
	public void setDeal_id(long deal_id) {
		this.deal_id = deal_id;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public double getAmount() {
		return amount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
	


}


