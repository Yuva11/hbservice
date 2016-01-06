package com.hungrybell.app.vo.request;

import java.io.Serializable;

public class CheckDistanceRequestVO implements Serializable{

	 private String longitude;

	    private String latitude;

	    private String merchantbranch_id;
	    private String userId;

	    public String getLongitude ()
	    {
	        return longitude;
	    }

	    public void setLongitude (String longitude)
	    {
	        this.longitude = longitude;
	    }

	    public String getLatitude ()
	    {
	        return latitude;
	    }

	    public void setLatitude (String latitude)
	    {
	        this.latitude = latitude;
	    }

	    public String getMerchantbranch_id ()
	    {
	        return merchantbranch_id;
	    }

	    public void setMerchantbranch_id (String merchantbranch_id)
	    {
	        this.merchantbranch_id = merchantbranch_id;
	    }
	    
	    

	    public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		@Override
	    public String toString()
	    {
	        return "ClassPojo [longitude = "+longitude+", latitude = "+latitude+", merchantbranch_id = "+merchantbranch_id+"]";
	    }
	    
	    
}
