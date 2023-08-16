package p2023_07_18;

// p180

//배열(Array) - 참조형
//동일한 (한가지) 자료형의 데이터를 저장하기 위한 "정적인" 자료구조
//- 인덱스를 사용하여 개별 요소에 접근 가능

//변수 --(확장)--> 배열 --(확장)--> 자료구조(List)
//1개의 데이터만 저장 -> 여러 데이터 저장 -> 여러 자료형의 데이터 저장

//1차원 배열
//형식2) 배열에 할당될 값이 정해진 경우 주로 사용
//		(배열 선언과 동시에 초기화를 할때 주로 사용)
public class ArrayEx02_Score_SumAvg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 형식2) 배열선언과 동시에 초기화 할때 주로 사용되는 형식
//		(배열에 할당될 값이 정해져 있는 경우에 주로 사용)
//		-따로 배열의 크기가 정해지지는 않음
		
		int[] scores = {83, 90, 87};
		
		System.out.println("scores[0]: "+scores[0]);
		System.out.println("scores[1]: "+scores[1]);
		System.out.println("scores[2]: "+scores[2]);
		
		// scores 배열의 요소들의 합계
		int sum=0;
		for (int idx=0; idx<scores.length; idx++) {
			sum += scores[idx];		// sum = sum + scores[idx]
		}
		System.out.println("총점: "+sum);
		
		// 확장 for문 사용
		System.out.println("\n확장 for문 사용");
		int sum2=0;
		for (int i : scores) {
			sum2 += i;
		}
		System.out.println("총점: "+sum2);
		
		// scores 배열 요소들의 평균값
		// int형 sum과 int형 scores.length => int형으로 연산됨
		// => 따라서, sum(int형)을 double형으로 강제 형변환
		double avg = (double) sum / scores.length;	// 강제 형변환
		System.out.println("평균: " + avg);
		
		// 평균값을 소수점2째자리까지 출력
		// 포맷 지정자
		// -'%': 포맷 지정자의 시작 의미
		// -'.2': 소수점 이하 자릿수를 의미
		// -'f': 부동 소수점 숫자 표시
		System.out.printf("평균: %.2f", avg); // %.2f: 소수점 2째자리까지 출력
		// 정수 포맷 지정자:
		// -%d: 10진수로 표현된 정수
		// -%o: 8진수로 표현된 정수
		// 실수 포맷 지정자:
		// -%f: 기본적으로 소수점 이하 6자리까지 표현된 실수
		// -%.nf: 소수점 이하 n자리까지 표현된 실수 출력
		// -%e 또는 %E: 지수 형식으로 표현된 실수
		// 문자열 포맷 지정자: %s(문자열 출력)
		// 논리값 포맷 지정자: %b(논리값 (true 또는 false) 출력)
		
	}

}
