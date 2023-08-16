package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*	자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램
 * 어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미
 * 어떤 자연수 M의 분해합이 N인 경우, M은 N의 생성자
 * ex) 245의 분해합 = 256(245+2+4+5)
 * 
 * 	- 생성자가 없는 경우, 0을 출력
 */
public class Decomposition_Sum {
	
	static StringBuilder sb;
	
	/*	방법1) 1 부터 입력받은 N 까지 한 개씩 모두 대입(가장 기본적인 브루트포스 방식)
	 * - 탐색 도중 생성자를 찾으면 종료하고 해당 생성자를 출력
	 * - N 을 넘길 때 까지 생성자를 찾지 못하면 0을 출력
	 */
	static void BasicSearchMethod(int N) {
		sb = new StringBuilder();
		// 각 자리수의 합 변수
		for (int i=0; i<N; i++) {
			int sum = i;
			
			int target = i;
			// 반복문을 사용해서 각 자리수 더하기
			while(target != 0) {
				// target숫자의 일의자리 수를 sum에 더함
				sum += target % 10;
				
				// 다음 자리 수를 더하기 위해 10으로 나눠줌(일의자리 수 버림)
				target /= 10;
			}
			
			// 만일 i의 값과 각 자리수 누적합이 같을 경우(생성자 찾은 경우)
			if(sum == N) {
				// i는 생성자
				sb.append(i).append('\n');
				System.out.println(sb);
				break;
			}
		}
	}
	
	/*	방법2) N - (9 × K의 길이) 부터 탐색하여 N 까지만 탐색
	 * - 어떤 임의의 수 N이 들어올 때, 해당 수 N 은 K + K의 각 자릿수 합
	 * - 네자릿수 N 의 각 자릿수의 합이 최대일 경우 => 9 + 9 + 9 + 9
	 * 		=> 즉, 입력받은 정수 N 에 대하여 자릿수의 길이만큼 9를 빼주면
	 * 		   그 미만의 수는 생성자가 될 수 없음
	 */
	static void SearchRange9(int N) {
		sb = new StringBuilder();
		// 입력받은 값 N의 자리수
		int N_length = Integer.toString(N).length();
		
		// i는 가능한 최솟값인 N-(9*N)의 각 자리수부터 시작
		for(int i=(N-(N_length * 9)); i<N; i++) {
			// 각 자리수 합 변수
			int sum = i;
			
			int targetN = i;
			// 반복문으로 각 자리수 더함
			while(targetN != 0) {
				// 일의자리 수 더함
				sum += targetN % 10;
				
				// 다음 자리수를 더하기 위해 10으로 나눠서 일의자리 버림
				targetN /= 10;
			}
			
			// 만일 i의 값과 각 자리수 누적합이 같을 경우(생성자 찾은 경우)
			if(sum == N) {
				// i는 생성자
				sb.append(i).append('\n');
				System.out.println(sb);
				break;
			}
		}
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("자연수 N(1 ≤ N ≤ 1,000,000)을 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 방법1. 가장 기본적인 브루트포스 방법 사용
		BasicSearchMethod(N);
		
		// 방법2. N - (9 × K의 길이) 부터 탐색하여 N 까지만 탐색
		SearchRange9(N);
	}
}
