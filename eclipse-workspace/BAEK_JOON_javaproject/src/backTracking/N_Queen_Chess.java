package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램
 * 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력
 * 
 * N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제
 * 퀸이 이동할 수 있는 위치는 상하좌우 및 대각선으로 거리 제한 없이 한 방향으로 이동이 가능
 */
public class N_Queen_Chess {

	/**
	 * 체스판 크기가 주어지면 해당 체스판 안에서 퀸이 서로 공격할 수 없도록
	 * 배치하는 경우의 수를 찾음
	 * 
	 * 퀸은 상하좌우 및 대각선으로 거리 제한 없이 한 방향으로 이동이 가능
	 * 이 이동가능한 동선과 겹치지 않는 곳에 또 다른 퀸을 배치해야 하는 것이 관건
	 * 
	 * ex) 4*4크기의 체스판이 있다고 가정
	 * 		1. 첫번 째 열에서 퀸이 놓여짐
	 * 		2. 다음 열에서 빈공간은 하나만 남음 => 그곳에 퀸 추가
	 * 		3. 그 다음 행에서 빈공간은 하나만 남음 => 그곳에 퀸 추가
	 * 		4. 마지막 행에서 남은 빈공간 하나에 퀸 추가
	 * 
	 * 		" 각 행별로 놓을 수 있는 위치에 재귀호출을 해주고,
	 * 		  만일 모두 배치되었다면 count해주면서 경우의 수 찾음"
	 * 
	 * 1. 재귀호출을 어떻게 할것인가
	 * 		- 배열을 받을 때, 1차원 배열로 받아도 됨.(index를 열, 원소값을 행이라고 생각)
	 * 		  => 첫번째 열(인덱스)부터 하나씩 재귀호출을 하며 채워나감
	 * 2. 퀸을 놓을 수 있는지 여부를 어떻게 조건문으로 판별할 것인가
	 */
	// 배열을 1차원 배열로 받음(index-열, 원소값-행)
	static int[] chessArr;
	// 입력받은 체스판의 크기
	static int N;
	// 행에 원소가 모두 배치되었는지 확인하는 변수
	static int count = 0;
	
	// 1. 1차원 배열을 토대로 재귀호출 함수(idx 인덱스는 재귀호출 함수의 깊이(얼마나 호출되었는지))
	static void nQueen(int idx) {
		
		// 행을 다 채우면 카운트를 1 증가시키고 리턴
		if(idx == N) {
			count++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			chessArr[idx] = i;
			
			// 규칙을 검사해서 해당 열(idx)에서 i번째 행에 놓을 수 있는지 검사
			if(PossibilityQueen(idx)) {
				// 해당 위치가 공격받지 않는 위치라면 다음 재귀를 호출
				nQueen(idx+1);
			}
		}
	}
	
	
	// 2. 놓을 위치가 다른 퀸으로부터 위협받는지를 검사하는 조건문
	static boolean PossibilityQueen(int col) {
		// 재귀탐색을 하게되면 기본적으로 '열'은 서로 다른 위치이니(인덱스 값은 서로 다름) 
		// 검사할 것은 다른 퀸과 동일한 '행'에 위치하는지와 대각선상에 위치하는지를 검사
		
		for (int i=0; i<col; i++) {
			// 해당 열의 행과 i열의 행이 일치할 경우(같은 행에 존재할 경우)
			if(chessArr[col] == chessArr[i]) {
				return false;
			}
			
			/*
			 * 대각선상에 놓여있는 경우
			 * (열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우다)
			 * 
			 * 1차원 배열에 각 인덱스(위치)는 '열'을 가리키고, 해당 인덱스의 값은 '행'을 의미
			 */
			else if(Math.abs(col - i) == Math.abs(chessArr[col] - chessArr[i])) {
				return false;
			}
		}
		
		// 그 외 모든조건을 만족하는 경우 true
		return true;
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("N(1 ≤ N < 15)을 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		chessArr = new int[N];
		
		// 체스판에 퀸을 배치하는 함수를 실행
		nQueen(0);		// 처음 인덱스 0을 매개변수로 전달해 실행
		
		// 결과적으로 누적된 count변수 출력
		System.out.println(count); 
	}
}
