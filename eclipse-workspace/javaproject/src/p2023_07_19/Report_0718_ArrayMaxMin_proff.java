package p2023_07_19;
import java.util.Scanner;

public class Report_0718_ArrayMaxMin_proff {

	// 키보드를 이용하여 정수 5개 입력받고,
	// in형 배열에 저장한 후, 배열에 저장된 값중 최대값과 최소값 구하는 프로그램
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int max, min;
		// int형 배열 선언 => heap메모리 상에 4byte기억공간 5개 생성
		int[] s = new int[5];

		System.out.print("정수 5개를 입력 하세요?");
		Scanner sc = new Scanner(System.in);

		// Array.length보다 작을때까지 loop돌려서 배열 값 입력
		for (int i = 0; i < s.length; i++) {
			s[i] = sc.nextInt();
		}
		
		//최대값과 최소값
		max = s[0]; // 초기값을 잘못 설정하면, 초기화 문제 발생 가능
		min = s[0]; // 초기값을 잘못 설정하면, 초기화 문제 발생 가능
		for (int i = 1; i < s.length; i++) {
			if (max < s[i]) max = s[i]; // 최대값
			if (min > s[i]) min = s[i]; // 최소값
		}
		System.out.println("max=" + max);
		System.out.println("min=" + min);
	}

}
