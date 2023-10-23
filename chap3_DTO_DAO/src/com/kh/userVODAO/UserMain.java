package com.kh.userVODAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		UserMain um = new UserMain();
		
		um.selectScanner();
	}
	


	public void selectScanner() {
		// 1. DB���� url, username, password
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "khcafe";
		
		
		try {
			Connection cc = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("User ID �Է��ϼ���.");
				System.out.println("�����ϰ� �ʹٸ� e �Է�");
				String input = sc.next();
				System.out.println("User �̸����� �Է��ϼ���");
				String email = sc.next();
				
				//���࿡ e�� �Է��ߴٸ� 
				if("e".equalsIgnoreCase(input)) {
					System.out.println("����");
					break; //break�� ������ �����������
				}
				
				int userId = Integer.parseInt(input);
				//select �� ����ϱ�
				String sql = "select * from userinfo where user_id = ? and email = ?";
				PreparedStatement st = cc.prepareStatement(sql);
				st.setInt(1, userId);
				st.setString(2, email);
				ResultSet rs = st.executeQuery();
				
				//selectOne if
				if(rs.next()) {
					System.out.println("user ID : " + rs.getInt("user_id"));
					System.out.println("userName : "+rs.getString("username"));
					System.out.println("email : "+ rs.getString("email"));
					System.out.println("Registration Date : " + rs.getDate("reg_date"));
				}else {
					//boolean ID or Email �ϳ��� ��ġ���� �ʴ� ��� ó��
					boolean isTrue = (userId == rs.getInt("user_id")) ? true : false;
					boolean emailTrue = email.equalsIgnoreCase(rs.getString("email"));
					if(!isTrue && emailTrue) {
						System.out.println("��ġ���� �ʴ� user ID�Դϴ�.");
						System.out.println();
     					}else if(isTrue&&!emailTrue) {
						System.out.println("��ġ���� �ʴ� user email�Դϴ�.");
					}else {
						System.out.println("��ġ�ϴ� user id �� email�� ã�� �� �����ϴ�.");
						System.out.println();
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void selectAll() {
		// 1. DB���� url, username, password
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "khcafe";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
			UserDAO userDAO = new UserDAO(connection);
			List<UserVO> users = userDAO.getAllUsers();
			for(UserVO u : users) {
				System.out.println("User Id : "+u.getUserId());
				System.out.println("User name : "+u.getUserName());
				System.out.println("User email : "+u.getEmail());
				System.out.println("Registration Date : "+u.getRegDate());
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertRun() {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "khcafe";
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
			UserDAO userDao = new UserDAO(connection);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("userId : ");
			int userId = sc.nextInt();
			System.out.println("���̵� �Է����ּ���.: ");
			String userName =  sc.next();
			
			System.out.println("ȸ�������� ���� �� �������ϴ�.");
			System.out.println("���������� �̸����ۼ����ּ���.");
			String email = sc.next();
			
			Date regDate = new Date();//���糯¥�� �ð��� ����Ѵٴ� �ǹ�
			
			//DB�� ��� ���� �ν��Ͻ� ���� �� �ۼ����� ���� �����ϱ�
			UserVO newUser = new UserVO();
			newUser.setUserId(userId);
			newUser.setUserName(userName);
			newUser.setEmail(email);
			newUser.setRegDate(regDate);
			
			//�����Ͱ� ���������� ������ Ȯ��
			if(userDao.createUser(newUser)) {
				System.out.println("������ ���������� ����� �Ǿ����ϴ�.");
			}else
			{
				System.out.println("����");
			}
			
			//����ݱ�
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
