package p2023_07_21;

// p280
// 싱글톤(Singleton): 특정 클래스의 인스턴스(객체) 생성이 1번만 수행되게 보장하는 패턴
// 여러 곳에서 동일한 인스턴스를 공유하고 사용해야 할 경우 유용
class Singleton {
	
	// 정적(static)필드 - 공유 허용
	// 외부접근 불가하게 private접근제어자 사용 => direct 접근X
	// => 정적메소드를 활용하여 공유
	private static Singleton s = new Singleton();	// 정적 필드
	
	// 생성자
	// 외부접근 불가하게 private접근제어자 사용 => direct 접근X
	// => 직접 객체 생성을 막아주는 역할 수행
	private Singleton() {};

	// 정적 메소드
	// - 정적 메소드를 이용하여 공유를 함
	public static Singleton getInstance() {
		return s;	// Singleton객체 s 전달
	}
	
	// 인스턴스 메소드
	public void check() {
		System.out.println("메소드 호출 성공1");
	}
	
	public void check1() {
		System.out.println("메소드 호출 성공2");
	}
	
}


public class SingleronEx_Static {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// private 접근제어자 => 외부 클래스에서 접근 불가
//		System.out.println(Singleton.s);	// 오류 발생
		
		// getInstance() 정적메소드를 활용하여, 이미 생성된 인스턴스를 반환 -> 변수에 할당
//  Singleton클래스명 변수명 = Singleton클래스명.정적메소드();
		Singleton obj1 = Singleton.getInstance();	// 값을 받는 자료형 => Singleton으로 해야
		Singleton obj2 = Singleton.getInstance();
		// 두개의 참조변수 obj1, obj2가 같은 인스턴스를 가리킴
		
		// 출력시 16진수 형태의 주소값이 출력됨
		System.out.println(obj1);
		System.out.println(obj2);
		// p2023_07_21.Singleton@7c30a502
		
		// 주소값 비교
		// obj1과 obj2는 같은 인스턴스를 가리킴 = 같은 주소를 가리킴
		if (obj1 == obj2) {
			System.out.println("같은 주소");	// 같은 주소
		} else {
			System.out.println("다른 주소");
		}
		
		// Singleton으로 객체 생성시 오류 발생
		// Singleton 클래스의 생성자는 private이므로 외부에서 객체 생성 불가
//		Singleton s = new Singleton();	// 오류 발생
		
		// 인스턴스 메소드 호출 - 생성객체.인스턴스메소드명();
		// 변수를 통해 얻은 인스턴스를 사용하여 인스턴스메소드 호출
		obj1.check();
		obj1.check1();
		System.out.println();
		
		obj2.check();
		obj2.check1();
		
	}
}
