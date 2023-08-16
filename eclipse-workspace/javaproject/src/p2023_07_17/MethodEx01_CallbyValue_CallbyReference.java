package p2023_07_17;

// 메소드(Method) : 여러가지 코드를 묶어 놓은 식
// - 메소드 사용 이유: 코드의 재사용을 위함
public class MethodEx01_CallbyValue_CallbyReference {
	
	// 사용자 정의 메소드
	// 사용자 정의 메소드는 프로그래머가 직접 호출해야 실행 됨
	// -static으로 선언됨 => 클래스에 직접적으로 연결됨
	// (클래스의 인스턴스 생성 없이도 check()메소드 호출 가능)
	// -반환타입 'void': 메소드가 반환하는 값이 없음. 
	// void반환 타입을 가지는 메소드는 명시적으로 return구문 작성하지 않아도 됨
	public static void check() {	//정적메서드(static이 붙음)
		System.out.println("메소드 호출 성공");
		return;					// void구문이 왔기에, 생략 가능함
	}
	
	// Call by Value방식 - 값 전달에 의한 전달 메소드 호출방식
	// - 기본 데이터타입(int, double, boolean등)과 같은 값을 저장하는 변수에 대해 적용
	// - 값을 복사하여 전달하는 방식=> 호출자의 변수에는 영향X
	static void check(int a) {	// 매개변수(parameter): int a 사용
		System.out.println("전달된 값: "+a);
		// 호출시 check(값)과 같이 인수로 전달된 값을 매개변수a에 복사
	}
	
	// 메소드 오버로딩(Method Overloading): 동일 이름 메소드 여러개 정의
	// - 매개변수 타입, 개수, 순서 증 하나는 서로 다른경우 사용 가능
	static void check(int a, double d) {
		double result =  a+d;			// 지역변수
		System.out.println("전달된 값의 합: "+result);
	}
	
	static void check(char c) {		// 매개변수 char c = 'A' 전달
		System.out.println("전달된 값: " + c);
	}
	
	static void check(boolean b) {	// 매개변수 boolean형 b=true 전달
		System.out.println("전달된 값: "+b);
	}
	
	// Call by Reference방식 - 주소값 전달에 의한 메소드 호출방식
	// - 메소드 호출 시, 호출자가 전달한 변수의 참조(주소)가 메소드로 전달되어 메소드 내부에서 해당 변수에 대한 변경이 가능해짐
	// (메소드 내에서 변수의 값이 변경되면, "호출자 변수에도 영향을 줌")
	// - 주소(참조)가 메소드로 전달됨(참조형 변수를 사용하면, 해당 변수는 객체의 주소를 가리킴)
	static void check(String s) {
		// String은 기본 자료형이 아님
		System.out.println("전달된 값: "+s);
		
	}
	
	// return구문: 메소드를 호출한 곳에 값을 돌려주는 역할
	// -return문은 메소드 가장 마지막줄에 사용해야 함
	static int check01() {	// int형 값을 메소드 호출한 곳에 돌려줌
		System.out.println("리턴구문");	
		return 50;	// int형 구문에 값 50을 돌려주는 역할(메소드 호출한 곳에 값을 돌려주는 역할)
//		System.out.println("리턴구문");	
	}
	
	static double check02(int a, double d) {
		double result = a + d;
		return result;			// 메소드 호출한 곳에 return
	}

	// public static void main: 자바 프로그램의 진입점 정의 메소드
	// - 자바 프로그램 실행 시 가장 먼저 호출되는 메소드. 프로그램 시작점
	// - main()메소드는 자바가상머신(JVM:java.exe)으로만 호출됨
	// - main()메소드는 프로그래머가 직접 호출X
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// check()메소드 호출
		MethodEx01_CallbyValue_CallbyReference.check();	
		check();				// 같은 클래스 내의 정적메소드는 클래스명 생략 가능
		
		// 매개변수a=30을 전달
		check(30);
		// 매개변수가 2개일 경우, 자료형에 맞는 값을 전달
		check(10, 20.5);		// int a=10, double d=20.5
		// 매개변수 char c = 'A' 전달
		check('A');
		// 매개변수 boolean형으로되어있기에 자료형에 맞는 값 전달
		check(true);
		
		// Call by Reference방식
		check("자바");				// String s = "자바": 자바라는 문자열을 인수로 전달
		// 문자열 그대로의 "자바"가 인수로 전달됨 -> 내부적으로 String객체로 변환되어 해당 객체의 주소가 메소드로 전달
		// (check 메소드 내에서 s는 "자바"라는 문자열을 가리키는 주소를 가짐
		check(new String("자바"));	// String s = new String("자바"): new String("자바")를 인수로 전달
		// (check 메소드 내에서 s는 새로 생성된 String객체의 주소를 가짐)
		// => 두 코드는 값은 같지만 주소는 다름
		
		// check01() 메서드 호출
		// check01메소드를 호출하지만, 반환된 값(return 50)을 사용하지는 않음
		// - 호출자가 반환 값을 받지 않기 때문 => 해당값은 무시되고 출력되지 않음
		check01();		// 단순히, check01메소드의 실행만을 수행. 반환값 무시
		
		// check01()메소드를 호출하고, 반환된 값을 문자열과 함께 출력
		// return 50과 같이 int형으로 돌려주기 때문
		int result = check01();		// check01()메소드를 호출하고, 반환된 값을 받아 사용
		System.out.println("돌려 받은 값1: "+result);		// 변수로 받아 출력
		
		// check01메소드의 반환값을 "직접" 출력함
		System.out.println("돌려 받은 값2: "+check01());	// return된 값을 받아 출력
		
		// check02() 메서드 호출
		// double result와 같이 double형으로 돌려줌
		double result2 = check02(50, 3.14);		// 50과 3.14라는 인수 전달 -> 메소드 호출 -> 연산 수행 -> result2에 반환된 값 할당
		System.out.println("돌려 받은 값3: "+result2);		// 변수로 받아 출력
		// check02메소드 호출 -> 두개의 매개변수 받아 double타입의 값 반환 -> 반환값을 result2변수에 저장

		// check02메소드의 반환값을 "직접" 출력함
		System.out.println("돌려 받은 값4: "+check02(50, 3.14));	// return된 값을 받아 출력
		
	}

}
