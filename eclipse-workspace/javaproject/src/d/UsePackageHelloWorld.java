package d;

// 서로다른 패키지 내의 class
// 1. import
// 2. import하려는 class는 public 접근제어자로 선언되어야 함

// hello패키지 내의 PackageHelloWorld 클래스 import
import hello.PackageHelloWorld;
//   import hello.*;	// hello패키지 내의 모든 클래스 import

public class UsePackageHelloWorld {

	// main메소드
	public static void main(String[] args) {

		// main메소드 내에서 hello패키지 내 method import
		// PackageHelloWorld클래스의 객체(phw) 생성
		PackageHelloWorld phw = new PackageHelloWorld();
		
		// 객체를 생성해서 메소드 호출
		phw.printHello();
		
//		PackageHelloWorld.printHello();
		// 다른 클래스내의 메소드를 바로 호출하기위해서는,
		// 메소드가 static으로 선언되어 있어야 함
		// public void printHello() { 으로 선언되었기에 불가
	}
}
