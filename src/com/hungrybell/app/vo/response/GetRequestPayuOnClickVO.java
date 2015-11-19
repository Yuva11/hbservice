package com.hungrybell.app.vo.response;

import java.io.Serializable;

public class GetRequestPayuOnClickVO implements Serializable{
	String txnid;

	public String getTxnid() {
		return txnid;
	}

	public void setTxnid(String txnid) {
		this.txnid = txnid;
	}
	

}
