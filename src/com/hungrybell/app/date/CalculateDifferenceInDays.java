package com.hungrybell.app.date;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalculateDifferenceInDays {

	public boolean checkAvailability(String date1, String date2) {
		try {
			
			String time1 = "00:00";
			String time2 = "23:59";
			String format = "yyyy-MM-dd";
			SimpleDateFormat sdf = new SimpleDateFormat(format);
		
			Date dateObj1 = sdf.parse(date1 + " " + time1);
			Date dateObj2 = sdf.parse(date2 + " " + time2);
			
			DecimalFormat crunchifyFormatter = new DecimalFormat("###,###");
			long diff = dateObj2.getTime() - dateObj1.getTime();
			int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
			if (diffDays >= 0) 
			{
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public static void main(String s[])
	{
		GetDateFromSystem getDateFromSystem=new GetDateFromSystem();
		String systemdate=""+getDateFromSystem.getDateFromSystem();
		System.out.println("Date format from system"+systemdate);
		CalculateDifferenceInDays checkAvailabilityDate=new CalculateDifferenceInDays();
		System.out.println(checkAvailabilityDate.checkAvailability(systemdate, "2015-11-23 23:59:59"));
	}
	
	
}