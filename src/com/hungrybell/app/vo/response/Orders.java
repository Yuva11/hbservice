package com.hungrybell.app.vo.response;

public class Orders {
	 private Double amount;

	    private Long quantity;

	    private Long deal_id;

	 
	  

	    public Double getAmount() {
			return amount;
		}

		public void setAmount(Double amount) {
			this.amount = amount;
		}

		public Long getQuantity() {
			return quantity;
		}

		public void setQuantity(Long quantity) {
			this.quantity = quantity;
		}

		public Long getDeal_id() {
			return deal_id;
		}

		public void setDeal_id(Long deal_id) {
			this.deal_id = deal_id;
		}

		@Override
	    public String toString()
	    {
	        return "ClassPojo [amount = "+amount+", quantity = "+quantity+", deal_id = "+deal_id+"]";
	    }

}
