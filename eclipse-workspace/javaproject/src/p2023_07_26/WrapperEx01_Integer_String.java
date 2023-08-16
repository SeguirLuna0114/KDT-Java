package p2023_07_26;

// Wrapper클래스 : 기본 데이터타입을 객체로 감싸는 클래스
//				(기본 데이터타입을 객체로 다룰 수 있게 함)

// Integer 클래스: int에 대응되는 클래스. 정수 값을 포함하고 처리
// - 기본생성자가 없기에, 기본생성자 형태로 객체 생성시 오류 발생(기본생성자 지원X)
// 1.박싱(boxing) 
//	: heap메모리를 박스로 생각하고, stack메모리에 저장된 기본데이터타입 값을 heap메모리에 복사하는 것
// 2.언박싱(unboxing) 
// 	: heap메모리를 박스로 생각하고, heap메모리에 있는 데이터를 stack메모리로 가져오는 것

public class WrapperEx01_Integer_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Integer클래스는 기본생성자를 지원X => 기본생성자 호출시 오류 발생
//		Integer num = new Integer();	// 오류발생

		// stack메모리: 지역변수와 메서드 호출 시 생성되는 임시 데이터 저장 영역
		//			  stack메모리에 heap메모리의 주소값이 저장됨
		// heap메모리: 객체와 동적으로 할당된 데이터를 저장하는 영역
		
		// 1.박싱(boxing) 
		//	: heap메모리를 박스로 생각하고, stack메모리에 저장된 기본데이터타입 값을 heap메모리에 복사하는 것
		// 기본데이터타입 지역변수(stack영역에 저장)
		// n이 stack메모리에 저장되면 해당 변수에 직접적으로 값 얻을 수 있음
		int n = 10;			
		// int변수 n(in stack)을 Integer객체로 박싱
		// 새로운 Integer객체가 heap메모리에 생성되고, 그 안에 n의 값인 10이 복사되어 저장됨
		Integer num01 = new Integer(n);		// 박싱
		// => num01은 기본데이터타입(int)을 감싸는 Integer객체가 됨
		
		// 2.언박싱(unboxing) 
		// 	: heap메모리를 박스로 생각하고, heap메모리에 있는 데이터를 stack메모리로 가져오는 것
		// Integer객체 num01에 저장된 값을 언박싱하여 기본데이터타입(int)으로 가져오는 과정
		// intValue()메소드: Integer객체에 저장된 값을 int형으로 변환
		int n01 = num01.intValue();			// 언박싱
		// 언박싱된 결과는 int변수 n01에 저장되어 stack메모리에 위치
		
		// 3. 자료형 변환
		// 문자열 "20"이 String변수 s에 할당됨
		String s = "20";
		// 문자열 s를 Integer객체로 박싱 => new Integer(s)를 통해 문자열 -> 정수 변환
		// 새로운 Integer객체가 heap메모리에 생성되고, 그 안에 s의 값인 문자열 "20"이 복사되어 저장됨
		Integer num02 = new Integer(s);	// 박싱
		// => num02는 Integer객체를 가리키는 참조변수가 됨
		
		// num02가 가리키는 Integer객체에 저장된 값을 언박싱하여 int로 가져오는 과정
		int n02 = num02.intValue();		// 언박싱
		// 언박싱된 결과는 문자열"20"을 int변수 n02에 정수값으로 변환하여 Stack메모리에 위치시킴 
	}

}
