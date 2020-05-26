package com.synex.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_user")
public class NewCart implements Serializable {

	@EmbeddedId
	private NewCartKey key;
	
	
	@Column(name="quantity")
	private int quantity;


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void addQuantity() {
		this.quantity += 1;
	}
	
	public void removeQuantity() {
		this.quantity -= 1;
	}
	
}
