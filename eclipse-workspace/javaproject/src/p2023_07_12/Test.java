package p2023_07_12;
//java의 경우 클래스명=파일명

import java.util.Date;
import java.util.Random;

public class Test {
//public: 접근제어자, class Test: 사용자 정의(프로그래머가 직접 만드는) 클래스

	//메인 메소드(public static void main)
	//main()메소드는 자바가상머신(JVM:java.exe)이 가장 먼저 호출하는 메소드
	//1개의 클래스가 독립적으로 실행되기 위해서는 반드시 main메소드가 필요
	public static void main(String[] args) {
	/*public:접근제어자, static:공유(정적메소드), main메소드,
	[]:1차원배열/위치변경가능(String ar[]) {) */

		//출력시 System 클래스 사용
//		System.out.println("java출력 성공");
		System.out.println("자바");
		System.out.println("오라클");
		
		System.out.println("파이썬");
		//System: java.lang패키지 안의 System 클래스(import필요X)
		//println()메서드
		
		Date d = new Date();
		System.out.println(d);
		
		Random r = new Random();
		System.out.println(r.nextInt(10)); // 0~9 난수 발생
		
	}

}
