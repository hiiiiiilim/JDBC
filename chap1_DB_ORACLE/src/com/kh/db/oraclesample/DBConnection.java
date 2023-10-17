package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	public static void main(String[] args) {
		//selectBank();
		//selectKhcafe();
		//selectIf();
		//selectwhile();
		insertBank();
	}
	
	static void selectBank() {
		// 1. 드라이버 연결: Oracle JDBC 드라이버 클래스 이름
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2. 오라클 내 컴퓨터 연결:데이터베이스 연결정보
		//								나의 ip 주소:포트번호
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		//내가 설정한 계정
		String user = "khbank";
		String password = "khbank";
		Connection con = null;
		try {
			//연결을 사용하여 쿼리 실행 또는 데이터베이스 작업 수행
			con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공!");
			
			//SELECT 쿼리
			String selectQuery = "select * from bank";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			//result.next():result 객체에서 다음행(row)로 이동, 다음 행이있으면 true를 반환하고 그렇지 않으면 false를 반환
			while(result.next()) {
				//khbank 에 있는 bank 테이블 결과 집합에서 account_id를 가져옴
				int accountID = result.getInt("account_id");
				int accountNumber = result.getInt("account_number");
				String accountName = result.getString("account_Name");
				double balance = result.getDouble("balance");
				String branchName = result.getString("branch_name");
				Date lastTransctionDate = result.getDate("last_transaction");
	
				System.out.println("ACCOUNT_ID : "+accountID+" ACCOUNT_NUMBER : "+accountNumber+" ACCOUNT_NAME : "+accountName+" BALANCE : "+balance+" BRANCH_NAME : "+branchName+" LAST_TRANSACTRION : "+lastTransctionDate);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void selectKhcafe() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "khcafe";
		Connection con = null;
		
		try {
			con =DriverManager.getConnection(url, user, password);
			System.out.println("db연결 성공");
			
			String selectQuery = "select * from menu where price >= 2000 order by price desc";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			while(result.next()) {
				int menuId = result.getInt("menu_id");
				String menuName = result.getString("menu_name");
				double price = result.getDouble("price");
				System.out.println(menuId + " "+menuName+" "+price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void selectIf() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "khbank";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			//where절 사용해서 조건 추가
			String selectQuery = "SELECT * FROM BANK WHERE account_id = ?";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			/*
			String[] targetAN= {"1234567890", "5555666777"};
			selectState.setString(1, targetAN[0]);
			selectState.setString(2, targetAN[1]);
			*/
			
			// 여기에 원하는 조건의 account_id설정
			int targetAID = 1;
			
			//조건설정
			selectState.setInt(1, targetAID); //1은 자리값, 열에서 몇번째 열에서 검색할 것인지 예를 들어 1 account_id, 2 account_number
			//targetAID where 절의 조건을 설정해주는 함수. 변경해주면 where절뒤에 조건이 변경이 된다. 
			
			ResultSet result = selectState.executeQuery();
			
			//값존재여부확인
			if(result.next()) {
				int a = result.getInt("account_id");
				String b = result.getString("account_number");
				System.out.println("ACCOUNT_ID: "+a+" ACCOUNT_NUMBER: "+b);
			}else {
				System.out.println("...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void selectwhile() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khstore";
		String passwoed = "khstore";
		
		Connection con= null;
		
		try {
			con = DriverManager.getConnection(url, user, passwoed);
			System.out.println("데이터베이스 연결 성공");
			String selectQuery = "select * from";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void insertBank() {
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
}
