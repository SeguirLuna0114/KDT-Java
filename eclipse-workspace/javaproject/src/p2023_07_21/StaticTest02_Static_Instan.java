package p2023_07_21;

// static - 공유를 한다는 의미
// private - 외부 클래스에서 접근 제한한다는 의미
// => 모순이 발생
class StaticTest2 {
	
	// 정적 필드: 메소드 영역(공유영역)에 저장됨
	// -값을 공유: 모든 인스턴스에서 공유하기 때문에, 
	// 	설정값이나 카운터, 공통으로 사용되는 상수 등을 저장하는데 유용
	private static int a = 10;	// private와 static이 혼용되어 오류 발생
	
	// 인스턴스 멤버변수: 힙 메모리 영역에 저장됨
	// -독립적인 값 유지: 각 인스턴스마다 다른 값을 가짐, 객체마다 고유한 상태를 유지하는 데 사용
	private int b = 20;

	// 정적 메소드
	public static void setA(int new_a) {
		a = new_a;
	}

	// 정적 메소드
	public static int getA() {
		return a;
	}
}

public class StaticTest02_Static_Instan {
	
	public static void main(String[] args) {
		
		// 정적필드a는 private으로 선언되어서 외부접근이 불가 => 컴파일 에러 발생
//		System.out.println(StaticTest2.a);// a가 private으로 선언되어서 컴파일 에러 발생
		
		// 정적메소드 getA()호출 - 클래스명.정적메소드명
		System.out.println(StaticTest2.getA());	//10
		// private로 선언된 필드a에 메소드를 사용하여 우회 접근 가능

		
		// 클래스의 객체 생성
		StaticTest2 s1 = new StaticTest2();
		StaticTest2 s2 = new StaticTest2();

		// 정적메소드 접근하여 수정 - 클래스명.메소드명
		s1.setA(10000);		// a=10000 저장됨
		StaticTest2.setA(10000);
		
		// 
		int res1 = s1.getA();
		System.out.println(res1);		//10000
		System.out.println(s2.getA());	//10000
	}
}