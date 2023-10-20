package com.kh.dtoSample;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductsView {
	
	public void displayProducts(List<ProductsDTO> products) {
		for(ProductsDTO p : products){
			System.out.println("product Id :" +p.getProductId());
			System.out.println("product Name :"+ p.getProductName());
			System.out.println("Caregory : "+p.getCategory());
			System.out.println("price : "+p.getPrice());
			System.out.println("stotck Qnantity : "+p.getStockQuantity());
			System.out.println();
		}
	}
}
