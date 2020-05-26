package com.synex.domain;

import java.io.Serializable;

import javax.persistence.Column;

public class NewCartKey implements Serializable {
	
	@Column(name="product_id")
	private int product_id;
	
	
	@Column(name="user_id")
	private int user_id;


	public NewCartKey(int product_id, int user_id) {
		this.product_id = product_id;
		this.user_id = user_id;
	}
	
	
}
