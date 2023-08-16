package p2023_07_27;

// 상속 - 부모클래스의 "필드"는 자식 클래스에게 상속됨
// protected접근제어자: 해당 클래스 내부에서 접근 가능 & 자식 클래스에서도 접근 가능

//1. 부모클래스
class Point2D_02 {
	
	// protected로 선언되어, 자식 클래스에서도 접근 가능(자식클래스에 상속됨O)
	protected int x = 10;
	protected int y = 20;
}

//2. 자식 클래스
class Point3D_02 extends Point2D_02 {
	// 부모클래스(Point2D_02)를 상속받은 자식클래스(Point3D_02)
	// - 부모클래스의 모든 필드와 메서드를 상속받음
	
	// protected로 선언되어, 자식 클래스에서도 접근 가능(자식클래스에 상속됨O)
	protected int z = 30;

	// print()메서드 - 현재 객체의 x, y, z값 출력하는 역할
	public void print() {
		
		// x와 y는 상속 받아 사용하는 멤버변수
		System.out.println(x + ", " + y + ", " + z); 
	}
}

//3. 메인클래스
class SuperTest02_Inheritance_protectedField {
	
	public static void main(String[] args) {
		
		// Point3D클래스(자식클래스)의 객체를 생성
		Point3D_02 pt = new Point3D_02();
		
		// 객체를 통해 print()클래스 호출
		pt.print();
	}
}