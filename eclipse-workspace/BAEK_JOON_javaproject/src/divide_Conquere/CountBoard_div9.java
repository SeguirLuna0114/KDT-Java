package divide_Conquere;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 규칙에 따라 종이를 잘랐을 때, -1로만 채워진 종이의 개수,
 * 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구해내는 프로그램
 * 
 * N×N크기의 행렬로 표현되는 종이가 있고, 종이의 각 칸에는 -1, 0, 1 중 하나가 저장되어 있다.
 * 
 * 우리는 이 행렬을 다음과 같은 규칙에 따라 적절한 크기로 자르려고 한다.
 * 1. 만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
 * 2. (1)이 아닌 경우에는 종이를 같은 크기의 종이 9개로 자르고, 
 * 	   각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
 */
public class CountBoard_div9 {
	
	/** 하나의 공간을 "9개"로 분할하여 풀어야 하는 문제
	 * => 현재 공간의 크기인 9×9 사이즈에서 가로와 세로를 3으로 나눈
	 *    3×3 사이즈 블럭으로 총 9개를 얻을 수 있다
	 *   1. 만일 같은 수(색상)으로 이루어진 경우, 이 종이를 그대로 사용
	 *   2. 같은 색상으로 이루어진 공간이 아닌경우, 
	 *   	해당 공간을 또 다시 9개로 분할
	 *   
	 *   "각 영역에 따라 색이 같은 색으로 이루어져있는지 검사를 하고, 
	 *   만약 같지 않다면 9개로 분할, 같다면 해당 색상의 카운트를 증가"
	 */
	
	static int[][] board;
	
	// 각 색상으로 채워진 종이의 개수를 입력받을 변수
	static int GRAY = 0;		// -1에 해당
	static int WHITE = 0;		// 0에 해당
	static int BLACK = 0;		// 1에 해당
	
	
	// 공간의 크기를 색이 같지 않은경우 3*3으로 나누어 분할 한 후 문제 풀이
	static void partition(int row, int col, int size) {
		
		// 만약 같은 색상으로 이루어져있다면 해당 색상 카운트를 증가시킨다.
		if(checkColor(row, col, size)) {
			
			if(board[row][col] == -1) {
				GRAY++;
			}
			
			else if(board[row][col] == 0) {
				WHITE++;
			}
			
			else if(board[row][col] == 1) {
				BLACK++;
			}
			
			return;
			// 해당 메소드 실행 중지
		}
		
		// 9개의 영역으로 나누어야 하기 떄문에 각 나눠진 파티션은 원래 크기의 1/3씩 감소
		// 같은 색상으로 이루어지지 않은 경우 크기를 3*3으로 나눔
		int newSize = size / 3;
		
		/** 9개로 분할한 공간
		 * 왼쪽 위	|	중앙 위	|	오른쪽 위
		 * ---------------------------------
		 * 왼쪽 중간	|	중앙 중간	|	오른쪽 중간
		 * ---------------------------------
		 * 왼쪽 아래	|	중앙 아래	|	오른쪽 아래
		 */
		
		partition(row, col, newSize);								// 왼쪽 위
		partition(row, col + newSize, newSize);						// 중앙 위
		partition(row, col + 2 * newSize, newSize);					// 오른쪽 위
		
		partition(row + newSize, col, newSize);						// 왼쪽 중간
		partition(row + newSize, col + newSize, newSize);			// 중앙 중간
		partition(row + newSize, col + 2 * newSize, newSize);		// 오른쪽 중간
		
		partition(row + 2 * newSize, col, newSize);					// 왼쪽 아래
		partition(row + 2 * newSize, col + newSize, newSize);		// 중앙 아래
		partition(row + 2 * newSize, col + 2 * newSize, newSize);	// 오른쪽 아래
	}
	
	
	// 해당 영역(종이)이 같은 색(숫자)로 이루어졌는지 확인하는 메소드
	static boolean checkColor(int row, int col, int size) {
		
		// 기준점(포인터)를 맨 왼쪽 x, y 위치로 잡음
		int target = board[row][col];
		
		// 공간의 크기 x+size, y+size 동안 
		for(int i=row; i< row+size; i++) {
			for (int j=col; j<col+size; j++) {
				
				// 기준점과 색이 다른 경우 false
				if(target != board[i][j]) {
					return false;
				}
			}
		}
		
		// 해당 공간이 모든 색이 기준점과 같은 경우 true리턴
		return true;
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 N(1 ≤ N ≤ 37, N은 3k 꼴)을, \n"
				+ "다음 N개의 줄에는 N개의 정수로 행렬을 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// N개의 줄에는 N개의 정수로 입력된 행렬를 저장할 배열 생성
		board = new int[N][N];
		
		// 입력받은 정수를 배열에 저장
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 각 영역에 따라 색이 같은 색으로 이루어져있는지 검사를 하고, 
		//  만약 같지 않다면 9개로 분할, 같다면 해당 색상의 카운트를 증가하는 메소드 실행
		partition(0, 0, N);
		
		// 각 색상으로 채워진 종이의 개수 출력
		StringBuilder sb = new StringBuilder();
		sb.append(GRAY).append('\n').append(WHITE).append('\n').append(BLACK);
		System.out.println(sb);
	}
}
