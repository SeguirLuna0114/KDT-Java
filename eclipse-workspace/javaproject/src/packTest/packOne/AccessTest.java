package packTest.packOne;

// 상속 & 패키지 import
// 부모 클래스를 다른 패키지에 작성한 경우

//접근 제어자에 따른 필드와 메서드의 접근가능성
//1. 상속 관계가 있는 경우
//1-1. 2개의 클래스(부모,자식 클래스)가 같은 패키지에 속할 때 
//	   부모의 접근제어자가 default, protected, public 접근제어자인 경우에
//	   자식클래스에서 접근가능. (단, private접근 제어자만 접근X)
//1-2. 2개의 클래스(부모,자식 클래스)가 다른 패키지에 속할 때
//		부모의 접근제어자가  protected, public 접근제어자인 경우에
//		자식클래스에서 접근 가능 
//2. 상속 관계가 없는 경우에
//	  2개의 클래스가 서로 다른 패키지 않에 들어 있을때는 public 
//	  접근제어자로 되어 있어야만 다른 클래스에서 접근 할 수 있다.
public class AccessTest { // 다른 패키지에서 가져다 사용할 것임으로 pubic으로
	
	// private 접근제어자 - 현재 클래스에서만 사용 가능(상속X)
	private int a = 10; // [1] private
	// default 접근제어자 - 
	int b = 20; // [2] 기본 접근 지정자
	protected int c = 30; // [3] protected
	public int d = 40; // [4] public

	public void print() {
		
		System.out.println("AccessTest의 print");
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}
}
