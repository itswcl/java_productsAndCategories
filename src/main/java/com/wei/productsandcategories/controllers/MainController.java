package com.wei.productsandcategories.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wei.productsandcategories.models.Category;
import com.wei.productsandcategories.models.Product;
import com.wei.productsandcategories.services.CategoryService;
import com.wei.productsandcategories.services.ProductService;;

@Controller
public class MainController {

	@Autowired
	private CategoryService cateService;

	@Autowired
	private ProductService proService;

// ---------- TEST JSP LINK --------------------
	@GetMapping("/")
	public String index() {
		return "test.jsp";
	}

// ---------- CREATE A PRODUCT -----------------
	// render page
	@GetMapping("/product/new")
	public String createProductForm(@ModelAttribute("product") Product product) {
		return "product/new.jsp";
	}

	// post requet for submit
	@PostMapping("/product/new")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "product/new.jsp";
		} else {
			proService.createAndUpdateProduct(product);
			return "redirect:/";
		}

	}

// ---------- Edit Page -----------------
//	// render page
	@GetMapping("/product/{id}")
	public String updateProductForm(
			@PathVariable("id") Long id,
			Model model) {
		
		Product product = proService.findProductById(id);
		List<Category> categories = cateService.findCategories();
		model.addAttribute("product", product);
		model.addAttribute("categories",categories);
		
		return "product/show.jsp";
	}
	
	// use the get request to update product attribute
	@GetMapping("/product/addCategory/{id}")
	public String updateProductCate(
			@PathVariable("id") Long productId,
			@RequestParam(name = "categories") Category category) {
//			
		Product product = proService.findProductById(productId);
		
		System.out.println(category);
		
		product.getCategories().add(category);
		proService.createAndUpdateProduct(product);
//		
		return "redirect:/product/{id}";
	}

// ---------- CREATE A CATEGORY -----------------
	// render page
	@GetMapping("/category/new")
	public String createCategoryForm(@ModelAttribute("category") Category category) {
		return "category/new.jsp";
	}

	// post requet for submit
	@PostMapping("/category/new")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "category/new.jsp";
		} else {
			cateService.createAndUpdateCategory(category);
			return "redirect:/";
		}

	}


}
