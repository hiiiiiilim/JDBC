package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateExam {

	public static void main(String[] args) {
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khbank";
		String password = "khbank";
		
		try {
			Connection con =DriverManager.getConnection(jdbcurl, username, password);
			String updateQuery = "UPDATE BANK SET branch_name = ? WHERE account_id=?";
			PreparedStatement ps = con.prepareStatement(updateQuery);
			ps.setString(1, "��������");
			ps.setInt(2, 1);
			
			int rowUpdate = ps.executeUpdate();
			System.out.println(rowUpdate+" ������Ʈ �Ǿ����ϴ�.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
