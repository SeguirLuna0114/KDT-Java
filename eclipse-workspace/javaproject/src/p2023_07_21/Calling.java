package p2023_07_21;

// Called클래스의 check()메소드 사용
// -같은패키지 내에서는 접근제어자가 public 또는 default로 된 경우
// 	import없이 메소드 호출 가능
public class Calling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Called클래스의 객체 생성
		Called called = new Called();
		// class가 private접근제어자로 정의된 경우, 같은 패키지여도 접근X
	
		// Called클래스의 check()메소드 호출
		called.check();
		// method가 private으로 정의된 경우, 메소드 호출 불가
		
	}

}
