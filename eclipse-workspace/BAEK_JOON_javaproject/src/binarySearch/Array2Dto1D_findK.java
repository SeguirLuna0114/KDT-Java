package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 세준이는 크기가 N×N인 배열 A를 만들었다. 배열에 들어있는 수 A[i][j] = i×j 이다. 
 * 이 수를 일차원 배열 B에 넣으면 B의 크기는 N×N이 된다. 
 * B를 오름차순 정렬했을 때, B[k]를 구하는 프로그램
 * (단, 배열 A와 B의 인덱스는 1부터 시작)
 * 
 * 입력으로 주어지는 행 또는 열의 크기 N은 10^5 로 전체 행렬의 크기는 최대 10^10 으로, 10,000,000,000 (100억)이 된다. 
 */
public class Array2Dto1D_findK {
	
	/** A[i][j] = i * j 로 이루어져있는 행렬들을
	 *  1차원 배열 B로 만들 때 B[k]의 값은 무엇인지를 찾는 문제
	 *  
	 ** B[11] = 8은 "B행렬의 11번째 값은 8" 이라는 의미
	 *  => 거꾸로, 8이라는 값보다 작거나 같은 원소의 개수는 최소 11개 라는 의미도 된다.
	 *  	(이는, 행렬B가 단조 증가 행렬(오름차순) 성질을 갖기 때문)
	 *  	모든 구간에 대해 B[i] ≤ B[i + 𝛼] 라는 의미
	 *  "B[K] = 𝑥 라는 의미는 𝑥 보다 작거나 같은 원소의 개수가 최소 K개라는 의미"
	 *  
	 *  따라서, B[K] = 𝑥 에서 K인덱스의 원소 값 𝑥 를 찾기 위해
	 *  	𝑥 의 값을 조정해나가면서 𝑥 보다 작거나 같은 원소의 개수가 K값이랑 일치하는 경우를 찾으면 됨
	 *  
	 **  𝑥 보다 작은 원소들의 개수를 찾는 방법
	 *  곱의 성질을 이해하고 있다면 8 / n단의 몫이 8보다 작거나 같은 수의 값이 된다
	 *  2차원 행렬 A에서 각 행 혹은 열이 위와 같이 일종의 구구단이 됨
	 *  => 1 ~ N까지 임의의  𝑥 로 나눠가면서 해당 합이 K와 같은지를 판별
	 *  "𝑥 를 통해  𝑥 보다 작은 원소의 개수(=K)를 찾고, 해당 값이 문제에서 주어지는 K값과 일치하는지를 이분탐색으로 구현"
	 */
	// '찾고자 하는 값과 같거나 큰 수가 있는 첫 번째 인덱스'를 찾는 Lower-Bound 사용
	// - K값에 대해 𝑥 보다 작은 수가 K값이랑 같은 경우의 수가 여러개일 가능성이 발생하기 때문
	static void Lowerbound(long N, long k) {
		
		/** x보다 작은 원소의 개수를 찾을 때 => 𝑥의 범위
		 * - 𝑥의 초기 범위는 1 ~ N^2
		 * - B행렬에서  𝑥 ≤ K (K의 최댓값은 N2 이랑 같기 때문에 반드시 𝑥 ≤ K)
		 * => 𝑥 의 범위를 1 ≤ 𝑥 ≤ K
		 */
		// 상한의 최솟값과 최댓값을 구하는 변수
		long low  = 1;
		long high = k;
		
		// 이분탐색
		// B[K] = x에 대해 x 는 left <= x < right 안의 수
		while(low < high) {
			
			// 임의의 x를 중간값으로 정함
			long mid = low + ((high-low)/2);
			
			// x보다 작은 원소의 개수를 count변수에 누적합
			long count = 0;		// 누적합인 count 변수의 경우 int 자료형을 벗어 날 수 있으니 count는 long 타입으로 선언해주는 것이 안전
			
			/** 𝑥 보다 작은 원소의 개수는 최대 N개를 넘지 못한다.
			 * ex) 𝑥=13 이 되었다고 가정
			 * 		1단에 대해 13 / 1 = 13 
			 * 		2단에 대해 13 / 2 = 6 
			 * 		3단의 경우는 13 / 3 = 4
			 * 		4단의 경우는 13 / 4 =  3 
			 * 	   (4, 8, 12) 총 3개로 N = 4 안에서 개수를 갖게 된다.
			 * 
			 *  임의의 x에 대해 i번 째 행을 나눔으로써 
			 *  x보다 작거나 같은 원소의 개수의 누적 합을 구한다.
			 *  이 때 각 행의 원소의 개수가 N(열 개수)를 초과하지 않는 선에서 합해주어야 한다.   
			 */
			// N을 초과하지 않는 선에서의 개수
			for(int i=1; i<=N; i++) {
				// 배열의 인덱스가 1부터 시작
				count += Math.min(mid / i, N);
			}

			/** 임의의 x보다 작거나 같은 수의 개수(count)가 k값보다 크거나 같은 경우
			 * 임의의 x(mid)보다 작은 수가 B[K]보다 많다는 뜻이기에,
			 * 상한 경계선(상한의 최대값)을 낮춤
			 */
			if(k <= count) {
				high = mid;
			}
			/** 임의의 x보다 작거나 같은 수의 개수(count)가 k값보다 작은 경우
			 * 임의의 x(mid)보다 작은 수가 B[K]보다 적다는 뜻이기에,
			 * 하한 경계선(상한의 최솟값)을 높임
			 */
			else {
				low = mid+1;
			}
		}
		
		System.out.println(low);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 배열의 크기 N(N은 10^5보다 작거나 같은 자연수)을\n"
				+ "둘째 줄에 k(k는 min(10^9, N^2)보다 작거나 같은 자연수)를 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		long k = Long.parseLong(br.readLine());
		
		// '찾고자 하는 값과 같거나 큰 수가 있는 첫 번째 인덱스'를 찾는 Lower-Bound 사용
		Lowerbound(N, k);
	}
}
