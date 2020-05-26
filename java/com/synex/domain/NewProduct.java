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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class NewProduct {

	// define our fields
	
	// define constructors
	
	// define getter setters
	
	// define tostring
	
	// annotate fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="img")
	private String img;
	
	@Column(name="price")
	private double price;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="category_id")
	private NewCategory category;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="product_id")
	private List<NewReview> reviews;
		
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="product_user",
			joinColumns=@JoinColumn(name="product_id"),
			inverseJoinColumns=@JoinColumn(name="user_id")
			)
	private List<NewUser> users;
	
	
	public NewProduct() {
		
	}

	public NewProduct(String title) {
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
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public NewCategory getCategory() {
		return category;
	}

	public void setCategory(NewCategory category) {
		this.category = category;
	}

	public List<NewReview> getReviews() {
		return reviews;
	}

	public void setReviews(List<NewReview> reviews) {
		this.reviews = reviews;
	}

	public List<NewUser> getUsers() {
		return users;
	}

	public void setUsers(List<NewUser> users) {
		this.users = users;
	}

	public void addReview(NewReview theReview) {
	
		if (reviews == null) {
			reviews = new ArrayList<>();
		}
		
		reviews.add(theReview);
	}
	
	public void addUser(NewUser theUser) {
		
		if (users == null) {
			users = new ArrayList<>();
		}
		
		users.add(theUser);
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + "]";
	}
	
	
}



