package p2023_07_27;

// 상속에서의 생성자
// 1. 생성자는 기본적으로 상속X
// 2. 자식클래스를 이용해서 객체를 생성할때 자식클래스의 
// 	  생성자(기본생성자,매개변수 있는 생성자 모두 가능)가 호출되면, 
//	  부모클래스의 "기본생성자"가 자동으로 호출된다.
// 3. 부모 클래스에 기본생성자가 없고, 매개변수가 있는 생성자가 있는 경우에는
//    더이상 컴파일러가  기본 생성자를 자동으로 생성해 주지 않는다.
// 4. 부모 클래스의 매개변수가 있는 생성자를 자식 클래스에서 호출 할때는
//    super() 키워드를 이용해서 호출할 수 있다.

// 부모클래스
class Point2D_05 {
	
	// 정수 필드 - protected접근제어자로 선언(상속O)
	protected int x = 10;
	protected int y = 20;

	// 기본생성자
	public Point2D_05() {
		System.out.println("슈퍼 클래스인 Point2D 생성자 호출");
	}
}

// 자식클래스
class Point3D_05 extends Point2D_05 {
	
	// 정수 필드 - protected접근제어자로 선언(상속O)
	protected int z = 30;

	public void print() {
		System.out.println(x + ", " + y + "," + z);
	}

	// 기본생성자
	public Point3D_05() {
		System.out.println("서브 클래스인 Point3D 생성자 호출");
	}
}

// 메인클래스
class SuperTest05_Inherit_ConstChaining {
	
	public static void main(String[] args) {
		
		// 자식클래스의 기본생성자 호출 -> 자식클래스의 객체 생성
		// 자식클래스의 생성자가 호출될 때, 연쇄적으로 부모클래스의 "기본생성자" 호출
		Point3D_05 pt = new Point3D_05();
		// 슈퍼 클래스인 Point2D 생성자 호출 (부모클래스의 기본생성자가 먼저 호출됨)
		// 서브 클래스인 Point3D 생성자 호출
		
		// 자식클래스의 print()메소드 호출
		pt.print();
	}
}