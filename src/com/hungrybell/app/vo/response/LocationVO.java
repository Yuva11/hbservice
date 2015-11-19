package com.hungrybell.app.vo.response;

import java.io.Serializable;

import com.hungrybell.util.LocationListSort;

public class LocationVO implements Serializable, Comparable {

	private Double distance;
	private String locationName;
	private String latitude;
	private String longitude;
	

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public int compareTo(Object o) {
		LocationVO listSort = (LocationVO) o;
		if (distance == listSort.distance) {
			return 0;
		} else if (distance > listSort.distance) {
			return 1;
		} else {
			return -1;
		}
	}

}
