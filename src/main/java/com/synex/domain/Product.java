package com.synex.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="Products")
public class Product {
	
	@Id
	private int id;
	@NotEmpty(message="Product name can not be empty.")
	private String name;
	private double cost;
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="cart_id")
	private CartItem cartItem;
	@ColumnDefault("0") 
	//@NotEmpty(message="Quantity name can not be empty")
	private double quantity;
	private String description;
	private int category;
	private String img;
	
	
	
	public Product() {
		
	}

	public Product(int id, @NotEmpty(message = "Product name can not be empty.") String name, double cost,
			CartItem cartItem, double quantity, String description, int category, String img) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.cartItem = cartItem;
		this.quantity = quantity;
		this.description = description;
		this.category = category;
		this.img = img;
	}









	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public CartItem getCartItem() {
		return cartItem;
	}
	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity += quantity;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public int getCategory() {
		return category;
	}




	public void setCategory(int category) {
		this.category = category;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	
	
	
}
