package Method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Principal;

// 2보다 큰 짝수n이 주어졌을 때, n의 골드바흐 파티션을 출력하는 프로그램
// 만약 가능한 n의 골드바흐 파티션이 여러가지인 경우, 두 소수의 차이가 가장 작은 것을 출력

// 골드바흐의 추측(Goldbach's conjecture)
// : 모든 짝수 정수는 두 개의 소수(prime number)의 합으로 표현할 수 있다는 수론적인 추측
// 	 (2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다 => 이러한 수를 골드바흐의 수)
// 골드바흐 파티션 : 2보다 큰 모든 짝수를 두 소수의 합으로 나타낸 것
//	(10000보다 작거나 같은 모든 짝수n에 대한 골드바흐 파티션은 존재)
// 	ex) 8=3+5 10=5+5 12=5+7
public class Prime_GoldbachsConjecture {
	
	// 소수 판별 알고리즘 - 에라토스테네스의 체 
	static boolean[] checkPrime(int N) {
		
		// 주어진 n의 범위가 (4 <= n <= 10,000) 이기에, 배열의 크기를 10000+1로 설정
		boolean[] PrimeFalse = new boolean[10001];
		
		// 0과 1은 소수가 아님
		PrimeFalse[0] = PrimeFalse[1] = true;
		
		for (int i=2; i<=Math.sqrt(PrimeFalse.length); i++) {
			if (PrimeFalse[i]) {
				continue;
			}
			// i배수 값들을 반복문 돌림
			for (int j=i*i; j < PrimeFalse.length; j+=i) {
				// i배수 값들은 소수가 아니기에, true값으로 업데이트
				PrimeFalse[j] = true;
			}
		}
		return PrimeFalse;
	}

	// 2보다 큰 짝수n이 주어졌을 때, n의 골드바흐 파티션을 출력하는 프로그램
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("테스트 케이스의 개수와 2보다 큰 짝수n을 입력하세요.(4 <= n <= 10,000)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		boolean[] PrimeFalse;
		
		// 아래의 for문 대신 while문 작성 가능
//		for (int i=1; i<=T;i++) {
//			int n = Integer.parseInt(br.readLine());
//		}
		// while(T-- > 0) :T 변수의 값을 1씩 감소시키면서 T가 0보다 큰 동안 반복
		while(T-- > 0) {
			
			int n = Integer.parseInt(br.readLine());
			
			// checkPrime(int N)메소드 호출
			PrimeFalse = checkPrime(n);
			
			// 짝수 n에 대하여 두 소수 구하기
			//ex) 짝수 14에 대하여 두 소수의 합이 14인 소수는 3+11, 7+7이 있어도 소수의 차가 적은 7+7출력
			// => 짝수 n을 절반을 나누어서 소수인지 검사 -> 만일 소수가 아니라면 +1 -1을 진행하며 소수일때까지 찾음
			int first_partition = n/2;
			int second_partition = n/2;
			
			while (true) {
				// 두 파티션이 모두 소수일 경우
				if(!PrimeFalse[first_partition] && !PrimeFalse[second_partition]) {
					sb.append(first_partition).append(' ').append(second_partition).append('\n');
					break;	// 반복문의 실행을 중지하고 반복문 바로 뒤의 코드로 이동
				}
				
				// 두 파티션이 모두 소수가 아닌경우
				first_partition--;
				second_partition++;
			}
		}
		System.out.println(sb);
	}

}
