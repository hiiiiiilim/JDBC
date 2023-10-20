package com.kh.update_MVC_Sington;

public class UpdateDTO {
	private int productId;
	private String productName;
	private String category;
	private double price;
	private int stockQuantity;
	
	//기본생성자
	public UpdateDTO() {
		
	}
	public UpdateDTO(int productId, double price) {
		this.productId = productId;
		this.price = price;
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
