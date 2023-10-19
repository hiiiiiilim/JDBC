package chap2_MVC;

import java.util.Scanner;

public class cafeView {
	//cafeModel이라는 클래스를 가지고 오기 위해 멤버변수로 카페 모델을 추가함
	public cafeModel model;
	
	//model 매개변수를 받을 수 있는 생성자를 만들어줘야함
	public cafeView(cafeModel model) {
		this.model=model;
	}
	
	public void addCafeName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 정보를 입력하세요.");
		System.out.println("상호명: ");
		String cname = sc.nextLine();
		System.out.println("카페 주소: ");
		String address = sc.nextLine();
		System.out.println("카페 연락처 : ");
		String phone_number = sc.nextLine();
		System.out.println("카페 운영 시간: ");
		String operating_hours = sc.nextLine();
		
		//카페 모델에서 insertcafe 메서드를 가지고 와야함
		model.insertCafe(cname, address, phone_number, operating_hours);
		System.out.println("카페가 성공적으로 추가되었습니다.");
	}
	
	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴 설명을 업데이트 하세요.");
		System.out.print("메뉴 ID : ");
		int menuId = sc.nextInt(); 
		System.out.print("카페 ID : ");
		int cafeId = sc.nextInt();
		System.out.print("수정할 메뉴 설명:");
		String description = sc.next();
		
		//모델에 있는 UdateMenu를 가지고 와서 사용자가 작성한 수정내용 추가하기
		model.UpdateMenu(description, menuId, cafeId);
		System.out.println("메뉴가 성공적으로 수정이 되었습니다.");
	}
	
	public void updatecafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 운영시간을를 업데이트하세요.");
		System.out.print("카페 ID : ");
		int cafeId = sc.nextInt();
		System.out.println("카페 운영시간 : ");
		String ophour = sc.next();
		
		model.UpdateCafe(ophour, cafeId);
		System.out.println("운영시간이 성공적으로 수정되었습니다.");
		
	}
	
	public void deleteCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페를 삭제하겠습니다.");
		System.out.print("삭제할 카페의 아이디를 입력하세요.");
		int cafeId = Integer.parseInt(sc.next());
		
		model.deleteCafe(cafeId);
		System.out.println("카페가 삭제되었습니다.");
	}
	
	public void deleteMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴를 삭제하겠습니다.");
		System.out.println("삭제할 메뉴의 아이디를 적어주세요");
		int menuId = Integer.parseInt(sc.next());
		
		model.deleteMenu(menuId);
		System.out.println("메뉴가 삭제 되었습니다.");
	}
	
	public void deleteOrder() {
		Scanner sc = new Scanner(System.in);
		System.out.println("주문을 삭제하겠습니다.");
		System.out.print("삭제할 주문의 아이디를 선택하세요 : ");
		int orderId = sc.nextInt();
		model.deleteOrder(orderId);
		
		System.out.println("주문이 삭제 되었습니다.");
	}
}
