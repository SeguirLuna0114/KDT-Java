package combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램
 * 
 * 뒷자리가 0이 나오는 경우 = 2와 5가 곱해진 경우
 * => 소인수 분해를 해서, 2와 5가 존재할 경우 뒷자리는 0으로 끝남
 * 
 * 뒷자리가 0이 n개 존재 = 2와 5가 n개씩 짝지어 존재
 * => 2와 5를 짝지을 수 있는 개수 = 뒷자리수 0의 개수
 * 
 * 팩토리얼 값을 보면, 2는 5보다 작은 수이기에, 연속된 수를 곱하면 모든 값의 소인수분해들은
 * 2의 개수가 5의 개수보다 많음 ==> 5의 개수에 따라 값이 변화함
 * "단순히 5로 나눌 것이 아니라 반복문을 통해 5로 나누면서 누적합해줘야 함"
 */
public class cntZero_factorial {
	
	// N의 거듭제곱을 얼마나 많이 포함하는지 구하는 함수
	static int power_n(int N, int num) {
		
		// N의 거듭제곱 개수
		int count = 0;
		
		while(num >= N) {
			// num에 포힘된 N의 거듭제곱의 개수 누적
			count += num / N;
			// num을 N으로 나누어 다시 할당
			num /= N;
		}
		
		// 누적된 N의 거듭제곱 개수 반환
		return count;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("N(0 ≤ N ≤ 500)을 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 팩토리얼 값 중 2와 5의 개수
		int count2 = power_n(2, N);
		int count5 = power_n(5, N);
		
		/**
		 * 팩토리얼 값을 보면 2는 5보다 작은 수이기에,
		 * 2의 개수가 5의 개수보다 많음 
		 * ==> 5의 개수에 따라 값이 변화함(5의 개수만 확인해도 되기는 함)
		 */
		// 2와 5를 짝지을 수 있는 개수 = 뒷자리수 0의 개수
		System.out.println(Math.min(count2, count5));

	}

}
