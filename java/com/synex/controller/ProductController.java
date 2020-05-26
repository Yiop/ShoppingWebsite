package com.synex.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.synex.dao.ProductDaoImpl;
import com.synex.domain.CartItem;
import com.synex.domain.NewOrder;
import com.synex.domain.NewProduct;
import com.synex.domain.NewUser;
import com.synex.domain.Product;
//import com.synex.validation.ProductValidator;

@Controller
public class ProductController {
	@Autowired
	ProductDaoImpl productDaoImpl;

//	@Autowired
//	ProductValidator productValidator;
//	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		binder.addValidators(productValidator);
//	}
	
	@RequestMapping(value="/product", method = RequestMethod.GET)
	public String getProduct(@ModelAttribute("productForm") NewProduct product, Model model) {
		return "product";
	}
	
	@RequestMapping(value="/signUp", method = RequestMethod.GET)
	public String signUp(@ModelAttribute("userForm") NewUser user, Model model) {
		return "signUp";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(@ModelAttribute("userForm") NewUser user, Model model) {
		return "login";
	}

	@RequestMapping(value="/userLogin", method = RequestMethod.POST)
	public String userLogin(@ModelAttribute("userForm") NewUser user, Model model) {
		if (productDaoImpl.authenticate(user.getFirstName(), user.getPassword())) {
			return "productListLoggedin";
		} else {
			return "login";
		}
	}
	
	
	@RequestMapping(value="/login2", method = RequestMethod.GET)
	public String login2(@ModelAttribute("userForm") NewUser user, Model model) {
		return "login2";
	}
	
	@RequestMapping(value="/adminLogin", method = RequestMethod.POST)
	public String adminLogin(@ModelAttribute("userForm") NewUser user, Model model) {
		List<NewProduct> listproduct = productDaoImpl.getAllProducts();
		model.addAttribute("product", listproduct);
		if (productDaoImpl.authenticate(user.getFirstName(), user.getPassword())) {
			return "product";
		} else {
			return "login";
		}
	}
	
	@RequestMapping(value="/deleteProduct", method = RequestMethod.POST)
	public String deleteProduct(Model model, @RequestParam int productId) {

		productDaoImpl.deleteProduct(productId);
		List<NewProduct> listproduct = productDaoImpl.getAllProducts();
		model.addAttribute("product", listproduct);
		
		return "product";
	}
//	@RequestMapping(value="/getProduct", method = RequestMethod.POST)
//	public String getProduct(Model model,@RequestParam int productId) {
//
//		NewProduct product = productDaoImpl.getProduct(productId);
//		model.addAttribute("product", product);
//		
//		return "product";
//	}
	
//	@RequestMapping(value="/getAllProduct", method = RequestMethod.POST)
//	public String getAllProduct(Model model) {
//
//		List<Product> listproduct = productDaoImpl.getAllProduct();
//		model.addAttribute("product", listproduct);
//		
//		List<Product> listcart = productDaoImpl.getCart(1).getProduct();
//		model.addAttribute("cart", listcart);
//		
//		
//		return "productList";
//	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET) 
	public String display(Model model) { 
		List<NewProduct> listproduct = productDaoImpl.getAllProducts();
		List<NewProduct> cartproduct;
		for (int i = 0; i < listproduct.size(); ++i) {
			System.out.println(listproduct.get(i).getUsers().size());
			System.out.println("============================");
		}
		
        List<NewUser> listuser = productDaoImpl.getAllUsers();
		
		for (int i = 0; i < listuser.size(); ++i) {
			System.out.println(listuser.get(i).getProducts().size());
			System.out.println("----------------------------");
		}
		
		cartproduct = listuser.get(0).getProducts();
		
		model.addAttribute("product", listproduct);
		model.addAttribute("cart", cartproduct);
		System.out.println("cart has " + cartproduct.size());
//		List<Product> listcart = productDaoImpl.getCart(1).getProduct();
//		model.addAttribute("cart", listcart);
//	    model.addAttribute("productForm", new NewProduct()); 
	    return "productList"; 
	}
	
	@RequestMapping(value="/saveProduct", method = RequestMethod.POST)
	public String productForm(@ModelAttribute("productForm") NewProduct productForm, BindingResult bindingResult, Model model) {

		if (!bindingResult.hasErrors()) {
			productDaoImpl.saveProduct(productForm);
		}
		return "product";
	}
	
	@RequestMapping(value="/saveUser", method = RequestMethod.POST)
	public String userForm(@ModelAttribute("userForm") NewUser userForm, BindingResult bindingResult, Model model) {

		if (!bindingResult.hasErrors()) {
			productDaoImpl.saveUser(userForm);
		}
		return "login";
	}
	
//	@RequestMapping(value="/updateCart", method = RequestMethod.POST)
//	public String saveCart(Model model,@RequestParam int productId, @RequestParam double quantity) {
//
//		productDaoImpl.updateCart(productId, quantity);
//		List<Product> listproduct = productDaoImpl.getAllProduct();
//		model.addAttribute("product", listproduct);
//		List<Product> listcart = productDaoImpl.getCart(1).getProduct();
//		model.addAttribute("cart", listcart);
//		
//		return "productList";
//	}
	
	@RequestMapping(value="/addToCart", method = RequestMethod.GET)
	public String saveCart(Model model,@RequestParam int productId) {
		
		List<NewProduct> listproduct = productDaoImpl.getAllProducts();
		model.addAttribute("product", listproduct);
		
		productDaoImpl.addToCart(productId, 1);
//		List<Product> listcart = productDaoImpl.getCart(1).getProduct();
//		model.addAttribute("cart", listcart);
		
		return "productList";
	}
	
	@RequestMapping(value = "/checkOut", method = RequestMethod.POST) 
	public String checkOut(@ModelAttribute("orderForm") NewOrder orderForm, Model model) {  
	    return "checkOut"; 
	}
	
	@RequestMapping(value="/placement", method = RequestMethod.POST)
	public String orderForm(@ModelAttribute("orderForm") NewOrder orderForm, BindingResult bindingResult, Model model) {

		if (!bindingResult.hasErrors()) {
			productDaoImpl.saveOrder(orderForm, 1);
			return "success";
		}
		return "error";
	}
	
	
	@RequestMapping(value="/addQuantity", method = RequestMethod.POST)
	public String addQuantity(Model model,@RequestParam int productId) {
		productDaoImpl.addQuantity(productId, 1);
		
		List<NewProduct> listproduct = productDaoImpl.getAllProducts();
		List<NewProduct> cartproduct;
        List<NewUser> listuser = productDaoImpl.getAllUsers();
		
		cartproduct = listuser.get(0).getProducts();
		
		model.addAttribute("product", listproduct);
		model.addAttribute("cart", cartproduct);
		
		return "productList";
	}
	
	@RequestMapping(value="/removeQuantity", method = RequestMethod.POST)
	public String removeQuantity(Model model,@RequestParam int productId) {
		productDaoImpl.removeQuantity(productId, 1);

		List<NewProduct> listproduct = productDaoImpl.getAllProducts();
		List<NewProduct> cartproduct;
        List<NewUser> listuser = productDaoImpl.getAllUsers();
		
		cartproduct = listuser.get(0).getProducts();
		
		model.addAttribute("product", listproduct);
		model.addAttribute("cart", cartproduct);
		
		return "productList";
	}
	
	@RequestMapping(value="/removeProduct", method = RequestMethod.POST)
	public String removeProduct(Model model,@RequestParam int productId) {
		productDaoImpl.removeProduct(productId, 1);
		
		List<NewProduct> listproduct = productDaoImpl.getAllProducts();
		List<NewProduct> cartproduct;
        List<NewUser> listuser = productDaoImpl.getAllUsers();
		
		cartproduct = listuser.get(0).getProducts();
		
		model.addAttribute("product", listproduct);
		model.addAttribute("cart", cartproduct);
		return "productList";
	}
	
//	@RequestMapping(value="/filterProduct", method = RequestMethod.POST)
//	public String filterCart(Model model,@RequestParam int filter) {
//
//		List<Product> listproduct = productDaoImpl.getAllProduct();
//		List<Product> newproduct = new ArrayList<Product>();
//		if (filter < 0) {
//			for (int i = 0; i < listproduct.size(); ++i) {
//				if (listproduct.get(i).getCost() > 60) {
//					newproduct.add(listproduct.get(i));
//				}
//			}
//		} else if (filter > 0) {
//			for (int i = 0; i < listproduct.size(); ++i) {
//				if (listproduct.get(i).getCost() > filter * 10 - 20 && listproduct.get(i).getCost() <= filter * 10) {
//					newproduct.add(listproduct.get(i));
//				}
//			}
//		} else if (filter == 0) {
//			newproduct = listproduct;
//		}
//		System.out.println("number of products: " + newproduct.size());
//		model.addAttribute("product", newproduct);
//		List<Product> listcart = productDaoImpl.getCart(1).getProduct();
//		model.addAttribute("cart", listcart);
//		
//		return "productList";
//	}
//	
//	@RequestMapping(value="/category", method = RequestMethod.POST)
//	public String category(Model model,@RequestParam int filter) {
//
//		List<Product> listproduct = productDaoImpl.getAllProduct();
//		List<Product> newproduct = new ArrayList<Product>();
//		
//		for (int i = 0; i < listproduct.size(); ++i) {
//			if (listproduct.get(i).getCategory() == filter) {
//				newproduct.add(listproduct.get(i));
//			}
//		}
//		System.out.println("number of products: " + newproduct.size());
//		model.addAttribute("product", newproduct);
//		List<Product> listcart = productDaoImpl.getCart(1).getProduct();
//		model.addAttribute("cart", listcart);
//		
//		return "productList";
//	}
}
