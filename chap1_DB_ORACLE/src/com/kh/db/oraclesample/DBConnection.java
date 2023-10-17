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
		// 1. ����̹� ����: Oracle JDBC ����̹� Ŭ���� �̸�
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2. ����Ŭ �� ��ǻ�� ����:�����ͺ��̽� ��������
		//								���� ip �ּ�:��Ʈ��ȣ
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		//���� ������ ����
		String user = "khbank";
		String password = "khbank";
		Connection con = null;
		try {
			//������ ����Ͽ� ���� ���� �Ǵ� �����ͺ��̽� �۾� ����
			con = DriverManager.getConnection(url, user, password);
			System.out.println("�����ͺ��̽� ���� ����!");
			
			//SELECT ����
			String selectQuery = "select * from bank";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			//result.next():result ��ü���� ������(row)�� �̵�, ���� ���������� true�� ��ȯ�ϰ� �׷��� ������ false�� ��ȯ
			while(result.next()) {
				//khbank �� �ִ� bank ���̺� ��� ���տ��� account_id�� ������
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
			System.out.println("db���� ����");
			
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
			//where�� ����ؼ� ���� �߰�
			String selectQuery = "SELECT * FROM BANK WHERE account_id = ?";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			/*
			String[] targetAN= {"1234567890", "5555666777"};
			selectState.setString(1, targetAN[0]);
			selectState.setString(2, targetAN[1]);
			*/
			
			// ���⿡ ���ϴ� ������ account_id����
			int targetAID = 1;
			
			//���Ǽ���
			selectState.setInt(1, targetAID); //1�� �ڸ���, ������ ���° ������ �˻��� ������ ���� ��� 1 account_id, 2 account_number
			//targetAID where ���� ������ �������ִ� �Լ�. �������ָ� where���ڿ� ������ ������ �ȴ�. 
			
			ResultSet result = selectState.executeQuery();
			
			//�����翩��Ȯ��
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
			System.out.println("�����ͺ��̽� ���� ����");
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
			insertState.setString(3, "�����");
			insertState.setDouble(4, 1500.00);
			insertState.setString(5, "kh");
			insertState.setDate(6, Date.valueOf("2023-10-16"));
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + "row �߰���");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
