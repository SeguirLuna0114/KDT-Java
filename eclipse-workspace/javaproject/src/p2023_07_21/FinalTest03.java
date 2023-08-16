package p2023_07_21;

//  final이 클래스에 사용될 경우 -> "상속을 허용하지 않는다"는 의미
//	- final로 선언된 클래스는 상속 불가
//	- String클래스는 final로 선언되어 상속X

// final 클래스 => 상속을 받는 쪽에 오류를 발생시킴
final class FinalClass { // 부모 클래스

	String str = "Java ";

	public void setStr(String s) {
		str = s;
		System.out.println(str);
	}
}

// final로 선언된 클래스는 상속을 허용X => 하위클래스가 상속을 시도할 경우 오류 발생
//class FinalEx extends FinalClass { // 하위 클래스 -> final은 상속X
//	int a = 10;
//
//	public void setA(int a) {
//		this.a = a;
//	}
//
//	public void setStr(String s) {
//		str += s;
//		System.out.println(str);
//	}
//}

public class FinalTest03 {
	
	public static void main(String[] args) {
		
		FinalEx fe = new FinalEx();
	}
}