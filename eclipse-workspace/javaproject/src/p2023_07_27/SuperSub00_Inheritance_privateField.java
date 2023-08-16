package p2023_07_27;

// 상속
// 1) 자바에서 자식클래스가 부모클래스를 상속받을 때 extends로 상속받음
// 2) 자바에서 부모 클래스를 상속받으면, 부모클래스 안의 필드, 메소드만 상속받을 수 있음
//		(생성자는 상속X)

// 1. 부모 클래스
class Point2Dim {
	
	// private 정수필드
	private int x;
	private int y;

	// 생성자가 정의되지X => 호출시, 매개변수가 없는 기본 생성자가 사용됨
	
	// get()메소드: 클래스 내의 필드값에 접근 가능
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	// set()메소드: 클래스 내의 필드값을 수정/설정 가능
	public void setX(int new_X) {
		x = new_X;
	}

	public void setY(int new_Y) {
		y = new_Y;
	}
}

// 2. 자식 클래스
class Point3Dim extends Point2Dim {
	// 자식클래스(Point3Dim)는 부모클래스(Point2Dim)를 상속받음
	// => 상속을 통해 부모 클래스의 모든 멤버(필드, 메소드)를 상속받음
	
	// private 정수필드
	private int z;

	// get()메소드: 클래스 내의 필드값에 접근 가능
	public int getZ() {
		return z;
	}

	// set()메소드: 클래스 내의 필드값을 수정/설정 가능
	public void setZ(int new_Z) {
		z = new_Z;
	}
}

// 3. 메인 클래스
class SuperSub00_Inheritance_privateField {
	
	public static void main(String[] args) {

		// 자식클래스(Point3Dim)의 객체 생성
		Point3Dim pt = new Point3Dim();
		
		// private접근제어자로 선언된 필드에 set()메소드를 사용하여 우회접근
		
		// 부모클래스로부터 상속받은 메소드 호출가능
		pt.setX(10); // 상속받아 사용
		pt.setY(20); // 상속받아 사용
		
		// 자신(자식클래스)의 메소드 호출
		pt.setZ(30); // 자신의 것 사용
		
		// 해당 필드 출력
		System.out.println(pt.getX()// 상속받아 사용
				+ ", " + pt.getY()// 상속받아 사용
				+ ", " + pt.getZ());// 자신의 것 사용
	}
}