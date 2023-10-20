package com.kh.dtoSample;

import java.sql.Connection;
import java.util.List;

public class ProductsController {
	private ProductsModel model;
	private ProductsView view;
	
	public ProductsController(Connection con, ProductsView view){
		this.model = new ProductsModel(con);
		this.view = view;
	}
	
	public void displayAllProducts() {
		List<ProductsDTO> products = model.getProducts();
		view.displayProducts(products);
	}
}
