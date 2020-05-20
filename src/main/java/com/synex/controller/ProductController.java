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

import com.synex.dao.CartDaoImpl;
import com.synex.dao.ProductDaoImpl;
import com.synex.domain.CartItem;
import com.synex.domain.Product;
import com.synex.validation.ProductValidator;

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
	public String getProduct(@ModelAttribute Product product, Model model) {

		return "product";
	}

	@RequestMapping(value="/getProduct", method = RequestMethod.POST)
	public String getProduct(Model model,@RequestParam int productId) {

		Product product = productDaoImpl.getProduct(productId);
		model.addAttribute("product", product);
		
		return "product";
	}
	
	@RequestMapping(value="/getAllProduct", method = RequestMethod.POST)
	public String getAllProduct(Model model) {

		List<Product> listproduct = productDaoImpl.getAllProduct();
		model.addAttribute("product", listproduct);
		
		List<Product> listcart = productDaoImpl.getCart(1).getProduct();
		model.addAttribute("cart", listcart);
		
		
		return "productList";
	}
	
	@RequestMapping(value="/saveProduct", method = RequestMethod.POST)
	public String saveProduct(@Valid @ModelAttribute Product product, BindingResult bindingResult, Model model) {

		if (!bindingResult.hasErrors()) {
			productDaoImpl.saveProduct(product);
		}
		return "product";
	}
	
	@RequestMapping(value="/updateCart", method = RequestMethod.POST)
	public String saveCart(Model model,@RequestParam int productId, @RequestParam double quantity) {

		productDaoImpl.updateCart(productId, quantity);
		List<Product> listproduct = productDaoImpl.getAllProduct();
		model.addAttribute("product", listproduct);
		List<Product> listcart = productDaoImpl.getCart(1).getProduct();
		model.addAttribute("cart", listcart);
		
		return "productList";
	}
	
	@RequestMapping(value="/addQuantity", method = RequestMethod.POST)
	public String addQuantity(Model model,@RequestParam int productId) {
		productDaoImpl.addQuantity(productId);
		List<Product> listproduct = productDaoImpl.getAllProduct();
		model.addAttribute("product", listproduct);
		List<Product> listcart = productDaoImpl.getCart(1).getProduct();
		model.addAttribute("cart", listcart);
		
		return "productList";
	}
	
	@RequestMapping(value="/removeQuantity", method = RequestMethod.POST)
	public String removeQuantity(Model model,@RequestParam int productId) {
		productDaoImpl.removeQuantity(productId);
		List<Product> listproduct = productDaoImpl.getAllProduct();
		model.addAttribute("product", listproduct);
		List<Product> listcart = productDaoImpl.getCart(1).getProduct();
		model.addAttribute("cart", listcart);
		
		return "productList";
	}
	
	@RequestMapping(value="/removeProduct", method = RequestMethod.POST)
	public String removeProduct(Model model,@RequestParam int productId) {
		System.out.println("THere there");
		productDaoImpl.removeProduct(productId);
		List<Product> listproduct = productDaoImpl.getAllProduct();
		model.addAttribute("product", listproduct);
		List<Product> listcart = productDaoImpl.getCart(1).getProduct();
		model.addAttribute("cart", listcart);
		
		return "productList";
	}
	
	@RequestMapping(value="/filterProduct", method = RequestMethod.POST)
	public String filterCart(Model model,@RequestParam int filter) {

		List<Product> listproduct = productDaoImpl.getAllProduct();
		List<Product> newproduct = new ArrayList<Product>();
		if (filter < 0) {
			for (int i = 0; i < listproduct.size(); ++i) {
				if (listproduct.get(i).getCost() > 60) {
					newproduct.add(listproduct.get(i));
				}
			}
		} else if (filter > 0) {
			for (int i = 0; i < listproduct.size(); ++i) {
				if (listproduct.get(i).getCost() > filter * 10 - 20 && listproduct.get(i).getCost() <= filter * 10) {
					newproduct.add(listproduct.get(i));
				}
			}
		} else if (filter == 0) {
			newproduct = listproduct;
		}
		System.out.println("number of products: " + newproduct.size());
		model.addAttribute("product", newproduct);
		List<Product> listcart = productDaoImpl.getCart(1).getProduct();
		model.addAttribute("cart", listcart);
		
		return "productList";
	}
	
	@RequestMapping(value="/category", method = RequestMethod.POST)
	public String category(Model model,@RequestParam int filter) {

		List<Product> listproduct = productDaoImpl.getAllProduct();
		List<Product> newproduct = new ArrayList<Product>();
		
		for (int i = 0; i < listproduct.size(); ++i) {
			if (listproduct.get(i).getCategory() == filter) {
				newproduct.add(listproduct.get(i));
			}
		}
		System.out.println("number of products: " + newproduct.size());
		model.addAttribute("product", newproduct);
		List<Product> listcart = productDaoImpl.getCart(1).getProduct();
		model.addAttribute("cart", listcart);
		
		return "productList";
	}
}
