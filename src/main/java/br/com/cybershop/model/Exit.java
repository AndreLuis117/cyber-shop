package br.com.cybershop.model;

import java.util.Date;

public class Exit {

	private long exitId;
	private Date date;
	private float quantity;
	
	public long getExitId() {
		return exitId;
	}
	public void setExitId(long exitId) {
		this.exitId = exitId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	
	
	
}
