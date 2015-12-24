package com.hungrybell.app.vo.response;

import java.io.Serializable;

public class GoogleLocationResponseVO implements Serializable {
	 private Results[] results;

	    private String status;

	    public Results[] getResults ()
	    {
	        return results;
	    }

	    public void setResults (Results[] results)
	    {
	        this.results = results;
	    }

	    public String getStatus ()
	    {
	        return status;
	    }

	    public void setStatus (String status)
	    {
	        this.status = status;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [results = "+results+", status = "+status+"]";
	    }
}
