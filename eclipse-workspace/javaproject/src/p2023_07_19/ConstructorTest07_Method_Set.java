package p2023_07_19;

class MyDate07 {
	
	// 필드(field), 멤버변수(하나의 코드를 구성하는 멤버라는 의미)
	// - 객체가 생성될 때 heap 메모리상에서 값을 저장하는 역할
	private int year;	// 접근제어자 private: 비공개 클래스. 자신의 클래스 내에서만 접근 가능
	private int month;
	private int day;

	// 생성자 - 1. 객체생성시 호출됨 2. 필드값 초기화(초기값 설정)
	// 기본 생성자
	public MyDate07() {
	}

	// 생성자 역시 매개변수의 이름을 속성과 동일하게 줄 수 있다.
	public MyDate07(int year, int month, int day) {
		// 멤버변수로 속성 값을 초기화하려면 대입연산자 왼쪽에 this를 붙여야 한다.
		this.year = year;
		this.month = month;
		this.day = day;
	}	// 원하는 값으로 초기값 형성 가능

	// 메소드(method)
	// setters 메소드 : 매개변수를 통해 원하는 필드값을 일부 수정/변경
	// [ctrl] + [메소드명] => 해당 메소드 위치로 바로 이동
	public void SetYear(int year) { // 대입연산자 왼쪽에 this를 붙였기에
		this.year = year; // 속성 값이 변경됨
	}

	public void SetMonth(int month) {// 대입연산자 왼쪽에 this를 붙였기에
		this.month = month; // 속성 값이 변경됨
	}

	// 메소드
	// 필드값 출력하는 역할
	public void print() {
		System.out.println(year + "/" + month + "/" + day);
	}
}

public class ConstructorTest07_Method_Set {
	
	public static void main(String[] args) {
		
		// 매개변수를 가진 생성자 호출 - 자료형에 맞는 값 입력하여 호출
		MyDate07 d = new MyDate07(2023, 7, 19);
		
		// 필드가 private 접근제어인 경우, 메소드를 사용해 클래스 내 접근 가능
		// print 메소드 : (생성자에서 초기화된) 필드값 출력
		d.print();	// 2023/7/19
		
		// setters 메소드 : 매개변수를 통해 원하는 필드값을 일부 수정/변경
		d.SetYear(2024); // 2024년으로 변경
		d.SetMonth(8); // 8월로 변경
		
		// print 메소드 : 변경된 필드값 출력
		d.print();	// 2024/8/19
	}
}