package com.hungrybell.app.vo.response;

import java.io.Serializable;

public class CheckDistanceResponseVO implements Serializable {
	private String status;

	private String[] destination_addresses;

	private String[] origin_addresses;

	private Rows[] rows;
	private String  deliveryCharge;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String[] getDestination_addresses() {
		return destination_addresses;
	}

	public void setDestination_addresses(String[] destination_addresses) {
		this.destination_addresses = destination_addresses;
	}

	public String[] getOrigin_addresses() {
		return origin_addresses;
	}

	public void setOrigin_addresses(String[] origin_addresses) {
		this.origin_addresses = origin_addresses;
	}

	public Rows[] getRows() {
		return rows;
	}

	public void setRows(Rows[] rows) {
		this.rows = rows;
	}

	
	public String getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(String deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

	@Override
	public String toString() {
		return "ClassPojo [status = " + status + ", destination_addresses = "
				+ destination_addresses + ", origin_addresses = "
				+ origin_addresses + ", rows = " + rows + "]";
	}
	
	

}
