package easy;

/** 입력값이 3의 제곱근인지 여부를 가리는 문제
 * Given an integer n, return true if it is a power of three.
 * Otherwise, return false
 * 
 * An integer n is a power of three,
 * if there exists an integer x such that n == 3^x
 * 
 * ex) n = 27 => true
 */
public class P326_Power_of_Three {
	
	/* 3의 제곱근 판별
	 * - 모든 3의 제곱근은 3으로 계속 나누면 결국은 3이 되고 이 3은 3으로 나누면 1이 됨
	 * 	1. 계속 나누면 마지막에 1이 되는 숫자
	 * 	2. 0이나 음수가 아닌 수 
	 */
//	방법1) 3으로 나누었을 때, 마지막 값이 1인 경우
	static boolean isPowerOfThree(int n) {
		
		// 0이 입력되면 false를 반환
		if (n<1) {
			return false;
		}
		
		// 3으로 나누어 지는 경우
		while(n%3 == 0) {
			n /= 3;		// 계속 3으로 나눔
		}
		// 그 결과가 1이면 true, 아니면 false를 리턴
		return n==1;
	}
	
	
//	방법2) 수열의 합인 시그마와 Regular expression을 사용
	/** Base Conversion
	 * all powers of 10 start with the digit 1 and then are followed only by 0.
	 * ex) in base 2,  10_2 => 2_10
	 * 				   100_2 => 4_10
	 * 				   1000_2 => 8_10
	 * - 문자열이 "10" 또는 "1"과 0 개 이상의 "0"으로 구성되어야 함
	 * -  3진수로 표현한 숫자가 3의 거듭제곱일 때만 참
	 */
	static boolean isPowerOfThree_BaseConversion(int n) {
		/* n이 3의 거듭제곱인지 여부를 확인
		 * 1. 입력된 정수 n을 3진수 문자열로 변환
		 * 	  Integer.toString(n, 3)
		 * 2. matches(String regex) 메서드를 호출하여 3진수 문자열이 정규 표현식 ^10*$와 일치하는지 확인
		 * 		- ^: 문자열의 시작을 나타내는 메타 문자
		 * 		- 1: 3진수에서 3의 거듭제곱을 나타내는 숫자 1을 의미
		 * 		- 0*: 0이 하나 이상 나타날 수 있는 패턴
		 * 		- $: 문자열의 끝을 나타내는 메타 문자
		 */
		return Integer.toString(n, 3).matches("^10*$");
	}
	
	
//	방법3. 수학의 제곱근을 나타내는식인 로그를 사용한 방법
	static boolean isPowerOfThree_Mathematics(int n) {
		/** n = 3^i
		 * => i = log_3(n) = logb(n) / logb(3)
		 * 
		 * n is a power of three if and only if i is an integer.
		 * if a number is an integer by taking the decimal part(using %1) and checking if it is 0.
		 */
		return (Math.log10(n) / Math.log10(3)) %1 == 0;
	}
	
	
//	방법4. java에서 int형의 최대값을 사용하여 3의 제곱근인지 판별
	static boolean isPowerOfThree_IntegerLimit(int n) {
		/** Integer Limitations
		 * - An important piece of information can be deduced from the function signature.
		 * - In particular, n is type of int. It means it is a 4byte. the maximum value of int type is 2147483647.
		 * => knowing the limitation of n, we can know the max val of n that is also a power of three
		 * 	  3^[log3(MaxInt)] = 3^[19.56] = 3^19 = 1162261467
		 * 	  Since 3 is a prime number, the only divisor of 3^19 are 3^0, 3^1, ... 3^19
		 * 		Therefore all we need to do is divide 3^19 by n.
		 * 		A remainder of 0 means n is a divisor of 3^19 
		 */
		return n >0  && Math.pow(3, (int)(Math.log10(Integer.MAX_VALUE) / Math.log10(3))) % n == 0;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 27;
		
//		방법1) 3으로 나누었을 때, 마지막 값이 1인 경우
		System.out.println(isPowerOfThree(n));
		
//		방법2) 수열의 합인 시그마와 Regular expression을 사용
		System.out.println(isPowerOfThree_BaseConversion(n));
		
//		방법3. 수학의 제곱근을 나타내는 식인 로그를 사용한 방법
		System.out.println(isPowerOfThree_Mathematics(n));
		
//		방법4. java에서 int형의 최대값을 사용하여 3의 제곱근인지 판별
		System.out.println(isPowerOfThree_IntegerLimit(n));
	}
}
