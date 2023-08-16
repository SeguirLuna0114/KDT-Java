package p2023_07_21;

//static - 공유를 한다는 의미
//private - 외부 클래스에서 접근 제한한다는 의미
//=> 모순이 발생
class StaticTest3 {

	// 정적 필드: 메소드 영역(공유영역)에 저장됨
	// -값을 공유: 모든 인스턴스에서 공유하기 때문에,
	// 설정값이나 카운터, 공통으로 사용되는 상수 등을 저장하는데 유용
	private static int a = 10; // private와 static이 혼용되어 오류 발생
	// 정적 필드 a는 클래스의 인스턴스에서 동일한 값을 가지게됨
	
	// 인스턴스 멤버변수: 힙 메모리 영역에 저장됨
	// -독립적인 값 유지: 각 인스턴스마다 다른 값을 가짐, 객체마다 고유한 상태를 유지하는 데 사용
	private int b = 20; // private-외부클래스 접근 허용X
	// 객체(인스턴스)마다 독립적인 값을 유지함

	// 출력 정적 메소드 - 객체의 인스턴스와는 상관없이 클래스명.메소드명으로 호출 가능
	public static void printA() { // 정적 메서드에서는 this를 사용하지 못함
		System.out.println(a);	// 메소드를 활용하여 정적필드에 접근 가능
//    	System.out.println(this.a);   //컴파일 에러 발생
		
		//정적메소드 내에서는 정적필드만 사용 가능
//    	System.out.println(this.b);   
	}

	// 출력 인스턴스 메소드 - 객체 생성 후에 해당 객체(인스턴스)로부터 호출 가능
	// 객체명.메서드명()으로 호출
	public void printB() { // this는 인스턴스 메서드에서 여러 객체에 의해서
		// 인스턴스 메소드 내에서는 정적필드사용O
		System.out.println(b); // 메서드가 호출될 때 이를 구분하기 위해서 사용된다.
		System.out.println(a);  	
//		System.out.println(this.b);	// 인스턴스 필드에서는 this.사용 가능
	}
	
	// 인스턴스 메소드 - 인스턴스 변수 값 얻는 메소드
	public int getB() {
		return b;
	}
}

public class StaticTest03_Static_X_this {

	public static void main(String[] args) {
		// 정적메소드 호출 - 클래스명.정적메소드명
		StaticTest3.printA();
		System.out.println();

		// 클래스의 인스턴스 생성
		StaticTest3 s1 = new StaticTest3();
		StaticTest3 s2 = new StaticTest3();

		// 각각의 인스턴스로부터 printB라는 인스턴스 메소드 호출
		s1.printB();
		System.out.println();
		
		s2.printB();
		System.out.println();
		
		System.out.println(s1.getB());
	}
}