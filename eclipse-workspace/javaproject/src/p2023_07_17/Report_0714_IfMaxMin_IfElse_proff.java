package p2023_07_17;

import java.util.Scanner;

// 키보드로 정수 3개를 입력 받았을때,
// 최대값과 최소값을 구하는 프로그램을 작성하세요?
public class Report_0714_IfMaxMin_IfElse_proff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 변수 선언(int-4byte 기억공간 형성)
		int n1, n2, n3, max, min;
		System.out.println("정수 3개를 입력 하세요.");
		Scanner sc = new Scanner(System.in);
		n1 = sc.nextInt();
		n2 = sc.nextInt();
		n3 = sc.nextInt();
		
		// if-else문으로 처리
		if(n1 > n2) {
			max = n1;
			min = n2;
		}else {
			max = n2;
			min = n1;
		}
		
		if(max > n3) {			// 최대값
			max = max;
		}else {
			max = n3;
		}
		if(min < n3) {			// 최소값
			min = min;
		}else {
			min = n3;
		}
		System.out.println("max="+max);
		System.out.println("min="+min);
		
	}

}
