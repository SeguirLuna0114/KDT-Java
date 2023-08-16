package p2023_07_18;

import java.util.Scanner;

public class Report_0718_ArrayMaxMin {

	// 키보드를 이용하여 정수 5개 입력받고,
	// in형 배열에 저장한 후, 배열에 저장된 값중 최대값과 최소값 구하는 프로그램
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("정수 5개를 입력해주세요?");
		Scanner sc = new Scanner(System.in);
		
		// int형 배열 선언 => heap메모리 상에 4byte기억공간 5개 생성
		int[] Array = new int[5];
		
		// Array.length보다 작을때까지 loop돌려서 배열 값 입력
		for (int i=0; i<5; i++) {
			Array[i] = sc.nextInt();
			System.out.print(Array[i]+" ");	// 입력한 값 출력
		}
		System.out.println();
		
		//최대값과 최소값
		int max = Array[0];	// 초기값을 잘못 설정하면, 초기화 문제 발생 가능
		int min = Array[0];
		for (int idx=1; idx<Array.length; idx++) {
			if (Array[idx] > max) {	// 최대값
				max = Array[idx];
			}
			if (Array[idx] < min) {	// 최소값
				min = Array[idx];
			}
		}
		System.out.println("max: "+max);
		System.out.println("min: "+min);
		
		
	}

}
