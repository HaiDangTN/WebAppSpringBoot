package com.website.tmdt.model.entity;

import java.util.Collections;

import com.website.tmdt.model.Products;

public class ProductMapper {

    public static ProductDTO toProductDTO(Products product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProduct_name(product.getProduct_name());
        
        productDTO.setUnit_price(product.getUnit_price());

        CategoriesDTO categoriesDTO = new CategoriesDTO();
        categoriesDTO.setCategory_id(product.getCategories().getCategory_id());
        productDTO.setCategories(categoriesDTO);

        if (product.getProductImage() != null) {
            ImageDTO imageDTO = new ImageDTO();
            imageDTO.setImage_name(product.getProductImage().getImage_name());
            imageDTO.setImage_url(product.getProductImage().getImage_url());
            productDTO.setImages(Collections.singletonList(imageDTO));
        }

        return productDTO;
    }
}
