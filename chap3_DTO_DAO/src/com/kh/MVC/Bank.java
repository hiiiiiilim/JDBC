package com.kh.MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String name = "khbank";
		String pw = "khbank";
		
		try {
			Connection c = DriverManager.getConnection(url, name, pw);
			Scanner sc = new Scanner(System.in);
			
			System.out.println("전송할 아이디를 입력해주세요. : ");
			int fromAccountId = sc.nextInt();
			
			System.out.println("전송받을 아이디를 입력해주세요: ");
			int toAccountId = sc.nextInt();
			
			System.out.println("전송할 금액을 입력해주세요.");
			double amount = sc.nextDouble();
			
			PreparedStatement a = c.prepareStatement("update bank set balance =  ? where account_id = ?");
			a.setDouble(1, amount);
			a.setInt(2, fromAccountId);
			a.executeUpdate();
			c.commit();
			
			PreparedStatement b = c.prepareStatement("update bank set balance =  ? where account_id = ?");
			a.setDouble(1, amount);
			a.setInt(2, fromAccountId);
			a.executeUpdate();
			c.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
