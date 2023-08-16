package p2023_07_19;

// 생성자는 객체가 생성될때 호출되면서, 필드값을 "한꺼번에" 초기화
// 메소드는 일부 필드값을 개별적으로 수정/변경하거나 데이터를 반환하는 역할

//# 이클립스에서 클래스의 메소드 자동 생성 기능
//: [오른쪽마우스]->[Source] ->[generate getters and setters]
//  -> 'select all'(모두선택) ->[insertion point] 위치 선택
//  -> [sort by] First getters, then setters (get 먼저 ->set) ->'Generate'
class MyDate06 {
	
	// 필드(field), 멤버변수(하나의 코드를 구성하는 멤버라는 의미)
	// - 객체가 생성될 때 heap 메모리상에서 값을 저장하는 역할
	private int year;	// 접근제어자 private: 비공개 클래스. 자신의 클래스 내에서만 접근 가능
	private int month;
	private int day;

	// 생성자 - 1. 객체생성시 호출됨 2. 필드값 초기화(초기값 설정)
//  public MyDate06(){	// 기본 생성자
//  }
	
	public MyDate06(int new_year, int new_month, int new_day) {
		year = new_year; 		// 2023
		month = new_month; 		// 7
		day = new_day; 			// 19
	}	// 원하는 값으로 초기값 형성 가능

	// 메소드(method)
	// 1. (생성자에서 초기화된) 필드값 출력하는 역할
	public void print() {
		System.out.println(year + "/" + month + "/" + day);
	}

	// 2. getters메소드(get으로 시작하는 메소드)
	//	  : 메서드 호출한 곳에 필드값을 돌려주는(return) 역할
	// 		돌려받은 값은 system.out.print()로 출력해야 함
	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	// 3. setters 메소드 : 매개변수를 통해 원하는 필드값을 일부 수정/변경
	// [ctrl] + [메소드명] => 해당 메소드 위치로 바로 이동
	public void setYear(int year) {
		this.year = year;
	}

	public void setMonth(int month) {
		this.month = month;		// 매개변수 입력값 -> 필드 month값
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	
}

public class ConstructorTest06_Method_GetSet {
	
	public static void main(String[] args) {
		
		// 매개변수를 가진 생성자 호출 - 자료형에 맞는 값 입력하여 호출
		MyDate06 d = new MyDate06(2023, 7, 19);
		// Stack메모리 영역				heap메모리 영역
		// 		d	-------->	year=2023, month=7, day=19
		
		// 필드가 private 접근제어인 경우, 메소드를 사용해 클래스 내 접근 가능
		// print 메소드 : (생성자에서 초기화된) 필드값 출력
		d.print();	// 2023/7/19
		
		// setters 메소드 : 매개변수를 통해 원하는 필드값을 일부 수정/변경
		d.setYear(2024); // year을 2024년으로 수정
		d.print();	// 2024/7/19
		
		d.setMonth(10); // month를 10월로 수정
		d.print();	// 2024/10/19
		
		d.setDay(25);	// day를 25일로 수정
		d.print();	// 2024/10/25
		
		// getters 메소드 : 객체의 필드(인스턴스 변수)값을 조회
		System.out.println("돌려받은 year: "+d.getYear());		// 2024
		System.out.println("돌려받은 month: "+d.getMonth());	// 10
		System.out.println("돌려받은 day: "+d.getDay());		// 25
		
	}
}