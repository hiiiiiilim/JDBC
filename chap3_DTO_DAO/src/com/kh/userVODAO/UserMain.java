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
	
	public boolean checkId(int userId/*id받는 파라메터*/) throws SQLException {
		//1. DB연결
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "khcafe";
		Connection cc = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
		
		//2.sql
		String sql = "select * from userinfo where user_id = ?";
		PreparedStatement ps = cc.prepareStatement(sql);
		ps.setInt(1, userId);
		
		//결과 집합을 보는 것
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			int id = rs.getInt("user_id");
			return id > 0;//아이디가 1이상이면 true
		}
		return false; //일치하지 않을때
	}
	
	public boolean checkEmail(String email) throws SQLException {
		//1. DB연결
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "khcafe";
		Connection cc = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
		
		String sql = "select count(*) from userinfo where email = ?";
		PreparedStatement st = cc.prepareStatement(sql);
		st.setString(1, email);
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			int count = rs.getInt(1);
			return count > 1;
		}
		
		return false;
	}
	
	public void selectScanner() {
		// 1. DB연결 url, username, password
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassWord = "khcafe";
		
		
		try {
			Connection cc = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("User ID 입력하세요.");
				System.out.println("종료하고 싶다면 e 입력");
				String input = sc.next();
				System.out.println("User 이메일을 입력하세요");
				String email = sc.next();
				
				//만약에 e를 입력했다면 
				if("e".equalsIgnoreCase(input)) {
					System.out.println("종료");
					break; //break가 없으면 종료되지않음
				}
				
				int userId = Integer.parseInt(input);
				//select 문 출력하기
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
					//boolean ID or Email 하나가 일치하지 않는 경우 처리
					boolean isTrue = checkId(userId);
					boolean emailTrue = checkEmail(email);
					if(!isTrue && emailTrue) {
						System.out.println("일치하지 않는 user ID입니다.");
						System.out.println();
     					}else if(isTrue&&!emailTrue) {
						System.out.println("일치하지 않는 user email입니다.");
					}else {
						System.out.println("일치하는 user id 와 email을 찾을 수 없습니다.");
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
