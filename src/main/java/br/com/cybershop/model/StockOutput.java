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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;

@Entity
public class StockOutput {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long exitId;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date date;
	@Min(value=1, message="A quantidade de entrada deve ser igual ou maior que 1")
	private long quantity;
	@OneToOne(cascade=CascadeType.ALL)
	private Product product = new Product();
	
	public StockOutput() {
		setDate();
	}
	
	public long getExitId() {
		return exitId;
	}
	public void setExitId(long exitId) {
		this.exitId = exitId;
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

}
