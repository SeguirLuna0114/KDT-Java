package p2023_07_28;

// 추상 클래스 : 인스턴스(객체)를 직접 생성할 수 없는 클래스
// 메소드 다형성(polymorphism)
// : 부모 추상 클래스를 상속 받으면, 자식 클래스들은 추상 메소드를 모두 메소드 오버라이딩 해서
//   동일한 이름을 갖고 있으나, 서로 다른 내용으로 동작하는 것을 메소드 다형성이라 함

// 추상클래스
abstract class ShapeClass {
	// 추상 메소드 선언
	abstract void draw();
}

// 추상클래스를 상속받는 자식클래스
class Circ extends ShapeClass {
	// 메소드 오버라이딩
	// 추상클래스의 추상메소드를 구현
	void draw() {
		System.out.println("원을 그린다");
	}
}

// 추상클래스를 상속받는 자식클래스
class Rect extends ShapeClass {
	// 메소드 오버라이딩
	// 추상클래스의 추상메소드를 구현
	void draw() {
		System.out.println("사각형을 그린다");
	}
}

// 추상클래스를 상속받는 자식클래스
class Tria extends ShapeClass {
	// 메소드 오버라이딩
	// 추상클래스의 추상메소드를 구현
	void draw() {
		System.out.println("삼각형을 그린다");
	}
}

public class AbstractTest02_MethodPolymorphism {
	
	public static void main(String args[]) {
		
		Circ c = new Circ();
		Rect r = new Rect();
		Tria t = new Tria();

		// 메소드 다형성을 이용해 자식클래스의 객체를 추상클래스의 객체로 취급하여 
		// 추상메소드 호출 가능
		c.draw();
		r.draw();
		t.draw();
	}
}
