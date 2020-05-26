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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class NewUser {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="product_user",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="product_id")
			)	
	private List<NewProduct> products;

//	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//	@JoinColumn(name="user_id")
//	@OneToMany(fetch=FetchType.LAZY,
//	   mappedBy="user",
//	   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
//				 CascadeType.DETACH, CascadeType.REFRESH})
//	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//	@JoinColumn(name="user_id")
	@OneToMany
	private List<NewOrder> orders;
	
	public NewUser() {
		
	}

	public NewUser(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<NewProduct> getProducts() {
		return products;
	}

	public void setProducts(List<NewProduct> products) {
		this.products = products;
	}

	
	
	
	public List<NewOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<NewOrder> orders) {
		this.orders = orders;
	}

	
	public void addOrder(NewOrder theOrder) {
		
		if (orders == null) {
			orders = new ArrayList<>();
		}
		
		orders.add(theOrder);
		theOrder.setUser(this);
		System.out.println("12345");
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
}




