package com.hungrybell.app.vo.response;

import java.io.Serializable;

public class DeliveryTrackingResponseRoadRunnrVO implements Serializable{
	  private String status;

	    private String order_id;
	    
	    private String driver_name;
	    private String driver_number;
	    private String timestamp;
	
	    
	    

	    public String getDriver_name() {
			return driver_name;
		}

		public void setDriver_name(String driver_name) {
			this.driver_name = driver_name;
		}

		public String getDriver_number() {
			return driver_number;
		}

		public void setDriver_number(String driver_number) {
			this.driver_number = driver_number;
		}

		public String getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}

		public String getStatus ()
	    {
	        return status;
	    }

	    public void setStatus (String status)
	    {
	        this.status = status;
	    }

	    public String getOrder_id ()
	    {
	        return order_id;
	    }

	    public void setOrder_id (String order_id)
	    {
	        this.order_id = order_id;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [status = "+status+", order_id = "+order_id+"]";
	    }
}
