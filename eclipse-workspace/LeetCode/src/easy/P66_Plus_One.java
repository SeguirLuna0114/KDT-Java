package easy;

/** 한자리 숫자들로 이루어진 배열을 입력받아서 처리
 *  그 숫자들로 구성된 한 숫자에 1을 더하는 프로그램
 *  - The digits are ordered from most significant to least significant in left to right order.
 *  - The large integer does not contain any leading 0's.
 *  ex) digits = [4, 3, 2, 1]
 *  	=> output = [4, 3, 2, 2]
 *  ex) digits = [9]
 *  	=> output = [1, 0]
 */
public class P66_Plus_One {
	
	/* 배열의 마지막 숫자가 9가 아니라면, 단순히 마지막 숫자에 1을 더하면 됨
	 * 그러나, 마지막 숫자가 9인 경우에는 좀 더 다르게 접근해야 함
	 * 
	 *  1. 맨 마지막 숫자가 9가 아닌 경우 : 마지막 숫자에 1을 더함
	 *  	digits[digits.length - 1] ++;
	 *  2. 마지막 숫자가 9인 경우
	 *  	2-1. 이전의 숫자 중 9가 아닌 숫자가 있는 경우
	 *  		: 9를 0으로 바꾸고, 9가 아닌 숫자에 1을 더함
	 *  	2-2. 모든 숫자가 9인 경우
	 *  		: 모든 숫자를 0으로 바꾸고 맨 앞에 1을 하나 붙임
	 *  		(즉, 배열의 크기가 하나 더 큰 새로운 배열을 만들어야 함)
	 */
	static int[] PlusOne(int[] digits) {
		
		// 1. 맨 마지막 숫자가 9인 경우
		if(digits[digits.length -1] == 9) {
			
			// 1-1) 배열의 숫자가 모두 9인지 확인
			boolean allNine = true;
			for(int num : digits) {
				if(num != 9) {
					allNine = false;
					break;
				}
			}
			
			// 만일 모두 9인 경우, 모든 숫자를 0으로 바꾸고 맨 앞에 1을 하나 붙임
			if(allNine) {
				// 배열의 크기가 하나 더 큰 새로운 배열을 만듦
				int[] newDigits = new int[digits.length+1];
				
				// 맨 앞의 숫자는 1, 그 외는 0으로 설정
				newDigits[0] = 1;
				for(int i=1; i< newDigits.length; i++) {
					newDigits[i] = 0;
				}
				return newDigits;
			}
			
			// 1-2) 이전의 숫자 중 9가 아닌 숫자가 있는 경우
			else {
				/* 9를 0으로 바꾸고, 9가 아닌 숫자에 1을 더함
				 * 이때 뒤에서부터 9가 아닌 수를 찾아서 +1
				 */
				for(int i=digits.length-1; i>=0; i--) {
					// 9가 아닌 숫자에 1을 더함
					if(digits[i] != 9) {
						digits[i]++;		// digits[j] = digits[j] + 1; 
						break;	// 반복문 벗어남
					}
					// 9인 경우 0으로 변경
					digits[i]=0;
				}
			}
		}
		
		// 2. 맨 마지막 숫자가 9가 아닌 경우: 마지막 숫자에 1을 더함
		else {
			digits[digits.length-1]++;
		}
		
		// 배열을 반환
		return digits;
	}
	
	
//	방법2) 좀더 간단하게 리팩토링한 방법
	static int[] PlusOne2(int[] digits) {
		
		// 끝에서부터 int배열을 탐색
		for(int idx = digits.length-1; idx>=0; idx--) {
			
			// 1. 해당 숫자가 9인 경우, 9를 0으로 변경
			if(digits[idx] == 9) {
				digits[idx] = 0;
			}
			
			// 2. 해당 숫자가 9가 아닌 숫자에 대해서
			else {
				/** 맨 마지막 숫자가 9가 아닌 경우,
				 * 맨 마지막 숫자에 1을 더한 후 해당 배열을 반환
				 */
				// 끝에서부터 탐색했을 때, 9가 아닌 숫자를 1 더해줌
				digits[idx]++;
				// 변경한 배열을 반환
				return digits;
			}
		}
		
		// 3. 모든 숫자가 9인 경우
		digits = new int[digits.length+1];
		// 첫번째 값을 1로,  나머지는 0으로 변경
		digits[0] = 1;
		return digits;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] digits = new int[] {9, 9, 9};
		
//		방법1) 마지막 숫자가 9인지 아닌지 확인
		int[] digits1 = PlusOne(digits);
		System.out.print("[");
		for(int i=0; i<digits1.length; i++) {
			System.out.print(digits1[i]+", ");
		}
		System.out.print("]\n");
		
//		방법2) 좀더 간단하게 리팩토링한 방법
		int[] digits2 = PlusOne2(digits);
		System.out.print("[");
		for(int i=0; i<digits2.length; i++) {
			System.out.print(digits2[i]+", ");
		}
		System.out.print("]\n");

	}
}
