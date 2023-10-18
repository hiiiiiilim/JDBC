package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class insertExam {

	public static void main(String[] args) {
		// cafes insert 작성해서 여러카페 추가하기
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user="khcafe";
		String password="khcafe";
		try {
		//cafe
		/*
			Connection con = DriverManager.getConnection(jdbcurl, user, password);
			String insertSQL = "insert into cafes(cname, address, phone_number, operating_hours)"
							+"values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			insertcafe(ps,"카페", "서울시 송파구 문정동", "02-000-0000", "매일: 7:00-21:00");
			
			*/
		
		//book
			//connection 최초 1회
			Connection con = DriverManager.getConnection(jdbcurl, user, password);
		/*	System.out.println("데이터베이스 연결 성공");
			String insertQuery = "insert into BOOK (book_id, title, author, publication_year, isbn, genre, description, price, publication_date, created_date, updated_date, is_available)"
								+"values(?,?,?,?,?,?,?,?,to_date(?,'YYYY-MM-DD'),?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertQuery);
			insertbook(ps, 30,"역행자", "자청",  2023, "123-12312123123", "Fiction", "베스트셀러 역행자", 12.00, 20220530, null,Date.valueOf("2023-10-18"), String.valueOf('Y'));
			con.close();
			ps.close();*/
			
			String selectQuery = "SELECT * FROM BOOK WHERE book_id = ?";
			PreparedStatement selectPs = con.prepareStatement(selectQuery);
			selectPs.setInt(1, 50);
			
			ResultSet rs = selectPs.executeQuery();
			
			while(rs.next()) {
				int bookId = rs.getInt("book_id");
				String bookname = rs.getString("title");
				double price = rs.getDouble("price");
				System.out.println(bookId + " "+bookname+ " "+ price);
			}
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void insertcafe(PreparedStatement ps, String cname, String address, String phone_number, String operating_hours) throws SQLException{
		ps.setString(1, cname);
		ps.setString(2, address);
		ps.setString(3, phone_number);
		ps.setString(4, operating_hours);
		ps.executeUpdate();
	}
	
	static void insertbook(PreparedStatement ps,int book_id, String title, String author, 
			int publication_year, String isbn, String genre, String description, double price, int publication_date,Date created_date, 
			 Date date,String is_available) throws SQLException {
		

		ps.setInt(1, book_id);
		ps.setString(2, title);
		ps.setString(3, author);
		ps.setInt(4, publication_year);
		ps.setString(5,isbn);
		ps.setString(6,genre);
		ps.setString(7,description);
		ps.setDouble(8,price);
		ps.setInt(9,publication_date);
		ps.setDate(10,created_date);
		ps.setNull(11, 0);
		ps.setString(12, is_available);
		
		ps.executeUpdate();
	
	}

}
