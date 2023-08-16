package p2023_07_21;

// final로 선언된 메소드 -> 메소드 오버라이딩을 허용하지 않는다는 의미
// - 하위 클래스에서 오버라이드(재정의)불가
//	   => 서브 클래스에서 해당 메소드 변경불가

// 상속
// - 상위클래스의 속성(필드)과 메소드를 물려받아 사용 가능
//   (단, 상위클래스의 생성자는 상속X)
// - 클래스를 상속받기 위해 하위클래스명 옆에 extends로 상속받음
//   : class   하위(자식)클래스명	extends	  상위(부모)클래스명

class FinalMethod {
	// 상위(부모) 클래스 - 상속을 해주는 클래스
	String str = "Java ";

	// public void setStr(String s) {
	// final 붙이면 서브 클래스에서 오버라이딩이 불가.
	public /*final*/ void setStr(String s) {
		// final로 선언된 메소드는 상속이 되지만, 메소드 오버라이딩X
		str = s;
		System.out.println(str);
	}
	// 메소드 오버라이딩
	// : 부모 클래스로부터 상속받은 메소드를 자식 클래스에서 이름, 형식은 동일하게 사용하고
	//   내용을 다르게 정의해서 재사용하는것 의미
}

// FinalMethod를 상속받는 FinalEx클래스
class FinalEx extends FinalMethod {
	// 하위(자식) 클래스 - 상속받는 클래스
	// 하위(자식)클래스명 extends 상위(부모)클래스명
	
	// 인스턴스 필드
	int a = 10; 
//	final int a = 10; // final 붙이면 밑에서 a값 대입 불가.
	
	// 메소드
	public void setA(int a) {
		// 전달받은 정수a로 인스턴스 a의 필드값 변경
		this.a = a;
	}

	// final로 선언된 메소드는 상속이 되지만, 메소드 오버라이딩X
	public void setStr(String s) { // 메소드 오버라이딩
		str += s;
		System.out.println(str);
	}

}

public class FinalTest02_finalMethod {
	
	public static void main(String[] args) {
		
		// FinalEx클래스의 인스턴스 ft 생성
		FinalEx ft = new FinalEx();
		
		// 하위클래스의 setA()메소드 사용하여 a필드 값 100으로 변경
		ft.setA(100);
		
		// Final클래스의 setSrt()메소드는 상위 클래스인 FinalMethod의 setStr을 오버라이딩시도
		// 주석처리할 경우, 상위클래스 FinalMethod의 setSrt()메소드가 상속됨
		// =>상위클래스의 setSrt()메소드 실행 
		ft.setStr("hi");	// hi
		
		
		// FinalMethod 클래스의 인스턴스 ft1 생성
		FinalMethod ft1 = new FinalMethod();
		
		// 자신의 클래스의 setStr()메소드 실행
		ft1.setStr("hi");	// hi
	}
}