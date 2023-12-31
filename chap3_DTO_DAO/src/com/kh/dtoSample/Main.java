package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		//connection에 연결할 내용 작성
		//url username password
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khcafe";
		String password = "khcafe";
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			//인스턴스 생성하여 뷰 초기화
			CafeView view = new CafeView();
			ProductsView view2 = new ProductsView();
			
			//인스턴스 생성하여 컨트롤러 초기화
			CafeController controller = new CafeController(con, view);
			ProductsController controller2 =  new ProductsController(con, view2);
			//카페정보 표시하는 메서드 가져오기
		//	controller.displayAllCafes();
			controller2.displayAllProducts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
