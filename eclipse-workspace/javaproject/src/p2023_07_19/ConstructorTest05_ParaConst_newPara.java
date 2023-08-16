package p2023_07_19;

// 기본 생성자는 객체를 생성할 때 컴파일러가 자동으로 생성해주지만,
// 매개변수를 가진 생성자가 정의된 경우, 더이상 기본 생성자를 만들어주지X
class MyDate05 {

	// 필드(field), 멤버변수(하나의 코드를 구성하는 멤버라는 의미)
	// 접근제어자 private: 비공개 클래스. 자신의 클래스 내에서만 접근 가능
	private int year;	
	private int month;
	private int day;

	// 생성자 - 1. 객체생성시 호출됨 2. 필드값 초기화(초기값 설정)
	// 기본 생성자: ()안에 매개변수가 없는 생성자
	// -기본 생성자는 객체가 생성될때 컴파일러가 자동으로 생성해줌
	public MyDate05() {
	}

	// 생성자 - 변수 new_year, new_month, new_day
	public MyDate05(int new_year, int new_month, int new_day) {
		// 필드값 할당/초기값 설정
		// 생성자의 매개변수 이름과 필드 이름이 달라서, 이름 충돌X
		year = new_year;
		month = new_month;
		day = new_day;
	}	// 객체를 생성할 때 원하는 값을 전달하여 초기화 가능

	// 메소드(method)
	// 메소드 반환타입이 void인 경우, 어떤 값도 반환X
	public void print() {
		System.out.println(year + "/" + month + "/" + day);
	}
}

public class ConstructorTest05_ParaConst_newPara {
	// main메소드를 가진 클래스 => 독립적으로 실행 가능
	public static void main(String[] args) {
		
		// 기본 생성자를 호출하여 d라는 객체 생성
		MyDate05 d = new MyDate05();	// MyDate05() = 기본생성자 호출 코드
		// Stack메모리 영역				heap메모리 영역
		// 		d	-------->	year=0, month=0, day=0 (int형이기에 필드 초기값 0)
		
		// print()메소드 호출을 위해서 MyDate 클래스의 객체 생성해야 함
		d.print();

		// 매개변수를 가진 생성자 호출 - 자료형에 맞는 값 입력하여 호출
		MyDate05 d2 = new MyDate05(2023, 7, 19);
		// Stack메모리 영역				heap메모리 영역
		// 		d	-------->	year=2023, month=7, day=19
		
		// print()메소드 호출을 위해서 MyDate 클래스의 객체 생성해야 함
		d2.print();
	}
}