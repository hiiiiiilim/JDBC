package com.kh.dtoSample;

import java.sql.Connection;
import java.util.List;

public class ProductController {
	private ProductsModel model;
	private ProductsView view;
	
	public ProductController(Connection con, ProductsView view){
		this.model = new ProductsModel(con);
		this.view = view;
	}
	
	public void displayAllProducts() {
		List<ProductsDTO> products = model.getProducts();
		view.displayProducts(products);
	}
}
