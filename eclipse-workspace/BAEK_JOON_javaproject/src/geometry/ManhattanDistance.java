package geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 반지름 R이 주어졌을 때, 유클리드 기하학에서 원의 넓이와,
 * 택시 기하학에서 원의 넓이를 구하는 프로그램
 * D(T1,T2) = |x1-x2| + |y1-y2|
 * 
 * -단, 정답과의 오차는 0.0001까지 허용
 */
public class ManhattanDistance {
	
	/** 맨해튼 거리(택시 기하학)
	 * 거리: D(T₁, T₂) = |𝑥₁ - 𝑥₂| + |y₁ - y₂|
	 * 택시 기하학에서의 거리 = 두 점의 x 좌표의 차 + 두 점의 y 좌표의 차 
	 *
	 ** 맨해튼 거리의 원은 중심 점에서 반지름이라고 불리는 일정한 거리만큼 떨어져 있는 점들의 집합
	 *=> 택시 기하학에서의 원의 반지름D = |x|+|y| => 정사각형이 45도 기울어진 모양
	 *	택시 기하학에서의 반지름 r이 주어졌을 때, 원의 넓이 = 2 * (반지름)^2
	 */
	static void Printf_Integer(BufferedReader br) throws IOException {
		int R = Integer.parseInt(br.readLine());
		
		// 유클리드 원의 넓이
		System.out.printf("유클리드 원의 넓이: %.6f\n", R * R * Math.PI);
		
		// 택시기하학 원의 넓이
		System.out.printf("택시기하학 원의 넓이: %.6f\n", (double)2 * R * R);
	}
	
	static void DoubleParse(BufferedReader br) throws IOException {
		double R = Double.parseDouble(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		sb.append("유클리드 원의 넓이: ").append(R * R * Math.PI).append('\n');
		sb.append("택시기하학 원의 넓이: ").append(2*R*R).append('\n');
		System.out.println(sb);
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("첫째 줄에 반지름 R이 주어진다. R은 10,000보다 작거나 같은 자연수");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 방법1) Integer로 받아서, printf()사용하는 방법
//		Printf_Integer(br);
		
		// 방법2) 문자열을 Double.parseDouble로 받는 경우
		DoubleParse(br);
	}
}
