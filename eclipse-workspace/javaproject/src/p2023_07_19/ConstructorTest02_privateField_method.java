package p2023_07_19;

class MyDate02 {
	
	// 필드(field), 멤버변수(하나의 코드를 구성하는 멤버라는 의미)
	// 접근제어자 private: 비공개 클래스. 자신의 클래스 내에서만 접근 가능
	private int year;		
	private int month;
	private int day;

	// 접근제어자 public: 가장 넓은접근 허용. 외부 클래스 접근 허용
	// 생성자 - 클래스명(MyDate)와 동일해야 함
	public MyDate02() {	
		// 기본 생성자: ()안에 매개변수가 없는 생성자. 클래스의 멤버변수 초기값 설정(초기화 작업)
		System.out.println("[생성자] : 객체가 생성될 때 자동 호출됩니다.");	// 객체 생성, 초기화 시점 알려줌
		// 기본 생성자 호출시, 생성자 내부 코드가 실행됨 => 메시지 출력
	}

	// 메소드(method) - 메소드 앞에는 void또는 자료형이 와야 함(메소드 반환타입을 나타냄)
	// 메소드 반환타입이 void인 경우, 어떤 값도 반환X
	// ex) 메시지를 출력 or 파일에 데이터를 쓰는 작업 수행시 사용
	public void print() {
		// print()메소드 - year, month, day 멤버변수를 활용하여 날짜정보 출력
		System.out.println(year + " / " + month + " / " + day);
	}
	
	public String print2() {
		// String타입으로 값을 반환 => System.out.println()로 반환값 출력 가능
		return year + " / " + month + " / " + day;
	}
}// MyDate end

public class ConstructorTest02_privateField_method {
// 하나의 클래스가 독립적으로 실행되기 위해선 main메소드 필요

	public static void main(String[] args) {
		
		// MyDate()=> Mydate클래스의 기본 생성자를 호출하라는 코드
		MyDate02 d = new MyDate02();	// MyDate02클래스의 생성자를 호출하여 d라는 객체 생성
		// print()메소드 호출을 위해서 MyDate 클래스의 객체 생성해야 함
		
		// year필드는 MyDate 클래스의 멤버변수 => 해당 클래스 내부에서 접근가능
		// year필드의 private 접근 제어자 => 클래스 외부에서 직접접근X
//		System.out.println(d.year);		// private접근제어로 직접접근X
//		System.out.println(d.month);		// private접근제어로 직접접근X
//		System.out.println(d.day);		// private접근제어로 직접접근X

		// => 따라서, year변수 접근을 위해 MyDate클래스 내 접근가능 메소드를 사용해야 함
		// print()메소드 호출	=> only 내부동작 실행
		d.print();
		
		// print()메소드 void타입
		// 반환된 값X=>System.out.println()에 출력할 값X = 컴파일 오류
//		System.out.println(d.print());	
		System.out.println("String print: "+d.print2());
		
		
//		MyDate02 dd =  new MyDate02();
	}
}