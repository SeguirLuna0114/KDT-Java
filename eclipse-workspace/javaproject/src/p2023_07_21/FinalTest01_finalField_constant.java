package p2023_07_21;

// final필드
// : 초기값이 저장되면 최종값이 되어 프로그램 실행 중 수정 불가
class FinalMember {
	
	// final로 선언된 변수는 상수로 취급됨 => 이후 수정불가
	final int a = 10; // 상수

	public void setA(int a) {
		// 상수는 값을 수정할 수 없음
//		this.a = a;		// 수정을 시도했기에 오류
	}
}

public class FinalTest01_finalField_constant {
	
	public static void main(String[] args) {
		
		// FinalMember클래스 객체 생성
		FinalMember ft = new FinalMember();
		
		// final로 선언된 변수 a의 값을 1000으로 초기화
		final int a = 1000;
		
		// setA()메소드를 호출하려했으나, 
		// setA()메소드는 final값을 수정하려 했기에 오류
		ft.setA(100);
		
		// a를 통해 출력하면 main메소드 내에서 정의된 final변수 a=1000이 출력됨
		System.out.println(a);
		// 1000
	}
}
