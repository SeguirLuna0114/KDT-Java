package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 게임 시작 전 스도쿠 판에 쓰여 있는 숫자들의 정보가 주어질 때 모든 빈 칸이 채워진 최종 모습을 출력하는 프로그램
 * 
 * 모든 빈 칸이 채워진 스도쿠 판의 최종 모습을 아홉 줄에 걸쳐 한 줄에 9개씩 한 칸씩 띄워서 출력
 * 
 * 게임 시작 전 일부 칸에는 1부터 9까지의 숫자 중 하나가 쓰여 있다
 * 나머지 빈 칸을 채우는 방식
 * 1. 각각의 가로줄과 세로줄에는 1부터 9까지의 숫자가 한 번씩만 나타나야 한다
 * 2. 굵은 선으로 구분되어 있는 3x3 정사각형 안에도 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
 */
public class Sudoku {

	/** 재귀호출부와 조건 검사 함수로 구성
	 * - int[][] 배열을 사용 할 것인데, 첫 번째 인덱스는 행을, 두 번째 인덱스는 열을 의미
	 * 
	 * - 해당 칸과 같은 행과 열 또한 숫자가 겹치지 않아야 한다 => 어떤 값이 해당 칸에 들어갈 수 있는지 여부를 판별
	 * 
	 * 3가지 조건을 모두 통과해야 해당 value 값이 해당 칸에 수가 될수 있음
	 * 1. 같은 행에 있는 열 원소 중에 겹치는 수가 있는지를 검사
	 * 2. 같은 열에 있는 행 원소 중에 겹치는 수가 있는지를 검사
	 * 3. 해당 위치에 속한 3×3 칸에 중복되는 수가 있는지를 검사
	 * 
	 * 재귀 호출하면서 모든 값이 다 채워지게 된다면 배열을 출력한 뒤 시스템을 종료
	 * 	- 시스템을 종료하는 방법은 System.exit(0) 를 사용
	 */
	// 스도쿠 9*9 배열
	static int[][] SudokuArr = new int[9][9];
	
	// 스도쿠 규칙을 만족하는지 확인
	static void CheckSudoku(int row, int col) {
		
		// 해당 행이 col 1~9까지 다 채워졌을 경우 다음 행의 첫 번째 열부터 시작
		if(col == 9) {
			CheckSudoku(row+1, 0);
			return;
		}
		
		// 행과 열이 모두 채워졌을 경우 출력 후 종료
		StringBuilder sb = new StringBuilder();
		if (row == 9) {
			
			for(int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					sb.append(SudokuArr[i][j]).append(' ');
				}
				sb.append('\n');	// 줄바꿈 -> 다음 행 출력
			}
			
			// 출력 후 시스템 종료
			System.out.println(sb);
			System.exit(0);
		}
		
		// 만일, 해당 위치의 값이 0이라면 1~9까지 중 가능한 수 탐색
		if(SudokuArr[row][col] == 0) {
			// 1부터 9까지의 가능한 숫자를 넣어보면서 유효한 조합을 찾음
			for(int i=1; i<=9; i++) {
				
				// i값이 중복되지 않는지 검사
				if(possibility(row, col, i)) {
					
					// 중복되지 않는다면, 해당 위치에 i 값을 넣음
					SudokuArr[row][col] = i;
					// 재귀 호출을 통해 다음 열로 이동
					CheckSudoku(row, col+1);
				}
			}
			
			// 다시 해당 위치를 0으로 초기화하고 이전 상태로 되돌림 => 다른 숫자로 시도 가능해짐
			SudokuArr[row][col] = 0;
			return;
		}
		
		// 해당 위치의 값이 이미 채워진 경우, 재귀호출을 통해 다음 열로 이동
		CheckSudoku(row, col+1);
	}
	
	
	// 3가지 조건을 모두 통과해야 해당 value 값이 해당 칸에 수가 될수 있음
	static boolean possibility(int row, int col, int value) {
		
		// 조건1. 같은 행에 있는 원소들 중 겹치는 열 원소가 있는지 검사
		for (int i=0; i<9; i++) {
			if(SudokuArr[row][i] == value) {
				return false;
			}
		}
		
		// 조건2. 같은 열에 있는 원소들 중 겹치는 행 원소가 있는지 검사
		for (int i=0; i<9; i++) {
			if(SudokuArr[i][col] == value) {
				return false;
			}
		}
		
		// 조건3. 3*3 칸 내부에서 중복되는 원소가 있는지 검사
		// value가 속한 3*3의 행의 첫 위치
		int set_row = (row / 3) * 3;
		// value가 속한 3*3d의 열의 첫 위치
		int set_col = (col / 3) * 3;
		
		for (int i=set_row; i<set_row+3; i++) {
			for (int j=set_col; j<set_col; j++) {
				if(SudokuArr[i][j] == value) {
					return false;
				}
			}
		}
		
		// 위 3가지 조건에 해당하지 않는 경우는 
		// 중복되는 것이 없다는 것이기에, true 반환 => value값 될 수 있음
		return true;
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("아홉 줄에 걸쳐 한 줄에 9개씩 게임 시작 전 스도쿠판 각 줄에 쓰여 있는 숫자를 한 칸씩 띄워서 차례로 입력하세요.\n"
				+ "(스도쿠 판의 빈 칸의 경우에는 0이 주어진다)");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력받은 9*9 스도쿠 판의 숫자를 배열에 입력
		for(int i=0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<9; j++) {
				SudokuArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 스도쿠 규칙을 만족하는지 확인
		// 인덱스 0,0부터 메소드를 시작 -> 재귀 함수이기에 반복되어 값을 계산
		CheckSudoku(0, 0);
	}
}
