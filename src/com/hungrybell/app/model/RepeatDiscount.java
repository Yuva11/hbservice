package com.hungrybell.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "repeat_discount")
public class RepeatDiscount implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "order_number")
	private int order_number;
	
	@Column(name = "type")
	private int type;
	
	@Column(name = "value")
	private int value;
	
	@Column(name = "custome_message")
	private String custome_message;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getOrder_number() {
		return order_number;
	}

	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getCustome_message() {
		return custome_message;
	}

	public void setCustome_message(String custome_message) {
		this.custome_message = custome_message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
	
}
