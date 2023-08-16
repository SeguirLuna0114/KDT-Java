package p2023_07_18;

// 배열(Array) - 참조형
// 동일한 (한가지) 자료형의 데이터를 저장하기 위한 "정적인" 자료구조
// - 인덱스를 사용하여 개별 요소에 접근 가능

// 변수 --(확장)--> 배열 --(확장)--> 자료구조(List)
// 1개의 데이터만 저장 -> 여러 데이터 저장 -> 여러 자료형의 데이터 저장

// 1차원 배열
// 형식2) 배열에 할당될 값이 정해진 경우 주로 사용
// 		(배열 선언과 동시에 초기화를 할때 주로 사용)
public class ArrayEx01_1dim_Express {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// 형식1) 배열에 저장될 값이 정해져있지 않은 경우 주로 사용
		
		// int형 배열 생성***
		int[] 	score = new 	int[3];	// heap메모리에 새로운 기억공간 형성
//		자료형	배열변수	연산자	자료형[배열의 크기]	
//		int 	score[] = new 	int[3];	// type arrayName[];으로 작성해도 됨
		
		// int형 배열은 자동으로 0으로 초기화됨***
		System.out.println(score[0]);	// 0
		System.out.println(score[1]);	// 0
		System.out.println(score[2]);	// 0
		
		// 개별 요소에 정수 할당
		score[0] = 80;
		score[1] = 90;
		score[2] = 100;
		
		System.out.println(score[0]);	// 80
		System.out.println(score[1]);	// 90
		System.out.println(score[2]);	// 100
		
		// double형 배열 생성
		double[] d = new double[3];
		
		// double형 배열은 자동으로 0.0으로 초기화 됨
		System.out.println(d[0]);		// 0.0
		System.out.println(d[1]);		// 0.0
		System.out.println(d[2]);		// 0.0
		
		// char형 배열 생성
		char[] ch = new char[3];
		
		// char형 배열은 자동으로 문자형태로 초기화 되지X
		System.out.println(ch[0]);
		System.out.println(ch[1]);
		System.out.println(ch[2]);
		
		// boolean형 배열 생성
		boolean[] b = new boolean[3];
		
		// boolean형 배열은 false값으로 초기화 됨
		System.out.println(b[0]);		// false
		System.out.println(b[1]);		// false
		System.out.println(b[2]);		// false
		
		// String형 배열 생성***
		String[] str = new String[3];
		
		// String형 배열은 null값으로 초기화됨
		// null: 값이 없음. 참조할 주소가 없음.
		System.out.println(str[0]);		// null
		System.out.println(str[1]);		// null
		System.out.println(str[2]);		// null
		
		// String형 배열의 값 할당 with 인덱스 사용
		str[0] = "자바";
		str[1] = "오라클";
		str[2] = "스프링";
		System.out.println(str[0]);		// 자바
		System.out.println(str[1]);		// 오라클
		System.out.println(str[2]);		// 스프링
		
		
// 형식2) 배열선언과 동시에 초기화 할때 주로 사용되는 형식
//		(배열에 할당될 값이 정해져 있는 경우에 주로 사용)
//		-따로 배열의 크기가 정해지지는 않음
		
		// int형 1차원 배열 선언&초기화
		// - heap메모리 상에, 4byte 기억공간 생성됨
		int[] s = {80, 90, 100};
		int[] s1 = new int[] {80, 90, 100};
		System.out.println(s[0]);		// 80
		System.out.println(s[1]);		// 90
		System.out.println(s[2]);		// 100
		
		// 배열의 크기 - length속성
		System.out.println("s 배열의 크기: "+s.length);
		System.out.println("s1 배열의 크기: "+s1.length);
		
		// for문을 활용하여 배열의 값 출력
		for (int idx=0; idx <s.length; idx++) {
			System.out.print(s[idx]+"\t");
		}
		System.out.println();
		
		// double형 1차원 배열 선언&초기화
		// -double형 배열에 int형 값을 할당해도 됨
		//  (이후, int형 -> double형으로 형변환 되어 출력됨)
		double[] dd = {3.14, 10.5, 42.195, 50};
		for (int idx=0; idx<dd.length; idx++) {
			System.out.print(dd[idx]+"\t");
		}
		System.out.println(); 	// 3.14	10.5	42.195	50.0
		
		// char형 1차원 배열 선언&초기화
		char[] cc = {'j', 'a', 'v', 'a', '자', '바'};
		for (int idx=0; idx<cc.length; idx++) {
			System.out.print(cc[idx]+"\t");
		}
		System.out.println();
		
		// boolean형 1차원 배열 선언&초기화
		boolean[] bb = {true, false, true};
		for (int idx=0; idx<bb.length; idx++) {
			System.out.print(bb[idx]+"\t");
		}
		System.out.println();
		
		// String형 1차원 배열 선언&초기화
		String[] str1 = {"java", "Oracle", "Spring", "Python"};
		String[] str2 = new String[]{"java", "Oracle", "Spring", "Python"};
		for (int idx=0; idx<str1.length; idx++) {
			System.out.print(str1[idx]+"\t");
		}
		System.out.println();
		
		
	}

}
