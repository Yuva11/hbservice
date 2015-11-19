package com.hungrybell.app.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hungrybell.app.date.GetDateFromSystem;
import com.hungrybell.app.model.NewOrderDetails;
import com.hungrybell.app.model.NewPayment;
import com.hungrybell.app.vo.request.PayUmoneyBean;
import com.hungrybell.app.vo.response.Result;
@Repository("PaymentDao")
public class PaymentDaoImpl implements PaymentDao{
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	Transaction tx = null;
	@Override
	public void addPaymentStatus(PayUmoneyBean payUmoneyVO) 
	{
		try
		{
		NewPayment payment = new NewPayment();
		
		
	/*	payment.setMihpayid(payUmoneyVO.getMihpayid());
        payment.setMode(payUmoneyVO.getMode());	
        payment.setStatus(payUmoneyVO.getStatus());
        payment.setKey(payUmoneyVO.getKey());
        payment.setTxnid(payUmoneyVO.getTxnid());
        payment.setAmount(payUmoneyVO.getAmount());
        payment.setDiscount(payUmoneyVO.getDiscount());
        payment.setProductinfo(payUmoneyVO.getProductinfo());
        payment.setFirstname(payUmoneyVO.getFirstname());
        payment.setLastname(payUmoneyVO.getLastname());
        payment.setAddress1(payUmoneyVO.getAddress1());
        payment.setAddress2(payUmoneyVO.getAddress2());
        payment.setCity(payUmoneyVO.getCity());
        payment.setState(payUmoneyVO.getState());
        payment.setCountry(payUmoneyVO.getCountry());
        payment.setZipcode(payUmoneyVO.getZipcode());
        payment.setEmail(payUmoneyVO.getEmail());
        payment.setPhone(payUmoneyVO.getPhone());
        payment.setUdf1(payUmoneyVO.getUdf1());
        payment.setUdf2(payUmoneyVO.getUdf2());
        payment.setUdf3(payUmoneyVO.getUdf3());
        payment.setUdf4(payUmoneyVO.getUdf4());
        payment.setUdf5(payUmoneyVO.getUdf5());
        payment.setHash(payUmoneyVO.getHash());
        payment.setError(null);
        payment.setPG_TYPE(null);
        payment.setBank_ref_num(payUmoneyVO.getBank_ref_num());
        payment.setShipping_firstname(payUmoneyVO.getShipping_firstname());
        payment.setShipping_lastname(payUmoneyVO.getShipping_lastname());
        payment.setShipping_address1(payUmoneyVO.getShipping_address1());
        payment.setShipping_address2(payUmoneyVO.getShipping_address2());
        payment.setShipping_city(payUmoneyVO.getShipping_city());
        payment.setShipping_state(payUmoneyVO.getShipping_state());
        payment.setShipping_country(payUmoneyVO.getShipping_country());
        payment.setShipping_zipcode(payUmoneyVO.getShipping_zipcode());
        payment.setShipping_phone(payUmoneyVO.getShipping_phone());
        payment.setShipping_phoneverified(payUmoneyVO.getShipping_phoneverified());
        payment.setUnmappedstatus(payUmoneyVO.getUnmappedstatus());
        payment.setPayuMoneyId(payUmoneyVO.getPayuMoneyId());
	    sessionFactory.getCurrentSession().save(payment);
*/		}catch(Exception ek)
		{
			ek.printStackTrace();
			
		}

		
/*		sessionFactory.getCurrentSession().save(payment);	
*/		
	}
	

