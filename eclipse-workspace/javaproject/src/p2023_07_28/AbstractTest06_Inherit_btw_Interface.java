package p2023_07_28;

// 인터페이스끼리의 상속
// : 인터페이스끼리 상속 받을 때는 extend로 상속을 받아야 하고, 다중상속도 가능
// - 인터페이스 내에서는 메소드 오버라이딩이 불가능(일반메소드가 되어버리기 때문)
// => 최종적으로 상속받는 일반 구현 클래스에서 모든 추상 메소드를 메소드 오버라이딩 진행

// 인터페이스
interface IHello06 {
	// 상수 : public static final이 생략됨
	int a = 10;
	double  b = Math.PI;
	boolean c = false;

	// 추상 메소드
	public abstract void sayHello(String name);
}

// 인터페이스
interface IGoodBye06 {
	
	// 추상 메소드
	public abstract void sayGoodBye(String name);
}

// 인터페이스끼리 상속 받을 때는 extend로 상속을 받아야 하고, 다중상속도 가능
interface ITotal extends IHello06, IGoodBye06 {
	// 추상메소드
	// 인터페이스 내에서는 메소드오버라이딩 불가능
	public abstract void greeting(String name);
}

// 일반 구현 클래스에서 상속받은 인터페이스를 상속받아야함
class SubClass06 implements ITotal {
	// 최종적으로 상속받는 일반 구현 클래스에서 모든 추상 메소드를 메소드 오버라이딩 진행
	// 메소드 오버라이딩
	public void sayHello(String name) {
		System.out.println(name + "씨 안녕하세요!");
	}

	// 메소드 오버라이딩
	public void sayGoodBye(String name) {
		System.out.println(name + "씨 안녕가세요!");
	}

	// 메소드 오버라이딩
	public void greeting(String name) {
		System.out.println(name + ", 안녕!");
	}
}

// 메인 클래스
class AbstractTest06_Inherit_btw_Interface {
	
	public static void main(String[] args) {
		
		SubClass06 test = new SubClass06();
		
		// 메소드 오버라이딩 된 메소드가 호출됨
		test.sayHello("홍길동");
		test.sayGoodBye("홍길동");
		test.greeting("홍길동");
		
		// 인터페이스 내에서 선언된 상수는 public static final이 생략된것
		// 인터페이스명.상수 로 접근 가능
		System.out.println("a= "+IHello06.a);
		System.out.println("b= "+IHello06.b);
		System.out.println("c= "+IHello06.c);
		
		// final로 선언된 상수이기에, 값을 수정할 수 없음
//		IHello06.a = 30;		// 오류 발생
	}
}