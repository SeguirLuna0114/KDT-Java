package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
	알파벳 소문자로 이루어진 N개의 단어가 들어오면 조건에 따라 정렬하는 프로그램
	1. 길이가 짧은 것부터
	2. 길이가 같으면 사전 순으로
	(단, 중복된 단어는 하나만 남기고 제거)
	
	첫째 줄에 단어의 개수 N이 주어진다.(1 ≤ N ≤ 20,000) 
	둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 
	주어지는 문자열의 길이는 50을 넘지 않음
 */
public class AlphabetWord_ArraysSortComparator {

	/*
	 * 단어 길이순으로 정렬 -> 길이가 같다면, 사전순으로 정렬
	 * 중복되는 단어의 경우, 한번만 출력
	 * 
	 * Comparator<? super T> c
	 * * Comparator는 객체를 비교할 수 있도록 해주는 인터페이스
	 * - 일반적인 자료형 비교가 아닌, 특정 규칙에 의해 비교하고 싶은 경우는 Comparator 구현
	 * 
	 * 입력받은 단어를 정렬하기에, String타입을 정렬할 것(T = String)
	 */
	static void ArraysSortCompare(int N, BufferedReader br) throws IOException {
		
		// 입력받은 단어를 배열에 할당
		String[] StrArr = new String[N];
		for (int i=0; i<N; i++) {
			StrArr[i] = br.readLine();
		}
		
		// Arrays.sort()메소드로 StrArr배열 정렬
		// <T> void sort(T[] a, Comparator<? super T> {...});
		Arrays.sort(StrArr, new Comparator<String>() {
			// Comparator 인터페이스를 사용하여 단어의 길이 비교
			@Override
			/* 
			 * int compare(T o1, T o2)메소드를 재정의
			 * - 길이가 같은 단어는 사전순으로 정렬
			 * - 길이가 다른 단어는 길이가 짧은 순서대로 정렬
			 */
			public int compare(String s1, String s2) {
				// 만일 단어의 길이가 같다면 사전순으로 정렬
				if (s1.length() == s2.length()) {
					/* 
					 * int compareTo(String anotherString)메소드
						String클래스에서 두개의 문자열을 '유니코드값'으로 바이트씩 비교하여
						- 비교중 차이가 발생되면 해당 위치의 문자의 유니코드 값의 차이를 반환
							(s1.charAt(i) - s2.charAt(i))
						- 비교중 차이가 없고,한 문자열이 다른 문자열의 모든 문자를 포함하는 경우, 긴 문자열값 반환
						=> 문자열을 사전순으로 비교하는데 유용
					*/
					return s1.compareTo(s2);
				}
				// 그 외의 경우(단어의 길이가 같지 않은 경우)
				else {
					return s1.length() - s2.length();
				}
			}
		});
		
		StringBuilder sb = new StringBuilder();
		// 정렬된 배열의 첫 번째 단어를 출력
		sb.append(StrArr[0]).append('\n');
		// 두번째 단어부터 배열 순회
		for (int i = 1; i < N; i++) {
			// 중복되지 않는 단어만 출력
			if (!StrArr[i].equals(StrArr[i - 1])) {
				sb.append(StrArr[i]).append('\n');
			}
		}
		System.out.println(sb);
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 단어의 개수 N(1 ≤ N ≤ 20,000)을 입력하고,"
				+ "둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어 입력");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//첫째 줄에는 단어의 개수N이 입력됨
		int N = Integer.parseInt(br.readLine());
		
		// 두번째 줄 부터 N개의 줄에 걸쳐 알파벳 단어가 입력됨
		
		// Arrays.sort()메소드 사용하는 경우
		ArraysSortCompare(N, br);
	}

}
