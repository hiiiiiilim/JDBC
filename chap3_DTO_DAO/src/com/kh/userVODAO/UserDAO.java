package com.kh.userVODAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDAO {
	private Connection connection;
	
	public UserDAO(Connection connection) {
		this.connection = connection;
	}
	
	public boolean createUser(/*파라메터 값 추가*/ UserVO user) {
		String sql = "INSERT INTO USERINFO(user_id, username, email, reg_date)"
					+"values (?, ?, ?, ?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, user.getUserId());
			st.setString(2, user.getUserName());
			st.setString(3, user.getEmail());
			st.setDate(4, new Date(user.getRegDate().getTime()));
			
			int rows = st.executeUpdate();
			
			return rows > 0; //값이 들어오면 0보다 커지므로 true가 됨
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		}
		
	}
	
	public List<UserVO> getAllUsers() throws SQLException {
		List<UserVO> users = new ArrayList<>();
		String sql = "select * from userinfo";
		
	
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		//selectOne if , selectAll while
		while(rs.next()) {
			UserVO user = new UserVO();
			user.setUserId(rs.getInt("user_id"));
			user.setUserName(rs.getString("username"));
			user.setEmail(rs.getString("email"));
			user.setRegDate(rs.getDate("reg_date"));
			
			users.add(user);
		}
		
		return users;
	}
}
