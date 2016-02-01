package com.hungrybell.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderfeedback")

public class FeedBack implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "order_id")
	private String order_id;

	@Column(name = "user_id")
	private String user_id;
	
	
	@Column(name = "rating1")
	private String rating1;
	
	@Column(name = "rating2")
	private String rating2;
	
	@Column(name = "rating3")
	private String rating3;
	
	@Column(name = "rating4")
	private String rating4;
	
	@Column(name = "feedback")
	private String feedback;
	
	
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

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	
	public String getRating1() {
		return rating1;
	}

	public void setRating1(String rating1) {
		this.rating1 = rating1;
	}

	public String getRating2() {
		return rating2;
	}

	public void setRating2(String rating2) {
		this.rating2 = rating2;
	}

	public String getRating3() {
		return rating3;
	}

	public void setRating3(String rating3) {
		this.rating3 = rating3;
	}

	public String getRating4() {
		return rating4;
	}

	public void setRating4(String rating4) {
		this.rating4 = rating4;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	
	
}
