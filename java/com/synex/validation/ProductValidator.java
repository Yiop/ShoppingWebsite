//package com.synex.validation;
//
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//
//import com.synex.domain.Product;
//
//@Component
//public class ProductValidator implements Validator {
//
//	@Override
//	public boolean supports(Class<?> clazz) {
//		return Product.class.equals(clazz);
//	}
//
//	@Override
//	public void validate(Object target, Errors errors) {
//		Product product = (Product)target;
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "customer.name.empty", "sorry: blank");
//		
//		if (product.getCost() < 0) {
//			errors.rejectValue("cities", "country.cities.tour", "sorry: cost must be a positive number");
//		}
//	}
//
//}
