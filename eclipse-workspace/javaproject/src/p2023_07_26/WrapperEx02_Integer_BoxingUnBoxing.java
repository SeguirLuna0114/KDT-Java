package p2023_07_26;

//Wrapper클래스 : 기본 데이터타입을 객체로 감싸는 클래스
//1.박싱(boxing) 
//	: stack메모리에 저장된 기본데이터타입 값을 heap메모리에 복사하는 것
//2.언박싱(unboxing) 
//	: heap메모리에 있는 데이터를 stack메모리로 가져오는 것
// - intValue()메소드: Integer 객체에 저장된 값을 언박싱하여 int 변수에 저장
public class WrapperEx02_Integer_BoxingUnBoxing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1.박싱(boxing) 
		//	: heap메모리를 박스로 생각하고, stack메모리에 저장된 기본데이터타입 값을 heap메모리에 복사하는 것
		// Integer와 같은 wrapper클래스로 객체 생성시 발생
		Integer obj1 = new Integer(100);
		Integer obj2 = new Integer("200");
		Integer obj3 = new Integer("300");
		
		
		// 2.언박싱(unboxing) 
		// 	: heap메모리를 박스로 생각하고, heap메모리에 있는 데이터를 stack메모리로 가져오는 것
		int value1 = obj1.intValue();
		int value2 = obj2.intValue();	// 자료형 변환: "200" -> 200
		int value3 = obj3.intValue();	// 자료형 변환: "300" -> 300
		
		System.out.println(value1);		// 100
		System.out.println(value2);		// 200
		System.out.println(value3);		// 300
		
	}

}
