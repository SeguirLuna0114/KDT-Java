package p2023_07_18;

import java.util.Scanner;

public class Report_0717_FatorialEx_For_proff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 팩토리얼 연산 결과 저장을 위한 함수
		int n, f=1;
		
		// 키보드로 입력받기 위해 Scanner객체 생성
		System.out.print("정수를 입력 하세요?");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();	// 사용자가 원하는 팩토리얼 값 저장
		
		//1씩 감소시키면서 곱하는 연산 수행
		for(int i=n; i>=1; i--){
			f = f * i;      // f *= i;
		}
		System.out.println(n+"!="+f);	
	}

}
