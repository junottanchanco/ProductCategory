package com.cd.productCategory.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="categories")
public class Category {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@Size(min=3, max=255)
	private String name;
	
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyy")
	private Date created_at;
	
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyy")
	private Date updated_at;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="categories_products", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns=@JoinColumn(name="product_id"))
	private List<Product> product;
	
	@PrePersist
	protected void onCreate() {
		this.created_at = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updated_at = new Date();
	}
	
	public Category() {
	}
	
	public Category(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
}
