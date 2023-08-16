package p2023_07_20;

// 정적필드 - 공유, 업데이트됨
// 인스턴스 필드 - 각 인스턴스마다 독립적인 값 유지
class StaticTest {
	// 정적 필드: 메소드 영역(공유영역)에 저장됨
	// -값을 공유: 모든 인스턴스에서 공유하기 때문에, 
	// 	설정값이나 카운터, 공통으로 사용되는 상수 등을 저장하는데 유용
	static int a = 10;	// a=100(공유영역)
	
	// 인스턴스 멤버변수: 힙 메모리 영역에 저장됨
	// -독립적인 값 유지: 각 인스턴스마다 다른 값을 가짐, 객체마다 고유한 상태를 유지하는 데 사용
	int b = 20;
}

class StaticTest01_Diff_Static_Instan {
	public static void main(String[] args) {
		
		// 정적 필드 접근 - 클래스명.정적필드명
		System.out.println("StaticTest.a->" + StaticTest.a);
		
		// 클래스의 객체를 생성하여 접근
		StaticTest s1 = new StaticTest();
		StaticTest s2 = new StaticTest();

		System.out.println("s1.a->" + s1.a + "\t  s2.a->" + s2.a);
		// s1.a->10	  s2.a->10
		System.out.println("s1.b->" + s1.b + "\t  s2.b->" + s2.b);
		// s1.b->20	  s2.b->20

		// 정적필드는 모든 인스턴스에 대해 "업데이트"되어 반영됨
		// (정적(static) 필드는 해당 클래스의 모든 인스턴스들 사이에서 공유됨)
		s1.a = 100;
		System.out.print("s1.a->" + s1.a);
		// s1.a->100	  
		System.out.println("\t  s2.a->" + s2.a + "  ");
		// s2.a->100 (정적 필드는 공유되기 때문)
		System.out.println(StaticTest.a);
		// 100

		// 인스턴스 필드는 각 인스턴스마다 다른 값을 가짐
		s1.b = 200;
		System.out.print("s1.b->" + s1.b);
		// s1.b->200
		System.out.println("\t  s2.b->" + s2.b);
		// s2.b->20
	}
}