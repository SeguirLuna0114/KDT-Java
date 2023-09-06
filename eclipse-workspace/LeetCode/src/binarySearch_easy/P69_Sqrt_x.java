package binarySearch_easy;

/** Sqrt(x) not use pow(x, 0.5) or x ** 0.5
 * 입력받은 숫자의 제곱근을 구하는 문제
 * 정수값만 리턴
 * 
 * -Given a non-negative integer x, compute and return the sqaure root of x.
 * -Since the return type is an integer, the decimal digits are truncated
 * and only the integer part of the result is returned.
 * 
 * ex) Input : x = 8 => output : 2(decimal part is truncated)
 */
public class P69_Sqrt_x {
	
	/* 방법1) Math.pow(x, y) & Math.log()메소드를 사용해서 제곱근을 구하는 방법
	 * 	- Math의 자연상수/오일러 상수 E를 활용
	 * x의 제곱근을 n이라고 한다면, n^2 = x
	 * 양변에 log값을 취하면
	 * 2log(n) = log(x) => log(n) = 0.5 * log(x)
	 * 따라서, n = E^(0.5 * log(x))
	 */
	static int mySqrt(int x) {
		
		//  0과 1의 제곱근은 각각 0과 1
		if(x < 2) {
			return x;
		}
		
		/** 수학적인 계산을 통한 제곱근 추정
		 *  Math.pow()메소드 & Math.log()활용
		 * - double pow(double a, double b)메소드 : a의 b제곱을 double형으로 반환
		 * - double log(double a) 메소드 : x의 자연 로그(밑이 e, 자연 상수)를 계산
		 */
//		int left = (int)Math.pow(Math.E, 0.5*Math.log(x));
		int left = (int)Math.pow(10, 0.5*Math.log10(x));
		int right = left + 1;
		
		// right를 제곱한 값과 x를 비교해서, right * right가 x보다 크다면 left를 반환
		return (long)right * right  > x ? left : right;
		// 결과가 int범위를 초과할 수 있기에, long타입으로 개스팅하여 사용
	}
	
	
	/* 방법2) Binary Search(이분탐색)을 사용
	 * if x < 2, return x
	 * set the left boundary to 2, and the right boundary to x/2
	 * while left <= right:
	 * 	take mid = (left + right)/2;
	 *  and compute num*num and compare it with x
	 *  - if num*num > x, move the right boundary right = mid-1
	 *  - else if num*num < x, move the right boundary left = mid+1
	 *  - otherwise num*num == x, the integer square root is here => return it
	 *  return right;
	 */
	static int BinarySearch_sqrt(int x) {
		
		//  0과 1의 제곱근은 각각 0과 1
		if(x < 2) {
			return x;
		}
		
		// 탐색 범위 설정
		int left = 2;	// 숫자 2부터 제곱근을 탐색
		int right = x/2;	
		while(left <= right) {
			
			// 중간 값 설정
			int mid = left + (right - left)/2;
			
			// 중간값의 제곱 값을 담을 변수 설정
			long num = (long)mid * mid;
			
			// 제곱값이 x보다 큰 경우에는, 탐색범위를 [left : mid-1]로 조정
			if(num > x) {
				right = mid -1;
			}
			// 제곱값이 x보다 작은 경우에는, 탐색범위를 [mid+1 : right]로 조정
			else if(num < x) {
				left = mid + 1;
			}
			// 제곱값과 x가 같은 경우에는 리턴
			else {
				return mid;
			}
		}
		return right;
	}
	
	
	/* 방법3) 재귀함수(Recursion)와 Bit Shift를 활용하여 구하는 방법
	 * sqrt(x) = 2 * sqrt(x/4)
	 * * Bit Shift : left and right shifts
	 * 	- x << y that means x * 2^y
	 *  - x >> y that means x / (2^y)
	 *  => sqrt(x) = sqrt(x >> 2) << 1
	 *  			(cus x/4 = x/(2^2) => x >> 2)
	 *  			(cus 2 * sqrt(x/4) => sqrt(x/4) * 2^1 => sqrt(x/4) << 1)
	 */
	static int BitShiftSqrt(int x) {
		
		//  0과 1의 제곱근은 각각 0과 1
		if(x < 2) {
			return x;
		}
		
		// sqrt(x) = sqrt(x >> 2) << 1 을 구현
		// sqrt(x >> 2) << 1 값은 제곱근일 가능성이 있는 정수
		int left = BitShiftSqrt(x >> 2) << 1;
		// BitShiftSqrt(x >> 2) << 1로 인해 구해진 정수가 소수점자리가 제거되었기에, +1큰 수도 제곱근일 가능성이 있음
		int right = left + 1;
		
		// 만일 right의 제곱이 x보다 크다면, right는 제곱근이 아니기에, left반환
		return (long)right*right > x ? left : right;
	}
	
	
	/* 방법4) 뉴턴 메소드(Newton's Method)를 사용하여 주어진 정수 x의 제곱근을 근사적으로 계산
	 *  : 함수의 근사치를 계산하는 수치해석적인 방법 
	 * - mathematical proofs
	 * 	x_(k+1) = 0.5 * [x_k + (x/x_k)]
	 *  converges to sqrt(x) if x0 = x.
	 *  
	 *  1. 제곱근을 구하고자 하는 값 x를 뉴턴 메소드의 시작점x_k(또는 x0)로 설정
	 *  	뉴턴 메소드 시작점x0 = x로 초기값 설정
	 *  	뉴턴 메소드의 시작점을 사용해 첫번째 반복공식을 사용한 첫번째 근사값을 x1으로 설정
	 *  2. 뉴턴 메소드의 반복공식을 사용하여 제곱근에 근사한 값을 계산
	 *  	x0와 x1의 차이가 1 이상 나는 동안 반복하여 결과의 정확도 조절
	 *  3. 반복공식을 사용해 갱신한 x_k = x_(k+1)과 x_(k+1) = 0.5 * [x_k + (x/x_k)]을 통해
	 *     계산된 x0의 값이 수렴할 때까지 반복 => 근사된 제곱근 값 x_k를 얻음
	 */
	static int UseNewtonMeth(int x) {
		
		//  0과 1의 제곱근은 각각 0과 1
		if(x < 2) {
			return x;
		}
		
		// 초기 추정치 설정
		// 뉴턴 메소드의 시작점 x0를 x로 설정
		double x0 = x;
		// x1은 초기 추정치 x0과 x / x0의 평균값으로 설정
		double x1 = (x0 + x/x0) / 2.0;
		
		// x0와 x1의 차이가 1보다 큰 동안 반복(결과의 정확도 조절을 위함)
		while(Math.abs(x0 - x1) >= 1) {
			// x0를 x1으로 업데이트
			x0 = x1;
			// x1을 (x0 + x / x0) / 2.0를 사용하여 새로운 값으로 업데이트
			x1 = (x0 + x/x0) / 2.0;
			// 반복이 진행될 때마다 x1은 x의 제곱근에 대한 근사값으로 수렴
		}
		
		// 근사된 제곱근인 x1을 int로 캐스팅하여 반환
		return (int)x1;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x = 8;
		
//		방법1) Math.pow(x, y) & Math.log()메소드를 사용해서 제곱근을 구하는 방법
		System.out.println(mySqrt(x));
		
//		방법2) Binary Search(이분탐색)을 사용
		System.out.println(BinarySearch_sqrt(x)); 

//		방법3) 재귀함수(Recursion)와 Bit Shift를 활용하여 구하는 방법
		System.out.println(BitShiftSqrt(x));
		
//		방법4) 뉴턴 메소드(Newton's Method)를 사용하여 주어진 정수 x의 제곱근을 근사적으로 계산
		System.out.println(UseNewtonMeth(x));
	}
}
