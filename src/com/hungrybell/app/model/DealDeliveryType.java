package com.hungrybell.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dealdeliverytype")
public class DealDeliveryType implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ddtpk")
    Long ddtpk;
	
		public Long getDdtpk() {
		return ddtpk;
	}
	public void setDdtpk(Long ddtpk) {
		this.ddtpk = ddtpk;
	}
		@Column(name = "dealid")
	  Long dealid;
		@Column(name="deliveryid")
		Long deliveryid;
		
		public Long getDealid() {
			return dealid;
		}
		public void setDealid(Long dealid) {
			this.dealid = dealid;
		}
		public Long getDeliveryid() {
			return deliveryid;
		}
		public void setDeliveryid(Long deliveryid) {
			this.deliveryid = deliveryid;
		}
		  
}


