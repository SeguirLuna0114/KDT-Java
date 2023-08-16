package p2023_07_13;

import java.util.Scanner;
// Scanner 클래스 : 사용자로부터 입력을 받기위한 기능을 제공하는 클래스


public class Oper05_Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// PrintStream클래스 - 텍스트 데이터 출력을 다루는 클래스
		// -System.out : PrintStream의 객체로 표준 출력 스트림 의미
		// InputStream클래스 - 바이트 단위로 데이터를 읽어오는 입력 클래스
		// -System.in : InputStream의 객체로 표준 입력 스트림
		System.out.println("정수 2개를 입력 하세요?");
		
		// Scanner(InputStream source)클래스 생성자: 입력받을 소스를 지정하는 역할
		// -InputStream: Scanner에게 데이터를 제공하는 역할
		// -Scanner는 데이터를 읽고 파싱하여 적절 형태로 반환
		// -System.in: 표준 입력 소스(키보드)를 나타내는 InputStream객체
		Scanner sc = new Scanner(System.in);	// Scanner객체인 sc는 키보드로부터 데이터를 입력받을 수 있게 함
		
		// Scanner 클래스의 주요 메서드
		// next(): 입력받은 문자열을 공백을 기준으로 읽어 반환
		// nextLine(): 입력받은 한 줄의 문자열을 읽음
		// nextInt(): 입력받은 정수값을 int타입으로 반환
		// nextDouble(): 입력받은 실수값을 double타입으로 반환
		int n1 = sc.nextInt();	// 스페이스바 or 엔터키로 구분
		int n2 = sc.nextInt();
		System.out.println("n1: " + n1);
		System.out.println("n2: " + n2);
		
		// 조건식
		if (n1 > n2) {
			System.out.println(n1 + "이" + n2 + "보다 크다");
		} else if (n1 == n2) {
			System.out.println("n1과 n2가 " + n1 + "으로 같다");
		} else {
			System.out.println(n2 + "이" + n1 + "보다 크다");
		}
		
		
	}

}
