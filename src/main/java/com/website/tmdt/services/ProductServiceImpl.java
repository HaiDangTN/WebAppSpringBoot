package com.website.tmdt.services;

import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.website.tmdt.model.Categories;
import com.website.tmdt.model.ProductImage;
import com.website.tmdt.model.Products;
import com.website.tmdt.model.User;
import com.website.tmdt.model.entity.ResponseObject;
import com.website.tmdt.repository.ProductImageRepository;
import com.website.tmdt.repository.ProductRepository;


import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductImageRepository productImageRepository;
    @Autowired
    private CategoryServices categoryServices;
   
    
    public ResponseEntity<ResponseObject> saveProduct(Products product,List<MultipartFile> images) {
        Products savedProduct = new Products();
        List<ProductImage> productImages = new ArrayList<>();
        savedProduct.setProduct_name(product.getProduct_name());
        savedProduct.setUnit_price(product.getUnit_price());
      
	     // Lấy và thiết lập danh mục cho sản phẩm
	    savedProduct.setCategories(categoryServices.getOne(product.getCategories().getCategory_id()));
	      
	        // Lưu sản phẩm trước để lấy ID
		savedProduct = productRepository.save(savedProduct);

	      
        for (MultipartFile image : images) {
            String imageUrl = saveImage(image);
            ProductImage productImage = new ProductImage();
            productImage.setImage_name(image.getOriginalFilename());
            productImage.setImage_url("http:localhost:8080/uploads/"+image.getOriginalFilename());
            productImage.setImage_id(product.getProduct_id());
            productImages.add(productImage);
            
            savedProduct.setProductImage(productImage);
            
        }
        productImages= productImageRepository.saveAll(productImages);
        if(productImages != null && savedProduct !=null) {
        	return ResponseEntity.status(HttpStatus.OK).body(
        			new ResponseObject("Succes", "Save product success", savedProduct));
        }
        else {
        	return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(
        			new ResponseObject("Failed", "Cannot save product", savedProduct));
        }
	    
    }


    public String saveImage(MultipartFile photo) {
		
		Path path = Paths.get("src/main/resources/static/uploads");
		try {
			InputStream inputStream = photo.getInputStream();
			Files.copy(inputStream, path.resolve(photo.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return path.toString();
	}
    
    //@Transactional
    public ResponseEntity<ResponseObject> getProductById (int id) {
		Optional<Products> foundProduct = productRepository.findById(id);
		if(foundProduct.isPresent()){
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject("Succes", "Found user success", foundProduct)
			);
		}
        else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					new ResponseObject("Failed", "Cannot found product with id ="+id,""));
		}	
	
	} 
    
    public ResponseEntity<ResponseObject> deleteProductById (int id) {
		Optional<Products> foundProduct = productRepository.findById(id);
		if(foundProduct.isPresent()){
			productRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject("Succes", "Delete user success", foundProduct)
			);
		}
        else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					new ResponseObject("Failed", " with id ="+id+" not exits",""));
		}	
	
	
	}


}
    
