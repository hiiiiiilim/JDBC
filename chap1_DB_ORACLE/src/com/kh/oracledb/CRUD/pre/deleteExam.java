package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteExam {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username="khbank";
		String password = "khbank";
		
		try {
			Connection con =  DriverManager.getConnection(url, username, password);
			String deleteQuery = "DELETE FROM BANK WHERE account_id = ?";
			PreparedStatement deletePs = con.prepareStatement(deleteQuery);
			deletePs.setInt(1, 2);
			
			int rowDelete = deletePs.executeUpdate();
			if(rowDelete > 0) {
				System.out.println("삭제되었습니다.");
			}else {
				System.out.println("데이터가 없습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
