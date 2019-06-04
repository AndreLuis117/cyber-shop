package br.com.cybershop.model;

import java.util.Date;

public class Promotion {
	
	private long promoId;
	private String promoName;
	private String description;
	private Date initialDate;
	private Date finalDate;
	
	public long getPromoId() {
		return promoId;
	}
	public void setPromoId(long promoId) {
		this.promoId = promoId;
	}
	public String getPromoName() {
		return promoName;
	}
	public void setPromoName(String promoName) {
		this.promoName = promoName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getInitialDate() {
		return initialDate;
	}
	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}
	public Date getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}
	
}
