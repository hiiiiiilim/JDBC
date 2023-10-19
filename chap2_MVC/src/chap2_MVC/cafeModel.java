package chap2_MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class cafeModel {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "khcafe";
	String password = "khcafe";
	
	public void insertCafe(String cname, String address, String phone_number, String operating_hours) {//실행공간을 만들어줘야 실행이 가능(메서드안에넣어야..), 출력할 공간이라고 간단하게 생각하면 좋음
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("연결 성공");
			String sql = "INSERT INTO cafes	(cname, address, phone_number, operating_hours)"
						+"VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cname);
			ps.setString(2, address);
			ps.setString(3, phone_number);
			ps.setString(4, operating_hours);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void UpdateMenu(String description, int menu_id, int cafe_id) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "UPDATE menu SET description = ? where menu_id = ? and cafe_id = ? ";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, description);
			st.setInt(2, menu_id);
			st.setInt(3, cafe_id);
			
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//카페 운영시간 수정하기
	public void UpdateCafe(String operating_hours, int cafe_id) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "UPDATE cafes SET operating_hours= ? where cafe_id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, operating_hours);
			ps.setInt(2, cafe_id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteCafe(int cafe_id) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "delete from cafes where cafe_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cafe_id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
	public void deleteMenu(int menuID) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "DELETE FROM menu WHERE menu_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, menuID);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteOrder(int order_id) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "delete from orders where order_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, order_id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}  
