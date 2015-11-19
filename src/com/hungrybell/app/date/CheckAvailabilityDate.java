package com.hungrybell.app.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckAvailabilityDate 
{
	public boolean checkAvailability(String start_date,String end_date)
	{
		Date validityStartDate=null;
        Date validityEndDate=null;
        
        
	    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		try
		{
		validityStartDate=simpleDateFormat.parse(start_date);
        
		validityEndDate=simpleDateFormat.parse(end_date);
        validityEndDate.setHours(23);
        validityEndDate.setHours(59);
        validityEndDate.setHours(59);
        
        Date curreDate=new Date();
        System.out.println(validityEndDate+" : "+simpleDateFormat.format(curreDate));
        if(curreDate.after(validityStartDate) && curreDate.before(validityEndDate))
        {
        	return true;
        }
		}
		catch(Exception e)
		{
			System.out.println("Exceprion:"+e);
		}
		return false;
		
	}
	
	public static void main(String s[])
	{
		CheckAvailabilityDate checkAvailabilityDate=new CheckAvailabilityDate();
		System.out.println(checkAvailabilityDate.checkAvailability("2015-09-09 12:00:00", "2015-9-34 24:00:00"));
	}

}
