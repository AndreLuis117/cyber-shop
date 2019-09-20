package br.com.cybershop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Promotion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long promoId;
	@NotNull
	@NotEmpty(message="Preencha esse campo")
	private String promoName;
	@NotNull
	@NotEmpty(message="Preencha esse campo")
	private String description;
	@NotNull
	@Temporal(value=TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date initialDate;
	@NotNull
	@Temporal(value=TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date finalDate;
	//
	@OneToMany(cascade = CascadeType.ALL)
	private List<PromoItems> PromoItem = new ArrayList<PromoItems>(); 
	//
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
