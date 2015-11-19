package com.hungrybell.app.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LastDateCalculate {
	
	public static void main(String a[])
	{
		        Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, -7);
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
				
			    String datesystem=dateFormat.format(cal.getTime());
					
					
				System.out.println("Date = "+ datesystem);
	}
	
	

}
