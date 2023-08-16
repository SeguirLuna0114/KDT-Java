package recursionFunction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 0보다 크거나 같은 정수 N이 주어질 때, N!을 출력하는 프로그램을 작성
 * 
 * 재귀함수
 * func 함수 안에 func 을 호출하고 그 호출 한 func 안에 func 을 참조하는 방법
 * 
 * - 재귀함수의 경우 함수를 반복적으로 호출하는 만큼 메모리에 스택이 되기 때문에 결국 메모리를 엄청나게 차지
 * - 재귀로 풀 수 있는 문제는 거의 대부분 반복문으로 대체하여 풀 수 있음
 */
public class factorial_recursion {
	
	// 방법1. 재귀함수로 구현한 팩토리얼 구하는 함수
	static int recursionfactorial(int N) {
		if (N <= 1) {
			return 1;
		}
		return N * recursionfactorial(N-1);
		/** N=6인 경우
		 * 6 * factorial(5){
			5 * factorial(4){
				4 * factorial(3){
					3 * factorial(2){
						2 * factorial(1){
							return 1;
						}
						return 2 * 1;
					}
					return 3 * 2 * 1;
				}
				return 4 * 3 * 2 * 1;
			}
			return 5 * 4 * 3 * 2 * 1;			
		}
		return 6 * 5 * 4 * 3 * 2 * 1;*/
	}
	
	
	// 방법2. 반복문을 사용하여 팩토리얼 구하는 방법
	//  재귀 구조를 그대로 반복문으로 옮겨 함수 호출이 아닌 변수 값 변경을 통해 유사재귀처럼 푸는 방법
	static void factorialWhile(int N) {
		int sum = 1;
		
		// N이 0이 아닐 때까지 1씩 감소하면서 sum에 곱해줌
//		while(N != 0) {			
//			sum *= N;
//			N--;				
//		}						
		// N이 0이 아닐 때까지 1씩 감소하면서 sum에 곱해줌
		while(N-- >0) {
			// while문에서 N이 1씩 감소되기에, 계산시 1을 더해서 곱
			sum *= N+1;
		}						
		System.out.println(sum);
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("정수 N(0 ≤ N ≤ 12)을 입력하세요.");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 방법1. 재귀함수로 구현한 팩토리얼 구하는 함수
		int factN = recursionfactorial(N);
		System.out.println(N+"!= "+factN);
		
		System.out.println();
		
		// 방법2. 반복문을 사용하여 팩토리얼 구하는 방법
		factorialWhile(N);
	}

}
