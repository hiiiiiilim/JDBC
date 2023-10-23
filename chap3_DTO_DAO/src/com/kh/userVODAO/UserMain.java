package com.kh.userVODAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		UserMain um = new UserMain();
		
		um.selectAll();
	}	

	public void selectScanner
	
	public void selectAll() {
		// 1. DB연결 url, username, password
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
			System.out.println("아이디를 입력해주세요.: ");
			String userName =  sc.next();
			
			System.out.println("회원가입이 거의 다 끝났습니다.");
			System.out.println("마지막으로 이메일작성해주세요.");
			String email = sc.next();
			
			Date regDate = new Date();//현재날짜와 시간을 사용한다는 의미
			
			//DB에 담기 위해 인스턴스 생성 후 작성받은 정보 저장하기
			UserVO newUser = new UserVO();
			newUser.setUserId(userId);
			newUser.setUserName(userName);
			newUser.setEmail(email);
			newUser.setRegDate(regDate);
			
			//데이터가 정상적으로 들어갔는지 확인
			if(userDao.createUser(newUser)) {
				System.out.println("유저가 성공적으로 등록이 되었습니다.");
			}else
			{
				System.out.println("실패");
			}
			
			//연결닫기
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
