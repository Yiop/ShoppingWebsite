package com.synex.dao;

import java.util.List;

import com.synex.domain.CartItem;
import com.synex.domain.Product;

public interface ProductDao {
	
	public Product getProduct(int productId);
	
	public List<Product> getAllProduct();
	
	public void saveProduct(Product product);
	
	public CartItem getCart(int id);
	
	public void updateCart(int productId, double quantity);
	
	public void addQuantity(int productId);
	
	public void removeQuantity(int productId);
	
	public void removeProduct(int productId);
}
