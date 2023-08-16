package p2023_07_27;

// 상속 - 클래스 3개 필요(부모/자식/메인)
// - 부모클래스의 "필드"는 자식 클래스에게 상속됨

// protected접근제어자: 해당 클래스 내부에서 접근 가능 & 자식 클래스에서도 접근 가능

// 1. 부모클래스
class Point2D {
	// private접근제어자일 경우에만, 직접 접근X
	// 자식 클래스더라도, 외부 클래스로 인식하기에 상속되지 X => 상속에서는 private접근제어자X
//	private int x = 10;
//	private int y = 10;
	
	// protected 정수 필드
	// protected로 선언되어, 자식 클래스에서도 접근 가능(자식클래스에 상속됨O)
	// - default접근제어자도 자식클래스에 상속 가능O(오직 private접근제어자만 상속X)
	protected int x = 10; // private int x=10;
	protected int y = 10; // private int y=10;
}

// 2. 자식 클래스
class Point3D extends Point2D {	
	// 부모클래스(Point2D)를 상속받은 자식클래스(Point3D)
	// => 부모클래스의 모든 필드와 메서드를 상속받음
	// 		= Point2D클래스의 x, y 필드 상속받아 사용 가능
	
	// protected로 선언되어, 자식 클래스에서도 접근 가능(자식클래스에 상속됨O)
	protected int z = 30;

	// print()메서드 - 현재 객체의 x, y, z값 출력하는 역할
	public void print() {
		// x,y는 부모클래스의 필드를 상속받아 사용 가능
		System.out.println(x + ", " + y + ", " + z);
	}
}

// 3. 메인클래스
class SuperSub04_Inheritance_protectedField {
	
	public static void main(String[] args) {
		
		// Point3D클래스(자식클래스)의 객체를 생성
		Point3D pt = new Point3D();
		
		// 객체를 통해 print()클래스 호출
		pt.print();
	}
}