package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class khcafeExam {
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String username="khcafe";
	static String password = "khcafe";
	static Connection con = null;

	public static void main(String[] args) {
		//selectcafe();
		//selectcafemenu();
		//insertcafe();
		//updatemenu();
		//updatecafe();
		//deletecafe();
		countmenu();
	}
	
	static void selectcafe() {
		try {
			con = DriverManager.getConnection(url,username,password);
			String selectQuery = "SELECT * FROM cafes";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			
			while(result.next()) {
				int cafeId = result.getInt("cafe_id");
				String cname = result.getString("cname");
				String address = result.getString("address");
				String phoneNumber = result.getString("phone_number");
				String opHours = result.getString("operating_hours");
				
				System.out.println(cafeId+" "+cname+" "+address+" "+phoneNumber+" "+opHours);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void selectcafemenu() {
		try {
			con = DriverManager.getConnection(url,username,password);
			String selectQuery = "SELECT * FROM cafes c, menu m WHERE c.cafe_id=m.cafe_id and c.cafe_id = ?";
			PreparedStatement ps = con.prepareStatement(selectQuery);
			
			ps.setInt(1, 1);
			
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				String menuName = result.getString("menu_name");
				
				System.out.println(menuName);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static void insertcafe() {
		try {
			con =DriverManager.getConnection(url, username, password);
			String insertQuery = "INSERT INTO cafes (cname, address, phone_number, operating_hours)"
								+"VALUES (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertQuery);
			
			ps.setString(1, "컴포즈커피");
			ps.setString(2, "서울 강남구 테헤란로4길 6");
			ps.setString(3, "02-539-7977");
			ps.setString(4, "월-금 7:00 - 21:00");
			
			int rowInsert = 	ps.executeUpdate();
			if(rowInsert>0) {
				System.out.println("입력이 되었습니다.");
			}else {
				System.out.println("...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static void updatemenu() {
		try {
			con =DriverManager.getConnection(url, username, password);
			String updateMenu = "UPDATE menu SET price = ? WHERE cafe_id = ? AND menu_name = ? ";
			PreparedStatement ps = con.prepareStatement(updateMenu);
			
			ps.setDouble(1, 4.0);
			ps.setInt(2, 1);
			ps.setString(3, "아메리카노");
			
			int rowInsert = ps.executeUpdate();
			if(rowInsert>0) {
				System.out.println("변경 되었습니다.");
			}else {
				System.out.println("...");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 static void updatecafe() {
		 try {
			con =DriverManager.getConnection(url, username, password);
			String updatecafe = "UPDATE cafes SET phone_number = ? WHERE cname = ?";
			PreparedStatement ps = con.prepareStatement(updatecafe);
			
			ps.setString(1, "02-1234-1234");
			ps.setString(2,"카페");
			
			int rowInsert = ps.executeUpdate();
			if(rowInsert>0) {
				System.out.println("변경 되었습니다.");
			}else {
				System.out.println("...");
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 static void deletecafe() {
		 try { //특정카페의 정보삭제하기
			con =DriverManager.getConnection(url, username, password);
			String altercafe = "delete from cafes where cname = ?";
			PreparedStatement ps = con.prepareStatement(altercafe);
			
			ps.setString(1, "컴포즈커피");
			
			int rowInsert = ps.executeUpdate();
			if(rowInsert>0) {
				System.out.println("삭제 되었습니다.");
			}else {
				System.out.println("...");
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 static void countmenu() {
		 try {
			con =DriverManager.getConnection(url, username, password);
			String countQuery = "SELECT c.cname, count(*) FROM cafes c, menu m WHERE c.cafe_id=m.cafe_id group by c.cname having cname = ?";
			PreparedStatement ps = con.prepareStatement(countQuery);
			
			ps.setString(1, "종로 그 집");
			
			ResultSet r = ps.executeQuery();
			if(r.next()) {
				String cname= r.getString("cname");
				int count = r.getInt("count(*)");
				
				System.out.println(cname + " " +count);
			}else {
				System.out.println("...");
			}
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 
	 }
	 

}
