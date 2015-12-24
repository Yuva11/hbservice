package com.hungrybell.app.dao;

import java.util.List;

import com.hungrybell.app.model.Location;

public interface LocationDao {

	public Location getLocation(String locationName);
	public List<Location> getChangeLocationList();
	public Location getAllLocationList(Long locationid);
	public List<Location> getAllLocationLists();
	public void saveNewLocation(Double latitude,Double longitude,String locationName,long cityId);
	public boolean locationExists(long cityId, String location_name1);
	
}
