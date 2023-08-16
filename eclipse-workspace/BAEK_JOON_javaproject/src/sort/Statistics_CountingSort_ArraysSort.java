package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
	N개의 수가 주어졌을 때, 네 가지 기본 통계값(산술평균, 중앙값, 최빈값, 범위)을 구하는 프로그램
	
	첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 단, N은 홀수
	그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다
	
	첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
	둘째 줄에는 중앙값을 출력한다.
	셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 '두 번째로 작은 값'을 출력한다.
	넷째 줄에는 범위를 출력
	
	산술평균 : N개의 수들의 합을 N으로 나눈 값
	중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
	최빈값 : N개의 수들 중 가장 많이 나타나는 값
	범위 : N개의 수들 중 최댓값과 최솟값의 차이
 */
public class Statistics_CountingSort_ArraysSort {
	
	/*
	 * 방법1. 카운팅 정렬(Counting Sort)을 사용하여 문제 풀이(최빈값을 구하는 과정 때문)
	 * - 산술평균: (double)sum / N => Math.round()소수점 이하에서 반올림한 값
	 * - 중앙값 : 정렬 -> 중앙값
	 * - 최빈값 : mode count++
	 * - 범위 : max - min
	 */
	static void CountingSort(int N, BufferedReader br) throws IOException {
		/*
		 * 입력되는 정수 데이터는 절댓값이 4000을 넘지 않기에
		 * 입력 데이터의 범위는 -4000 ~ 4000이고, 이에 따라 정수배열의 크기는 8001이다
		 */
		// 입력값의 범위를 이용하여 배열 선언
		int[] cntArr = new int[8001];
		
		/** 사용할 변수 선언 및 초기값 설정
		 * sum: 총 합계
		 * max: 최댓값
		 * min: 최솟값
		 * * 중앙값과 최빈값은 -4000~4000 범위 외의 수로 초기값 설정
		 * median: 중앙값
		 * mode: 최빈값
		 */
		int sum=0;
		int max = Integer.MIN_VALUE;	// 정수 중 최솟값을 초기값으로 설정
		int min = Integer.MAX_VALUE;	// 정수 중 최댓값을 초기값으로 설정
		int median = 10000;
		int mode = 10000;
		
		// 입력받은 정수 처리
		// while문 사용을 위해서 N을 복사한 후, --연산 수행(이후에 N을 사용하기 때문)
		int cpN = N;
		while(cpN-- >0) { 		// for (int i=0; i < N; i++) {
			// 입력받은 정수
			int value = Integer.parseInt(br.readLine());
			
			// N개의 수들의 합계
			sum += value;
			
			// 카운팅 정렬을 위해, 입력받은 정수에 해당하는 인덱스값 1 증가
			// 이때, 범위가 -4000~4000이기에, 0은 index[4000]이다.
			cntArr[value+4000]++;
			
			// 최댓값
			if (max < value) {
				max = value;
			}
			
			// 최소값
			if (min > value) {
				min = value;
			}
		}
		
		// 최빈값 및 중앙값 처리
		// 순회
		int count = 0;		// 중앙값 빈도 누적수
		int mode_max = 0;	// 최빈값의 최댓값 변수
		
		// 이번에 동일한 최빈값이 1번만 등장했을 경우 true, 아닐경우 false
		boolean flag = false;
		
		// 카운팅 배열의 최대값 ~ 최소값 범위 내에서만 탐색
		// 이때, 범위가 -4000~4000이기에, 0은 index[4000]
		for (int i=min+4000; i<=max+4000; i++) {
			
			// 입력받은 범위 내에서 탐색(최소값 ~ 최대값)
			if(cntArr[i] >0) {
				/*
				 * <중앙값 찾기>
				 * 누적횟수를 입력받은 수의 개수인 홀수N과 비교
				 * 
				 * 누적횟수가 입력받은 수의 개수인 N의 절반에 못미친다면
				 * 입력받은 i값의 빈도수(cntArr[i])를 count변수에 누적
				 * 중앙값을 해당 i값으로 변경
				 */
				// 이때, 입력받은 수N은 홀수이기에, N+1을 수행하여 짝수로 계산
				if(count < (N+1)/2) {
					count += cntArr[i];		// 입력받은 i값의 빈도수(cntArr[i])를 count변수에 누적
					median = i-4000;		// 중앙값을 해당 i값으로 변경
				}
				
				/*
				 * <최빈값 찾기>
				 * 이전 최빈값보다 현재 값의 빈도수가 더 높은 경우
				 * 중복값이 입력될 수 있기에, 1번 등장했던 최빈값의 경우 true로 변경
				 */
				if(mode_max < cntArr[i]) {
					// 최빈값의 최대값을 현재 값으로 업데이트
					mode_max = cntArr[i];
					// 최빈값을 현재 인덱스로 변경
					mode = i-4000;
					// 첫 등장이기에, true로 변경
					flag = true;
				}
				// 이전 최빈값 중 최대값과 동일한 경우 & 1번만 중복되는 경우(2번째 등장인 경우)
				else if(mode_max == cntArr[i] && flag == true) {
					// 최빈값을 현재 인덱스로 변경
					mode = i-4000;
					// 최빈값이 이전에 한번 더 등장했었기에 flag를 false로 변경
					flag = false;
				}
			}
		}
		// 통계값들을 출력
		printStatistics(N, sum, median, mode, max, min);
	}
	
