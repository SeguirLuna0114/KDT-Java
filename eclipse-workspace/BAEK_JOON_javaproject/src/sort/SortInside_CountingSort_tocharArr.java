package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

/*
	첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력하는 프로그램
	ex) 61423 -> 64321
	
	첫째 줄에 정렬하려고 하는 수 N이 주어진다.
	N은 1,000,000,000보다 작거나 같은 자연수
 */
public class SortInside_CountingSort_tocharArr {

	// 방법1. 카운팅 정렬을 이용 - 각 자리수의 값에 해당하는 빈도배열의 인덱스 값을 ++
	static void CountingSort(int N) {
		
		/* 	입력받은 수의 각 자리수의 값에 빈도수만큼 +1할 배열 선언
		 	이때, 입력받은 자연수를 각자리 수의 값을 기준으로 계산

		 	각 자리수는 0~9사이의 정수이기에, 각 자리수의 빈도수를 계산할 배열의 크기 10으로 설정
		 */
		int[] cntArr = new int[10];
		
		// 입력받은 값의 자리수들에 해당하는 인덱스값을 1++
		while(N != 0) {
			// N의 일의자리수에 해당하는 인덱스값 증가
			cntArr[N%10]++;		
			
			// N의 일의자리수를 날려버림
			N /= 10;		// N = N/10;
		}
		
		/* 내림차순으로 정렬하여 출력
		 * => 마지막 인덱스(9) -> 처음 인덱스(0)으로 반복하며 출력
		 */
		StringBuilder sb = new StringBuilder();
		for (int i=9; i >= 0; i--) {
			// cntArr의 값 중 1번이라도 입력된 값만을 출력(빈도 배열의 값이 0인경우는 제외)
			while(cntArr[i]-- >0) {
				// 해당 빈도배열의 값은 누적값이기에, 해당 값만큼 인덱스를 반복해서 출력
				sb.append(i);
			}
		}
		sb.append('\n');
		System.out.println(sb);
	}
	
	
	// 방법2. toCharArray와 Arrays.sort(int[] a)메소드 사용
	static void ArraysSort(int N) {
		
		// 입력받은 값을 charArray로 변환(int -> String -> toChararray)
		char[] charArr = Integer.toString(N).toCharArray();
		// 만일, br.readLine()으로 바로 문자열로 받은 경우에는 tocharArray()만 하면 됨
		
		// charArray를 Arrays.sort()메소드를 사용해 정렬
		Arrays.sort(charArr);
		
		// 정렬된 값을 내림차순으로 출력해야 함
		// => 마지막 인덱스(배열의 길이-1) ~ 처음 인덱스까지 --(1 감소)시키며 출력
		StringBuilder sb = new StringBuilder();
		for(int i=charArr.length-1; i >= 0; i--) {
			sb.append(charArr[i]);
		}
		sb.append('\n');
		System.out.println(sb);
	}
	
	// 방법3. charAt()메소드와 카운팅 정렬을 사용
	static void CountingSort_charAt(int N) {
		
		/* 	입력받은 수의 각 자리수의 값에 빈도수만큼 +1할 배열 선언
	 	이때, 입력받은 자연수를 각자리 수의 값을 기준으로 계산

	 	각 자리수는 0~9사이의 정수이기에, 각 자리수의 빈도수를 계산할 배열의 크기 10으로 설정
		 */
		int[] cntArr = new int[10]; 
		// 입력받은 수를 문자열로 사용
		String strN = Integer.toString(N);
		
		// 해당 숫자의 자리수의 값을 이용해 cntArr 빈도배열의 인덱스의 값 증가
		for(int i=0; i<strN.length(); i++) {
			// char charAt(int index)메소드로 문자열 -> 문자로 변환
			// 이때, charAt()메소드는 ASCII코드값으로 반환하기에, -'0'으로 반환값을 숫자로 변환
			// 또는 숫자0의 ASCII코드값이 48이기에, -'0' 또는 -48로 원하는 숫자를 얻을 수 있음
			cntArr[strN.charAt(i) - '0']++;
		}
		
		// 내림차순으로 정렬된 숫자를 출력
		StringBuilder sb = new StringBuilder();
		for (int i=9; i>=0; i--) {
			// 중복값의 경우 해당 빈도수만큼 출력
			while (cntArr[i]-- >0) {
				sb.append(i);
			}
		}
		sb.append('\n');
		System.out.println(sb);
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("정렬하려고 하는 자연수 N(1,000,000,000보다 작거나 같은 자연수)을 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 정렬하려고 하는 자연수 N
		int N = Integer.parseInt(br.readLine());
		
		// 방법1. 카운팅 정렬을 이용하여 자연수N을 정렬한 방법
		CountingSort(N);
		
		// 방법2. toCharArray와 Arrays.sort(int[] a)메소드 사용
		ArraysSort(N);
		
		// 방법3. charAt()메소드와 카운팅 정렬을 사용
		CountingSort_charAt(N);
	}

}
