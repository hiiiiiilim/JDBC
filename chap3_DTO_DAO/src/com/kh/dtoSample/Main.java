package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		//connection�� ������ ���� �ۼ�
		//url username password
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khcafe";
		String password = "khcafe";
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			//�ν��Ͻ� �����Ͽ� �� �ʱ�ȭ
			CafeView view = new CafeView();
			ProductsView view2 = new ProductsView();
			
			//�ν��Ͻ� �����Ͽ� ��Ʈ�ѷ� �ʱ�ȭ
			CafeController controller = new CafeController(con, view);
			ProductController controller2 =  new ProductController(con, view2);
			//ī������ ǥ���ϴ� �޼��� ��������
		//	controller.displayAllCafes();
			controller2.displayAllProducts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
