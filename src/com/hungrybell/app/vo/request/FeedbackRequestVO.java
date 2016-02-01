package com.hungrybell.app.vo.request;

public class FeedbackRequestVO {
	
	private String order_id;

	private String user_id;

	private String rating;
	private String rating1;
	private String rating2;
	private String rating3;
	private String rating4;

	private String feedback;

	private String timestamp;

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

	

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
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

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}



}
