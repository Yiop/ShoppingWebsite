package com.synex.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

import com.synex.domain.Cart;
@Entity
@Table(name="CartItems")
public class CartItem {

	@Id
	private int id;
	
	private int quantity;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ShoppingCardId")
	private Cart ShoppingCardId;
	
	@OneToMany(mappedBy="cartItem",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	private List<Product> product;
	
	public CartItem() {
		
	}
	
	public CartItem(int id, int quantity) {
		
		this.id = id;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart getShoppingCardId() {
		return ShoppingCardId;
	}

	public void setShoppingCardId(Cart shoppingCardId) {
		ShoppingCardId = shoppingCardId;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	
	
	
}
