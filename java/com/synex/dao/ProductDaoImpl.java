package com.synex.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.synex.domain.CartItem;
import com.synex.domain.NewCart;
import com.synex.domain.NewCartKey;
import com.synex.domain.NewOrder;
import com.synex.domain.NewProduct;
import com.synex.domain.NewUser;
import com.synex.domain.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired(required=true)
	SessionFactory sessionFactory;
	
	Session session;

//	@Override
//	public NewProduct getProduct(int productId) {
//		
//		session = sessionFactory.openSession();
//		NewProduct product = session.load(NewProduct.class, productId);
//		System.out.println(product.getTitle());
//		return product;
//	}
	
	@Override
	public void saveProduct(NewProduct product) {
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(product);
		session.getTransaction().commit();
	}

	@Override
	public void saveUser(NewUser user) {
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
	}
	
	@Override
	public List<NewProduct> getAllProducts() {
		
		session = sessionFactory.openSession();
		List<NewProduct> listproduct = session.createCriteria(NewProduct.class).list();
		System.out.println(listproduct.size());
		return listproduct;
	}
	
	@Override
	public List<NewUser> getAllUsers() {
		
		session = sessionFactory.openSession();
		List<NewUser> listuser = session.createCriteria(NewUser.class).list();
		System.out.println(listuser.size());
		return listuser;
	}

	@Override
	public void addToCart(int productId, int userId) {
		
		session = sessionFactory.openSession();
		NewProduct product = session.load(NewProduct.class, productId);
		NewUser user = session.load(NewUser.class, userId);
		product.addUser(user);
		session.beginTransaction();
		session.saveOrUpdate(product);
		session.getTransaction().commit();
	}

	@Override
	public void saveOrder(NewOrder order, int userId) {
//		session = sessionFactory.openSession();
//		NewUser user = session.load(NewUser.class, userId);
//		user.addOrder(order);
//		order.setUser(user);
////		System.out.println(user.getId());
////		System.out.println(order.getCost());
////		System.out.println(order.getId());
////		System.out.println(order.getUser().getId());
////		user.addOrder(order);
//		session.beginTransaction();
//		session.saveOrUpdate(order);
//		session.getTransaction().commit();
//		System.out.println("Done!");
	}

	
	
	
//	@Override
//	public CartItem getCart(int cartId) {
//		session = sessionFactory.openSession();
//		CartItem cart = session.load(CartItem.class, cartId);
//		System.out.println("cart:" + cart.getProduct().size());
//		return cart;
//	}
//
//	@Override
//	public void updateCart(int productId, double quantity) {
//		
//		session = sessionFactory.openSession();
//		Product product = session.load(Product.class, productId);
//		product.setQuantity(quantity);
//		CartItem cartItem = session.load(CartItem.class, 1);
//		product.setCartItem(cartItem);
//		session.beginTransaction();
//		session.saveOrUpdate(product);
//		session.getTransaction().commit();
//	}
	
	@Override
	public void addQuantity(int productId, int userId) {
		
		session = sessionFactory.openSession();
		NewCart cart = session.get(NewCart.class, new NewCartKey(productId, userId));
		cart.addQuantity();
		session.beginTransaction();
		session.saveOrUpdate(cart);
		session.getTransaction().commit();
	}
	
	@Override
	public void removeQuantity(int productId, int userId) {
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		NewCart cart = session.get(NewCart.class, new NewCartKey(productId, userId));
		
		if (cart.getQuantity() == 1) {
			session.delete(cart);
		} else {
			cart.removeQuantity();
			session.saveOrUpdate(cart);
		}
		
		
		session.getTransaction().commit();
	}
	
	@Override
	public void removeProduct(int productId, int userId) {
		
		session = sessionFactory.openSession();
		NewCart cart = session.get(NewCart.class, new NewCartKey(productId, userId));
		session.beginTransaction();
		session.delete(cart);
		session.getTransaction().commit();
	}

	@Override
	public boolean authenticate(String username, String password) {
		session = sessionFactory.openSession();
		List<NewUser> listuser = session.createCriteria(NewUser.class).list();
		for (int i = 0; i < listuser.size(); ++i) {
			if (listuser.get(i).getFirstName().contentEquals(username) &&
					listuser.get(i).getPassword().contentEquals(password)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();
		NewProduct product = session.load(NewProduct.class, productId);
		session.beginTransaction();
		session.delete(product);
		session.getTransaction().commit();
	}
}
