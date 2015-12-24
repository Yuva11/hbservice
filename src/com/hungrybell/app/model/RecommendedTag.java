
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
@Table(name="recommended_taglist")
public class RecommendedTag implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name = "id")
	private Long id;
	
	
	@Column(name = "location_name")
	private String location_name;

	@Column(name = "tagName_of_location")
	private String tagName_of_location;
	
	@Column(name = "latitude")
	private double latitude;
	
	@Column(name = "longitude")
	private double longitude;
	
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation_name() {
		return location_name;
	}

	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}

	public String getTagName_of_location() {
		return tagName_of_location;
	}

	public void setTagName_of_location(String tagName_of_location) {
		this.tagName_of_location = tagName_of_location;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

		

	
		
	
}
