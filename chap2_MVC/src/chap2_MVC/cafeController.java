package chap2_MVC;

import java.util.Scanner;

public class cafeController {
	public cafeModel model;
	public cafeView view;
	
	//������ �𵨰� �並 ������ �� ������
	public cafeController(cafeModel model, cafeView view) {
		this.model=model;
		this.view = view;
	}
	
	public void run() {
		Scanner sc = new Scanner(System.in);
		//������ ��ȣ ��� �޼���� �Է�
		
		
		boolean isTrue = true;
		while(isTrue) {
			System.out.println("1. ī�� ���� �߰�");
			System.out.println("2. �޴����� �߰�");
			System.out.println("3. ī�� ����");
			System.out.println("4. ��ð� ������Ʈ");
			System.out.println("9. ����");
			System.out.println("���ϴ� �۾��� �����ϼ���.");
			int choice = sc.nextInt();
			switch(choice) {
				case 1:
					view.addCafeName();
					break;
				case 2:
					view.updateMenu();
					break;
				case 3:
					view.deleteCafe();
					break;
				case 4:
					view.updatecafe();
					break;
				case 9:
					System.out.println("���α׷��� �����մϴ�.");
					isTrue =false;
					break;
				default :
					System.out.println("�ùٸ� ��ȣ�� �Է��ϼ���.");
			}
			
		}
	}
}
