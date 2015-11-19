package com.hungrybell.app.vo.response;

import java.io.Serializable;
import java.util.List;

public class MyOrderStatus implements Serializable{

	      String status;
		
		private List<Myorderdetails> myorderdetails;

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public List<Myorderdetails> getMyorderdetails() {
			return myorderdetails;
		}

		public void setMyorderdetails(List<Myorderdetails> myorderdetails) {
			this.myorderdetails = myorderdetails;
		}

	
		
		

}
