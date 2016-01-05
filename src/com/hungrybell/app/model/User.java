package com.hungrybell.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "delete_status")
	private int delete_status;

	@Column(name = "name")
	private String first_name;
	@Column(name = "email")
	private String email;
	@Column(name = "contact_number")
	private String mobile_number;
	@Column(name = "username")
	private String username;

	@Column(name = "password_hash")
	private String password_hash;
	
	@Column(name = "new_password_hash")
	private String new_password_hash;
	
	@Column(name = "role_id")
	private Long role_id;
	
	@Column(name = "branch_id")
	private String branch_id;
	
	
	
	
	
	

	public String getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public String getNew_password_hash() {
		return new_password_hash;
	}

	public void setNew_password_hash(String new_password_hash) {
		this.new_password_hash = new_password_hash;
	}

	public String getPassword_hash() {
		return password_hash;
	}

	public void setPassword_hash(String password_hash) {
		this.password_hash = password_hash;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDevice_id() {
		return device_id;
	}

	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}

	@Column(name = "device_id")
	private String device_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDelete_status() {
		return delete_status;
	}

	public void setDelete_status(int delete_status) {
		this.delete_status = delete_status;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
