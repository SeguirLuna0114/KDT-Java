package p2023_07_21;

class StaticTest4 {
	
	// 정적 필드: 메소드 영역(공유영역)에 저장됨
	// -값을 공유: 모든 인스턴스에서 값이 공유
	private static int a = 10;	// private와 static이 혼용되어 오류 발생
	
	// 인스턴스 멤버변수: 힙 메모리 영역에 저장됨
	// -독립적인 값 유지: 각 인스턴스마다 다른 값을 가짐
	private int b = 20;

	// 출력 정적 메소드 - 객체의 인스턴스와는 상관없이 클래스명.메소드명으로 호출 가능
	public static void printA() {
		// 정적 메소드 안에는 정적 필드만 사용 가능
		System.out.println(a);
//		System.out.println(b); // 인스턴스 필드(b)는 컴파일 에러 발생
	}

	// 출력 인스턴스 메소드 - 객체 생성 후에 해당 객체(인스턴스)로부터 호출 가능
	public void printB() {
		// 인스턴스(일반)메소드에서는 정적필드와 인스턴스필드 모두 사용 가능
		System.out.println(a);	// 인스턴스 메소드 내에서는 정적필드사용O
		System.out.println(b);
	}
}

public class StaticTest04_Static_Instan_Method {
	
	public static void main(String[] args) {
		// 정적메소드 호출 - 클래스명.정적메소드명
		StaticTest4.printA();
		System.out.println();
		
		// 클래스의 인스턴스 생성
		StaticTest4 s1 = new StaticTest4();
		StaticTest4 s2 = new StaticTest4();
		
		// 각각의 인스턴스로부터 printB라는 인스턴스 메소드 호출
		s1.printB();
		System.out.println();
		
		s2.printB();
	}
}