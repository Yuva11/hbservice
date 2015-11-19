package com.hungrybell.app.vo.response;

import java.io.Serializable;

public class Location  implements Serializable{
	 private String lon;

	    private String ts;

	    private String lat;

	    public String getLon ()
	    {
	        return lon;
	    }

	    public void setLon (String lon)
	    {
	        this.lon = lon;
	    }

	    public String getTs ()
	    {
	        return ts;
	    }

	    public void setTs (String ts)
	    {
	        this.ts = ts;
	    }

	    public String getLat ()
	    {
	        return lat;
	    }

	    public void setLat (String lat)
	    {
	        this.lat = lat;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [lon = "+lon+", ts = "+ts+", lat = "+lat+"]";
	    }

}
