package p;

// 다른 패키지 내의 AccessTest클래스를 현재 코드에 사용하기 위해 import
// import할 클래스가 속한 패키지명.import할 클래스명;
import packTest.packOne.AccessTest;

// 접근 제어자에 따른 필드와 메서드의 접근가능성
//1. 상속 관계가 있는 경우
//1-1. 2개의 클래스(부모,자식 클래스)가 같은 패키지에 속할 때 
//	   부모의 접근제어자가 default, protected, public 접근제어자인 경우에
//	   자식클래스에서 접근가능. (단, private접근 제어자만 접근X)
//1-2. 2개의 클래스(부모,자식 클래스)가 다른 패키지에 속할 때
//		부모의 접근제어자가  protected, public 접근제어자인 경우에
//		자식클래스에서 접근 가능 
//2. 상속 관계가 없는 경우에
//	  2개의 클래스가 서로 다른 패키지 않에 들어 있을때는 public 
//	  접근제어자로 되어 있어야만 다른 클래스에서 접근 할 수 있다.

//AccessTest의 서브 클래스로 SubOne을 설계
class SubOne extends AccessTest {
	// 상속을 통해, 자식클래스(SubOne)는 부모클래스(AccessTest)의 필드, 메서드를 상속받음
	
	// 메서드
	void subPrn() {
		// 부모클래스의 필드(멤버변수)를 사용
		// 단, 부모클래스에서 a는 private접근제어자로 선언되어 상속X
		System.out.println(a); // [1. Sub] private -X
		// default 접근제어자로 선언되었기에 "같은 패키지 내에서만" 상속가능
		System.out.println(b); // [2. Sub] 기본 접근 지정자-X
		// protected 접근제어자로 선언된 경우 다른 패키지에서도 상속O
		System.out.println(c); // [3. Sub] protected -O
		// public 접근제어자인 경우에는 넓은 범위에서 접근 가능
		System.out.println(d); // [4. Sub] public -0
	}
}

//AccessTest랑 상속관계가 없는 클래스
// 상속관계가 없는 경우에는 public 접근제어자만 다른 클래스에서 접근O
class SuperSubA {
	
	public static void main(String[] args) {
		// 부모클래스(AccessTest)의 객체 생성
		AccessTest at = new AccessTest();
		
		// 객체를 통해 부모클래스의 메소드 호출
		at.print();
		
		System.out.println("main");
		
		// 부모클래스의 private 멤버변수 a는 외부 클래스에서 접근X
		System.out.println(at.a); // [1. main] private -X
		// 부모클래스의 default 멤버변수는 "같은 패키지 내에서만" 접근가능
		System.out.println(at.b); // [2. main] 기본 접근 지정자-X
		// 부모클래스의 protected 멤버변수를 접근하려면 다른 패키지에서는 상속받는 클래스에서만 접근 가능
		System.out.println(at.c); // [3. main] protected -X
		// 부모클래스의 public 멤버변수는 가장 넓은 범위에서 접근 가능하기에 정상접근O
		System.out.println(at.d); // [4. main] public -O
	}
}