	public void addPaymentStatus1(String mihpayid,String mode,String status,String key,String txnid,String amount,String discount,	String productinfo,	String firstname,	String lastname,String address1,String address2,String city,String state,String country,String zipcode,String email,String phone,String udf1,	String udf2,	String udf3,	String udf4,	String udf5,	String hash,	String Error,String PG_TYPE,String bank_ref_num,	String shipping_firstname,	String shipping_lastname,	String shipping_address1,	String shipping_address2,	String shipping_city,	String shipping_state,	String shipping_country,	String shipping_zipcode,	String shipping_phone,	String shipping_phoneverified,	String unmappedstatus,	String payuMoneyId) 
	{
		try
		{
		NewPayment payment = new NewPayment();
		
		
		payment.setMihpayid(mihpayid);
        payment.setMode(mode);	
        payment.setStatus(status);
        payment.setKey(key);
        payment.setTxnid(txnid);
        payment.setAmount(amount);
        payment.setDiscount(discount);
        payment.setProductinfo(productinfo);
        payment.setFirstname(firstname);
        payment.setLastname(lastname);
        payment.setAddress1(address1);
        payment.setAddress2(address2);
        payment.setCity(city);
        payment.setState(state);
        payment.setCountry(country);
        payment.setZipcode(zipcode);
        payment.setEmail(email);
        payment.setPhone(phone);
        payment.setUdf1(udf1);
        payment.setUdf2(udf2);
        payment.setUdf3(udf3);
        payment.setUdf4(udf4);
        payment.setUdf5(udf5);
        payment.setHash(hash);
        payment.setError(Error);
        payment.setPG_TYPE(PG_TYPE);
        payment.setBank_ref_num(bank_ref_num);
        payment.setShipping_firstname(shipping_firstname);
        payment.setShipping_lastname(shipping_lastname);
        payment.setShipping_address1(shipping_address1);
        payment.setShipping_address2(shipping_address2);
        payment.setShipping_city(shipping_city );
        payment.setShipping_state(shipping_state);
        payment.setShipping_country(shipping_country);
        payment.setShipping_zipcode(shipping_zipcode);
        payment.setShipping_phone(shipping_phone);
        payment.setShipping_phoneverified(shipping_phoneverified);
        payment.setUnmappedstatus(unmappedstatus);
        payment.setPayuMoneyId(payuMoneyId);
	    sessionFactory.getCurrentSession().save(payment);
		}catch(Exception ek)
		{
			ek.printStackTrace();
			
		}

		
/*		sessionFactory.getCurrentSession().save(payment);	
*/		
	}
	
	
	public List<NewPayment> getIniciatedTxnidID()
	{
		try {
			GetDateFromSystem getDateFromSystem = new GetDateFromSystem();
	        Calendar yesterdayMidnight = Calendar.getInstance();
	        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
		     yesterdayMidnight.set(Calendar.HOUR_OF_DAY, 0);
	        yesterdayMidnight.set(Calendar.MINUTE, 0);
	        yesterdayMidnight.set(Calendar.SECOND, 0);
	        String startTime=dateFormat.format(yesterdayMidnight.getTime());
			Calendar todayMidnight=Calendar.getInstance();
		    todayMidnight.set(Calendar.HOUR_OF_DAY, 23);
	        todayMidnight.set(Calendar.MINUTE, 59);
	        todayMidnight.set(Calendar.SECOND, 59);
	        String endTime=dateFormat.format(todayMidnight.getTime());
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(NewPayment.class);
		    criteria.add(Restrictions.between("payment_date", startTime, endTime+""));
			if (!criteria.list().isEmpty()) {
				return criteria.list();
			} else {
				return null;
			}
		} catch (Exception el) {
		}
		return null;
	}
	@Override
	public String updateIniciatedDataOfPayu(Result[] result) 
	{
	  int i=0;
	  GetDateFromSystem getDateFromSystem=new GetDateFromSystem();
	 	NewPayment newPayment[]=new NewPayment[result.length];
		System.out.println("result length - "+result.length);
		NewPayment newPayment3=null;
		for (Result newPayment2:result) 
		{
			String id=newPayment2.getMerchantTransactionId();
			Query hql = sessionFactory.getCurrentSession().createQuery("from  NewPayment where txnid= '"+ id + "'");
			@SuppressWarnings("unchecked")
			List<NewPayment> list=hql.list();
			if(list!=null && list.size()>0){
				Object obj=list.get(0);
				newPayment3=(NewPayment)obj;
			}else{
				newPayment3=new NewPayment();
			}
			newPayment3.setMihpayid(newPayment2.getPostBackParam().getMihpayid());
			newPayment3.setMode(newPayment2.getPostBackParam().getMode());
			newPayment3.setStatus(newPayment2.getPostBackParam().getStatus());
			newPayment3.setKey(newPayment2.getPostBackParam().getKey());
			newPayment3.setTxnid(newPayment2.getMerchantTransactionId());
			newPayment3.setAmount(newPayment2.getPostBackParam().getAmount());
			newPayment3.setDiscount(newPayment2.getPostBackParam().getDiscount());
			newPayment3.setProductinfo(newPayment2.getPostBackParam().getProductinfo());
			newPayment3.setFirstname(newPayment2.getPostBackParam().getFirstname());
			newPayment3.setLastname(newPayment2.getPostBackParam().getLastname());
			newPayment3.setAddress1(newPayment2.getPostBackParam().getAddress1());
			newPayment3.setAddress2(newPayment2.getPostBackParam().getAddress2());
			newPayment3.setCity(newPayment2.getPostBackParam().getCity());
			newPayment3.setState(newPayment2.getPostBackParam().getState());
			newPayment3.setCountry(newPayment2.getPostBackParam().getCountry());
			newPayment3.setZipcode(newPayment2.getPostBackParam().getZipcode());
			newPayment3.setEmail(newPayment2.getPostBackParam().getEmail());
			newPayment3.setPhone(newPayment2.getPostBackParam().getPhone());
	        newPayment3.setPG_TYPE(newPayment2.getPostBackParam().getPg_TYPE());
	        newPayment3.setBank_ref_num(newPayment2.getPostBackParam().getBank_ref_num());
	        newPayment3.setUnmappedstatus(newPayment2.getPostBackParam().getUnmappedstatus());
	        newPayment3.setPayuMoneyId(newPayment2.getPostBackParam().getPaymentId());
	        newPayment3.setPayment_date(""+getDateFromSystem.getDateFromSystem());
	        newPayment3.setCard_merchant_param(newPayment2.getPostBackParam().getCard_merchant_param());
	        
	    	try
			{
//	    		sessionFactory.getCurrentSession().clear();
	    		sessionFactory.getCurrentSession().saveOrUpdate(newPayment3);
			}
			catch(Exception ek){
				ek.printStackTrace();
				
			}
			        
		}
	
		return null;
	}
	

}
