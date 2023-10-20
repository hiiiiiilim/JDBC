package com.kh.update_MVC_Sington;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.dtoSample.ProductsModel;

public class UpdateModel {
	private static Connection connection;
	//클래스의 인스턴스를 저장하는 싱글톤 객체
	private static UpdateModel updateModel = null;
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String ID = "khcafe";
	private static String PW = "khcafe";
	
	private UpdateModel() {
		
	}
	
	public static UpdateModel getInstance() throws SQLException {
		if(updateModel == null) {
			updateModel = new UpdateModel();
			connection = DriverManager.getConnection(DB_URL, ID, PW);
		}
		
		return updateModel;
	}
	
	public boolean updateProduct(UpdateDTO updateProduct) {
		String sql = "UPDATE products SET price = ? WHERE product_id= ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, updateProduct.getPrice());
			ps.setInt(2, updateProduct.getProductId());
			
			int rowsAffected = ps.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

}
