package p2023_07_28;

// 인터페이스
// 1. 인터페이스는 상수와 추상메소드로 구성되어 있다.
// 	  자바8부터 디폴터 메소드, 정적 메소드 도 사용가능함
// 2. 인터페이스를 상속 받을때는 implements로 상속을 받는다.
// 3. 인터페이스에서 선언된 변수는 자동적으로 public, static, final 특성을 가짐

// 인터페이스
public interface Interface01_constant_abstractMethod {

	// 상수(public static final)이 생략됨 => 수정 불가
	int a = 10;
	
	// 추상 메소드
	public abstract void action();
	
	// 추상 메소드(public abstract 생략 가능)
	void check();
	
}
