package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
	N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램
	
	첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다.
	둘째 줄부터 N개의 줄에는 수가 주어진다. 
	이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
 */
public class Number_Sort_Range1k {

	// 값 교환 메소드
	static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
	
	// 배열 출력하는 메소드
	static void printArr(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int value : arr) {
			sb.append(value).append('\n');
		}
		System.out.println(sb);
	}
	
	
	// 1. 선택정렬(Selection Sort) 
	// : 첫 번째 인덱스부터 시작하여 뒤의 인덱스들의 값들과 비교하여 최솟값들을 차곡차곡 쌓아나가는 방법
	static void selectionSort(int[] arr) {
		// 0번째 인덱스 ~ 맨 뒤에서 2번째 인덱스까지 반복
		for (int i=0; i<arr.length-1; i++) {
			// 선택된 인덱스의 다음 인덱스 ~ 맨 뒤 인덱스까지
			for (int j=i+1; j < arr.length; j++) {
				// target > 다음 타겟 이라면, 값 교환(큰 값이 뒤로가게)
				if(arr[i] > arr[j]) {
					// 값 교환
					swap(arr, i, j);
				}
			}
		}
		// 정렬된 배열 출력
		printArr(arr);
	}
	
	// 2. Arrays.sort() 메소드 사용 - static void sort(int[] array)
	// : sort() 안에 배열만 넣어주면 자동으로 해당 배열이 정렬되어 나옴
	static void UseArraysSort(int[] arr) {
		// 정렬 메소드
		Arrays.sort(arr);
		// 정렬된 배열 출력
		printArr(arr);
	}
	
	
	// 3. 카운팅 정렬(Counting Sort) - boolean배열
	// 중복되는 수는 없다는 조건 => boolean배열을 사용하여 카운팅 정렬 수행
	static void CountingSort(int[] arr) {
		/* 중복되는 수는 없다는 조건
		 * => boolean배열을 사용하여 카운팅 정렬 수행
		 * 
		 * 이때, 입력되는 수는 절댓값이 1,000보다 작거나 같은 정수이기에,
		 * 		범위는 -1000 ~ 1000임
		 * 		따라서, boolean배열의 크기는 2001로 설정
		 */
		boolean[] booleanarr = new boolean[2001];
		// 따라서, 0은 index[1000]을 의미
		
		// 입력받은 값을 이용해 생성한 배열 arr를 이용하여
		// 입력된 값과 같은 인덱스의 논리배열(booleanarr)값을 true로 설정
		for (int i=0; i<arr.length; i++) {
			booleanarr[arr[i]+1000] = true;
		}
		
		/*
			논리배열을 사용해서 입력된 값에 해당하는 인덱스만
			true로 변경했기에, 따로 정렬과정이 필요X
		 */
		for(int i=0; i<booleanarr.length; i++) {
			if(booleanarr[i]) {
				// 배열을 -1000 ~ 1000으로 크기를 잡아서
				// 0의 값은 index[1000]이었기에, 실제 값 출력을 위해 i-1000 시행
				System.out.println(i-1000);
			}
		}
	}
	
	// 4. Collections.sort(List)메소드 사용
	static void CollectionsSort(int[] arr) {
		
		// list 계열 중 하나를 사용
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		// 입력받은 값을 list에 추가
		for (int element : arr) {
			list.add(element);
		}
		
		// Collections.sort()메소드 사용하여 정렬
		Collections.sort(list);
		
		
		// list를 출력
		StringBuilder sb = new StringBuilder();
		for (int value : list) {
			sb.append(value).append('\n');
		}
		System.out.println(sb);
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)을, 둘째 줄부터 N개의 줄에는 수를 작성하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력받은 수의 개수 N
		int N = Integer.parseInt(br.readLine());
		
		// 둘째줄부터 입력받은 N개의 수
		int[] inputArr = new int[N];
		for(int i=0; i<N; i++) {
			inputArr[i] = Integer.parseInt(br.readLine());
		}
		
		// 정렬
		// 1. 선택정렬 메소드 사용
		// : 첫 번째 인덱스부터 시작하여 뒤의 인덱스들의 값들과 비교하여 최솟값들을 차곡차곡 쌓아나가는 방법
		selectionSort(inputArr);
		
		System.out.println();
		
		// 2. Arrays.sort() 메소드 사용 - static void sort(int[] array)
		// : sort() 안에 배열만 넣어주면 자동으로 해당 배열이 정렬되어 나옴
		UseArraysSort(inputArr);
		
		System.out.println();
		
		// 3. 카운팅 정렬(Counting Sort)
		// 중복되는 수는 없다는 조건 => boolean배열을 사용하여 카운팅 정렬 수행
		CountingSort(inputArr);
		
		System.out.println();
		
		// 4. Collections.sort(List)메소드 사용
		CollectionsSort(inputArr);
	}
}
