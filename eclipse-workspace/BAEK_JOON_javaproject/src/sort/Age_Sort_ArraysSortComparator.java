package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
	회원들을 나이가 증가하는 순으로, 
	나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램
	
	첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)
	둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다. 
	나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고, 
	이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다.
	
	** 입력순으로 배열에 값을 할당할 경우, 해당 배열을 나이값으로만 정렬하기만 하면 됨
 */
public class Age_Sort_ArraysSortComparator {
	
	static StringBuilder sb = new StringBuilder();
	
	/* 방법1. Arrays.sort()메소드와 Comparator객체 활용하는 방법
	 * 나이순으로 정렬 -> 나이가 같다면, 입력순으로 정렬
	 * 입력순으로 배열에 값을 할당할 경우, 해당 배열을 나이값으로만 정렬하기만 하면 됨
	 * 
	 * Comparator<? super T> c
	 * * Comparator는 객체를 비교할 수 있도록 해주는 인터페이스
	 * - 일반적인 자료형 비교가 아닌, 특정 규칙에 의해 비교하고 싶은 경우는 Comparator 구현
	 * 
	 * 입력받은 단어를 정렬하기에, String타입을 정렬할 것(T = String)
	 */
	static void ArraysSortComparator(int N, BufferedReader br) throws IOException {
		
		String[][] StrArr = new String[N][2];
		
		for(int i=0; i<N; i++) {
			// 입력받은 회원의 나이와 이름을 공백 기준으로 파싱
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			StrArr[i][0] = st.nextToken();	// 나이
			StrArr[i][1] = st.nextToken();	// 이름
		}
		
		// Arrays.sort()메소드로 StrArr배열 '나이순' 정렬
		// <T> void sort(T[] a, Comparator<? super T> {...});
		Arrays.sort(StrArr, new Comparator<String[]>() {
			// Comparator 인터페이스를 사용하여 단어의 길이 비교
			@Override
			/* int compare(T o1, T o2)메소드를 재정의
			 * 나이순으로 정렬
			 */
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
			}
		});
		
		for (int i=0; i<N; i++) {
			sb.append(StrArr[i][0]+ " "+StrArr[i][1]).append('\n');
//			sb.append(StrArr[i][0]).append(' ').append(StrArr[i][1]).append('\n');
		}
		System.out.println(sb);
		
	}
	
//-----------------------------------------------------------------------------------	
	/* 방법2. Person클래스를 생성하여 출력하는 방법
	 * Person클래스 생성 후, Person클래스의 객체배열을 생성하여
	 * 해당 배열을 Arrays.sort()메소드와 Comparator메소드로 나이순 정렬
	 */
	static class Person{
		int age;
		String name;
		
		// 생성자
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
		
		/**	toString()메소드 재정의
		 *  => toString() 메소드는 객체를 출력할 때, 
		 *  	사용자의 임의로 출력하고자 하는 문자열을 지정하여 출력 가능
		 */
		@Override
		public String toString() {
			return age+' '+name+'\n';
		}
	}
	
	static void ClassArraysSort(int N, BufferedReader br) throws IOException {
		
		// Person클래스의 객체배열 생성
		Person[] person = new Person[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 입력받은 값을 객체배열에 할당
		for (int i=0; i<N; i++) {
			person[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
		// Arrays.sort()메소드로 StrArr배열 '나이순' 정렬
		// <T> void sort(T[] a, Comparator<? super T> {...});
		Arrays.sort(person, new Comparator<Person>() {
			// Comparator 인터페이스를 사용하여 단어의 길이 비교
			@Override
			/* int compare(T o1, T o2)메소드를 재정의
			 * 나이순으로 정렬
			 */
			public int compare(Person p1, Person p2) {
				return p1.age - p2.age;
			}
		});
		
		// 정렬한 객체배열 출력
		for(int i=0; i<N; i++) {
			// 객체배열의 객체를 출력하면, 해당 인덱스의 객체의 toString()이 출력됨
			sb.append(person[i]);
		}
		System.out.println(sb);
	}
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 온라인 저지 회원의 수 N(1 ≤ N ≤ 100,000)를\n"
				+ "둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름을 공백으로 구분하여 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 온라인 저지 회원의 수
		int N = Integer.parseInt(br.readLine());
		
		// 둘째줄부터 입력된 회원의 나이와 이름을 공백으로 구분하여 입력
		
		// 방법1.Arrays.sort()메소드 사용하는 경우 - <T> void sort(T[] a, Comparator<? super T> {...});
		ArraysSortComparator(N, br);
		
		System.out.println(); 
		
		// 방법2. Person클래스를 사용하는 경우
		ClassArraysSort( N, br);
	}

}
