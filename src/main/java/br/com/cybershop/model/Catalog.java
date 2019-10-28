package br.com.cybershop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Catalog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long catalogId;
	@NotNull
	@NotEmpty(message = "Preencha essa campo")
	private String name;
	@Temporal(value = TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date deadLine;

	@OneToMany(cascade= CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="catalog_id")
	private List<CatalogItems> catalogItems = new ArrayList<CatalogItems>();
	
	public long getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(long catalogId) {
		this.catalogId = catalogId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}
	public List<CatalogItems> getCatalogItems() {
		return catalogItems;
	}
	public void setCatalogItems(List<CatalogItems> catalogItems) {
		this.catalogItems = catalogItems;
	}
	

}
