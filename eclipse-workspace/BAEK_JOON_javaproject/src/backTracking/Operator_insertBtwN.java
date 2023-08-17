package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 연산자를 숫자 사이에 끼워넣어서 얻을 수 있는 최댓값과 최솟값을 찾는 문제
 * 
 * 수와 수 사이에 끼워넣을 수 있는 N-1개의 연산자가 주어진다. 
 * 연산자는 덧셈(+), 뺄셈(-), 곱셈(×), 나눗셈(÷)으로만 이루어짐
 * 
 * 첫째 줄에 만들 수 있는 식의 결과의 최댓값을, 둘째 줄에는 최솟값을 출력
 * 연산자를 어떻게 끼워넣어도 항상 -10억보다 크거나 같고, 10억보다 작거나 같은 결과가 나오는 입력만 주어짐
 */
public class Operator_insertBtwN {
	
	// 수의 개수 N
	static int N;
	// 입력받은 숫자
	static int[] number;
	// 연산자
	static int[] operator;
	
	// 식의 결과 최대값 및 최소값
	static int Max = Integer.MIN_VALUE;
	static int Min = Integer.MAX_VALUE;
	
	
	// 연산자를 숫자 사이에 끼워넣어서 얻을 수 있는 최댓값과 최솟값을 찾는 메소드
	static void CheckOper(int num, int idx) {
		
		/**
		 * 	num: 현재까지 계산된 결과값
		 *  idx: 현재 숫자/연산자를 가리키는 인덱스(재귀호출 시작 깊이)
		 *  
		 *  idx(인덱스이자 깊이를 의미)가 N이랑 같아지면
		 *  모든 연산자를 사용했다는 의미이므로, 
		 *  해당 값이 최댓값인지, 최솟값인지를 보고 해당 값을 교체
		 */
		// idx가 숫자 배열의 크기N에 도달 = 모든 연산자 사용
		if(idx == N) {
			Max = Math.max(Max, num);
			Min = Math.min(Min, num);
			return;
		}
		
		// 아직 연산자를 사용할 수 있는 경우
		for(int i=0; i<4; i++) {
			// 해당 연산자 개수가 1개 이상인 경우
			if(operator[i] > 0) {
				
				// 해당 연산자 값(개수)를 1 감소시킴(해당 연산자 사용함을 표시)
				operator[i]--;
				
				// 인덱스번호i가 0(+), 1(-), 2(*), 3(/)
				switch(i) {
					case 0: 
						CheckOper(num + number[idx], idx+1);
						break;
					case 1: 
						CheckOper(num - number[idx], idx+1);
						break;
					case 2: 
						CheckOper(num * number[idx], idx+1);
						break;
					case 3: 
						CheckOper(num / number[idx], idx+1);
						break;
				}
				
				// 재귀호출이 종료되면, 다시 사용하지 않았던 상태로 해당 연산자 개수를 복구
				// (모든 가능한 연산 조합을 정확하게 시도)
				operator[i]++;
			}
		}
	}
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 수의 개수 N(2 ≤ N ≤ 11)를 입력하고,\n"
				+ "둘째 줄에는 A1, A2, ..., AN(1 ≤ Ai ≤ 100)과 \n"
				+ "셋째 줄에는 합이 N-1인 4개의 정수(덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수)를 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 수의 개수 N
		N = Integer.parseInt(br.readLine());
		
		// 둘째줄에 입력받은 값
		number = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		// 셋째줄에 입력받은 연산자의 개수
		operator = new int [4];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		for (int i=0; i<4; i++) {
			operator[i] = Integer.parseInt(st2.nextToken());
		}
		
		// 연산자를 사용하는 메소드 사용
		// 처음에 첫 번째 숫자부터 시작하기 때문에 number[0]을 초기 값으로 사용
		// 연산자 사용 깊이는 1로 설정(함수 처음 호출)
		CheckOper(number[0], 1);
		
		// 최대값 및 최소값 출력
		StringBuilder sb = new StringBuilder();
		sb.append(Max).append('\n');
		sb.append(Min).append('\n');
		System.out.println(sb);
	}
}
