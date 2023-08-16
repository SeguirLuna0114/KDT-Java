package p2023_07_19;

// Animal_class (사용자 정의 클래스)
public class Animal_class {
	
	// 필드(field)/멤버변수: 메소드 바깥쪽에 정의되는 변수
	// -필드(멤버변수)는 heap메모리 영역에 저장됨. 객체의 속성 표현
	int age;	// 필드(field), 멤버변수, 전역변수
	
	
	// 생성자
	// -생성자는 반드시 class명과 동일하고, 괄호()를 가져야 함
	// 기본 생성자(Default Constructor): 매개변수가 없는 생성자
	public Animal_class() {
		System.out.println("생성자 호출 성공");
	}

	
	// 메소드 - 객체의 동작을 표현
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 지역변수: main메소드 안에서 정의된 변수
		// -지역변수는 stack메모리 영역에 저장됨
		int a = 10;
		
		// String클래스: 하나의 클래스 형태의 자료형
		String str = new String("자바");		// heap메모리 상에 새로운 기억공간 형성
		
		// 클래스명	 레퍼런스변수   new연산자	   생성자 호출
		Animal_class	a1	  =  new	Animal_class();
		
		// 변수에 접근 - 객체의 인스턴스를 통해 접근
//		System.out.println(age);  		// 오류 발생
		System.out.println(a1.age);		// 0 (초기값은 0으로 할당됨)
		// heap메모리에 저장되면 자동 초기화됨
		
		// 변수값 수정(새로운 값 할당)
		a1.age = 5;						// age값을 5로 수정
		System.out.println(a1.age);		// 5 (수정된 값이 출력됨)
		// "a1" in stack메모리 -> "age=5" in heap메모리
		
		// 클래스명	 레퍼런스변수   new연산자	   생성자 호출
		// Animal클래스의 인스턴스 a2를 생성
		Animal_class	a2	  =  new	Animal_class();
		
		System.out.println(a2.age); 	// 0
		// "a2" in stack메모리 -> "age=0" in heap메모리
		
		// new연산자를 통해 저장공간을 생성 => 다른주소를 서로 참조함(객체는 참조형)
		if(a1 == a2) {
			System.out.println("같은 주소");
		} else {
			System.out.println("다른 주소");
		}
	}

}
