package com.hungrybell.app.dao;

import java.util.ArrayList;
import java.util.List;

import com.hungrybell.app.model.NewPayment;
import com.hungrybell.app.vo.request.PayUmoneyBean;
import com.hungrybell.app.vo.response.Result;

public interface PaymentDao {

	
	public void addPaymentStatus(PayUmoneyBean employee) ;
	public void addPaymentStatus1(String mihpayid,String mode,String status,String key,String txnid,String amount,String discount,	String productinfo,	String firstname,	String lastname,String address1,String address2,String city,String state,String country,String zipcode,String email,String phone,String udf1,	String udf2,	String udf3,	String udf4,	String udf5,	String hash,	String Error,String PG_TYPE,String bank_ref_num,	String shipping_firstname,	String shipping_lastname,	String shipping_address1,	String shipping_address2,	String shipping_city,	String shipping_state,	String shipping_country,	String shipping_zipcode,	String shipping_phone,	String shipping_phoneverified,	String unmappedstatus,	String payuMoneyId ) ;
	public List<NewPayment> getIniciatedTxnidID();
	
    public String  updateIniciatedDataOfPayu(Result[] result);
}
