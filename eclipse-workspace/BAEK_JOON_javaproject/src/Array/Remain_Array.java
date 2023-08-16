package Array;

import java.util.Scanner;

public class Remain_Array {

	// 수 10개를 입력받은 후, 이를 42로 나눈 나머지를 구하고
	// 나머지가 서로 다른 값들이 몇 개 있는지 출력
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("10개의 수를 입력해주세요");
		
		// 나머지가 나올 수 있는 수는 0~41이므로, 길이가 42인 boolean배열 생성
		boolean[] ArrayRemain = new boolean[42];
		Scanner sc = new Scanner(System.in);
		
		// nextInt()메서드를 사용하여 정수 입력을 받음
		// 입력된 정수값은 나머지연산자(%)를 사용해 42로 나눔
		// sc.nextInt() % 42: 0~41 사이 값을 가짐 => 인덱스로 사용
		for (int i=0; i<10; i++) {
			ArrayRemain[sc.nextInt() % 42] = true;
			// 해당 나머지값을 갖는 인덱스에 true값을 할당 => 나머지값이 이미 입력된 적 있음 의미
		}
		
		System.out.print("나머지가 서로 다른 값: ");
		for (int i=0; i <ArrayRemain.length; i++) {
			if (ArrayRemain[i]) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
		
		// 확장 for문 활용
		int count=0;
		for (boolean value : ArrayRemain) {
			if (value) {	// value가 true라면
				count++;
			}
		}
		System.out.println("나머지가 서로 다른 값: "+count+"개");
		
	}

}
