package divide_Conquere;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 입력으로 주어진 종이의 한 변의 길이 N과 각 정사각형칸의 색(하얀색 또는 파란색)이 주어질 때
 * 잘라진 하얀색 색종이와 파란색 색종이의 개수를 구하는 프로그램
 * 
 * 여러개의 정사각형칸들로 이루어진 정사각형 모양의 종이가 주어져 있고, 
 * 각 정사각형들은 하얀색으로 칠해져 있거나 파란색으로 칠해져 있다. 
 * 주어진 종이를 일정한 규칙에 따라 잘라서 다양한 크기를 가진
 *  정사각형 모양의 하얀색 또는 파란색 색종이를 만들려고 한다
 *  
 *  전체 종이의 크기가 N×N(N=2k, k는 1 이상 7 이하의 자연수) 이라면 종이를 자르는 규칙
 *  1. 전체 종이가 모두 같은 색으로 칠해져 있지 않으면 
 *  	가로와 세로로 중간 부분을 잘라서 똑같은 크기의 네 개의 N/2 × N/2색종이로 나눈다.
 *  2. 나누어진 종이에 대해서도 앞에서와 마찬가지로 
 *  	모두 같은 색으로 칠해져 있지 않으면 같은 방법으로 
 *  	똑같은 크기의 네 개의 색종이로 나눈다. 
 *  3. 이와 같은 과정을 잘라진 종이가 모두 하얀색 또는 모두 파란색으로 칠해져 있거나, 
 *  	하나의 정사각형 칸이 되어 더 이상 자를 수 없을 때까지 반복한다
 */
public class CountBoard_div4 {
	
	/** 분할정복 과정
	 * 1. 현재 상태의 문제를 풀 수 없는 경우, 문제를 분할 할 수 있는지 확인
	 * 2. 문제를 분할하여 각각 풀이(풀이할 수 없는 경우, 1번 과정으로 감)
	 * 3. 풀린 문제들을 합침
	 */
	 
	/** 부분 색종이 문제 - 잘라진 하얀색 색종이와 파란색 색종이의 개수
	 * - 부분 색종이는 모두 같은 색상이어야 한다
	 * - 만약 모두 같은 색상이 아닐 경우 색종이를 잘라야 한다.
	 * - 색종이를 자를 때는 1/2 씩, 즉 절반씩 잘라서 정사각형을 얻어야 한다.
	 * 
	 * 1. 각각의 행과 열의 시작점(초기는 (0, 0)이 기준)에서 
	 * 		현재 파티션에 대하여 모두 같은 색상인지 체크를 먼저 해야한다.
	 * 2. 색상이 같다면 해당 색상의 개수를 1 증가시키고 함수를 종료한다.
	 * 3. 색상이 같지 않다면, 4등분 하여 각 부분 문제로 쪼개어 문제를 푼다.
	 */
	// 색종이
	static int[][] board;
	
	// 색상 카운트 할 변수
	static int white = 0;
	static int blue = 0;

	// 잘라진 하얀색 색종이와 파란색 색종이의 개수를 구하는 메소드
	static void partition(int row, int col, int size) {
		
		/*
		 * 만약 현재 파티션(부분)이 모두 같은 색상이라면
		 * 현재 색상을 1 증가시키고 함수 종료
		 */
		if(colorCheck(row, col, size)) {
			// 숫자 0은 white
			if(board[row][col] == 0) {
				white++;
			}
			// 숫자 1은 blue
			else {
				blue++;
			}
			return;
			// 해당 메소드 끝냄
		}
		
		// 현재 파티션의 컬러가 같지 않은 경우
		// 절반 사이즈
		int newSize = size / 2;
		
		// 재귀호출
		partition(row, col, newSize);						// 2사분면
		partition(row, col + newSize, newSize);				// 1사분면
		partition(row + newSize, col, newSize);				// 3사분면
		partition(row + newSize, col + newSize, newSize);	// 4사분면
	}
	
	
	// 현재 파티션의 컬러가 같은지 체크
	static boolean colorCheck(int row, int col, int size) {
		
		// 첫번째 원소를 기준으로 검사
		int color = board[row][col];
		
		for(int i=row; i<row+size; i++) {
			for(int j=col; j<col+size; j++) {
				
				// 색상이 같지 않다면 false return
				if(board[i][j] != color) {
					return false;
				}
			}
		}
		
		// 검사가 모두 통과하였다면, true리턴
		return true;
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("첫째 줄에는 전체 종이의 한 변의 길이 N(N은 2, 4, 8, 16, 32, 64, 128 중 하나)을\n"
				+ "색종이의 각 가로줄의 정사각형칸들의 색을 윗줄부터 차례로 둘째 줄부터 마지막 줄까지 입력하세요.\n"
				+ "(하얀색으로 칠해진 칸은 0, 파란색으로 칠해진 칸은 1로 주어지며, 각 숫자 사이에는 빈칸이 하나씩 있다)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 전체 종이의 한 변의 길이 N(N은 2, 4, 8, 16, 32, 64, 128 중 하나)
		int N = Integer.parseInt(br.readLine());
		
		// 색종이에 칠해진 색
		board = new int[N][N];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 함수 실행
		partition(0, 0, N);
		
		StringBuilder sb = new StringBuilder();
		sb.append(white).append('\n').append(blue);
		System.out.println(sb);
	}
}
