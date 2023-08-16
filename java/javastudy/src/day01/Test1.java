package day01;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// 변수 : 메모리 상에서 데이터를 저장하기 위한 기억 공간의 이름
// 변수를 만드는 형식 : 자료형   변수명 = 데이터값;
		
// 지역 변수 : main()메소드 안에서만 사용 가능하다.
// 지역변수는 main()메소드 호출될때 Stack메모리 영역에 값을 저장한다. 		
		int age = 25;        // 나이
		
//		int a = 1.5;         // 오류발생
		double left = 1.5;   // 좌측 시력
		double rigth = 2.0;  // 우측 시력
		
		char c = '자';
		
		boolean b = true;
		
		System.out.println("나이:"+ age);
		System.out.println("좌측시력:"+ left);
		System.out.println("우측시력:"+ rigth);
		System.out.println("c:"+ c);
		System.out.println("b:"+ b);		
	}

}
