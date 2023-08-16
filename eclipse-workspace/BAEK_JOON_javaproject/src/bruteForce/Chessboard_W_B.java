package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * M N개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 잘라서 8*8크기 체스판
 * (N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수)
 * 다시 칠해야 하는 정사각형의 개수의 최솟값을 출력하는 프로그램
 * 
 * 체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 
 * 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 함
 * 
 * 따라서 체스판을 색칠하는 경우는 두 가지뿐
 * 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우
 */
public class Chessboard_W_B {

	// 최소로 칠하는 정사각형의 개수
	static int min = 64;	// 초기값은 64(최대값)으로 설정 => 이후 변경되게
	
	/*
	 * 어떤 크기로 주어지던, 최소로 칠할 수 있는 8*8크기를 찾아내야 함
	 * - 한 칸이 좌우의 색과 다르면 됨
	 * - 체스판이 잘못 칠해진 경우, '최소'의 개수로 칠할 수 있는 부분을 찾아야 함
	 * 
	 ** 최소 크기가 8*8일때, 경우의 수가 1이기에,
	 * =>나올 수 있는 경우의수는 (M-7)*(N-7) 이다.
	 ** 또한, 첫 칸이 검은색일 경우와 하얀색일 경우 변경되어야 하는 색들의 개수도 비교해야 함
	 * => 경우의수 = 2 * (M-7)*(N-7)
	 */
	static void FindRepaintSquare(int x, int y, boolean[][] checkWhite) {
	
		// 다시 칠해야 하는 칸의 수
		int count=0;
		
		// 첫번째 칸의 색
		boolean first = checkWhite[x][y];
		
		// 입력받은 x=N-7, y=M-7이기 때문에 가로(N), 세로(M)길이까지 확인
		for(int i=x; i<= x+7; i++) {
			for(int j=y; j<=y+7; j++) {
				
				// 첫번째 칸의 색과 다른경우(올바른 색이 아닌경우) count 1증가
				if(checkWhite[i][j] != first) {
					// 칠해야 하는 색의 수 증가
					count++;
				}
				
				/* * 다음 칸은 색이 바뀌므로
				 * true라면 false로, false 라면 true 로 값을 변경
				 */
				first = (!first);
			}
			/* * 다음 줄도 색이 바뀌므로
			 * true라면 false로, false 라면 true 로 값을 변경
			 */
			first = (!first);
		}
		
		/* *  첫 번째 칸을 기준으로 할 때의 색칠 할 개수(count)와
		 *  첫 번째 칸의 색의 반대되는 색을 기준으로 할 때의
		 *  색칠 할 개수(64 - count) 중 최솟값을 count 에 저장 
		 */
		count = Math.min(count, 64-count);
		
		/*
		 * 이전까지의 경우 중 최솟값보다 현재 count 값이
		 * 더 작을 경우 최솟값을 갱신 
		 */
		min = Math.min(min, count);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 N과 M을 입력하세요.\n"
				+ "둘째줄부터 N개의 줄에는 보드의 각 행의 상태를 입력하세요(B검은색, W흰색)"); 
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 첫째줄에 입력된 N과 M
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// W와 B을 구분하기 위해 boolean 2차원 배열을 사용
		// => w일때 true, B일때 false로 표현
		boolean[][] checkWhite = new boolean[N][M];
		
		// W, B 구분위한 배열 입력
		for (int i=0; i<N; i++) {
			// 입력받은 한 행을 문자열로 받음 -> 한글자(char)씩 확인
			String checkWB = br.readLine();
			
			for (int j=0; j<M; j++) {
				if(checkWB.charAt(j) == 'W') {
					checkWhite[i][j] = true;	// W일때는 true
				} else {
					checkWhite[i][j] = false;	// B일때는 false
				}
			}
		}
		
		// 경우의 수 확인
		int N_row = N-7;
		int M_col = M-7;
		
		for (int i=0; i<N_row; i++) {
			for (int j=0; j<M_col; j++) {
				// 메소드 사용
				FindRepaintSquare(i, j, checkWhite);
			}
		}
		
		// 탐색이 끝난 후 갱신된 최솟값을 출력
		System.out.println(min);
	}

}
