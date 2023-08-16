package combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 어떤 수 N의 진짜 약수가 모두 주어질 때, N을 구하는 프로그램
 * 양수 A가 N의 진짜 약수가 되려면, N이 A의 배수이고, A가 1과 N이 아니어야 한다.
 * 
 * 첫째 줄에 N의 진짜 약수의 개수가 주어진다. 이 개수는 50보다 작거나 같은 자연수이다.
 * 둘째 줄에는 N의 진짜 약수가 주어진다.
 * 1,000,000보다 작거나 같고, 2보다 크거나 같은 자연수이고, 중복되지 않는다
 */
public class Divisor {

	/**
	 * 어떤 수 N의 진짜 약수가 모두 주어질 때
	 * => 그냥 입력으로 들어오는 값 중 최솟값과 최댓값을 서로 곱함
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 N의 진짜 약수의 개수를 입력하고,\n"
				+ "둘째 줄에는 N의 진짜 약수를 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N의 진짜 약수의 개수
		int cntN = Integer.parseInt(br.readLine());
		
		// 둘째줄에 입력받은 N의 진짜 약수
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 입력받은 값 중 최대값 및 최소값을 저장할 변수
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		while(cntN-- >0) {
			int divisor = Integer.parseInt(st.nextToken());
			
			max = Math.max(max, divisor);
			// 연산자를 활용해서 작성 가능
			// max = (divisor > max) ? divisor : max;
			min = Math.min(min, divisor);
			// 연산자를 활용해서 작성 가능
			// min = (divisor < min) ? divisor : min;
		}
		System.out.println(max * min);
	}

}
