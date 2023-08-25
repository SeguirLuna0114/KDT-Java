package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값을 출력하는 프로그램
 * 
 * 높이 H를 지정하면, 한 줄에 연속해있는 나무를 모두 절단
 * - 높이가 H보다 큰 나무는 H 위의 부분이 잘릴 것이고, 낮은 나무는 잘리지 않을 것
 * ex) 한 줄에 연속해있는 나무의 높이가 20, 15, 10, 17이라고 하자. 상근이가 높이를 15로 지정했다면, 
 *     나무를 자른 뒤의 높이는 15, 15, 10, 15가 될 것이고, 상근이는 길이가 5인 나무와 2인 나무를 들고 집에 갈 것
 */
public class Treecutting {
	
	/** 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값
	 * 
	 * "자르고 난 뒤의 가져가야 할 부분은 윗 부분"
	 * -만일, 자른 나무들의 길이 합(sum)이 가져가고자 하는 길이(M)보다 크면
	 * 		자르는 높이를 낮춰야 하는가 높여야 함 => 하한선(lo 혹은 min변수)을 높여야 한다
	 * -만일, 잘린 나무의 길이가 가져가려는 나무의 길이보다 너무 작은 경우
	 * 		자르려는 높이를 낮춰야 함 => 상한선을 낮춰야 함
	 * 		이때, UpperBound 방식을 사용하여 하면, 원하는 탐색값의 +1이 되기 때문에
	 * 		실제로 만족하는 값은 Upper Bound를 통해 반환 된 값의 -1을 한 값
	 * => 배열의 원소들을 순회하면서 해당 나무들에서 자르는 높이(mid)를 빼주어 합을 구함
	 */
	static void Upperbound(long[] tree, long max, long M) {
		
		/* [upper bound 방식]
		 * int[] tree : 입력받은 나무들의 높이가 저장되어있는 배열(정렬할 필요 없음)
		 * min : 하한선 변수로 초기값은 0
		 * max : tree 에 저장 된 나무들 중 가장 큰 나무의 높이
		 */
		// 탐색범위의 최대값과 최소값 설정
		long min = 0;
		
		// 이분탐색
		while(min < max) {
			
			// 중간값(= 자르는 위치)을 구함
			long mid = min + ((max-min)/2);		//  (min + max) / 2 대신 (min + max) >>> 1 으로 바꿔도 된다
			
			// 잘린 나무의 길이를 합할 변수 sum
			long sum = 0;		// 단일 나무의 길이가 최대 1,000,000,000 (10억) 이기 때문에 합산하는 과정에서 overflow가 발생하지 않도록
			
			for(long treeHeight : tree) {
				
				/*  tree의 잘린 길이 = tree의 높이 - 자르는 위치(mid)
				 *  tree의 잘린 길의의 합을 구한다.
				 *  이 때 자르는 위치가 주어진 나무의 높이보다 클 수 있기 때문에
				 *  0 이하인 경우(=음수)에는 합산을 하지 않고 양수만 합산하도록 해야한다.
				 */
				if( treeHeight - mid > 0) {
					sum += (treeHeight - mid);
				}
			}
			
			/** 자른 나무 길의의 합이 M보다 작다는 것은
			 * 자르는 위치(높이)가 높다는 의미이므로 높이를 낮춰야 한다.
			 * 즉, 상한(max)를 줄여야 한다.
			 */
			if(sum < M) {
				max = mid;
			}
			
			/** 자른 나무 길이의 합이 M보다 크다거나 같는 것은
			 * 자르는 위치(높이)가 낮다는 의미이므로 높이를 높여야 한다.
			 * 또한, 같을 경우에는 최대한 적게 자르기 위해 자르는 높이를
			 * 높여야 하므로 하한(min)을 올려야 한다.
			 */
			else {
				min = mid+1;
			}
		}
		
		/** UpperBound 방식을 사용하여 하면, 
		 * 원하는 탐색값의 +1이 되기 때문에
		 * 실제로 만족하는 값은 Upper Bound를 통해 반환 된 값의 -1을 한 값 출력
		 */
		System.out.println(min-1);
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 나무의 수 N과 상근이가 집으로 가져가려고 하는 나무의 길이 M을 입력하고,\n"
				+ "(1 ≤ N ≤ 1,000,000, 1 ≤ M ≤ 2,000,000,000)\n"
				+ "둘째 줄에는 항상 M보다 크거나 같은 나무의 높이를 입력하세요.(단, 높이는 1,000,000,000보다 작거나 같은 양의 정수 또는 0)");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		
		//입력받은 나무들의 높이가 저장되어있는 배열
		long[] tree = new long[N];
		
		// 탐색범위 중 상한선을 설정하기위한 최대값 변수
		long max = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			tree[i] = Long.parseLong(st.nextToken());
			/*
			 * 나무들 중 최댓값을 구하기 위해 매 입력 때마다 max 변수와 비교하여
			 * 입력 받은 나무가 max보다 클 경우 max 값을 해당 나무의 높이로 갱신해준다. 
			 */
			if(max < tree[i]) {
				max = tree[i];
			}
		}
		
		// 배열의 원소들을 순회하면서 해당 나무들에서 자르는 높이(mid)를 빼주어 합을 구하는 메소드 실행
		// 이때, 상한으로 문제를 구했기에 반환되는 값은 min-1
		Upperbound(tree, max, M);
	}
}
