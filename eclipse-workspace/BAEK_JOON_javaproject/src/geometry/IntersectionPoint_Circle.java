package geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 반지름이 𝑟₁ 인 A 와 반지름이 𝑟₂ 인 B 의 접점의 개수 구하는 프로그램
 * 
 * 조규현의 좌표 (x_1, y_1)와 백승환의 좌표 (x_2, y_2)가 주어지고,
 * 조규현이 계산한 류재명과의 거리 r_1과 백승환이 계산한 류재명과의 거리 r_2가 주어졌을 때,
 * 류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램
 * 
 * - 좌표의 수가 무한대인 경우에는 -1을 출력
 */
public class IntersectionPoint_Circle {

	/**
	 * 반지름이 𝑟₁ 인 A 와 반지름이 𝑟₂ 인 B 의 접점의 개수 1. 두 원의 중심이 같고, 반지름도 같을 때 ( 접점의 개수가 무한할
	 * 때) 2. 접점이 없을 때 -1) 두 점 사이의 거리가 각 원의 반지름의 합보다 클 때 -2) 한 원 안에 다른 원이 있으면서 접점이 없을
	 * 때 3. 접점이 한개일 경우 -1) 내접 -2) 외접 4. 그 외의 경우에는 교점이 2개
	 */
	static int InsertionPoint(int x1, int y1, int r1, int x2, int y2, int r2) {

		// 중심점 간의 거리 distance의 제곱
		int distance_pow = (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

		// case1: 중심점이 같고, 반지름도 같은 경우
		if (x1 == x2 && y1 == y2 && r1  == r2) {
			return -1;
		}

		// case2-1: 두 원의 반지름 합보다 중점간 거리가 더 길 때
		else if (distance_pow > Math.pow(r1 + r2, 2)) {
			return 0;
		}

		// case 2-2: 원 안에 다른 원이 있으면서 접점이 없을 때
		else if (distance_pow < Math.pow(r2 - r1, 2)) {
			return 0;
		}

		// case 3-1: 내접할 때
		else if (distance_pow == Math.pow(r2 - r1, 2)) {
			return 1;
		}

		// case 3-2: 외접할 때
		else if (distance_pow == Math.pow(r2 + r1, 2)) {
			return 1;
		}

		else {
			return 2;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("첫째 줄에 테스트 케이스의 개수 T\n" + "둘째줄부터 한 줄에 공백으로 여섯 정수 x_1, y_1, r_1, x_2, y_2, r_2 입력하세요.");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int x_1, y_1, r_1, x_2, y_2, r_2;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			x_1 = Integer.parseInt(st.nextToken());
			y_1 = Integer.parseInt(st.nextToken());
			r_1 = Integer.parseInt(st.nextToken());
			x_2 = Integer.parseInt(st.nextToken());
			y_2 = Integer.parseInt(st.nextToken());
			r_2 = Integer.parseInt(st.nextToken());
			sb.append(InsertionPoint(x_1, y_1, r_1, x_2, y_2, r_2)).append('\n');
		}
		System.out.println(sb);
	}
}
