package com.cd.productCategory.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cd.productCategory.models.Category;
import com.cd.productCategory.repositories.CategoryRepository;

@Service
public class CategoryService {

		private CategoryRepository categoryRepository;
		
		public CategoryService(CategoryRepository categoryRepository) {
			this.categoryRepository = categoryRepository;
		}
		
		public void addCategory(Category category) {
			categoryRepository.save(category);
		}
		
		public List<Category> allCategories(){
			return (List<Category>) categoryRepository.findAll();
		}
		
		public Category findCategoryById(Long id) {
			return (Category) categoryRepository.findOne(id);
		}
		
		public void update(Category category) {
			categoryRepository.save(category);
		}
}
