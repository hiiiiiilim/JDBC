package com.kh.dtoSample;

public class ProductsDTO {

	private int productId;
	private String productName;
	private String category;
	private double price;
	private int stockQuantity;
	
	//기본생성자
	public ProductsDTO() {
		
	}
	public ProductsDTO(int productId, String productName, String category, double price, int stockQuantity) {
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}
	
	//getter setter
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getStockQuantity() {
		return stockQuantity;
	}
	
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	
}
