package com.hungrybell.app.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kitchen_coupon")
public class KitchenCoupon implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "coupon_id")
	private Long coupon_id;
	@Column(name = "merchantbranch_id")
	private Long merchantbranch_id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(Long coupon_id) {
		this.coupon_id = coupon_id;
	}
	public Long getMerchantbranch_id() {
		return merchantbranch_id;
	}
	public void setMerchantbranch_id(Long merchantbranch_id) {
		this.merchantbranch_id = merchantbranch_id;
	}
	
	
	
}
