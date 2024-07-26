package com.website.tmdt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import com.website.tmdt.model.ProductImage;
import com.website.tmdt.model.Products;
import com.website.tmdt.model.entity.ResponseObject;
import com.website.tmdt.services.ProductServiceImpl;
import com.website.tmdt.services.StoreageService;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;
    
    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getProduct(@PathVariable("id") int id) {
        return productService.getProductById(id);
    }
     
  
    @PostMapping("/upload")
    public ResponseEntity<ResponseObject> uploadProduct(@RequestPart("product") Products new_product, 
    											@RequestParam("images") List<MultipartFile> image ) { 
       
    	return productService.saveProduct(new_product, image);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseObject>  deleteProduct(@PathVariable("id") int id){
    	return  productService.deleteProductById(id);
    	

    }
    
}