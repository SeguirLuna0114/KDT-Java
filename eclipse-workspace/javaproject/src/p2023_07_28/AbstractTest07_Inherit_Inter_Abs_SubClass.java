package p2023_07_28;

// 인터페이스 - 추상클래스 - 일반 구현 클래스 구조
// - 상위 인터페이스에서는 추상 메서드만을 정의
// - 중간에 위치한 추상 클래스에서는 
// 	 이러한 추상 메서드들을 일부 구현하거나 구현을 미룰 수 있음
// - 최종 일반 구현 클래스에서는 모든 추상 메서드를 구현

//인터페이스(IColor)므로 다중 상속 가능
interface IColor {
	// 상수(public static final 로 인식)
	// -해당 인터페이스를 구현하는 모든 클래스에서 상수 사용 가능
	int RED = 1; 
	public static final int GREEN = 2; // 상수
	public static final int BLUE = 3; // 상수

	void setColor(int c); // 추상메서드 (public abstract 로 인식)

	public abstract int getColor(); // 추상메서드
}

//클래스(AbsColor)이므로 다중 상속 불가능 단일 상속만, 
abstract class AbsColor implements IColor {
	int color = GREEN; // 변수도 가질 수 있디.

	// 부모 인터페이스의 추상 메소드를 메소드 오버라이딩
	public void setColor(int c) { // 구현된 메서드도 가질 수 있다.
		// 전달된 변수값(c)를 사용하여 color변수에 저장
		color = c; // color=1;
	}
}

// 추상 클래스를 상속받는 하위클래스(최종적으로 상속받는 일반 구현 클래스)
class SubClass07 extends AbsColor {
	// 인터페이스의 추상메소드를 메소드 오버라이딩
	public int getColor() {
		return color;
	}
}

class AbstractTest07_Inherit_Inter_Abs_SubClass {
	
	public static void main(String[] args) {
		// 일반 구현 클래스(하위클래스)의 객체를 생성하여 test라는 변수에 할당
		SubClass07 test = new SubClass07();
		
		// setColor()메소드를 호출
		test.setColor(IColor.RED);	// Icolor.RED = 1이라는 상수
		// color객체의 값을 1로 설정
		
		// getColor()메소드 호출 => color값 반환
		System.out.println(test.getColor());
	}
}