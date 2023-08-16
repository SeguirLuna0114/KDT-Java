package combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 첫째 줄에 정수 n,m(0 <= m <= n <= 2,000,000,000 ,n != 0)를 입력하고,
 *  nCm의 끝자리 0의 개수를 출력하는 프로그램
 * 
 * 끝자리 0 = 2와 5의 승수가 겹치는 수
 * 
 * 2의 승수와 5의 승수가 구해졌다면, 이제 겹치는(짝지을 수 있는) 개수를 구함
 * => 2와 5의 승수 중 최솟값을 출력
 */
public class cntZero_multiplier {
	
	/** 0의 개수 = 2와 5의 겹치는 승수의 값
	 * 
	 * 	nCm = n! / (n-m)!m!
	 * => nCm{2^k, 5^k} = 2^(n! - (n-m)! - m!) X 5^(n! - (n-m)! - m!)
	 * "2의 승수(a1 - b1, c1) 와 5의 승수(a2 - b2 - c2) 가 구해졌으면, 
	 *  겹치는(짝지을 수 있는) 개수 => 2와 5의 승수 중 최솟값을 출력"
	 */
	
	// 5의 승수를 구하는 함수(5의 거듭제곱을 얼마나 많이 포함하는지 계산)
	static int five_power_n(long number) {
		
		// 5의 거듭제곱의 개수(승수)를 반환
		int cnt = 0;
		
		while(number >= 5) {
			// number에 포함된 5의 거듭제곱의 개수를 누적
			cnt += number / 5;		// cnt = cnt + number/5
			
			// number가 5으로 나누어 다시 할당
			number /= 5;			// number = number / 5
		}
		
		return cnt;
	}
	
	
	// 2의 승수를 구하는 함수(2의 거듭제곱을 얼마나 많이 포함하는지 계산)
	static int two_power_n(long number) {
		
		// 2의 거듭제곱의 개수(승수)를 반환
		int cnt = 0;
		
		while(number >= 2) {
			// number에 포함된 2의 거듭제곱의 개수를 누적
			cnt += number / 2;		// cnt = cnt + number/2
			
			// number가 2으로 나누어 다시 할당
			number /= 2;			// number = number / 2
		}
		
		return cnt;
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("정수 n,m(0 <= m <= n <= 2,000,000,000 ,n != 0)를 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		long N = Long.parseLong(input[0]);
		long M = Long.parseLong(input[1]);
		
		// 2의 승수와 5의 승수를 구해줌
		long count5 = five_power_n(N) - five_power_n(N-M) - five_power_n(M);
		long count2 = two_power_n(N) - two_power_n(N-M) - two_power_n(M);
		
		System.out.println(Math.min(count5, count2));
	
	}

}
