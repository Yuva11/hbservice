package com.hungrybell.app.vo.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

public class DealVO implements Serializable {

	private List<String> dealTag;

	public List<String> getDealTag() {
		return dealTag;
	}

	public void setDealTag(List<String> dealTag) {
		this.dealTag = dealTag;
	}

	public Long getDealId() {
		return dealId;
	}

	public void setDealId(Long dealId) {
		this.dealId = dealId;
	}

	private Long dealId;
	private Long merchantBranchid;


	private Double dealPrice;

	private String name;
	private String details;

	private String detailText;

	private String imageUrl;

	private String merchantName;

	private String merchantAddress;

	private Double merchantLatitude;
	private Double merchantLongitude;
	private String merchantLogo;

	private Long min_order_value;
	private String operation_time;

	private int dealview_count;

	private int dealshare_count;
	private int deallike_count;
	
	private int opening_quantity;

	private List<String> deliveryTypes;

	public List<String> getDeliveryTypes() {
		return deliveryTypes;
	}

	public void setDeliveryTypes(List<String> deliveryTypes) {
		this.deliveryTypes = deliveryTypes;
	}

	public int getDealview_count() {
		return dealview_count;
	}

	public void setDealview_count(int dealview_count) {
		this.dealview_count = dealview_count;
	}

	public int getDealshare_count() {
		return dealshare_count;
	}

	public void setDealshare_count(int dealshare_count) {
		this.dealshare_count = dealshare_count;
	}

	public int getDeallike_count() {
		return deallike_count;
	}

	public void setDeallike_count(int deallike_count) {
		this.deallike_count = deallike_count;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getMerchantLogo() {
		return merchantLogo;
	}

	public void setMerchantLogo(String merchantLogo) {
		this.merchantLogo = merchantLogo;
	}

	private String content_type;

	public String getContent_type() {
		return content_type;
	}

	public void setContent_type(String content_type) {
		this.content_type = content_type;
	}

	public Double getMerchantLatitude() {
		return merchantLatitude;
	}

	public void setMerchantLatitude(Double merchantLatitude) {
		this.merchantLatitude = merchantLatitude;
	}

	public Double getMerchantLongitude() {
		return merchantLongitude;
	}

	public void setMerchantLongitude(Double merchantLongitude) {
		this.merchantLongitude = merchantLongitude;
	}

	private Double distance;

	private Long availability;
	private Double original_price;

	public Double getOriginal_price() {
		return original_price;
	}

	public void setOriginal_price(Double original_price) {
		this.original_price = original_price;
	}

	private String can_buy;

	public String getCan_buy() {
		return can_buy;
	}

	public void setCan_buy(String can_buy) {
		this.can_buy = can_buy;
	}

	public Double getDealPrice() {
		return dealPrice;
	}

	public void setDealPrice(Double dealPrice) {
		this.dealPrice = dealPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetailText() {
		return detailText;
	}

	public void setDetailText(String detailText) {
		this.detailText = detailText;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getMerchantAddress() {
		return merchantAddress;
	}

	public void setMerchantAddress(String merchantAddress) {
		this.merchantAddress = merchantAddress;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Long getAvailability() {
		return availability;
	}

	public void setAvailability(Long availability) {
		this.availability = availability;
	}

	public Long getMin_order_value() {
		return min_order_value;
	}

	public void setMin_order_value(Long min_order_value) {
		this.min_order_value = min_order_value;
	}

	public String getOperation_time() {
		return operation_time;
	}

	public void setOperation_time(String operation_time) {
		this.operation_time = operation_time;
	}

	public Long getMerchantBranchid() {
		return merchantBranchid;
	}

	public void setMerchantBranchid(Long merchantBranchid) {
		this.merchantBranchid = merchantBranchid;
	}

	public int getOpening_quantity() {
		return opening_quantity;
	}

	public void setOpening_quantity(int opening_quantity) {
		this.opening_quantity = opening_quantity;
	}


}
