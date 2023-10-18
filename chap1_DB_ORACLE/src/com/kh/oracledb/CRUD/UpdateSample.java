package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateSample {

	public static void main(String[] args) {
		String jdbcUrl="jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khbank";
		String password="khbank";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			String updateQuery = "UPDATE BANK SET balance = ? WHERE account_number = ?";
			PreparedStatement updateps = con.prepareStatement(updateQuery);
			updateps.setDouble(1, 2000.00);
			updateps.setString(2, "1234567890");
			
			int rowUpdate = updateps.executeUpdate();
			System.out.println(rowUpdate + " 업데이트 되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
