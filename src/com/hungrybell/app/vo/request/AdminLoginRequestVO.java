package com.hungrybell.app.vo.request;

import java.io.Serializable;

public class AdminLoginRequestVO implements Serializable {
	String user_email;
	String confirm_pass;
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getConfirm_pass() {
		return confirm_pass;
	}
	public void setConfirm_pass(String confirm_pass) {
		this.confirm_pass = confirm_pass;
	}
	
	

}
