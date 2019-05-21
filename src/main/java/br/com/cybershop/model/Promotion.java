package br.com.cybershop.model;

import java.util.Date;

public class Promotion {
	
	private long promotionId;
	private String promotionName;
	private String description;
	private Date initialDate;
	private Date finalDate;
	public long getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(long promotionId) {
		this.promotionId = promotionId;
	}
	public String getPromotionName() {
		return promotionName;
	}
	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
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
