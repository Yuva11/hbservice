package com.hungrybell.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="setting")
public class Setting implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "delivery_charges")
	private int delivery_charges;
	
	@Column(name = "delivery_distance")
	private float delivery_distance;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDelivery_charges() {
		return delivery_charges;
	}

	public void setDelivery_charges(int delivery_charges) {
		this.delivery_charges = delivery_charges;
	}

	public float getDelivery_distance() {
		return delivery_distance;
	}

	public void setDelivery_distance(float delivery_distance) {
		this.delivery_distance = delivery_distance;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
}
