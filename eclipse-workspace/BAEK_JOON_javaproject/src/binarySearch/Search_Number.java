package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 
 * 이 안에 X라는 정수가 존재하는지 알아내는 프로그램
 * 
 * M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력
 */
public class Search_Number {
	
	/** 이진탐색을 이용하여 정수가 존재하는지 찾는 알고리즘 
	 * 결국 처음 배열이 주어지고 그 다음에 각 값이 처음 주어진 배열에 존재하는지 확인하는 문제
	 * 
	 * 수가 존재하는지만 알아내면 되기에, 중복 원소에 대해서는 고려하지 않을 것
	 * (중복원소가 있을 때 크게 가장 왼쪽의 원소의 위치를 반환하는 방법과, 가장 오른쪽 원소의 위치를 반환하는 방법이 있음)
	 * 
	 * 반복문 내 탐색과정
	 * 1. 탐색 범위내의 배열의 중간인덱스를 구한다. 
	 * 2. 중간 인덱스의 값과 key값을 비교한다.
	 * 3. 값이 중간 값보다 작다면 왼쪽 부분을, 값이 중간 보다 크다면 오른쪽 부분을 탐색하고, 
	 *    같다면 해당 인덱스를 반환하고 종료한다.
	 *    - 찾으려는 값이 있는 경우, 인덱스를 반환하면 되지만,
	 *    - 찾으려는 값이 없는 경우도 존재
	 *    	:  탐색 범위의 왼쪽 끝과 오른쪽 끝이 같은 경우까지 탐색을 했는데 
	 *         그 값이 key값과 같지 않을 경우 해당 배열에는 key값이 존재하지 않는다는 의미
	 * 
	 */
	// 이진탐색을 이용하여 정수가 존재하는지 찾는 알고리즘
	static int binarySearch(int[] arr, int key) {
		
		// 탐색 범위의 왼쪽 끝 인덱스
		int low = 0;
		int high = arr.length -1;
		
		// 탐색범위가 오른쪽 끝과 왼쪽 끝이 같을때까지 탐색
		// => low가 high보다 커지기 전까지 반복
		while(low <= high) {
			
			// 중간 위치를 구함
			int mid = (low + high)/2;
			
			/* key값이 중간 위치의 값보다 작을 경우
			*  key값(찾으려는 값)이 배열의 중간(mid)위치보다 왼쪽에 있다
			*  => 탐색 범위의 오른쪽 끝을 가리키는 hi가 재조정되어야 한다는 의미
			*  	  key는 lo~mid 사이에 있다는 의미 => high = mid -1으로 재조정
			*/
			if(key < arr[mid]) {
				high = mid-1;
			}
			
			/* key값이 중간 위치의 값보다 클 경우
			 * key값(찾으려는 값)이 배열의 중간(mid)위치보다 오른쪽에 있다
			 * => 탐색 범위의 왼쪽 끝을 가리키는 lo가 재조정되어야 한다는 의미
			 * 	  key는 mid ~ high사이에 있기에, low = mid+1로 재조정
			 */
			else if(key > arr[mid]) {
				low = mid+1;
			}
			
			/* key값과 중간 위치의 값이 같을 경우
			 * 이미 찾고자하는 값을 찾았으므로 mid 를 반환
			 */
			else {
				return mid;
			}
		}
		
		// 찾고자 하는 값이 존재하지 않은 경우
		// 근사값의 인덱스를 반환하거나, 음수를 반환한다(여기서는 음수를 반환)
		return -1;
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)을, \n"
				+ "다음 줄에는 N개의 정수 A[1], A[2], …, A[N]를 입력하고,\n"
				+ "다음 줄에는 M(1 ≤ M ≤ 100,000)을\n"
				+ "다음 줄에는 M개의 수를 입력하세요.(모든 정수의 범위는 -2^31 보다 크거나 같고 2^31보다 작다)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 입력받은 N개의 정수 A[1], A[2], …, A[N]
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 배열은 반드시 정렬되어 있어야 함
		Arrays.sort(arr);
		
		// 입력받은 M
		int M = Integer.parseInt(br.readLine());
		
		// 찾고자 하는 값이 있는 경우 1, 없으면 0 출력
		StringBuilder sb = new StringBuilder();
		
		// 이진 탐색을 통해 입력받은 M개의 수가 N개의 정수 안에 있는지 확인
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			
			// 찾고자 하는 값이 있는 경우 1
			if(binarySearch(arr, Integer.parseInt(st.nextToken())) >= 0) {
				sb.append(1).append('\n');
			}
			else {
				sb.append(0).append('\n');
			}
			
			/** Arrays 클래스의 binarySearch 메소드를 활용하여 탐색하는 방법
			 *  binaraySearch(int[] a, int key);
			 *  a는 배열이고, key는 찾고자 하는 값
			 *  
			 *  따라서, 구현한 binarySearch() 대신에, Arrays.binarySearch()메소드를 사용해도 된다
			 */
		}
		System.out.println(sb);
	}
}
