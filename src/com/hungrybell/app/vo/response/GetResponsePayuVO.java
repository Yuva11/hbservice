package com.hungrybell.app.vo.response;

import java.io.Serializable;

public class GetResponsePayuVO implements Serializable {
	 private String message;

	    private String responseCode;

	    private Result[] result;

	    private String status;

	    private String errorCode;

	    public String getMessage ()
	    {
	        return message;
	    }

	    public void setMessage (String message)
	    {
	        this.message = message;
	    }

	  
	    
	    public String getResponseCode() {
			return responseCode;
		}

		public void setResponseCode(String responseCode) {
			this.responseCode = responseCode;
		}

		public String getErrorCode() {
			return errorCode;
		}

		public void setErrorCode(String errorCode) {
			this.errorCode = errorCode;
		}

		public Result[] getResult ()
	    {
	        return result;
	    }

	    public void setResult (Result[] result)
	    {
	        this.result = result;
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
	        return "ClassPojo [message = "+message+", responseCode = "+responseCode+", result = "+result+", status = "+status+", errorCode = "+errorCode+"]";
	    }
}
