package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 
 * 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램
 * 
 * - 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)
 * - 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
 * - 상근이가 몇개 갖고 있는 숫자카드인지 구해야 할 정수 M(1 ≤ M ≤ 500,000)
 */
public class count_NumCard {
	
	/**
	 * 이분 탐색: 구간의 중간 위치의 값과 key(찾고자 하는 값)를 비교하여 
	 * 			구간을 절반으로 줄여나가며 풀이
	 * *단! 중복 원소의 개수를 알아내야 함!!
	 *	=> 중복 원소의 왼쪽 끝 값과 오른쪽 끝 값을 각각 알아내는 방법(lower bound(하한)과 upper bound(상한)을 이용)
	 *	   가장 왼쪽의 인덱스와 오른쪽의 인덱스를 얻어내어 구간의 길이를 얻어내는 방법
	 *	   중복 원소에 대한 길이 = 상한 - 하한
	 *
	 * * 이분탐색의 원리 => 구간 내 중앙값을 기준으로 key값과 비교하여 상한을 내릴지 하한을 올릴지 결정
	 */
	// 하한(lowerbound)을 반환하는 메소드
	static int lowerBound(long[] arr, long key) {
		
		// 시작과 끝 인덱스를 설정
		int low = 0;
		int high = arr.length;	
		// arr.length-1일 경우, 인덱스가 하나인 배열일때 lo와 hi가 같은 시점에서 탐색하게 됨
		
		// low와 high가 같아질 때 까지 반복
		while(low < high) {
			
			// 중간 위치를 구함
			int mid = (low + high) /2;
			
			/* "중복원소에 대해 왼쪽으로 탐색하도록 상계를 내림"
			 * key값이 중간 위치의 값보다 작거나 같은 경우
			 * 범위는 [low:mid]라는 뜻이기에,
			 * 끝점을 mid로 변경 => 중복원소에 대해 왼쪽으로 탐색
			 */
			if(key <= arr[mid]) {
				high = mid;
			}
			/* key값이 중간위치의 값보다 큰 경우
			 * 범위는 [mid+1:high]라는 뜻이기에,
			 * 시작점을 mid+1로 변경 => 중복원소에 대해 오른쪽으로 탐색 진행
			 */
			else {
				low = mid+1;
			}
		}
		// 하한을 반환
		return low;
	}
	
	// 상한(upperbound)를 반환하는 메소드
	static int upperBound(long[] arr, long key) {
		
		// 시작과 끝 인덱스를 설정
		int low = 0;
		int high = arr.length;
		// arr.length-1일 경우, 인덱스가 하나인 배열일때 lo와 hi가 같은 시점에서 탐색하게 됨
		
		// low와 high가 같아질 때 까지 반복
		while(low < high) {
			
			/** 중간 위치를 구함
			 * 1. 중간지점 = (시작점+끝점)/2
			 * 2. 중간지점 = 시작점 + ((끝점 - 시작점)/2)
			 */
			int mid = low + ((high - low)/2);
			
			/* key값이 중간 위치의 값보다 작을 경우
			 * 범위는 [low:mid]라는 뜻이기에,
			 * 끝점을 mid로 변경 => 중복원소에 대해 왼쪽으로 탐색
			 */
			if(key < arr[mid]) {
				high = mid;
			}
			/* "중복원소에 대해 오른쪽으로 탐색되도록 하한을 올림"
			 * 		key >= arr[mid]
			 * key값이 중간위치의 값보다 크거나 같은 경우
			 * 범위는 [mid+1:high]라는 뜻이기에,
			 * 시작점을 mid+1로 변경 => 중복원소에 대해 오른쪽으로 탐색 진행
			 */
			else {
				low = mid+1;
			}
		}
		return low;
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)을\n"
				+ "둘째 줄에는 숫자 카드에 적혀있는 정수를 입력하세요.\n"
				+ "(단, 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다)\n"
				+ "셋째 줄에는 M(1 ≤ M ≤ 500,000)을, 넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수를 입력하세요.\n"
				+ "(단, 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다)");
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		// 이분탐색을 위해서는 반드시 정렬되어 있어야 함
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M; i++) {
			long key = Long.parseLong(st.nextToken());
			
			// upperBound(상한)와 lowerBound(하한)의 차이 값을 구한다.
			sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
		}
		
		System.out.println(sb);
	}
}
