package com.website.tmdt.model.entity;

import java.math.BigDecimal;
import java.util.List;

public class ProductDTO {
	private String product_name;
    private CategoriesDTO categories;
    private BigDecimal unit_price;
    private String description; // Nếu có thêm trường này
    private List<ImageDTO> images; // Danh sách hình ảnh nếu cần
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public CategoriesDTO getCategories() {
		return categories;
	}
	public void setCategories(CategoriesDTO categories) {
		this.categories = categories;
	}
	public BigDecimal getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(BigDecimal unit_price) {
		this.unit_price = unit_price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<ImageDTO> getImages() {
		return images;
	}
	public void setImages(List<ImageDTO> images) {
		this.images = images;
	}
    
    

}
