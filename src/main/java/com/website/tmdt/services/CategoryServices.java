package com.website.tmdt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.tmdt.model.Categories;
import com.website.tmdt.repository.Categories_Repository;

@Service
public class CategoryServices {
	@Autowired
	private Categories_Repository categories_Repository;
	
	public List<Categories> getAll() {
		List<Categories> list = categories_Repository.findAll();
		return list;
	}
	
	public Categories getOne(int id) {
		return categories_Repository.findById(id).get();
	}
}
