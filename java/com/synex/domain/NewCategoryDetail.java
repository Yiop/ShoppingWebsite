package com.synex.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="category_detail")
public class NewCategoryDetail {

	// annotate the class as an entity and map to db table
	
	// define the fields
	
	// annotate the fields with db column names
	
	// create constructors
	
	// generate getter/setter methods
	
	// generate toString() method
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	// add new field for instructor (also add getter/setters)
	
	// add @OneToOne annotation
	
	@OneToOne(mappedBy="categoryDetail", 
			cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
						CascadeType.REFRESH})
	private NewCategory category;

	public NewCategoryDetail() {
		
	}

	public NewCategoryDetail(String description) {
		this.description = description;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public NewCategory getCategory() {
		return category;
	}

	public void setCategory(NewCategory category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "CategoryDetail [id=" + id + ", description=" + description + "]";
	}
		
}







