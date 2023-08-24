package divide_Conquere;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* N ×N 크기의 영상이 주어질 때, 이 영상을 압축한 결과를 출력하는 프로그램
 * 
 * 흑백 영상을 압축하여 표현하는 데이터 구조로 쿼드 트리(Quad Tree)라는 방법
 * 흰 점을 나타내는 0과 검은 점을 나타내는 1로만 이루어진 영상(2차원 배열)에서
 * 같은 숫자의 점들이 한 곳에 많이 몰려있으면, 쿼드 트리에서는 이를 압축하여 간단히 표현 가능
 * 
 * - 주어진 영상이 모두 0으로만 되어 있으면 압축 결과는 "0"이 되고,
 * 	 모두 1로만 되어 있으면 압축 결과는 "1"이 된다.
 * - 만약 0과 1이 섞여 있으면 전체를 한 번에 나타내지를 못하고, 
 * 	 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래, 이렇게 4개의 영상으로 나누어 압축하게 되며,
 * 	 이 4개의 영역을 압축한 결과를 차례대로 괄호 안에 묶어서 표현
 */
public class QuadTree {
	
	/** 이진트리(Binary Tree)
	 * : 자식노드를 2개 갖는 트리
	 * 
	 ** 쿼드트리(Quad Tree)
	 * : 자식노드가 4개인 트리 자료구조
	 * - 2차원 공간을 재귀적으로 4개의 영역으로 분할하여 데이터를 세분화 하는 방법으로 많이 사용됨
	 * - 각 레벨(깊이)에서 현재의 평면을 4개로 쪼개고 각 쪼개어진 4개의 영역에 대해 유사성을 검증하여 
	 * 	 하나의 영역으로 묶는다거나 등 필요한 과정을 처리할 수도 있고, 
	 * 	 또는 쪼개어진 영역을 또 4개의 영역으로 쪼개어 재귀호출을 더 할 수도 있는 것
	 * 
	 ** 옥트리(OcTree)
	 * : 3차원 공간을 분할하고 싶을 경우에는 8개의 영역으로 나누면 된다
	 */
	
	/** 쿼드 트리 적용 알고리즘
	 * "공간을 분할시켜 각 영역에 대해 처리하고자 하는 알고리즘을 적용시키는 방법"
	 * 
	 * 규칙
	 * 1. 압축하기 위해서는 부분 영역이 모두 같은 색상이어야 함
	 * 		- 하얀색(0)으로 이루어져 있거나, 검은색(1)로 이루러진 단일 색상 영역
	 * 2. 같은 색이 아닐경우, 공간을 쿼드트리 방식으로 "4분할"
	 * 		- 왼쪽 위 → 오른쪽 위 → 왼쪽 아래 → 오른쪽 아래 순서대로 진행됨
	 */
	// 입력받은 흑(1)백(0) 이미지
	static int[][] img;
	
	static StringBuilder sb = new StringBuilder();
	
	// 쿼드 트리 적용 알고리즘
	static void QuadTree(int x, int y, int size) {
		
		// 압축이 가능할 경우, 하나의 색상으로 압축
		if(colorPossible(x, y, size)) {
			sb.append(img[x][y]);
			return;		// 해당 반복문 종료
		}
		
		// 압축이 불가능할 경우, 사이즈를 절반으로 나눔
		int newSize = size / 2;
		
		// 각 레벨(depth)에서 여는 괄호로 시작
		sb.append('(');
		
		QuadTree(x, y, newSize);		// 왼쪽 위(2사분면)
		QuadTree(x, y+newSize, newSize);	// 오른쪽 위(1사분면)
		QuadTree(x+newSize, y, newSize); 	// 왼쪽 아래(3사분면)
		QuadTree(x+newSize, y+newSize, newSize);	// 오른쪽 아래(4사분면)
		
		// 해당 레벨이 끝나면 닫는 괄호도 닫아줌
		sb.append(')');
	}
	
	// 부분 영역이 같은 색상으로 이루어졌는지 확인
	// => 압축이 가능한지 해당 공간을 체크해주는 함수
	static boolean colorPossible(int x, int y, int size) {
		
		// 기준점(포인터)을 입력받은 x, y위치로 설정(가장 왼쪽 위 위치)
		int value = img[x][y];
		
		//  x + size, y + size가 현재 공간의 크기
		for(int i=x; i < x+size; i++) {
			for(int j=y; j < y+size; j++) {
				
				// 초기값과 색이 일치하지 않는 경우 false 리턴
				if(value != img[i][j]) {
					return false;
				}
			}
		}
		
		// 초기 값과 색이 일치하는 경우에는 true 리턴
		return true;
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에는 영상의 크기를 나타내는 숫자 N(N 은 언제나 2의 제곱수로 주어지며, 1 ≤ N ≤ 64)을 입력하고,\n"
				+ "두 번째 줄부터는 영상의 각 점들을 나타내는 0과 1로 이루어진 길이 N의 문자열을 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 영상의 크기를 나타내는 숫자 N(N 은 언제나 2의 제곱수로 주어지며, 1 ≤ N ≤ 64)
		int N = Integer.parseInt(br.readLine());
		
		// 입력받은 이미지를 저장하기 위한 2차원 배열 생성
		img = new int [N][N];
		
		// 영상의 각 점을 0과 1로 나타냄
		for (int i=0; i<N; i++) {
			String str = br.readLine();
			for (int j=0; j<N; j++) {
				// String.charAt()메소드로 한글자만 char형태로 받아오고, - '0'으로 숫자 변환
				img[i][j] = str.charAt(j) - '0';
			}
		}
		
		// 공간을 분할시켜 각 영역에 대해 처리하고자 하는 알고리즘을 적용
		QuadTree(0, 0, N);
		
		// 결과 출력
		System.out.println(sb);
	}
}
