package p2023_07_19;

// 같은 패키지 내에서 class명이 같으면 오류 발생됨
// main메소드가 없어서 독립적으로 실행X, 컴파일만 가능
class MyDate03 {

	// 필드(field), 멤버변수(하나의 코드를 구성하는 멤버라는 의미)
	// 접근제어자 private: 비공개 클래스. 자신의 클래스 내에서만 접근 가능
	private int year;
	private int month;
	private int day;

	// 생성자 - 1. 객체생성시 호출됨 2. 필드값 초기화(초기값 설정)
	// 접근제어자 public: 가장 넓은접근 허용. 외부 클래스 접근 허용
	public MyDate03() { // 기본 생성자: ()안에 매개변수가 없는 생성자
		// 필드값 초기화 - 클래스의 멤버변수 초기값 설정(초기화 작업)
		year = 2023;
		month = 4;
		day = 1;
	}	// 항상 고정된 초기값을 가짐

	// 메소드(method)
	// 메소드 반환타입이 void인 경우, 어떤 값도 반환X
	public void print() {
		// print()메소드 - year, month, day 멤버변수를 활용하여 날짜정보 출력
		System.out.println(year + "/" + month + "/" + day);
	}

}// MyDate end

public class ConstructorTest03_InitValue {
	
	public static void main(String[] args) {
		// MyDate03클래스의 생성자를 호출하여 d라는 객체 생성
		MyDate03 d = new MyDate03();
		// 생성자에 의해 객체d가 생성되면서, 각 필드를 초기화 
		// Stack메모리 영역				heap메모리 영역
		// 		d	-------->	year=2023, month=4, day=1
		
		// print()메소드 호출을 위해서 MyDate 클래스의 객체 생성해야 함
		d.print();	// print()메소드 호출
		
		// private 접근제어자: 외부 클래스의 접근 허용X = 직접접근X
//		System.out.println(d.year); 	// 오류발생
		
		
	}
}