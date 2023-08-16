package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램2
 * 
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다.
 * 둘째 줄부터 N개의 줄에는 수가 주어진다. 
 * 이 수는 10,000보다 작거나 같은 자연수
 */
public class Number_Sort_Range10k {
	
	/*
	 * 수의 개수로 입력받을 수 있는 값(데이터)은 "천만개"이고,
	 * 데이터의 범위는 10000보다 작거나 같은 자연수
	 * => 시간복잡도가 낮은 방법을 사용해야 함!!!
	 */
	// 방법1. Arrays.sort(int[] a)메소드 사용
	static void UseArraysSort(int[] arr) {
		
		// 정렬
		Arrays.sort(arr);
		
		// 배열 출력
		StringBuilder sb = new StringBuilder();
		for (int element : arr) {
			sb.append(element).append('\n');
		}
		System.out.println(sb);
	}
	
	
	// 방법2. int[]배열을 이용한 카운팅정렬 사용
	static void CountingSort_intArr(int[] arr) {
		
		/*
		 * 입력받는 데이터의 범위는 10,000보다 작거나 같은 자연수이기에,
		 * 정수 배열은 0~10000의 범위를 갖는 10001크기를 갖는다 
		 */
		int[] count = new int[10001];
		
		// 입력값을 저장한 배열을 활용하여,
		// 배열의 원소값에 해당하는 인덱스 값을 1 증가
		for (int i=0; i < arr.length; i++) {
			// 원소값에 해당하는 인덱스 값 1 증가
			count[arr[i]]++;
		}
		
		// 해당 배열을 출력
		StringBuilder sb = new StringBuilder();
		/* 	입력받은 값이 10000이하의 자연수이기에, 입력받은 범위에서 0은 없음
			따라서, i=1부터 시작해도 무방
		 */
		for (int i=1; i<count.length; i++) {
			// count[]정수배열의 값이 0 이상이면 출력(1번 이상 입력되었다는 뜻이기에)
			while(count[i] > 0) {
				sb.append(i).append('\n');
				/* 
				 * 인덱스의 value 값을 한 개씩 줄이면서 0 이 될 때 까지 출력
				 * (= 인덱스의 value 값을 1 감소시킴)
				 * => 중복된 데이터가 존재한다면 중복된 횟수만큼 출력될 것
				 */
				count[i]--;
			}
		}
		System.out.println(sb);
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)을, "
				+ "둘째 줄부터 N개의 줄에는 수(10,000보다 작거나 같은 자연수)를 작성하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 입력받은 수를 넣을 배열 설정
		int[] inputArr = new int[N];
		for (int i=0; i<N; i++) {
			inputArr[i]= Integer.parseInt(br.readLine());
		}
		
		// 정렬방법1. Arrays.sort()메소드 사용
		UseArraysSort(inputArr);
		
		System.out.println();
		
		// 정렬방법2. int[]배열을 이용한 카운팅정렬 사용
		CountingSort_intArr(inputArr);
	}
}
