package com.hungrybell.app.date;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetDateFromSystem 

{
	
	public Timestamp getDateFromSystem()
	{
//		   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
//		   Date date = new Date();
//		   Calendar cal = Calendar.getInstance();
//		   String datesystem=dateFormat.format(cal.getTime());
		   return new Timestamp(System.currentTimeMillis());
		   
					
	}
	public static void main(String ar[])
	{
		//System.out.print(GetDateFromSystem.getDateFromSystem());
		Timestamp ts=new Timestamp(System.currentTimeMillis());
		Date d=new Date();
		
		System.out.println(ts);
	}
	
}
