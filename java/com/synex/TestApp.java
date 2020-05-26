package com.synex;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.synex.domain.NewCart;
import com.synex.domain.NewCartKey;
import com.synex.domain.NewCategory;
import com.synex.domain.NewCategoryDetail;
import com.synex.domain.NewOrder;
import com.synex.domain.NewProduct;
import com.synex.domain.NewReview;
import com.synex.domain.NewUser;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(NewUser.class)
				.addAnnotatedClass(NewCategoryDetail.class)
				.addAnnotatedClass(NewProduct.class)
				.addAnnotatedClass(NewReview.class)
				.addAnnotatedClass(NewCategory.class)
				.addAnnotatedClass(NewOrder.class)
				.addAnnotatedClass(NewCart.class)
				.addAnnotatedClass(NewCartKey.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {			

			session.beginTransaction();
			
//			NewCart cart = session.get(NewCart.class, new NewCartKey(10, 1));
//			cart.addQuantity();
//			session.saveOrUpdate(cart);
//			session.getTransaction().commit();
			
			NewUser tempUser = session.load(NewUser.class, 1);
			NewOrder tempOrder1 = new NewOrder(123);
			NewOrder tempOrder2 = new NewOrder(12.3);

			List<NewOrder> orders = tempUser.getOrders();
			if (orders == null) {
				orders = new ArrayList<>();
			}
			orders.add(tempOrder1);
			orders.add(tempOrder2);
//			tempOrder1.setUser(tempUser);
//			tempOrder2.setUser(tempUser);
//			tempUser.addOrder(tempOrder1);
//			tempUser.addOrder(tempOrder2);

			session.saveOrUpdate(tempUser);

			session.getTransaction().commit();
			
			

//			NewProduct tempProduct = new NewProduct("temp");
//
//			tempProduct.addReview(new NewReview("temp1"));
//			tempProduct.addReview(new NewReview("temp2"));
//			tempProduct.addReview(new NewReview("temp3"));
//		
//			System.out.println(tempProduct);
//			System.out.println(tempProduct.getReviews());
//
//			session.save(tempProduct);
//
//			session.getTransaction().commit();

		}
		finally {

			// add clean up code
			session.close();

			factory.close();
		}
	}

}
