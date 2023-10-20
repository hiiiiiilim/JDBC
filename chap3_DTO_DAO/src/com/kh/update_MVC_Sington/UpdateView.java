package com.kh.update_MVC_Sington;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateView {
	public void updateProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("업데이트할 제품의 아이디를 입력하세요.");
		System.out.println("제품 ID : ");
		int productId = sc.nextInt();
		System.out.println("업데이트할 가격 정보");
		Double price = sc.nextDouble();
		
		UpdateDTO updateProduct = new UpdateDTO(productId,price);
		UpdateModel updateModel;
		
		boolean success = false;
		
		try {
			updateModel = UpdateModel.getInstance();
			success = updateModel.updateProduct(updateProduct);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(success) {
			System.out.println("제의 가격이 성공적으로 변경되었습니다.");
		}else {
			System.out.println("제품 가격 변경 중 오류가 발생했습니다.");
		}
		
		sc.close();
	}
}
