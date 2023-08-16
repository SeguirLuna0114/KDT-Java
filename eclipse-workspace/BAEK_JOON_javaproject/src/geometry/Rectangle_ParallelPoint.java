package geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 
 * 필요한 네 번째 점을 찾는 프로그램
 * 
 * XOR(^) 비트 연산자
 * : 두 비트가 서로 다를 때 1을 반환하고, 같을 때 0을 반환
 * =>  주어진 세 개의 숫자 중에서 쌍을 이루는 숫자가 아닌
 * 	   나머지 하나의 숫자를 찾는 문제와 같은 경우에 유용하게 활용
 */
public class Rectangle_ParallelPoint {
	
	/**
	 * 3개의 좌표가 주어질 때, 나머지 하나 좌표를 찾기 위해서는 
	 * x 가 쌍을 이루지 않는 좌표가 나머지 좌표의 x좌표가 되고, 
	 * y좌표 또한 쌍을 이루지 않는 y좌표가 나머지 좌표의 y가 될 것
	 * => 쌍을 이루지 않는 각각의 좌표만 찾기
	 */
	static class Coodinate {
		int x;
		int y;
		
		private Coodinate(BufferedReader br) throws IOException {
			StringTokenizer st = new StringTokenizer(br.readLine());
			this.x = Integer.parseInt(st.nextToken());
			this.y = Integer.parseInt(st.nextToken());
		}
	}
	
	static void checkPoint(Coodinate coord1, Coodinate coord2, Coodinate coord3) {
		
		int x = 0;
		int y = 0;
		
		/** x좌표 비교
		 * x좌표 비교 후, 쌍을 이루지 않는 x좌표를 저장
		 */
		// 1번 x좌표와 2번 x좌표 비교
//		if(coord1.x == coord2.x) {
//			x = coord3.x;
//		}
//		// 1번 x좌표와 3번 x좌표 비교
//		else if(coord1.x == coord3.x) {
//			x = coord2.x;
//		}
//		// 2번 x좌표와 3번 x좌표 비교
//		else if(coord2.x == coord3.x) {
//			x = coord1.x;
//		}
		
		/**
		 * XOR(^) 비트 연산자를 활용
		 * 같은 값이면 0을, 다른 값이면 1을 반환
		 * 
		 * -  XOR 연산하여 쌍을 이루는 x 좌표 값을 제거한 비트 패턴을 생성
		 * -> ^ coord3.x를 추가하여, 생성한 비트 패턴과 coord3.x의 각 비트를 XOR 연산 => 나머지 하나의 x 좌표 값을 생성
		 */
		x = coord1.x ^ coord2.x ^ coord3.x;
		
		/** y좌표 비교
		 * y좌표 비교 후, 쌍을 이루지 않는 y좌표를 저장
		 */
//		// 1번 y좌표와 2번 y좌표 비교
//		if(coord1.y == coord2.y) {
//			y = coord3.y;
//		}
//		// 1번 y좌표와 3번 y좌표 비교
//		else if(coord1.y == coord3.y) {
//			y = coord2.y;
//		}
//		// 2번 y좌표와 3번 y좌표 비교
//		else if(coord2.y == coord3.y) {
//			y = coord1.y;
//		}
		
		/**
		 * XOR(^) 비트 연산자를 활용
		 * 같은 값이면 0을, 다른 값이면 1을 반환
		 */
		y = coord1.y ^ coord2.y ^ coord3.y;
		
		// 좌표 출력
		System.out.println(x +" "+ y);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("세 점의 좌표를 한 줄에 하나씩 입력하시오.\n"
				+ " 좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 첫번째 좌표
		Coodinate coord1 = new Coodinate(br);
		// 두번째 좌표
		Coodinate coord2 = new Coodinate(br);
		// 세번째 좌표
		Coodinate coord3 = new Coodinate(br);
		
		// 메소드를 사용하여 나머지 좌표 출력
		checkPoint(coord1, coord2, coord3);
	}
}
