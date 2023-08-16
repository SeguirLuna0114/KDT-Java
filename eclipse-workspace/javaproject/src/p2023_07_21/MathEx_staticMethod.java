package p2023_07_21;

// Math클래스에서 제공되는 메소드 구현하는 예제
// Math클래스 = 정적필드 + 정적 메소드
// - Math클래스는 생성자 제공이 안됨(X) => Math클래스로 직접 객체 생성불가

public class MathEx_staticMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Math클래스는 생성자 제공안됨(X) => Math클래스로 직접 객체 생성불가
//		Math m = new Math();	// 오류 발생
		
		// Math클래스에서 제공하는 정적메소드 호출: Math.정적메소드명
		System.out.println("E= "+Math.E); 	// 오일러 상수
		System.out.println("F= "+Math.PI);	// 원주율
		
		System.out.println("abs()= "+Math.abs(-10));	// 절대값
		// abs()= 10
		
		// ceil()메소드: 결과값을 double형으로 처리
		System.out.println("ceil()="+Math.ceil(3.14));	// 올림
		// ceil()=4.0
		
		// round()메소드: 결과값을 long형으로 처리
		System.out.println("round()="+Math.round(10.5)); // 반올림
		// round()=11
		
		// floor()메소드: 결과값을 double형으로 처리
		System.out.println("floor()="+Math.floor(10.9)); // 내림
		// floor()=10.0
		
		// max()메소드: 최대값을 long형으로 출력
		System.out.println("max()="+Math.max(10, 20));	// 최대값
		
		// min()메소드: 최소값을 double형으로 출력
		System.out.println("min()="+Math.min(10, 20));	// 최소값
		
		// pow()메소드: 결과값을 double형으로 처리
		System.out.println("pow()="+Math.pow(2, 3));	// 2의 3승
		// pow()=8.0
		
		// random()메소드: 0.0 <= Math.random < 1.0 (1.0미만), double형으로 처리
		System.out.println("random()="+Math.random());	// 난수발생
		
		// 주사위 번호: 1~6사이 난수 발생 => 정수형으로 처리
		int d = (int)(Math.random() * 6) + 1;	//난수발생:1~6
		System.out.println("주사위 번호:" + d);
		
		// 로또 번호: 1~45사이 난수 발생 => 정수형으로 처리
		int r = (int)(Math.random() * 45) + 1;	//난수발생:1~45
		System.out.println("로또번호:" + r);
		
		// sqrt()메소드: 제곱근을 구하여 double형으로 처리
		System.out.println("sqrt()="+Math.sqrt(5));
		// sqrt()=2.23606797749979
		System.out.println("sqrt()="+Math.sqrt(9));
		// sqrt()=3.0
		
	}

}
