package com.hungrybell.app.vo.response;

import java.io.Serializable;

public class Body implements Serializable{
	
	private String coupon_code;

    private String discount_amount;

    private String first_name;

    private String landmark;

    private String order_amount;

    private String mobile_number;

    private String discount_method;

    private String email;

    private String address;

    private Orders[] orders;

    private String user_id;


    private String order_type;

    private String longitude;

    private String latitude;
    
    private String delivery_status;
   

    
    
    
    public String getDelivery_status() {
		return delivery_status;
	}

	public void setDelivery_status(String delivery_status) {
		this.delivery_status = delivery_status;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getCoupon_code ()
    {
        return coupon_code;
    }

    public void setCoupon_code (String coupon_code)
    {
        this.coupon_code = coupon_code;
    }

    public String getDiscount_amount ()
    {
        return discount_amount;
    }

    public void setDiscount_amount (String discount_amount)
    {
        this.discount_amount = discount_amount;
    }

    public String getFirst_name ()
    {
        return first_name;
    }

    public void setFirst_name (String first_name)
    {
        this.first_name = first_name;
    }

    public String getLandmark ()
    {
        return landmark;
    }

    public void setLandmark (String landmark)
    {
        this.landmark = landmark;
    }

    public String getOrder_amount ()
    {
        return order_amount;
    }

    public void setOrder_amount (String order_amount)
    {
        this.order_amount = order_amount;
    }

    public String getMobile_number ()
    {
        return mobile_number;
    }

    public void setMobile_number (String mobile_number)
    {
        this.mobile_number = mobile_number;
    }

    public String getDiscount_method ()
    {
        return discount_method;
    }

    public void setDiscount_method (String discount_method)
    {
        this.discount_method = discount_method;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getAddress ()
    {
        return address;
    }

    public void setAddress (String address)
    {
        this.address = address;
    }

    public Orders[] getOrders ()
    {
        return orders;
    }

    public void setOrders (Orders[] orders)
    {
        this.orders = orders;
    }

    public String getUser_id ()
    {
        return user_id;
    }

    public void setUser_id (String user_id)
    {
        this.user_id = user_id;
    }


    public String getOrder_type ()
    {
        return order_type;
    }

    public void setOrder_type (String order_type)
    {
        this.order_type = order_type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [coupon_code = "+coupon_code+", discount_amount = "+discount_amount+", first_name = "+first_name+", landmark = "+landmark+", order_amount = "+order_amount+", mobile_number = "+mobile_number+", discount_method = "+discount_method+", email = "+email+", address = "+address+", orders = "+orders+", user_id = "+user_id+", longitude = "+longitude+", latitude = "+latitude+", order_type = "+order_type+"]";
    }

}
