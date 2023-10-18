package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertSample {
	public static void main(String[] args) {
		//insertBank();
		insertkhcafe();
	}
	

	static void insertOne() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String passwoed = "khbank";
		
		try {
			Connection con= DriverManager.getConnection(url, user, passwoed);
			String insertQuery = "INSERT INTO BANK (account_id, account_number, account_name, balance, branch_name, last_transaction)"
								+ "values (?,?,?,?,?,?)";
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			insertState.setInt(1, 13);
			insertState.setString(2, "789789789");
			insertState.setString(3, "사아자");
			insertState.setDouble(4, 1500.00);
			insertState.setString(5, "kh");
			insertState.setDate(6, Date.valueOf("2023-10-16"));
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + "row 추가됨");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void insertkhcafe() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "khcafe";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공");
			String insertQuery = "insert into BOOK (book_id, title, author, publication_year, isbn, genre, description, price, publication_date, created_date, updated_date, is_available)"
								+"values(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			insertState.setInt(1, 21);
			insertState.setString(2, "모순");
			insertState.setString(3, "양귀자");
			insertState.setInt(4, 2023);
			insertState.setString(5,"0000-000000" );
			insertState.setString(6,"Novel");
			insertState.setString(7,"양귀자의 모순");
			insertState.setDouble(8,10.99);
			insertState.setDate(9,Date.valueOf("2013-04-01"));
			insertState.setDate(10,Date.valueOf("2023-10-18"));
			insertState.setNull(11, 0);
			insertState.setString(12, String.valueOf('N'));
			
			int rowInsert = insertState.executeUpdate();
			
			System.out.println(rowInsert);
			
			/*String deleteQuery="delete from book where book_id = ?";
			PreparedStatement deleteState =con.prepareStatement(deleteQuery);
			deleteState.setInt(1, 21);
			
			deleteState.execute();*/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
