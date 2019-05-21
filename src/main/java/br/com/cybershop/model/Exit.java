package br.com.cybershop.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Exit {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long exitId;
	@Temporal(value=TemporalType.TIMESTAMP)
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
