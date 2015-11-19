package com.hungrybell.app.vo.response;

public class DeliveryTrackingResponseVO {

	 private String townrush_shipment_id;

	    private String status;

	    private Assigned_worker assigned_worker;

	    private String created_at;

	    private String webhook_id;

	    private String shipment_id;

	    private String deadline;

	    public String getTownrush_shipment_id ()
	    {
	        return townrush_shipment_id;
	    }

	    public void setTownrush_shipment_id (String townrush_shipment_id)
	    {
	        this.townrush_shipment_id = townrush_shipment_id;
	    }

	    public String getStatus ()
	    {
	        return status;
	    }

	    public void setStatus (String status)
	    {
	        this.status = status;
	    }

	    public Assigned_worker getAssigned_worker ()
	    {
	        return assigned_worker;
	    }

	    public void setAssigned_worker (Assigned_worker assigned_worker)
	    {
	        this.assigned_worker = assigned_worker;
	    }

	    public String getCreated_at ()
	    {
	        return created_at;
	    }

	    public void setCreated_at (String created_at)
	    {
	        this.created_at = created_at;
	    }

	    public String getWebhook_id ()
	    {
	        return webhook_id;
	    }

	    public void setWebhook_id (String webhook_id)
	    {
	        this.webhook_id = webhook_id;
	    }

	    public String getShipment_id ()
	    {
	        return shipment_id;
	    }

	    public void setShipment_id (String shipment_id)
	    {
	        this.shipment_id = shipment_id;
	    }

	    public String getDeadline ()
	    {
	        return deadline;
	    }

	    public void setDeadline (String deadline)
	    {
	        this.deadline = deadline;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [townrush_shipment_id = "+townrush_shipment_id+", status = "+status+", assigned_worker = "+assigned_worker+", created_at = "+created_at+", webhook_id = "+webhook_id+", shipment_id = "+shipment_id+", deadline = "+deadline+"]";
	    }
	
	
}
