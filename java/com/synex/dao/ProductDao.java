package com.synex.dao;

import java.util.List;

import com.synex.domain.CartItem;
import com.synex.domain.NewOrder;
import com.synex.domain.NewProduct;
import com.synex.domain.NewUser;
import com.synex.domain.Product;

public interface ProductDao {
	
//	public NewProduct getProduct(int productId);
	
	public void saveProduct(NewProduct product);
	
	public void saveUser(NewUser user);
	
	public List<NewProduct> getAllProducts();
	
	public List<NewUser> getAllUsers();
	
	public void addToCart(int productId, int userId);
	
	public void saveOrder(NewOrder order, int userId);
//	public CartItem getCart(int id);
//	
//	public void updateCart(int productId, double quantity);
//	
	public void addQuantity(int productId, int userId);
	
	public void removeQuantity(int productId, int userId);
	
	public void removeProduct(int productId, int userId);
	
	public boolean authenticate(String username, String password);
	
	public void deleteProduct(int productId);
}
