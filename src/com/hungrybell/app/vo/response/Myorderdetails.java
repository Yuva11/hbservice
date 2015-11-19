package com.hungrybell.app.vo.response;

import java.io.Serializable;

public class Myorderdetails implements Serializable
{
	
	 private Body body;

	    public Body getBody ()
	    {
	        return body;
	    }

	    public void setBody (Body body)
	    {
	        this.body = body;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [body = "+body+"]";
	    }
	

}
