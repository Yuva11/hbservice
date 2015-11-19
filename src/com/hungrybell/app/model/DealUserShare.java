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
@Table(name="deal_shared_by_user")
public class DealUserShare implements Serializable {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "id")
	  Long id;
		@Column(name = "deal_id")
	  Long deal_id;
		@Column(name = "user_id")
	  Long user_id;
		@Column(name = "deal_tag")
	  String deal_tag;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getDeal_id() {
			return deal_id;
		}
		public void setDeal_id(Long deal_id) {
			this.deal_id = deal_id;
		}
		public Long getUser_id() {
			return user_id;
		}
		public void setUser_id(Long user_id) {
			this.user_id = user_id;
		}
		public String getDeal_tag() {
			return deal_tag;
		}
		public void setDeal_tag(String deal_tag) {
			this.deal_tag = deal_tag;
		}
	  
}
