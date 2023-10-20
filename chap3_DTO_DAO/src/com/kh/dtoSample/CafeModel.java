package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CafeModel {
	private Connection connection;
	
	public CafeModel(Connection connection) {
		this.connection=connection;
	}
	
	public List<CafeDTO> getCafes() {//내용을 전달하는 함수
		List<CafeDTO> cafes = new ArrayList<>();
		String query = "SELECT * FROM cafes";
		try {
			PreparedStatement st = connection.prepareStatement(query);
			ResultSet result = st.executeQuery();
			
			while(result.next()) {
				//기존에는 예약어나 참조어를 사용해서, 넣어줄 값ㄱ을 작성했지만 예를 들어 int cafeId = result.getInt("cafe_id)
				//이제는 DTO 를 활용하여 예약어나 참조어를 캡슐화(보호)하여 따로 DTO로 작성해준다.
				//그리고 DTO로 작성해준 객체를 인스턴스화하여 객체안에 있는 멤버변수를 호출한다.
				
				CafeDTO cafe = new CafeDTO();
				cafe.setCafeId(result.getInt("cafe_id"));
				cafe.setCafeName(result.getString("name"));
				cafe.setAddress(result.getString("address"));
				cafe.setPhoneNumber(result.getString("phone_number"));
				cafe.setOperatingHours(result.getString("operating_hours"));
				
				cafes.add(cafe);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cafes;
	}

}
