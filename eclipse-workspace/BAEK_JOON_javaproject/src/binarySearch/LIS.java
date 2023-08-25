package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력하는 프로그램
 * ex) 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 
 *     가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4
 */
public class LIS {
	
	/** 가장 긴 증가하는 부분수열(LIS)을 이분탐색
	 * 
	 * - LIS(가장 긴 증가하는 부분 수열) = 결국 중점이 '증가' 한다는 것과 '가장 길다'는 것
	 * - 증가한다 = 선행 원소보다 후행 원소가 크다
	 * - 가장 길다 = 제한 된 수의 범위 내 볼 때 "상호 원소간 값의 차이가 적다"
	 * 		- 선행 원소보다 크지 않은 경우, "좀 더 작은값으로 큰 값을 대치"
	 * 		  즉, 탐색 값보다 큰 값중 가장 가까이에 있는 수와 맞바꾼다
	 * 			=> 좀 더 작은 값으로 대치하여 이후 원소가 더 많이 들어 올 수 있는 가능성을 넓힘
	 * 
	 * 따라서, 이분탐색을 "대치를 하는 과정에 탐색하는 값보다 큰 가장 가까운 원소를 찾는"데 사용
	 */
	static void Lowerbound(int[] seq, int[] LIS) {
		
		// LIS 초기값으로 seq의 첫번째 수열의 값을 가짐
		LIS[0] = seq[0];
		// LIS의 배열의 길이 변수 설정
		int lengthOfLIS = 1;
		
		for(int i=1; i<seq.length; i++) {
			
			// key값 설정
			int key = seq[i];
			
			// 만일 현재 탐색값이 LIS의 마지막 값보다 크다면, LIS에 원소 추가
			if(key > LIS[lengthOfLIS - 1]) {
				lengthOfLIS++;	// 길이++
				LIS[lengthOfLIS - 1] = key;		// 마지막에 key값 추가
			}
			
			// 만일 현재 탐색값이 LIS의 마지막 값보다 작거나 같은 경우
			// seq[i]보다 큰 가장 가까운 값을 LIS 찾기위해 lower-bound를 쓴다.
			else {
				// Lowerbound 이분탐색 진행
				int low = 0;	// 하한의 최솟값
				int high = lengthOfLIS;		// 하한의 최댓값
				
				while(low < high) {
					
					// 중간값을 x로 설정
					int mid = low + (high - low)/2;
					
					/** LIS의 중간인덱스 값이 key값보다 작은 경우
					 *  하한의 최솟값을 높여줌
					 */
					if(LIS[mid] < key) {
						low = mid+1;
					}
					
					/** LIS의 중간인덱스 값이 key값보다 크거나 같은 경우
					 *  하한의 최댓값을 낮춰줌
					 */
					else {
						high = mid;
					}
				}
				
				/**  low가 LIS에서 대치 될 원소의 위치가 될 것이고
				 *  해당 위치에 key값으로 원소를 바꿔준다.
				 */
				LIS[low] = key;
			}
		}
		
		// 위 과정을 통해 나온 LIS의 길이를 출력
		System.out.println(lengthOfLIS);
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)을 \n"
				+ "둘째 줄에는 수열 A를 이루고 있는 Ai(1 ≤ Ai ≤ 1,000,000)를 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 입력받은 수열을 저장할 배열
		int[] seq = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		
		// LIS배열 생성
		int[] LIS = new int[N];

		// 이분탐색을 "대치를 하는 과정에 탐색하는 값보다 큰 가장 가까운 원소를 찾는"데 사용
		Lowerbound(seq, LIS);
	}
}
