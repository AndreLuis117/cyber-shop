package br.com.cybershop.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;


@Entity
public class StockInput {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long entryId;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date date;
	@Min(value=1, message="A quantidade de entrada deve ser igual ou maior que 1")
	private long quantity;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Product product = new Product();
	
	public long getEntryId() {
		return entryId;
	}
	public void setEntryId(long entryId) {
		this.entryId = entryId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate() {
	    Date dateNow = new Date();  
		this.date = dateNow;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	public StockInput() {
		setDate();
	}
	
}
