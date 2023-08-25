package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* N개를 만들 수 있는 랜선의 최대 길이를 센티미터 단위의 정수로 출력하는 프로그램
 * 
 * 자체적으로 K개의 랜선을 가지고 있다. 그러나 K개의 랜선은 길이가 제각각
 * 랜선을 모두 N개의 같은 길이의 랜선으로 만들고 싶었기 때문에 K개의 랜선을 잘라서 만들어야 한다
 * N개보다 많이 만드는 것도 N개를 만드는 것에 포함
 */
public class Cablecutting {
	
	/** 배열에 대한 이분탐색
	 * 	1. 특정 값에 대한 배열의 특정 인덱스를 찾는 것
	 * 	  - 특정 Key값에 대해 arr[mid]와 비교
	 *  2. 특정 개수에 대한 배열의 특정 길이를 찾는 것
	 *    - 우리는 만들고자 하는 개수가 key이고, 잘라진 mid 길이로 잘랐을 때 잘린 개수와 비교
	 *    - Upper Bound(상한)와 Lower Bound(하한)을 이용
	 *  	상한은 찾고자 하는 특정 값을 초과하는 '첫 위치'를 반환
	 *  	하한은 찾고자 하는 특정 값 이상인 '첫 위치'를 반환
	 *    - 중복 원소에 대한 값을 찾기위한 활용
	 *    	중복 원소에서 가장 끝 값(가장 오른쪽 값)을 찾고자 한다면 Upper Bound - 1
	 *      중복 원소 중 가장 왼쪽 끝 값(가장 왼쪽 값)을 찾고자 한다면 Lower Bound 을 통해 반환 된 값 그대로
	 */
	
	/** 특정 개수에 대한 특정 길이 
	 * => 개수가 중복이 될 때 최대 길이를 찾아야 한다는 것 : Upper Bound - 1
	 * K개의 랜선이 있고 똑같은 길이의 N개의 랜선으로 만들고자 할 때, N개의 랜선이 가질 수 있는 최대 길이
	 * 
	 */
	static void binarySearchLen(long[] arr, long max, long N) {
		
		// 자연수 탐색 범위를 0 ~ max 가 아닌 0 ~ max + 1 범위에서 탐색
		// 탐색길이 최소값을 설정
		long min = 0;
		//  입력 받는 랜선에서 최대 길이 + 1 을 max값으로 잡아야 한다
		max++;		// 반드시 max에서 +1을 해줘야 함
		
		// min = 0, max 는 입력받은 LAN선 중 가장 긴 길이를 갖는다.
		while(min < max) {
			
			// 범위 내에서 중간 길이를 구한
			long mid = min + ((max-min)/2);			// mid = (min + max)/2; 와 동치
			
			// 특정 개수를 구하는 변수
			long count = 0;
			
			// 구해진 중간 길이로 잘라서 총 몇개가 만들어지는지
			for(int i=0; i<arr.length; i++) {
				
				count += (arr[i] / mid);
			}
			
			/* [upper bound 형식]
			 *  mid길이로 잘랐을 때의 개수가 만들고자 하는 랜선의 개수보다 작다면
			 *  자르고자 하는 길이를 줄이기 위해 최대 길이를 줄인다.
			 *  그 외에는 자르고자 하는 길이를 늘려야 하므로 최소 길이를 늘린다.
			 */
			if(count < N) {
				max = mid;
			}
			else {
				min = mid+1;
			}
		}
		
		// UpperBound로 얻어진 값(min)에 -1이 최대 길이가 된다.
		System.out.println(min -1);
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에는 오영식이 이미 가지고 있는 랜선의 개수 K, 그리고 필요한 랜선의 개수 N을 입력하고,\n"
				+ "(K는 1이상 10,000이하의 정수이고, N은 1이상 1,000,000이하의 정수이다. 그리고 항상 K ≦ N )\n"
				+ "그 후 K줄에 걸쳐 이미 가지고 있는 각 랜선의 길이가 센티미터 단위의 정수로 입력하시오(랜선의 길이는 2^31-1보다 작거나 같은 자연수)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		long N = Long.parseLong(st.nextToken());
		
		// 이미 가지고 있는 각 랜선의 길이를 입력받은 정수 배열
		long[] arr = new long[K];
		
		// 랜선의 길이 중 최대값을 입력받을 변수 선언
		long max = 0;
		// 입력과 동시에 해당 랜서느이 길이가 최댓값인지 확인하고 max갱신
		for(int i=0; i<K; i++) {
			arr[i] = Long.parseLong(br.readLine());
			
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		// 특정 개수에 대한 특정 길이를 구하기 위한 이분탐색 시행
		binarySearchLen(arr, max, N);
	}
}
