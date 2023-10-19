package chap2_MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class cafeModel {
	String url = "jdbc:oracle:thin:@localhost:12521:xe";
	String username = "khcafe";
	String password = "khcafe";
	
	public void insertCafe(String cname, String address, String phone_number, String operating_hours) {//실행공간을 만들어줘야 실행이 가능(메서드안에넣어야..), 출력할 공간이라고 간단하게 생각하면 좋음
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "INSERT INTO cafes	(cname, address, phone_number, operationg_hours)"
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
}
