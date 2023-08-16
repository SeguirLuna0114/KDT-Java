package p2023_07_20;

// 생성자 오버로딩(Overloading): 한개의 클래스에 여러개의 생성자 정의
// -조건) 매개변수의 자료형, 매개변수의 갯수, 매개변수 순서를 달리하는 생성자 여러개 선언
// -외부에서 제공되는 다양한 데이터를 사용하여 객체화 하기 위함

// this()키워드 : 같은 클래스안에 있는 생성자 내부에서, 다른 생성자를 호출할때 사용

class MyDate10 {

	// 필드(field), 멤버변수(하나의 코드를 구성하는 멤버라는 의미)
	// - 객체가 생성될 때 heap 메모리상에서 값을 저장하는 역할
	private int year;
	private int month;
	private int day;

	// 생성자 - 1. 객체생성시 호출됨 2. 필드값 초기화(초기값 설정)
	public MyDate10() {	// 기본 생성자
		// this()를 통해 MyDate10(int, int, int) 생성자 호출
		this(2023, 1, 1);	// 같은 클래스 내의 다른 생성자를 호출하여 기본 값을 설정
	}

	public MyDate10(int new_year) {	
		// MyDate10클래스의 년도 정보만 받아서 초기화
		// this()를 통해 MyDate10(int, int, int) 생성자 호출
		this(new_year, 1, 1);	// 같은 클래스 내의 다른 생성자를 호출하여 기본 값을 설정
	}

	public MyDate10(int new_year, int new_month) {
		// MyDate10클래스의 년도와 월 정보만 받아서 초기화
		// this()를 통해 MyDate10(int, int, int) 생성자 호출
		this(new_year, new_month, 1);	// 같은 클래스 내의 다른 생성자를 호출하여 기본 값을 설정
	}

	public MyDate10(int new_year, int new_month, int new_day) {
		year = new_year;
		month = new_month;
		day = new_day;
	}

	// 메소드
	// (생성자에서 초기화된) 필드값 출력하는 역할
	public void print() {
		System.out.println(year + "/" + month + "/" + day);
	}
}

public class ConstructorTest10_this_ConstOverload {
	//메인함수
	public static void main(String[] args) {
		
		// MyDate10 클래스의 객체를 생성하기위해 생성자 호출
		MyDate10 d = new MyDate10(2023, 7, 19);
		d.print();		// 2023/7/19
		
		MyDate10 d2 = new MyDate10(2023, 7);
		d2.print();		// 2023/7/1
		
		MyDate10 d3 = new MyDate10(2023);
		d3.print();		// 2023/1/1
		
		// 기본생성자 호출
		MyDate10 d4 = new MyDate10();
		d4.print();		// 2023/1/1
		
		
	}
}