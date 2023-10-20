package com.kh.update_MVC_Sington;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateView {
	public void updateProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������Ʈ�� ��ǰ�� ���̵� �Է��ϼ���.");
		System.out.println("��ǰ ID : ");
		int productId = sc.nextInt();
		System.out.println("������Ʈ�� ���� ����");
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
			System.out.println("���� ������ ���������� ����Ǿ����ϴ�.");
		}else {
			System.out.println("��ǰ ���� ���� �� ������ �߻��߽��ϴ�.");
		}
		
		sc.close();
	}
}
