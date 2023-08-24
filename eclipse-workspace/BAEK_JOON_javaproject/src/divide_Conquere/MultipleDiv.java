package divide_Conquere;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 자연수 A를 B번 곱한 수를 알고 싶다. 
 * 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램
 * 
 * A, B, C는 모두 2,147,483,647 이하의 자연수
 */
public class MultipleDiv {
	
	/** 지수법칙
	 *	a^(n+m) = a^n * a^m
	 *
	 ** 모듈러 성질
	 *  (a X b) mod C = ( a mod C X b mod C ) mod C
	 *  (a * b) % X = (a % C  *  b % C) % C
	 */
	
	/**
	 * A, B, C는 각각 최대 2,147,483,647을 갖을 수 있다는 것이고,
	 * 2,147,483,647번 거듭제곱 하는 것 부터 많은 수행 과정과, C로 모듈러 연산까지 해주어야 하기 떄문에 
	 * "시간초과"가 날 것
	 * 
	 * => 분할정복을 이용해 시간 단축
	 * A가 밑(base)이고, B가 지수(exponent)고 C는 결과값에 나눌 값
	 * 
	 * * A^B 지수법칙을 이용
	 * 	=> 지수를 반으로 나누어서 계산
	 * 		지수가 짝수인 경우 => a^(n+n) = a^n * a^n
	 * 		지수가 홀수인 경우 => a^(n+n+1) = a^n * a^n * a
	 * 		"지수를 절반으로 나누기에, 각 레벨에서 나뉜 지수를 모두 탐색할 필요X. 한번만 구함"
	 * 
	 * * % C는 모듈러 연산을 활용
	 *  => A, B, C는 모두 2,147,483,647 이하의 자연수 이기에, 
	 *      2,147,483,647 (231-1)을 입력받을 수 있다
	 *      단, long형의 경우 9,223,372,036,854,775,807 (263-1) 이고 대략 9*1018 정도 된다
	 *      
	 *      예로들어 temp가 2,147,483,647 , A도 2,147,483,647 이라면 
	 *      temp * temp * A 는 (231-1) * (231-1) * (231-1) ≒ 294 로 딱 보더라도 long 형 범위를 넘어간다
	 *      
	 *      따라서, 모듈러 합동 공식을 활용해, 나머지를 계산해줘야 함
	 *      (temp * temp * A) % C = ((temp * temp % C) * (A % C)) % C
	 *      					  = (((temp * temp % C) % C) * (A % C)) % C
	 *      					  = ((temp * temp % C) *A) % C
	 */ 
	static long C;
	
	// A^exponent: A = 밑, exponent = 지수
	// 단, 모듈러 연산을 활용하여 반환되는 값의 %C를 돌려줌
	static long pow(long A, long exponent) {
		
		// 지수가 1일 경우, A^1=A이기에, A 리턴
		if(exponent == 1) {
			return A % C;
		}
		
		// 지수법칙 적용 => 지수의 절반에 해당하는 A^(exponent/2)을 구함
		long temp = pow(A, exponent /2);
		
		/* 현재 지수가 홀수 였다면
		 * A^(exponent / 2) * A^(exponent / 2) * A 이므로
		 * A를 한 번 더 곱해주어야 한다.
		 * 
		 * ex) A^9 = A^4 * A^4 * A
		 */
		if(exponent % 2 == 1) {
			return ((temp * temp % C) * A) % C;
		}
		
		// 현재 지수가 짝수인 경우에는 지수의 절반값을 한번 더 곱해서 반환
		return temp * temp % C;
	}
	


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 입력하세요."+
		"\n(단, A, B, C는 모두 2,147,483,647 이하의 자연수)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// A, B, C는 모두 2,147,483,647 이하의 자연수
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		System.out.println(pow(A, B));
	}
}