	static void printStatistics(int N, int sum, int median, int mode, int max, int min) {
		StringBuilder sb = new StringBuilder();
		
		// 산술평균 : N개의 수들의 합을 N으로 나눈 값. 소수점 이하 첫째 자리에서 반올림한 값을 출력
		sb.append((int)Math.round((double)sum / N)).append('\n');
		
		// 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
		sb.append(median).append('\n');
		
		// 최빈값 : N개의 수들 중 가장 많이 나타나는 값. 여러 개 있을 때에는 최빈값 중 '두 번째로 작은 값'을 출력
		sb.append(mode).append('\n');
		
		// 범위 : N개의 수들 중 최댓값과 최솟값의 차이
		sb.append(max-min).append('\n');
		
		System.out.println(sb);
	}

/*--------------------------------------------------------------------------------------*/
	
	/* 방법2. Arrays.sort()메소드 사용하는 경우
	 * counting정렬의 경우 애초에 해당 값의 빈도수가 cntArr배열의 value값으로 들어있기에, 값만 비교하면 되지만,
	 * Arrays.sort()메소드를 사용하는 경우, count를 해줘야 함
	 */
	static void ArraysSort(int N, BufferedReader br) throws IOException {

		// 합계
		int sum=0;
		
		// 입력받은 정수 N을 할당할 배열 선언
		int[] inputArr = new int[N];
		for(int i=0; i<N; i++) {
			int value = Integer.parseInt(br.readLine());
			inputArr[i] = value;
			// 입력받은 값들의 합계
			sum += value;
		}
		
		// 입력받은 값들을 정렬
		Arrays.sort(inputArr);
		
		/*
		 * <최빈값 찾기>
		 * 최빈값은 -4000~4000 범위 외의 수로 초기값 설정
		 */
		// 최빈값을 처리하기 위한 변수 설정
		int mode = 10000;		// 최빈값 변수
		int mode_max = 0;		// 최빈값의 최댓값 변수
		
		// 이번에 동일한 최빈값이 1번만 등장했을 경우 true, 아닐경우 false
		boolean flag = false;
		
		// 입력받은 값으로 이루어진 배열(inputArr) 순회
		for(int i=0; i<N; i++) {
			// 동일한 수가 중복된 만큼 i값을 jump 시킬 변수
			int jump = 0;
			// 입력받은 값들로만 이루어져 있기에 빈도수는 1부터 시작
			int count = 1;
			
			int i_value = inputArr[i];
			// 중복값 처리
			for (int j=i+1; j < N; j++) {
				// 인덱스i에 해당하는 값이 중복된 값이 아니라면
				if(i_value != inputArr[j]) {
					break;	// 해당 j를 중지하고, j+1로 넘어감
				}
				// 중복된 값이라면
				count++;
				jump++;	// 중복값이기에 넘어감
			}
			
			// 최빈값의 최대값보다 해당 빈도수가 큰 경우 
			if(count > mode_max) {
				mode_max = count;	// 최빈값 횟수를 현재 count로 할당
				mode = i_value;		// 최빈값을 현재 i번째 값으로 변경
				// 최빈값의 첫 등장이기에, true로 변경
				flag = true;
			}
			// 이전 최빈값 중 최대값과 동일한 경우 & 1번만 중복되는 경우(2번째 등장인 경우)
			else if(count == mode_max && flag == true) {
				mode = i_value;		// 최빈값을 현재 i번째 값으로 변경
				// 최빈값이 이전에 한번 더 등장했었기에 flag를 false로 변경
				flag = false;
			}
			
			// 인덱스 값을 동일한 수가 중복된 만큼 +jump 시킴
			i += jump;
		}
		
		/**	통계값들을 출력
		 	중앙값 median은 입력받은 값들로 이루어진 배열(inputArr)에서 가운데 인덱스(N/2)에 해당하는 값
		 	이때, 입력받은 N은 홀수이기에, N/2를 수행하면 소수점아래가 버려짐.
		 	단, index는 0부터 시작 => index[N/2]가 중앙값
		 	
		 	최대값 max는 inputArr[N-1]		(인덱스는 0부터 시작 ~ N-1까지 존재)
		 	최소값 min은 inputArr[0]
		*/
		printStatistics(N, sum, inputArr[N/2], mode, inputArr[N-1], inputArr[0]); 
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 수의 개수 홀수 N(1 ≤ N ≤ 500,000), 그 다음 N개의 줄에는 정수를 입력");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 수의개수N
		int N = Integer.parseInt(br.readLine());
		
		// 방법1. 카운팅 정렬(Counting Sort)을 사용하여 문제 풀이
		CountingSort(N, br);
		
		System.out.println();
		
		// 방법2. Arrays.sort()메소드 사용
		ArraysSort(N, br);
	}
}
