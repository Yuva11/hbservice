package com.hungrybell.app.dao;

import java.util.List;

import com.hungrybell.app.model.Location;

public interface LocationDao {

	public Location getLocation(String locationName);
	public List<Location> getChangeLocationList();
	public Location getAllLocationList(Long locationid);
	public List<Location> getAllLocationLists();
	
}
