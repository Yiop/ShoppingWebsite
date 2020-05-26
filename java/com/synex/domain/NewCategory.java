package com.synex.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class NewCategory {

	// annotate the class as an entity and map to db table
	
	// define the fields
	
	// annotate the fields with db column names
	
	// ** set up mapping to InstructorDetail entity
	
	// create constructors
	
	// generate getter/setter methods
	
	// generate toString() method

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="category_detail_id")
	private NewCategoryDetail categoryDetail;
	
	@OneToMany(fetch=FetchType.LAZY,
			   mappedBy="category",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	private List<NewProduct> products;
	
	
	public NewCategory() {
		
	}

	public NewCategory(String title) {
		this.title = title;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public NewCategoryDetail getCategoryDetail() {
		return categoryDetail;
	}

	public void setCategoryDetail(NewCategoryDetail categoryDetail) {
		this.categoryDetail = categoryDetail;
	}

	public List<NewProduct> getProducts() {
		return products;
	}

	public void setProducts(List<NewProduct> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", title=" + title
				+ ", categoryDetail=" + categoryDetail + "]";
	}

	
	
	public void add(NewProduct tempProduct) {
		
		if (products == null) {
			products = new ArrayList<>();
		}
		
		products.add(tempProduct);
		
		tempProduct.setCategory(this);
	}
	
}











