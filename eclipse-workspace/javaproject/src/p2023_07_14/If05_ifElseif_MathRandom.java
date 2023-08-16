package p2023_07_14;

// p140
// 난수 발생 공식
// 난수 = (정수화)(Math.random() * (상한값-하한값+1)) + 하한값;
// (상한값-하한값+1): 원하는 난수 범위. +1은 상한값포함을 위함
// 난수 발생: 0.0 <= Math.random() < 1.0
// (정수화): 소수점 아래를 버리기 위해 double형 -> int형으로 변환
// + 하한값: 하한값부터 상한값 사이의 임의의 정수 구할 수 있음

// 짝수 난수(0~100): int randEven = (int)(Math.random() * 51) * 2;
// 홀수 난수(1~101): int randOdd = (int)(Math.random() * 51) * 2 + 1;
public class If05_ifElseif_MathRandom {

	// 주사위 번호 뽑기: 1 ~ 6
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Math는 정적메서드를 포함 => 인스턴스화X(실제 객체생성X)
//		Math m = new Math();		// 오류발생
		
		// new키워드를 사용해 Math클래스의 생성자(클래스 내에서 객체 초기화 수행)호출
		// -> 해당 객체(인스턴스) 참조할 변수 선언하여 객체의 속성 접근 or 메서드 호출 가능
		// Person p = new Person();
		// (Person: 클래스, p: Person클래스의 인스턴스(객체)를 참조하는 변수)
		
		// Math클래스의 정적메서드 호출: Math.메서드이름()
		System.out.println("E="+Math.E);			// 자연로그	
		System.out.println("PI="+Math.PI);			// 원주율
		System.out.println("random="+Math.random());	// 난수발생
		
		// Math.random(): 0~1미만의 랜덤 부동 소수점 숫자를 반환
		// =>(Math.random()*6): 0이상 6미만의 범위에서 균등하게 분포되는 부동소수점 생성
		int num = (int)(Math.random()*6) + 1;	// 1~6사이의 임의의 정수 생성
		// 하한=1, 상한=6
		System.out.println("num= "+num);
		
		// if문 활용
		if (num == 1) {
			System.out.println("1번");
		} else if (num == 2) {
			System.out.println("2번");
		} else if (num == 3) {
			System.out.println("3번");
		} else if (num == 4) {
			System.out.println("4번");
		} else if (num == 5) {
			System.out.println("5번");
		} else {
			System.out.println("6번");
		}
		
		// switch문 활용
		switch (num) {
			case 1:
				System.out.println("1번");
				break;
			case 2:
				System.out.println("2번");
				break;
			case 3:
				System.out.println("3번");
				break;
			case 4:
				System.out.println("4번");
				break;
			case 5:
				System.out.println("5번");
				break;
			case 6:
				System.out.println("6번");
				break;
		}
		
		
		// 1~45사이 난수 발생
		// 로또와 같은 프로그램 생성이 가능
		System.out.println("1~45사이 난수 발생");
		int random = (int)(Math.random() * 45)+1;
		System.out.println("1~45사이 난수: " + random);
		
	}

}
