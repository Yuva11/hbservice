package com.hungrybell.app.vo.response;

public class Distance {
	private String text;

	private double value;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ClassPojo [text = " + text + ", value = " + value + "]";
	}

}
