package p2023_07_28;

// 추상 클래스 : 인스턴스(객체)를 직접 생성할 수 없는 클래스
// 1. 자체적으로 객체를 생성할수 없는 클래스를 말한다.
// 2. 추상클래스를 상속받은 자식 클래스는 추상 클래스 안에 있는 추상메소드를
//	  반드시 메소드 오버라이딩 해야 함
// 3. 추상 클래스도 단일 상속만 가능(클래스의 다중 상속을 허용X)
//    => 다중상속을 허용하는 인터페이스로 처리함

// 추상클래스1 - Hello
abstract class Hello {
	// 추상메소드 - abstract, 내용{}갖지 않음, 세미콜론;으로 끝남
	// 매개변수를 가질수는 있음
	public abstract void sayHello(String name);
}

// 추상클래스2 - GoodBye
abstract class GoodBye {
	// 추상메소드 - abstract, 내용{}갖지 않음, 세미콜론;으로 끝남
	// 매개변수를 가질수는 있음
	public abstract void sayGoodBye(String name);
}

// 자바에서는 클래스의 다중상속을 허용하지 않음(c++과 파이썬은 다중상속 허용)
// => 다중상속을 허용하는 인터페이스로 처리
class SubClass03 extends GoodBye,Hello {

	public void sayHello(String name){
      System.out.println(name+"씨 안녕하세요!");
  }

	public void sayGoodBye(String name) {
		System.out.println(name + "씨 안녕히 가세요!");
	}
}

class AbstractTest03_NoMultiInherit {
	
	public static void main(String[] args) {
		
		SubClass03 test = new SubClass03();
		test.sayHello(args[0]);
		test.sayGoodBye(args[0]);
	}
}
