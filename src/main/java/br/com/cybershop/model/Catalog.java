package br.com.cybershop.model;

import java.util.Date;

public class Catalog {
	
	private long catalogId;
	private long name;
	private Date deadLine;

	public long getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(long catalogId) {
		this.catalogId = catalogId;
	}
	public long getName() {
		return name;
	}
	public void setName(long name) {
		this.name = name;
	}
	public Date getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}
	
}
