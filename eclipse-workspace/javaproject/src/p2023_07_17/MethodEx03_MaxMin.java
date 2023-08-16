package p2023_07_17;

import java.util.Scanner;

// 키보드로 입력한 2개의 정수 중에서 최대값과 최소값 구하는 프로그램
// 단, 메소드를 이용하여 작성
public class MethodEx03_MaxMin {

	// 최대값 구하는 정적메소드 - max()메소드 
	static int max(int a, int b) {
		// static 메소드 => main에서 max()로만 호출 가능
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}
	
	// 최소값 구하는 정적메소드 - min()메소드 
	static int min(int a, int b) {
		// static 메소드 => main에서 min()로만 호출 가능
		if (a < b) {
			return a;
		} else {
			return b;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n1, n2, max, min;
		System.out.println("2개의 정수를 입력 하세요?");
		Scanner sc = new Scanner(System.in);
		
		n1 = sc.nextInt();
		n2 = sc.nextInt();
		
		// 정적메소드 호출
		max = max(n1, n2);  // max()메소드 호출
		min = min(n1, n2);	// min()메소드 호출
		System.out.println("max: "+max);
		System.out.println("min: "+min);
		
		
	}

}
