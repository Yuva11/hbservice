package com.hungrybell.util;

public class DistanceCalculatorUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(distance(12.9104723, 77.6851335, 12.9712301, 77.7148376, "M") + " Miles\n");
		System.out.println(distance(12.9081357, 77.647608, 12.9591722, 77.697419, "K") + " Kilometers\n");
		//System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "N") + " Nautical Miles\n");

	}

	
	public static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		  double theta = lon1 - lon2;
		  double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		  dist = Math.acos(dist);
		  dist = rad2deg(dist);
		  dist = dist * 60 * 1.1515;
		  if (unit == "K") {
		    dist = dist * 1.609344;
		  } else if (unit == "N") {
		    dist = dist * 0.8684;
		    }
		  return (dist);
	}
		  private static double deg2rad(double deg) {
		  return (deg * Math.PI / 180.0);
		  }
		private static double rad2deg(double rad) {
		  return (rad * 180 / Math.PI);
		}
		
		

}
