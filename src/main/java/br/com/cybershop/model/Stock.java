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
public class Stock {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long stockId;
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date dateOfLastUpdate;
	@Min(value=1, message="A quantidade de estoque deve ser igual ou maior que 0")
	private long quantity;
	@OneToOne(cascade=CascadeType.ALL)
	private Product product = new Product();
	
	public Stock() {
		setDateOfLastUpdate();	
	}
	
	public long getStockId() {
		return stockId;
	}
	public void setStockId(long stockId) {
		this.stockId = stockId;
	}
	public Date getDateOfLastUpdate() {
		return dateOfLastUpdate;
	}
	public void setDateOfLastUpdate() {
		Date dateNow = new Date();  
		this.dateOfLastUpdate = dateNow;
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
