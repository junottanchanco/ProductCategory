package com.cd.productCategory.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="products")
public class Product {

		@Id
		@GeneratedValue
		private Long id;
		
		@Column
		@Size(min=2, max=255)
		private String name;
		
		@Column
		private String description;
		
		@Column
		@Min(0)
		private float price;
		
		@Column
		@DateTimeFormat(pattern = "MM/dd/yyy")
		private Date created_at;
		
		@Column
		@DateTimeFormat(pattern = "MM/dd/yyy")
		private Date updated_at;
		
		@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(name="categories_products", joinColumns = @JoinColumn(name="product_id"), inverseJoinColumns = @JoinColumn(name="category_id"))
		private List<Category> categories;
		
		@PrePersist
		protected void onCreate() {
			this.created_at = new Date();
		}
		
		@PreUpdate
		protected void onUpdate() {
			this.updated_at = new Date();
		}
		
		public Product() {
		}
		
		public Product(String name, String description, float price) {
			this.name = name;
			this.description = description;
			this.price = price;
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

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
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

		public List<Category> getCategories() {
			return categories;
		}

		public void setCategories(List<Category> categories) {
			this.categories = categories;
		}
		
}
