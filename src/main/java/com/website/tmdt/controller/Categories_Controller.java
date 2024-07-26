package com.website.tmdt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.website.tmdt.model.Categories;
import com.website.tmdt.services.CategoryServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/category")
public class Categories_Controller {
	@Autowired
	private CategoryServices categoryServices;
	
	@GetMapping("/getAll")
	public List<Categories> getAll() {
		return categoryServices.getAll();
	}
	
	@GetMapping("{id}")
	public Categories getMethodName(@PathVariable("id") int id) {
		return categoryServices.getOne(id);
	}
	
	
	
}
