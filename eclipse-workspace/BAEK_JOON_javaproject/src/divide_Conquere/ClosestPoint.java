package divide_Conquere;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * 2차원 평면상에 n개의 점이 주어졌을 때, 
 * 이 점들 중 가장 가까운 두 점의 거리의 제곱을 출력하는 프로그램
 * 
 * <문제풀이>
 * 1. 분할 정복 방식
 * 2. 스윕 라인 방식
 */
public class ClosestPoint {
	
	/** 방법1. 분할 정복 방식
	 * 1. x좌표와 y좌표를 표현하기 위한 Point라는 클래스 생성
	 * 2. 두 개의 Point에 대해 거리를 반환하는 함수
	 * 	 - 두 점의 거리의 제곱을 출력하라고 했기 때문에, 각 x좌표와 y좌표의 차의 제곱을 더해준 값만 사용
	 * 
	 * **3. 분할정복 - 구간 내의 가운데 점을 기준으로 왼쪽과 오른쪽으로 나누어서 풀이
	 * 		단, 주의점이 존재
	 * 		1) 입력으로 주어지는 좌표는 정렬되어있는 좌표X => Arrays.sort메소드 comparator
	 * 		2) 분할 정복을 할 때, 원소가 1개만 남을 경우 거리를 탐색하지 못함
	 * 			- 3에 대해서 분할정복을 하게 되면 1개만 남는 경우가 발생
	 * 			  => 분할 된 구간의 점의 개수가 3이하라면 맨 처음 필자가 설명한 brute force 방식을 적용
	 * 		3) 분할한 구간 내의 두 점에 대한 최솟값이 전체에 대한 최솟값이라고 보장할 수는 없음
	 * 
	 *  1. 일단 분할정복을 통해 왼쪽 혹은 오른쪽에서 얻어진 거리 중 최솟값(dist)을 알아야한다.
	 *  2. 그 다음 분할 된 위치인 mid를 기준으로 dist 내에 있는 원소들을 추출하여 후보군으로 만든다.
	 *  3. 후보 원소들을 y축에 대해 정렬한다.
	 *  4. y값이 낮은 원소부터 차례대로 거리를 측정하되, y + dist 범위 내에 있는 점들만 거리를 측정한다.
	 *  5. 얻어진 거리가 기존 최소거리보다 작다면 dist를 갱신
	 */
	static class Point {
		// 좌표 클래스
		int x;
		int y;
		
		public Point(int x, int y) {
			
			this.x = x;
			this.y = y;
		}
	}
	
	// 객체 배열
	static Point[] p;
	
	// 두 점의 거리를 반환하는 메소드(x^2 + y^2)
	static int dist(Point o1, Point o2) {
		return (int)(Math.pow(o1.x - o2.x, 2) + Math.pow(o1.y - o2.y, 2));
//		return (o1.x - o2.x) * (o1.x - o2.x) + (o1.y - o2.y) * (o1.y - o2.y);
	}
	
	// X좌표를 기준으로 오름차순 정렬하는 comparator 익명 객체
	static Comparator<Point> Xcomp = new Comparator<Point>() {
		@Override
		public int compare(Point o1, Point o2) {
			// TODO Auto-generated method stub
			return o1.x - o2.x;
		}
	};
	
	
	// 브루트포스 방식 - 분할된 구간의 점의 개수가 3 이하라면 브루트포스 방식 적용
	static int brute(int start, int end) {
		
		int minDist = Integer.MAX_VALUE;
		
		for(int i=start; i<end; i++) {
			for(int j=i+1; j<=end; j++) {
				minDist = Math.min(minDist, dist(p[i], p[j]));
			}
		}
		return minDist;
	}
	
	// 분할정복을 할 중심 메소드
	static int closest(int start, int end) {
		
		// p[start] ~ p[end]원소가 3개 이하라면, 브루트포스 방식 사용 => 거리 반환
		if(end - start +1 < 4) {
			return brute(start, end);
		}
		
		// 그 외에는 분할정복 방식 사용
		int mid = start + (end-start)/2;
		
		// left는 [start:mid] , right는 [mid+1:start]로 분할하여 탐색
		int left = closest(start, mid);
		int right = closest(mid+1, end);
		
		// 각 각의 거리 중 최솟값을 구한 후, 반환
		int minDist = Math.min(left, right);
		return minDist;
	}
	
	// Y좌표를 오름차순으로 정렬하는 Comparator 익명객체
	static Comparator<Point> Ycomp = new Comparator<Point>() {
		@Override
		public int compare(Point o1, Point o2) {
			return o1.y - o2.y;
		}
	};
	
	// 중간 Band 영역에서의 최소 거리를 구하는 함수
	static int middleBand(int start, int mid, int end, int minDist) {
		
		int xDist;
		
		// index참조가 많기 때문에 ArrayList활용
		ArrayList<Point> list = new ArrayList<Point>();
		
		// 후보군 추출
		int midX = p[mid].x;	// mid인덱스의 x좌표
		for(int i=start; i <= end; i++) {
			// x좌표 차이
			xDist = p[i].x -midX;
			
			/*
			 * midDist는 제곱값이므로, x좌표거리고 제곱으로 계산해준다.
			 * xDist^2 < midDst 라면 후보군으로 리스트에 넣는다.
			 */
			if(xDist * xDist < minDist) {
				list.add(p[i]);
			}
		}
		
		// 후보군들을 y좌표 기준으로 정렬
		Collections.sort(list, Ycomp);
		
		// 후보군들을 순회하면서 y좌표 차이가 midDist내에 있는 원소들만 거리 측정
		int yDist;
		for(int i=0; i<list.size()-1; i++) {
			for(int j=i+1; j<list.size(); j++) {
				
				/*
				 * i번째 점과 j번째 점을 비교하여 y좌표거리를 측정한다.
				 * 측정된 y좌표거리가 minDist보다 작다면
				 * i, j 점의 거리를 측정하여 midDist와 측정한 거리 중
				 * 작은 값으로 갱신한다.  
				 */
				yDist = list.get(i).y - list.get(j).y;
				
				if(yDist * yDist < minDist) {
					minDist = Math.min(dist(list.get(i), list.get(j)), minDist);
				}
				
				/*
				 *  그 외는 y좌표 차이가 midDist보다 크다는 의미로 i번째 원소에 대한
				 *  측정을 멈추고 다음 점으로 넘어간다. 
				 */
				else {
					break;
				}
			}
		}
		
		return minDist;
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("첫째 줄에 자연수 n(2 ≤ n ≤ 100,000)을, 다음 n개의 줄에는 차례로 각 점의 x, y좌표를 입력하세요.\n"
				+ "(단, 각의 좌표는 절댓값이 10,000을 넘지 않는 정수)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// class Point 객체 생성
		p = new Point[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(p, Xcomp);
		
		System.out.println(closest(0, N-1));
	}
}
