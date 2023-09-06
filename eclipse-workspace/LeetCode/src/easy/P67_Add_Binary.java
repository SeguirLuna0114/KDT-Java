package easy;

import java.math.BigInteger;

/** Add Binary
 * 두개의 string타입의 입력값은 이진수이고, 그 두 값을 이진수로 더한 값을 return
 * -Given two binary string a and b, return their sum as a binary String.
 * ex) Input : a="11", b="1" => output: "100"
 * ex) Input : a="1010", b="1011" => output: "10101"
 */
public class P67_Add_Binary {
	
	/* o Integer.parseInt(String s, int radix)
	 *  : String s는 숫자로만 구성되고, radix는 그 숫자가 몇진수인지를 나타내는 값
	 * 
	 * o Integer.toBinaryString(int num)
	 *  : 숫자 10진수를 입력받아서, 그것을 2진수로 바꿔서 String타입으로 반환
	 * 
	 * 방법1) 자릿수가 많은 입력값은 NumberFormatException이 발생
	 *  1. 이진수 String값을 받아서, 10진수로 변환한 다음 더한다
	 * 		Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
	 *  2. 10진수 값을 다시 2진수로 바꾸고 이를 String으로 반환
	 * 	 	return Integer.toBinaryString(); 
	 * 
	 * 방법2) bit 별로 계산(비트 단위에서 계산)
	 * 		- 1 + 1 = 1 0
	 * 		- 1 + 0 = 1
	 * 		- 0 + 0 = 0
	 * 
	 * 방법3) XOR로 처리한 후 carry하는 방법
	 * 	- while carry is nonzero : y != 0;
	 * 		- carry is XOR of x and y : answer = x^y
	 * 		- carry is left-shifted AND of x and y : carry = (x & y) << 1	
	 * 		- x = answer, y = carry
	 *  - return x in the binary form. 
	 */
//	방법2) 재귀함수 사용 - bit 별로 계산(비트 단위에서 계산)
	static String addBinary(String a, String b) {
		
		int a_len = a.length();
		int b_len = b.length();
		
		// 길이가 더 긴 방향을 기준으로 addBinary()메소드 실행
		if(a_len < b_len) {
			return addBinary(b, a);
		}
		
		// a와 b중 긴 길이값을 L변수에 할당
		int L = Math.max(a_len, b_len);
		
		// return할 String을 담아둘 클래스
		StringBuilder sb = new StringBuilder();
		
		// 범위 설정(입력 받은 두 값 중 자릿수가 큰 입력값의 크기 만큼 for 문을 돌림)
		int carry = 0;
		int j = b_len -1;
		for(int i = L-1; i>=0; i--) {
			// 이진수 계산법을 하는 로직 작성
			if(a.charAt(i) == '1') {
				++carry;
			}
			if(j > -1 && b.charAt(j--) == '1') {
				++carry;
			}
			
			if(carry % 2 == 1) {
				sb.append('1');
			} else {
				sb.append('0');
			}
			
			carry /= 2;
		}
		
		if(carry == 1) {
			sb.append('1');
		}
		
		sb.reverse();
		
		return sb.toString();
	}
	
	
//	방법3) XOR로 처리한 후 carry하는 방법
	static String addBinary2(String a, String b) {
		/** BigInteger 클래스
		 * :임의 정밀도로 정수를 다룰 수 있는 클래스로, 
		 *  이진 문자열을 정수로 변환하기 위해 사용
		 *  
		 * - BigInteger xor(BigInteger val) 메소드
		 * 	: BigInteger 객체와 다른 BigInteger 객체를 
		 *    XOR(배타적 논리합) 연산하여 새로운 BigInteger 객체를 반환
		 *   - XOR 연산은 비트 단위로 작동하며, 
		 *     두 비트가 서로 다를 때 결과가 1이 되고, 두 비트가 같으면 결과가 0
		 *     
		 * - BigInteger and(BigInteger val)메소드
		 *  : 현재 BigInteger 객체와 다른 BigInteger 객체를 
		 *    비트 단위로 AND(논리곱) 연산하여 새로운 BigInteger 객체를 반환하는 메소드
		 *   - AND 연산은 두 비트가 모두 1일 때 결과가 1이 되고, 그 외의 경우에는 결과가 0
		 */
		// 문자열을 2진수로 변환
		BigInteger x = new BigInteger(a, 2);
		BigInteger y = new BigInteger(b, 2);
		
		// 0을 나타내는 이진 문자열 "0"으로 초기화
		BigInteger zero = new BigInteger("0", 2);	// 이진수 0
		
		BigInteger carry, answer;
		
		// while 루프를 사용하여 두 이진수를 더함
		while(y.compareTo(zero) != 0) {
			
			// x와 y를 XOR(배타적 논리합) 연산 => 두 이진수를 더한 비트들 나타냄
			answer = x.xor(y);
			// x와 y의 AND(논리곱) 연산 + 그 결과를 왼쪽으로 1 비트 시프트(이동)
			// => 더해진 비트 중에서 자리 올림을 처리
			carry = x.and(y).shiftLeft(1);
			
			// x는 더한 결과를 나타냄
			x = answer;
			// y는 이전 자리 올림을 나타냄
			y = carry;
		}
		
		/* y가 0이 되면 루프가 종료되고, 최종 결과는 x에 저장됨
		 *  이 값을 이진 문자열로 변환하여 반환
		 * => String toString(int radix)메소드 사용하여 2진수로 변환
		 */
		return x.toString(2);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = "1010";
		String b = "1011";
		
//		방법2) 재귀함수 사용 - bit 별로 계산(비트 단위에서 계산)
		System.out.println(addBinary(a, b));
		
//		방법3) XOR로 처리한 후 carry하는 방법
		System.out.println(addBinary2(a, b));
	}
}
