package com.wei.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wei.productsandcategories.models.Category;
import com.wei.productsandcategories.repositories.CategoryRepo;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepo cateRepo;

// CRUD
	// ---------- READ ALL ---------- READ ALL ---------- READ ALL
	public List<Category> findCategories() {
		return cateRepo.findAll();
	}

	
	// ---------- READ ONE ---------- READ ONE ---------- READ ONE
	public Category findCategoryById(Long categoryId) {
		Optional<Category> optionalCategory = cateRepo.findById(categoryId);

		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}

	
	// ---------- CREATE and UPDATE for ONE  ---------- CREATE and UPDATE for ONE
	public Category createAndUpdateCategory(Category category) {
		return cateRepo.save(category);
	}

	
	// ---------- DELETE ONE
	public void deleteCategory(Long categoryId) {
		cateRepo.deleteById(categoryId);
	}
}
