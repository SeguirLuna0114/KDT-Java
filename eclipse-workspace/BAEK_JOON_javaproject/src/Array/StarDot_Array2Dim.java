package Array;

// 입력받은 크기N에 따라 별(*)과 공백을 이루어진 패턴 출력
import java.util.Scanner;

// ex) N=3일때, 2차원 배열에서, 공백은 StarArray[1][1]
//		=> (0,0), (0,1), (0,2), (1,0)까지는 별 출력
//		=>	별 출력이 4번 이루어지면, 그 다음 블럭은 반드시 공백
public class StarDot_Array2Dim {
	
	// 재귀 함수 - Makestar
	// 입력받은 크기와 위치에 따라 별과 공백을 배열에 저장
	static void Makestar(char[][] StarArray, int x, int y, int N, boolean blank) {
		// 매개변수 - 2차원 문자배열, 시작좌표(x,y), 블록의 크기N, blank
		// 공백칸
		if (blank) {	//blank가 true인 경우, 블록 영역을 공백으로 채움
			// 시작위치 (x, y) 부터
			for (int row=x; row<x+N; row++) {	// x~x+N-1까지 행
				for (int col=y; col<y+N; col++) {	// y~y+N-1까지 열
					StarArray[row][col] = ' ';
				}	// 블록을 공백으로 채움
			}
			return;
		}
		
		// 더이상 쪼갤 수 없는 블록
		if (N==1) {		// N이 1이라면, 현재 블록 가운데에 별을 찍음
			StarArray[x][y] ='*';
			return;
		}
		
		// 공백도 N=1도 아닌경우, 현재 블록을 9개의 동일한 크기의 작은 블록으로 나눔
		// size=해당 블록의 한 칸을 담을 변수(가장 작은 블록의 크기)
		int size = N/3;
		int count=0;	// 현재 위치가 몇 번째 블록인지 추적
		for (int i=x; i<x+N; i+=size) {
			for (int j=y; j<y+N; j+=size) {
				count++;
				// 5번째 블록은 공백으로 처리
				if (count==5) {	 // 공백 칸일 경우
					Makestar(StarArray, i, j, size, true);
				} else {		 // 공백이 아닐 경우 Makestar메소드 호출
					Makestar(StarArray, i, j, size, false);
				}
			}
		}
		
	}//end Makestar()

	// 별을 출력하는데, block의 가운데는 비우면서 출력
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("숫자를 입력해주세요");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		char[][] StarArray = new char[N][N];
		
		// MakeStar()메소드 호출
		Makestar(StarArray, 0, 0, N, false);	// 초기값
		
		// '*'출력
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				System.out.print(StarArray[i][j]);
			}
			System.out.println();
		}
		
	}
}
