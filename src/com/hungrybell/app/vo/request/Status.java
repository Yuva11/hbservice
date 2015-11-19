package com.hungrybell.app.vo.request;

import java.io.Serializable;

public class Status implements Serializable {
	 private String code;

	    public String getCode ()
	    {
	        return code;
	    }

	    public void setCode (String code)
	    {
	        this.code = code;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [code = "+code+"]";
	    }

}
