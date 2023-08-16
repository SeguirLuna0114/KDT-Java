package p2023_07_18;
import java.util.Scanner;

public class Report_0717_Factorial_Method_proff {

	// 재귀함수 : 함수안에서 자기자신의 함수를 호출하는 함수
	// -static: 정적메소드
	static int fact(int n) {	// fact메소드
		if(n<=1) {		// 팩토리얼은 양수값만 나오기 때문
			return 1;
		}
		return n * fact(n-1);	// return문으로 값을 돌려줌
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("원하는 팩토리얼을 입력하세요?");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// fact()메소드 호출
		int result = fact(n);	// 매개변수 result를 통해 정수n 전달
		System.out.println(n+"!="+ result);
		
	}

}
