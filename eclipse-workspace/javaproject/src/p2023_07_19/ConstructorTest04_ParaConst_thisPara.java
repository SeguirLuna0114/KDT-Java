package p2023_07_19;

// this 내부레퍼런스 변수: 현재 클래스의 인스턴스(클래스로부터 생성된 객체)에 접근
// 이클립스에서 클래스의 매개변수를 갖는 생성자 자동 생성 기능
// : [오른쪽마우스]->[generate constructor using fields] -> [Source] 
// -> 'Generate Constructor using Fields..." 옵션
// ->'Omit call to default constructor super()': 부모 클래스 기본생성자 호출 제거
class MyDate04 {
	
	// 필드(field), 멤버변수(하나의 코드를 구성하는 멤버라는 의미) => heap메모리상에 저장
	int year;	// default접근제어자
	int month;
	int day;

	// 기본 생성자
	public MyDate04(){ // 초기값 설정
		year=2023; 		// this.year=2023;과 같음
		month=4; 
		day=1; 
	}	// 항상 고정된 초기값을 가짐

	// 생성자 - 1. 객체생성시 호출됨 2. 필드값 초기화(초기값 설정)
	// 접근제어자 public: 가장 넓은접근 허용. 외부 클래스 접근 허용
	public MyDate04(int year, int month, int day) {
		// 생성자에서 전달받은 매개변수명 = 필드명
		// 이 경우, 값 전달이 되지 않음
		// => 'this'키워드를 사용해 클래스로부터 생성된 객체 참조하며 필드를 매개변수로 초기화
		this.year = year;	// this: 객체(d2)가 갖는 값을 묵시적으로 전달받음
		this.month = month;
		this.day = day;
	}	// 원하는 값으로 초기값 형성 가능

	// 메소드(method)
	// 메소드 반환타입이 void인 경우, 어떤 값도 반환X
	public void print() {
		System.out.println(year + "/" + month + "/" + day);
	}
}// MyDate end

public class ConstructorTest04_ParaConst_thisPara {
	
	public static void main(String[] args) {
		
		// 기본 생성자가 직접 정의X => 기본생성자 호출X
		MyDate04 d = new MyDate04();
		d.print();	// print()메소드 호출
		
		// default접근제어자 => 같은 패키지 내에서는 필드에 "직접" 접근 가능
		System.out.println(d.year);		// 2023
		System.out.println(d.month);	// 4
		System.out.println(d.day);		// 1

		// 매개변수를 가진 생성자 호출 - 자료형에 맞는 값 입력하여 호출
		MyDate04 d2 = new MyDate04(2023, 7, 19);
		d2.print();	// print()메소드 호출
		
		// default접근제어자 => 같은 패키지 내에서는 필드에 "직접" 접근 가능
		System.out.println(d2.year);	// 2023
		System.out.println(d2.month);	// 7
		System.out.println(d2.day);		// 19
	}
}