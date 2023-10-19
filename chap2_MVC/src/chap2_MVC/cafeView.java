package chap2_MVC;

import java.util.Scanner;

public class cafeView {
	//cafeModel�̶�� Ŭ������ ������ ���� ���� ��������� ī�� ���� �߰���
	public cafeModel model;
	
	//model �Ű������� ���� �� �ִ� �����ڸ� ����������
	public cafeView(cafeModel model) {
		this.model=model;
	}
	
	public void addCafeName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�� ������ �Է��ϼ���.");
		System.out.println("��ȣ��: ");
		String cname = sc.nextLine();
		System.out.println("ī�� �ּ�: ");
		String address = sc.nextLine();
		System.out.println("ī�� ����ó : ");
		String phone_number = sc.nextLine();
		System.out.println("ī�� � �ð�: ");
		String operating_hours = sc.nextLine();
		
		//ī�� �𵨿��� insertcafe �޼��带 ������ �;���
		model.insertCafe(cname, address, phone_number, operating_hours);
		System.out.println("ī�䰡 ���������� �߰��Ǿ����ϴ�.");
	}
	
	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴� ������ ������Ʈ �ϼ���.");
		System.out.print("�޴� ID : ");
		int menuId = sc.nextInt(); 
		System.out.print("ī�� ID : ");
		int cafeId = sc.nextInt();
		System.out.print("������ �޴� ����:");
		String description = sc.next();
		
		//�𵨿� �ִ� UdateMenu�� ������ �ͼ� ����ڰ� �ۼ��� �������� �߰��ϱ�
		model.UpdateMenu(description, menuId, cafeId);
		System.out.println("�޴��� ���������� ������ �Ǿ����ϴ�.");
	}
	
	public void updatecafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�� ��ð����� ������Ʈ�ϼ���.");
		System.out.print("ī�� ID : ");
		int cafeId = sc.nextInt();
		System.out.println("ī�� ��ð� : ");
		String ophour = sc.next();
		
		model.UpdateCafe(ophour, cafeId);
		System.out.println("��ð��� ���������� �����Ǿ����ϴ�.");
		
	}
	
	public void deleteCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�並 �����ϰڽ��ϴ�.");
		System.out.print("������ ī���� ���̵� �Է��ϼ���.");
		int cafeId = Integer.parseInt(sc.next());
		
		model.deleteCafe(cafeId);
		System.out.println("ī�䰡 �����Ǿ����ϴ�.");
	}
	
	public void deleteMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴��� �����ϰڽ��ϴ�.");
		System.out.println("������ �޴��� ���̵� �����ּ���");
		int menuId = Integer.parseInt(sc.next());
		
		model.deleteMenu(menuId);
		System.out.println("�޴��� ���� �Ǿ����ϴ�.");
	}
	
	public void deleteOrder() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�ֹ��� �����ϰڽ��ϴ�.");
		System.out.print("������ �ֹ��� ���̵� �����ϼ��� : ");
		int orderId = sc.nextInt();
		model.deleteOrder(orderId);
		
		System.out.println("�ֹ��� ���� �Ǿ����ϴ�.");
	}
}
