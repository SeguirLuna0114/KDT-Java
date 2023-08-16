package geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 각 입력에 대해 직각 삼각형이 맞다면 "right", 아니라면 "wrong"을 출력
 * 
 * 입력은 여러개의 테스트케이스로 주어지며 마지막줄에는 0 0 0이 입력
 * 각 테스트케이스는 모두 30,000보다 작은 양의 정수로 주어지며, 
 * 각 입력은 변의 길이를 의미
 */
public class RightAngled_Triangle {

	/** 기본적인 알고리즘:𝑎² = 𝘣² + 𝘤² 을 만족하는지만 체크
	 * 직각삼각형 조건을 구할 때 어느 변이 대각선인지는 알 수 없음
	 * 그러므로 3개의 조건 중 맞는 경우를 테스트해야 함
	 */
	static void checkTriangle(int x, int y, int z) {
		
		if((x * x + y * y) == z * z) {
			System.out.println("right");
		}
    	else if(x * x == (y * y + z * z)) {
			System.out.println("right");
		}
    	else if(y * y == (z * z + x * x)) {
			System.out.println("right");
		}
    	else {
			System.out.println("wrong");
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("삼각형의 세변을 입력하세요.(입력종료: 0 0 0)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 0 0 0 입력 전까지 반복
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			// 0 0 0 입력시 종료
			if(x == 0 && y == 0 && z == 0) break;
			System.out.println();
			
			// checkTriangle()메소드 사용하여 확인
			checkTriangle(x, y, z);
		}
	}
}