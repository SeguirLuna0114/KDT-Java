package p2023_07_27;

// p318 ~ 319
// #메소드 재정의(Method Overriding)
//	: 부모 클래스로부터 상속받은 메소드를 자식 클래스에서 재정의하며 사용하는 것
// 1. 자식 클래스로 객체 생성한 후, 메소드를 호출하면 메소드 오버라이딩 된 자식메소드만 호출됨
// 2. 부모클래스의 상속해주는 메소드는 더 이상 사용할 수 없는 은닉 메소드가 됨
// 3. 부모 클래스의 은닉된 메소드를 사용하기 위해서는 
//	  자식클래스의 메소드 내에서 "super.은닉메소드명" 형식을 통해 호출해서 사용가능

// 메소드 오버라이딩 자동 설정방법
// 마우스 우클릭 -> [source] -> [Override/Implement Method] -> 재정의하고자 하는 메소드 선택

// 1. 부모클래스
class Calculator {
	
	// areaCircle 메소드 - 반지름을 매개변수로 받아 원의 면적 계산
	double areaCircle(double radius) {
		
		System.out.println("Calculator객체의 areaCircle()메소드 실행");
		return 3.14159 * radius * radius;
		// 위 코드를 Math클래스의 메소드를 사용해서 구현 가능
//		return 3.14159 * Math.pow(radius, radius);
	}
}

// 2. 자식클래스
class Computer extends Calculator {
	// 메소드 오버라이딩 자동 설정방법
	// 마우스 우클릭 -> [source] -> [Override/Implement Method] -> 재정의하고자 하는 메소드 선택
	
	// Calculator 클래스의 areaCircle(double radius) 메소드를 
	// 오버라이딩하여 자식 클래스에 맞게 재정의
	@Override	// 어노테이션(컴파일러에게 인식)
	double areaCircle(double radius) {
		// TODO Auto-generated method stub
		
		System.out.println("Calculator객체의 areaCircle()메소드 실행");
		return Math.PI * radius * radius;
		// 위 코드를 Math클래스의 pow메소드 사용하여 구현 가능
//		return Math.PI * Math.pow(radius, radius);	
	}
	
}


public class ComputerEx_MethodOverriding_mkObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 반지름 값 설정
		int radius = 10; 
		
		// 부모클래스(Calculator클래스) 객체 생성
		Calculator mycal = new Calculator();
		// 부모클래스(Calculator클래스)에서 은닉된 메소드 호출 가능
		System.out.println("원의 면적: "+ mycal.areaCircle(radius));
		System.out.println();
		
		// 자식클래스(computer클래스) 객체 생성
		Computer mycom = new Computer();
		// 자식클래스에서 재정의된 areaCircle()메소드가 호출됨
		System.out.println("원의 면적: "+mycom.areaCircle(radius));

	}

}
