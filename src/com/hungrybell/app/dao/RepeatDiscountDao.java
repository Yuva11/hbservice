package com.hungrybell.app.dao;

import com.hungrybell.app.model.RepeatDiscount;

public interface RepeatDiscountDao {
	public RepeatDiscount getRepeatDiscount(int orderNumber);
	public boolean getCheckExistsUser(int orderNumber);

}
