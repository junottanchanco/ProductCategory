package com.cd.productCategory.controllers;

import javax.validation.Valid;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cd.productCategory.models.Category;
import com.cd.productCategory.models.Product;
import com.cd.productCategory.services.CategoryService;
import com.cd.productCategory.services.ProductService;

@Controller
public class CategoryController {
	
	private final CategoryService categoryService;
	private final ProductService productService;
	
	public CategoryController(CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}
	
	@RequestMapping("/category/new")
	public String newCategory(Model model) {
		model.addAttribute("category",  new Category());
		return "newCategory.jsp";
	}
	@PostMapping("/category/new")
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		}else {
			categoryService.addCategory(category);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/category/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		model.addAttribute("category", categoryService.findCategoryById(id));
		model.addAttribute("products", productService.allProducts());
		return "categoryPage.jsp";
	}
	@PostMapping("/category/{id}")
	public String addProductToCategory(@PathVariable("id") Long id, @RequestParam("product") Long productId) {
		Category category = categoryService.findCategoryById(id);
		Product product = productService.findProductById(productId);
		
		List<Product> products = (List<Product>) category.getProduct();
		products.add(product);
		categoryService.update(category);
		
		return "redirect:/category/"+id;
	}
}
