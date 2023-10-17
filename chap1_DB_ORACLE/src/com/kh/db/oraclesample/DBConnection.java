package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	public static void main(String[] args) {
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

}
