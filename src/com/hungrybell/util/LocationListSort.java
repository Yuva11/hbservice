package com.hungrybell.util;

public class LocationListSort implements Comparable {
	
	
double distance;
String distanceName;


LocationListSort(double distanse,String distanseName)
{
	this.distance=distanse;
	this.distanceName=distanseName;
	
}

	

	public int compareTo(Object o) 
	{
		LocationListSort listSort=(LocationListSort)o;
		if(distance==listSort.distance)
		{
			return 0;
		}
		else if(distance>listSort.distance)
		{
			return 1;
		}
		else
		{
		  return 0;
		}
	}
	
	
	

}
