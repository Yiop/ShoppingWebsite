package com.synex.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.synex.domain.CartItem;
import com.synex.domain.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired(required=true)
	SessionFactory sessionFactory;
	
	Session session;

	@Override
	public Product getProduct(int productId) {
		
		session = sessionFactory.openSession();
		Product product = session.load(Product.class, productId);
		System.out.println(product.getName());
		return product;
	}
	
	@Override
	public List<Product> getAllProduct() {
		
		session = sessionFactory.openSession();
		List<Product> listproduct = session.createCriteria(Product.class).list();
		System.out.println(listproduct.size());
		return listproduct;
	}
	
	@Override
	public void saveProduct(Product product) {
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(product);
		session.getTransaction().commit();
	}
	
	@Override
	public CartItem getCart(int cartId) {
		session = sessionFactory.openSession();
		CartItem cart = session.load(CartItem.class, cartId);
		System.out.println("cart:" + cart.getProduct().size());
		return cart;
	}

	@Override
	public void updateCart(int productId, double quantity) {
		
		session = sessionFactory.openSession();
		Product product = session.load(Product.class, productId);
		product.setQuantity(quantity);
		CartItem cartItem = session.load(CartItem.class, 1);
		product.setCartItem(cartItem);
		session.beginTransaction();
		session.saveOrUpdate(product);
		session.getTransaction().commit();
	}
	
	@Override
	public void addQuantity(int productId) {
		System.out.println("here here");
		session = sessionFactory.openSession();
		Product product = session.load(Product.class, productId);
		product.setQuantity(1);
		session.beginTransaction();
		session.saveOrUpdate(product);
		session.getTransaction().commit();
	}
	
	@Override
	public void removeQuantity(int productId) {
		
		session = sessionFactory.openSession();
		Product product = session.load(Product.class, productId);
		if (product.getQuantity() == 1) {
			CartItem cartItem = session.load(CartItem.class, 0);
			product.setCartItem(cartItem);
		} else {
			product.setQuantity(-1);
		}
		session.beginTransaction();
		session.saveOrUpdate(product);
		session.getTransaction().commit();
	}
	
	@Override
	public void removeProduct(int productId) {
		
		session = sessionFactory.openSession();
		Product product = session.load(Product.class, productId);
		CartItem cartItem = session.load(CartItem.class, 0);
		product.setCartItem(cartItem);
		session.beginTransaction();
		session.saveOrUpdate(product);
		session.getTransaction().commit();
	}
}
