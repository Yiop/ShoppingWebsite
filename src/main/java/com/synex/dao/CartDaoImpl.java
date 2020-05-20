package com.synex.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.synex.domain.CartItem;
import com.synex.domain.Product;

public class CartDaoImpl implements CartDao {

//	@Autowired(required=true)
//	SessionFactory sessionFactory;
//	
//	Session session;
//	
//	@Override
//	public List<CartItem> getAllCarts() {
//		session = sessionFactory.openSession();
//		List<CartItem> listcart = session.createCriteria(CartItem.class).list();
//		System.out.println(listcart.size());
//		return listcart;
//	}
//
//	@Override
//	public CartItem getCart(int cartId) {
//		session = sessionFactory.openSession();
//		CartItem cart = session.load(CartItem.class, cartId);
//		System.out.println("cart:" + cart.getProduct().size());
//		return cart;
//	}

}
