package com.cd.productCategory.controllers;

import java.util.List;

import javax.validation.Valid;

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
public class ProductController {
	
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public ProductController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/products/new";
	}
	
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	@PostMapping("/products/new")
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/products/new";
		}else {
			productService.addProduct(product);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/products/{id}")
	public String showProduct(Model model, @PathVariable("id") Long id) {
		model.addAttribute("product", productService.findProductById(id));
		model.addAttribute("categories", categoryService.allCategories());
		return "productPage.jsp";
	}
	@PostMapping("/products/{id}")
	public String addCategorytoProduct(@PathVariable("id") Long id, @RequestParam("category") Long categoryId) {
		Product product = productService.findProductById(id);
		Category category = categoryService.findCategoryById(categoryId);
		
		List<Category> categories = (List<Category>) product.getCategories();
		categories.add(category);
		productService.update(product);
		
		return "redirect:/products/"+id;
	}
}
