package Method;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// 가장 가까운 두 점 구하는 프로그램
// 첫째 줄에 자연수(2<=n<=100000)이 주어짐, 다음 n개의 줄에는 차례로x,y좌표가 주어짐
// 각 좌표는 절대값이 10,000을 넘지 않는 정수
// Point(좌표)클래스 정의
class Point {
	// 필드 - 좌표선언
	int x;
	int y;
	
	// 생성자
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

// 첫째 줄에 가장 가까운 두 점의 거리의 제곱을 출력
class PointEx {
	
	// Point클래스의 배열선언
	static Point[] p;
	
	// PointEx클래스의 객체 배열선언 => 다양한 Point객체들을 관리가능
	PointEx(int N) {
		p = new Point[N];
	}

	// 메소드
	// pow메소드 - 제곱수 출력
	static int pow(int value) {
		return value * value;
	}

	// dist메소드 - 두 point사이의 거리를 반환하는 메소드
	// 두 Point의 거리를 반환하는 메소드 (x^2 + y^2)
	static int dist(Point o1, Point o2) {
		return (int) Math.sqrt(pow(o1.x - o2.x) + pow(o1.y - o2.y));
	}

	// Y좌표를 오름차순으로 정렬하는 Comparator 익명객체
	static Comparator<Point> Ycomp = new Comparator<Point>() {
		@Override
		public int compare(Point o1, Point o2) {
			return o1.y - o2.y;
		}
	};
	
	// X좌표를 오름차순으로 정렬하는 Comparator 익명객체
	static Comparator<Point> Xcomp = new Comparator<Point>() {
		@Override
		public int compare(Point o1, Point o2) {
			return o1.x - o2.x;
		}
	};

	
	// brute메소드 - 브루트포스 방식으로 모든 점 쌍의 거리를 계산하여 가장 가까운 두 점의 거리를 찾는 메소드
	static int brute(int start, int end) {
		// start부터 end까지의 모든 점 쌍의 거리를 계산하고 최소 거리를 찾아 반환
		int minDist = Integer.MAX_VALUE;

		for (int i = start; i < end; i++) {
			for (int j = i + 1; j <= end; j++) {
				minDist = Math.min(minDist, dist(p[i], p[j]));
			}
		}
		return minDist;
	}

	// closest메소드 - 분할정복을 이용하여 가장 가까운 두 점의 거리를 찾는 중심 메소드
	static int closest(int start, int end) {
		
		// Point[start] ~ Point[end] 원소가 3개 이하라면 브루트포스 방식으로 거리 반환
		if (end - start + 1 < 4) {
			return brute(start, end);
		}

		// 가운데 index를 구함
		int midIdx = (start + end) / 2;

		// left는 start~mid, right는 mid+1~end로 분할 검색
		int left = closest(start, midIdx);
		int right = closest(midIdx + 1, end);

		// 각 각의 거리 중 최소값을 구한 뒤 반환
		int minDist = Math.min(left, right);
		
		// 중간 영역의 최소 거리
		int band = middleBand(start, midIdx, end, minDist);
		return Math.min(minDist, band);	// 둘 중 작은 값을 반환
	}

	static int middleBand(int start, int mid, int end, int minDist) {
		int xDist;

		// index 참조가 많으므로 ArrayList를 활용
		ArrayList<Point> list = new ArrayList<Point>();

		// 후보군 추출
		int midX = p[mid].x; // mid인덱스의 x좌표
		for (int i = start; i <= end; i++) {
			xDist = p[i].x - midX; // x좌표 차이

			// xDist < midDist이면 후보군 리스트에 넣음
			if (xDist * xDist < minDist) {
				list.add(p[i]);
			}
		}

		// 후보군들을 y좌표 기준으로 정렬
		Collections.sort(list, Ycomp);

		// 후보군들을 순회하면서 y좌표 차이가 midDist내에 있는 원소들만 거리 측정
		int yDist;
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				// i번째 점과 j번째 점을 비교하여 y좌표거리를 측정
				yDist = list.get(i).y - list.get(j).y;
				
				// 만약 측정된 y좌표거리가 minDist보다 작다면
				if (yDist * yDist < minDist) {
					// i, j점의 거리를 측정하여 minDist와 측정한 거리 중 작은값으로 갱신
					minDist = Math.min(dist(list.get(i), list.get(j)), minDist);
				} else {
					// 그외는 y좌표차이가 midDist보다 크다는 의미로 i번째 원소에 대한 측정 멈춤
					break;	// 다음 점으로 넘어감
				}
			}
		}
		return minDist;
	}
	
    // Point 객체 배열을 초기화하는 메소드
    public void setPoints(Point[] points) {
        for (int i = 0; i < points.length; i++) {
            p[i] = points[i];
        }
    }

}

public class ClosestPoint_Method {
	
	// 가장 가까운 두 점을 찾는 알고리즘을 구현하는 main메소드 코드
	public static void main(String[] args) {
		 
		Scanner sc = new Scanner(System.in);
		
		// 주어진 입력을 받아 Point배열을 초기화 
		System.out.println("첫째줄에 가장 가까운 두 점의 거리의 제곱을 출력하는 프로그램");
		System.out.println("첫째 줄에 자연수n(2<=n<=100,000)이 주어지고, "
				+ "\n 다음 n개의 줄에는 차례로 각 점의 x, y좌표가 주어진다.");
 
		// 첫번째 줄에서 입력받은 자연수N
		int N = sc.nextInt();
		
		// PointEx 클래스의 객체를 생성하고 Point 배열을 초기화
		PointEx pointEx = new PointEx(N);
		// Point객체를 N개 저장할 1차원 배열 생성
		// Point클래스의 객체 배열선언 => 다양한 Point객체들을 관리가능
		Point[] points = new Point[N];
		
		// 배열 p에 N개의 좌표들을 입력받고, Point객체를 생성해 배열에 저장
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			points[i] = new Point(x, y);
		}
 
		// PointEx 클래스의 setPoints 메소드를 사용하여 Point 배열을 초기화
        pointEx.setPoints(points);
		
        // closest 메소드 호출
		Arrays.sort(points, PointEx.Xcomp);
		System.out.println(PointEx.closest(0, N - 1));
		
		sc.close();
	}
}