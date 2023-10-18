package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertAll {

	public static void main(String[] args) {
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khcafe";
		String password = "khcafe";
		
		try {
			Connection con = DriverManager.getConnection(jdbcurl, username, password);
			String insertSQL = "INSERT INTO products( product_id, product_name, category, price, stock_quantity)"
					+"values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			//"products"���̺� ������ ����
			insertProduct(ps,7, "��Ʈ��", "������ǰ", 899.99,10);
			insertProduct(ps,8, "�����", "������ǰ", 799.99,20);
			insertProduct(ps,9, "���콺", "�޴���", 79.99,33);
			
			int rowInsert = ps.executeUpdate();
			System.out.println(rowInsert+"row�߰���");
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	static void insertProduct(PreparedStatement ps, int product_id, String product_name, String category, double price, int stock_quantity) throws SQLException{
		ps.setInt(1, product_id);
		ps.setString(2, product_name);
		ps.setString(3, category);
		ps.setDouble(4, price);
		ps.setInt(5, stock_quantity);
		ps.executeUpdate();
	}
}
