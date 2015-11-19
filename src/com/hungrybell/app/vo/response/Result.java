package com.hungrybell.app.vo.response;

public class Result {

	 private PostBackParam postBackParam;

	    private String merchantTransactionId;

	    public PostBackParam getPostBackParam ()
	    {
	        return postBackParam;
	    }

	    public void setPostBackParam (PostBackParam postBackParam)
	    {
	        this.postBackParam = postBackParam;
	    }

	    public String getMerchantTransactionId ()
	    {
	        return merchantTransactionId;
	    }

	    public void setMerchantTransactionId (String merchantTransactionId)
	    {
	        this.merchantTransactionId = merchantTransactionId;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [postBackParam = "+postBackParam+", merchantTransactionId = "+merchantTransactionId+"]";
	    }
}
