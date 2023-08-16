package day02;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[]   s    =   new    int[3];
//		자료형  배열변수     연산자   자료형[배열의 크기]
// new 연산자 : heap메모리상에 배열 데이터를 저장하기 위한
//		      기억 공간을 생성 해주는 역할
		
		System.out.println(s[0]);   // 0
		System.out.println(s[1]);   // 0
		System.out.println(s[2]);   // 0
		
		String s1   = new    String("자바");
//		자료형   변수명   연산자   생성자 호출
		
		String s2 = "자바";   //처음 한번만 heap메모리상에 "자바"를 저장한다.
		String s3 = "자바";
		
		//1.참조형 변수(클래스,배열,인터페이스)들은 stack메모리 영역에
		//	주소값 저장한다.
		//2.참조형 변수들은 비교연산자(==)로 주소값을 비교한다.
		//3.참조형 변수들은 가르키는 데이터(값)를 비교할때는 equals()
		//  메소드로 비교한다.
		if(s1 == s2) {  	// 주소값을 비교
			System.out.println("같은 주소");
		}else {
			System.out.println("다른 주소");  // 다른주소
		}
		if(s2 == s3) {  	// 주소값을 비교
			System.out.println("같은 주소");  // 같은주소
		}else {
			System.out.println("다른 주소");
		}
		if(s1.equals(s3)) { // 데이터(값)을 비교
			System.out.println("같은 값");	// 같은 값
		}else {
			System.out.println("다른 값");
		}
	}

}


