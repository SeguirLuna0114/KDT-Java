package p2023_07_14;

import java.util.Scanner;

// 키보드로 정수 3개 입력받을 경우, 최대 및 최소 구하는 프로그램
// if-else구문으로 작성
public class Report_0714_MinMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n1, n2, n3, max, min;
		
		System.out.println("정수 3개를 입력하세요?");
		Scanner sc = new Scanner(System.in);
		n1 = sc.nextInt();
		n2 = sc.nextInt();
		n3 = sc.nextInt();
		
		if (n1==n2 && n1==n3) {
			System.out.println("서로 다른 정수 3개를 입력해 주세요");
		} else {
			// 최대값
			if (n1 > n2 && n1 > n3) {
				max = n1;
			} else if (n2 > n3) {
				max = n2;
			} else {
				max = n3;
			}
			
			// 최소값
			if (n1 < n2 && n1 < n3) {
				min = n1;
			} else if (n2 < n3) {
				min = n2;
			} else {
				min = n3;
			}
			System.out.println("max= "+max+"\nmin= "+min);
		}
		
	}

}
