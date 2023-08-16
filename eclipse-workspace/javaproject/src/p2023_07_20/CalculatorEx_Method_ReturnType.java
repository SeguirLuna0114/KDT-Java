package p2023_07_20;

// p250~251
// default접근제어자(혹은 아무런 접근 제어자도 지정X경우)
//  : 동일한 패키지 내의 클래스에서만 접근가능
//   -같은 패키지 내에서는 필드에 "직접" 접근 가능(package-private)

// 메소드 리턴타입
// -void 타입: 메소드가 반환하는 값이 없음. 주로 작업을 실행하거나 처리하는 용도로 사용됨
// -자료형/데이터타입: 리턴값이 있는 경우에는, 메소드의 반환유형(데이터타입)이 명시되어야 함
class Calculator{
	
	// 메소드
	// 접근제어자 생략(Default) - 같은 패키지 내에서는 필드에 직접접근가능
	void powerOn() {
		System.out.println("전원을 켭니다.");
		return;		// void이기에, 생략가능
	}
	
	// return구문: 메소드를 호출한 곳에 값을 돌려주는 역할
	// - return문은 메소드 가장 마지막줄에 사용해야 함
	int plus(int x, int y) {
		// 지역변수 x, y, result
		int result = x + y;
		return result;		
//		System.out.println("test");	// 가장 마지막에 return문 사용
	}
	
	double divide (int x, int y) {	// 자동 형변환: byte(1byte) -> int(4byte)
		// int형(4byte)을 double(8byte)형으로 강제 형변환
		double result = (double)x / (double)y;
		return result;
	}
	
	void powerOff() {
		System.out.println("전원을 끕니다.");
		return;		// void이기에, 생략가능
	}
	
}


public class CalculatorEx_Method_ReturnType {

	// 메인메소드
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculator mycal = new Calculator();
		
		mycal.powerOn();
		
		// 리턴값이 있는 메소드 => 변수에 저장하여 호출
		// plus()메소드를 result1에 저장하여 호출
		int result1 = mycal.plus(5, 6);
		System.out.println("result1: "+ result1);
		
		// divide()메소드를 result2에 저장하여 호출
		byte x = 10;
		byte y = 4;
		// 자동 형변환: byte(1byte) -> int(4byte)
		// byte와 int중 큰 크기의 데이터타입인 int로 자동 형변환됨
		// (계산과정에서 데이터 손실이 발생하는 것을 막기 위함) 
		double result2 = mycal.divide(x, y);
		System.out.println("result2: "+ result2);
		
		mycal.powerOff();
		
	}

}
