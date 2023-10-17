package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	public static void main(String[] args) {
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

}