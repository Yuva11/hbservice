package com.hungrybell.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="delivery_type")
public class DeliveryType implements Serializable {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "id")
	  Long id;
		@Column(name="type")
		String type;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		
}
