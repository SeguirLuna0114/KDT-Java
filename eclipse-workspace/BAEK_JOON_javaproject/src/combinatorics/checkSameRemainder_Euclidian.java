package combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * N개의 수가 주어지고, 주어진 숫자를 M으로 나누었을 때, 
 * 나머지가 모두 같게 되는 M을 모두 찾는 프로그램(단, M은 1보다 커야 한다)
 * 
 * 항상 M이 하나 이상 존재하는 경우만 입력으로 주어짐
 * 첫째 줄에 가능한 M을 공백으로 구분하여 모두 출력한다. 이때, M은 증가하는 순서로 출력
 */
public class checkSameRemainder_Euclidian {
	
	/**
	 * M이 하나 이상 존재하는 경우로만 주어진다
	 * 나머지가 모두 같게 되는 M을 찾으려고 한다
	 * => 나머지가 같은 경우는 반드시 존재하며 이 때의 M은 모든 수에서 "동일"
	 * 		=> 모든 수에서 '동일하다' == 결과적으로 M은 공약수
	 * 	ex) 6 / M + r 		34 / M + r		38 / M + r
	 * 		여기서 r은 모두 같음 즉, r만 0으로 만들수 있다면, M은 쉽게 구할 수 있다.
	 * 
	 * 		if r==0
	 * 			(6 / M + r) - (34 / M + r) -> (6 - 34) / M
	 * 			(34 / M + r) - (38 / M + r) -> (34 - 38) / M
	 * 			여기서 M은 모두 같음 => (6 - 34)과 (34 - 38)의 공약수
	 * 			*단, 음수가 나올 수 있으니 "정렬"
	 * 
	 * 유클리드 알고리즘을 이용해서 최대공약수 및 최소공약수를 구함
	 * 1. 두 수의 차이 계산: 큰수a에서 작은수 b를 뺀 차이
	 * 2. 나머지 계산: 이렇게 구한 차이를 a에 할당, 작은수를 b에 할당
	 * 3. b가 0이 아닐때까지 반복. b가 0이되면 a가 최대공약수
	 */
	// 최대공약수 함수
	static int GCD(int a, int b) {
		// 유클리드 알고리즘: GCD(a,b) = GCD(b,r)
		while (b!= 0) {
			int r = a % b;
			
			a = b;
			b = r;
		}
		return a;
		
		/**
		 * if (b == 0) {
		 * 		return a;
		 * } else {
		 * 		return GCD(b, a%b);
		 * }
		 */
	}
	
	
	/** 방법1) 최대공약수 약수찾기
	 * 최대공약수의 약수를 굳이 끝까지 탐색할 필요X
	 * 자신을 제외한 약수로 가질 수 있는 수 중 최대값은 최대공약수/2
	 */
	static void findDivisor_half(int gcdVal) {
		
		StringBuilder sb = new StringBuilder();
		// 최대공약수의 약수 찾기
//		for(int i=2; i<=gcdVal; i++) {
		for(int i=2; i<=gcdVal/2; i++) {	// 절반까지만 탐색하는 경우
			
			// i가 최대공약수의 약수라면 출력
			if(gcdVal % i == 0) {
				sb.append(i).append(' ');
			}
		}
		// 마지막 최대공약수 출력
		sb.append(gcdVal).append('\n');
		System.out.println(sb);
	}
	
	
	/** 방법2) 최대공약수 약수찾기
	 * 제곱근까지만 탐색
	 * ArrayList사용해서 요소 출력
	 */
	static void findDivisor_sqrt(int gcdVal) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		// 제곱근까지만 탐색
		for (int i=2; i<=Math.sqrt(gcdVal); i++) {
			
			// i의 제곱이 gcdVal과 같다면, 이는 중복된 약수이므로 한 번만 리스트에 추가
			if( Math.pow(i, 2) == gcdVal) {
				list.add(i);
			}
			
			// i가 최대공약수의 약수라면 i와 나눈 몫 추가
			else if(gcdVal % i == 0) {
				list.add(i);
				list.add(gcdVal/i);
			}
		}
		
		// 오름차순 정렬
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for (int val : list) {
			sb.append(val).append(' ');
		}
		// 마지막 최대공약수 꼭 출력
		sb.append(gcdVal);
		System.out.println(sb);
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 종이에 적은 수의 개수 N(2 ≤ N ≤ 100)을 입력하세요.\n"
				+ "다음줄 부터 N개의 줄에는 종이에 적은 수를 하나씩 입력하세요.(1보다 크거나 같고, 1,000,000,000보다 작거나 같은 자연수)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 입력받은 수를 위한 배열
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 입력받은 수들을 정렬
		//(음수가 되지 않게 하기 위함)
		Arrays.sort(arr);
		
		// 최대공약수의 초기값 설정 - 배열에서 인접한 두 수의 차이들의 최대공약수 계산
		int gcdVal = arr[1]- arr[0];
		// 배열 내 숫자들의 차이들의 최대공약수를 구함
		for(int i=2; i<N; i++) {
			// 직전의 최대 공약수와 다음 수(arr[i] - arr[i - 1])의 최대공약수를 갱신
			gcdVal = GCD(gcdVal, arr[i] - arr[i-1]);
		}
		
		// 최대공약수 약수찾기
		// 방법1) 자신을 제외한 약수로 가질 수 있는 수 중 최대값은 최대공약수/2
		findDivisor_half(gcdVal);
		
		System.out.println();
		
		// 방법2) 제곱근까지만 탐색 + ArrayList사용해서 요소 출력
		findDivisor_sqrt(gcdVal);

	}
}
