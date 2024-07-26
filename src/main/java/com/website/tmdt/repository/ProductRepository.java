package com.website.tmdt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.website.tmdt.model.Products;

public interface ProductRepository extends JpaRepository<Products , Integer>{

}
