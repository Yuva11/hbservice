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
@Table(name="deal")
public class Deal implements Serializable {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "id")
	  Long id;
		@Column(name="availability")
		Long availability;
		@Column(name="content_type")
	  String content_type;
		@Column(name="couponcode")
		String couponcode;
		@Column(name="created_date")
	  Timestamp created_date;
		@Column(name="deal_discount_percent")
	  Double deal_discount_percent;
		@Column(name="deal_price")
	  Double deal_price;
		@Column(name="deal_template")
	  String deal_template;
		@Column(name="deletestatus")
	  Integer deletestatus;
		@Column(name="delivery_charge")
	  Double delivery_charge;
		@Column(name="delivery_time")
	  String delivery_time;
		@Column(name="details")
	  String details;
		@Column(name="end_date")
	  Timestamp end_date;
		@Column(name="food_type")
	  String food_type;
		@Column(name="last_modified_availability")
	  Timestamp last_modified_availability;
		@Column(name="last_modified_date")
	  Timestamp last_modified_date;
		@Column(name="name")
	  String name;
		@Column(name="opening_quantity")
	  Integer opening_quantity;
		@Column(name="original_price")
	  Double original_price;
		@Column(name="published")
	  Integer published ;
		@Column(name="rating")
	  Integer rating;
		@Column(name="reedem")
	  Integer reedem;
		@Column(name="start_date")
	  Timestamp start_date;
		@Column(name="status")
	  String status;
		@Column(name="food_category_id")
	  Long food_category_id;
		@Column(name="merchantbranch_id")
	  Long merchantbranch_id;
		@Column(name="detail_text")
	  String detail_text;
		@Column(name="tag")
		  String tag;
		@Column(name="recommended")
		private String recommended;
		@Column(name="can_buy")
		private String can_buy;
		
		@Column(name="dealview_count")
		private int dealview_count;
		@Column(name="dealshare_count")
		private int dealshare_count;
		@Column(name="deallike_count")
		private int deallike_count;
		
		
		
		public int getDealview_count() {
			return dealview_count;
		}
		public void setDealview_count(int dealview_count) {
			this.dealview_count = dealview_count;
		}
		public int getDealshare_count() {
			return dealshare_count;
		}
		public void setDealshare_count(int dealshare_count) {
			this.dealshare_count = dealshare_count;
		}
		public int getDeallike_count() {
			return deallike_count;
		}
		public void setDeallike_count(int deallike_count) {
			this.deallike_count = deallike_count;
		}
		public String getRecommended() {
			return recommended;
		}
		public void setRecommended(String recommended) {
			this.recommended = recommended;
		}
		public String getCan_buy() {
			return can_buy;
		}
		public void setCan_buy(String can_buy) {
			this.can_buy = can_buy;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getAvailability() {
			return availability;
		}
		public void setAvailability(Long availability) {
			this.availability = availability;
		}
		public String getContent_type() {
			return content_type;
		}
		public void setContent_type(String content_type) {
			this.content_type = content_type;
		}
		public String getCouponcode() {
			return couponcode;
		}
		public void setCouponcode(String couponcode) {
			this.couponcode = couponcode;
		}
		public Timestamp getCreated_date() {
			return created_date;
		}
		public void setCreated_date(Timestamp created_date) {
			this.created_date = created_date;
		}
		public Double getDeal_discount_percent() {
			return deal_discount_percent;
		}
		public void setDeal_discount_percent(Double deal_discount_percent) {
			this.deal_discount_percent = deal_discount_percent;
		}
		public Double getDeal_price() {
			return deal_price;
		}
		public void setDeal_price(Double deal_price) {
			this.deal_price = deal_price;
		}
		public String getDeal_template() {
			return deal_template;
		}
		public void setDeal_template(String deal_template) {
			this.deal_template = deal_template;
		}
		public Integer getDeletestatus() {
			return deletestatus;
		}
		public void setDeletestatus(Integer deletestatus) {
			this.deletestatus = deletestatus;
		}
		public Double getDelivery_charge() {
			return delivery_charge;
		}
		public void setDelivery_charge(Double delivery_charge) {
			this.delivery_charge = delivery_charge;
		}
		public String getDelivery_time() {
			return delivery_time;
		}
		public void setDelivery_time(String delivery_time) {
			this.delivery_time = delivery_time;
		}
		public String getDetails() {
			return details;
		}
		public void setDetails(String details) {
			this.details = details;
		}
		public Timestamp getEnd_date() {
			return end_date;
		}
		public void setEnd_date(Timestamp end_date) {
			this.end_date = end_date;
		}
		public String getFood_type() {
			return food_type;
		}
		public void setFood_type(String food_type) {
			this.food_type = food_type;
		}
		public Timestamp getLast_modified_availability() {
			return last_modified_availability;
		}
		public void setLast_modified_availability(Timestamp last_modified_availability) {
			this.last_modified_availability = last_modified_availability;
		}
		public Timestamp getLast_modified_date() {
			return last_modified_date;
		}
		public void setLast_modified_date(Timestamp last_modified_date) {
			this.last_modified_date = last_modified_date;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getOpening_quantity() {
			return opening_quantity;
		}
		public void setOpening_quantity(Integer opening_quantity) {
			this.opening_quantity = opening_quantity;
		}
		public Double getOriginal_price() {
			return original_price;
		}
		public void setOriginal_price(Double original_price) {
			this.original_price = original_price;
		}
		public Integer getPublished() {
			return published;
		}
		public void setPublished(Integer published) {
			this.published = published;
		}
		public Integer getRating() {
			return rating;
		}
		public void setRating(Integer rating) {
			this.rating = rating;
		}
		public Integer getReedem() {
			return reedem;
		}
		public void setReedem(Integer reedem) {
			this.reedem = reedem;
		}
		public Timestamp getStart_date() {
			return start_date;
		}
		public void setStart_date(Timestamp start_date) {
			this.start_date = start_date;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Long getFood_category_id() {
			return food_category_id;
		}
		public void setFood_category_id(Long food_category_id) {
			this.food_category_id = food_category_id;
		}
		public Long getMerchantbranch_id() {
			return merchantbranch_id;
		}
		public void setMerchantbranch_id(Long merchantbranch_id) {
			this.merchantbranch_id = merchantbranch_id;
		}
		public String getDetail_text() {
			return detail_text;
		}
		public void setDetail_text(String detail_text) {
			this.detail_text = detail_text;
		}
		public String getTag() {
			return tag;
		}
		public void setTag(String tag) {
			this.tag = tag;
		}
	
	
	  
}
