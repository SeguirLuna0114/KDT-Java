package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * 2차원 평면 위의 점 N개가 주어진다. 
 * 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음
 * 출력하는 프로그램
 * 
 * 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어지고,
 * 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다.
 * (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수, 위치가 같은 두 점은 없음(중복X)
 */
public class Point_Sort_ArraySortComparator_lambda {
	
	static StringBuilder sb = new StringBuilder();

	/** lambda
	 * 람다식을 사용하여 ArraysSort()메소드 확장 => 2차원 배열 정렬 * 람다식 : (매개변수1, ...) -> {함수;} ex)
	 * public int sum(int a, int b) { return a+b; } => (int a, int b) -> {return
	 * a+b;} // 람다식으로 구현한 익명함수
	 * 
	 * Arrays.sort()메소드 <T> void sort(T[] a, Comparator<? super T> c ); - sort메소드는
	 * 제너릭타입의 객체배열(T[])를 매개변수로 받음 = 어떠한 타입이든 상관없이 배열의 형태로 받을 수 있다는 의미 - Comparator 의
	 * 경우 람다식으로 표현가능 => compare 메소드를 오버라이딩하여 compare 메소드 안에 자신만의 비교 방법(우선순위 판단)을 구현
	 */
	// 방법1. 람다식을 이용해서 ArraysSort메소드를 Comparator인터페이스를 사용하여 정렬
	static void ArraysSort_lambda(int N, BufferedReader br) throws IOException {

		// 입력받은 단어를 배열에 할당
		int[][] PointArr = new int[N][2];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			// 매번 입력되는 N개의 줄에 대해서 파싱
			st = new StringTokenizer(br.readLine(), " ");
			PointArr[i][0] = Integer.parseInt(st.nextToken());
			PointArr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// Arrays.sort()메소드로 StrArr배열 정렬
		// <T> void sort(T[] a, Comparator<? super T> {...}); => 람다식 활용
		Arrays.sort(PointArr, (p1, p2) -> {
			// 만일 첫번째 원소(x좌표)가 같은경우, 두번째 원소끼리 비교
			if(p1[0] == p2[0]) {
				return p1[1] - p2[1];
			} else {
				// 같지 않은 경우에는 x좌표끼리 비교
				return p1[0] - p2[0];
			}
		});
		
		// 정렬을 끝낸 PointArr[][]배열 출력
		for (int i=0; i<N; i++) {
			sb.append(PointArr[i][0]).append(' ').append(PointArr[i][1]).append('\n');
		}
		System.out.println(sb);
	}
	
	
	// 방법2. 일반적으로 ArraysSort메소드와 Comparator인터페이스를 사용하여 정렬하는 방법
	static void ArraysSortComparator(int N, BufferedReader br) throws IOException {

		// 입력받은 단어를 배열에 할당
		int[][] PointArr = new int[N][2];
		for (int i = 0; i < N; i++) {
			// 매번 입력되는 N개의 줄에 대해서 파싱
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			PointArr[i][0] = Integer.parseInt(st.nextToken());
			PointArr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// Arrays.sort()메소드로 StrArr배열 정렬
		// <T> void sort(T[] a, Comparator<? super T> {...});
		Arrays.sort(PointArr, new Comparator<int[]>() {
			// Comparator 인터페이스를 사용하여 단어의 길이 비교
			@Override
			/* int compare(T o1, T o2)메소드를 재정의
			 * => x좌표가 같으면 y좌표가 증가하는 순서로 정렬
			 */
			public int compare(int[] p1, int[] p2) {
				// 만일 첫번째 원소(x좌표)가 같은경우, 두번째 원소끼리 비교
				if(p1[0] == p2[0]) {
					return p1[1] - p2[1];
				} else {
					// 같지 않은 경우에는 x좌표끼리 비교
					return p1[0] - p2[0];
				}
			}
		});
		
		// 정렬을 끝낸 PointArr[][]배열 출력
		for (int i=0; i<N; i++) {
			sb.append(PointArr[i][0]).append(' ').append(PointArr[i][1]).append('\n');
		}
		System.out.println(sb);
	}

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)를,\n" + "둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi을 입력하세요.");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 둘째줄부터 입력받는 x, y좌표를 정렬하여 출력하기
		
		// 방법1. 람다식을 이용해서 ArraysSort메소드를 Comparator인터페이스를 사용하여 정렬
		ArraysSort_lambda(N, br);
	
		System.out.println();
		
		// 방법2. 일반적으로 ArraysSort메소드와 Comparator인터페이스를 사용하여 정렬하는 방법
		ArraysSortComparator(N, br);
	}

}
