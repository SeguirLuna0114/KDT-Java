package p2023_07_14;

// while문 (반복문)
// -조건식은 True/False 값을 가져야 함
//	while(조건식){	// 조건식에 따라 반복여부 결정. 
//	  반복 실행할 문장;
//	}
public class While02_sumEvenOdd {

	// while문을 이용해서 1~100까지 홀수, 짝수의 합을 구하는 프로그램
	// while문 1개 & if-else문 1개
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 변수선언 및 초기화
		int count=1, odd=0, even=0;
		
		while (count<=100) {	// count가 100일때까지 반복
			if (count%2==0) {
				even += count;	// 짝수
			} else {
				odd += count;	// 홀수
			}
			count+=1;	// count는 1씩 증가
		}
		System.out.println("1~100까지 홀수의 합: " + odd);
		System.out.println("1~100까지 짝수의 합: " + even);
		
	}

}
