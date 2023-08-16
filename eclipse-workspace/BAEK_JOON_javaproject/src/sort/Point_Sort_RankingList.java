package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/* Coordinate Compression(좌표압축)
 * 수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용
 * Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수와 같아야 
 * 
 * 첫째 줄에 N이 주어지고, 둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.
 */
public class Point_Sort_RankingList {
	
	// 좌표압축 메소드
	static void CoordinateCompress(int N, BufferedReader br) throws IOException {
		
		// 둘째줄에 입력받은 N개의 좌표를 입력받은 원본배열
		int[] OriginArr = new int [N];
		// 정렬할 배열 선언
		int[] SortedArr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 정렬될 배열과 원본배열에 값을 넣어줌
		for (int i=0; i<N; i++) {
			SortedArr[i]=OriginArr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 배열의 rank를 매길 HashMap
		HashMap<Integer, Integer> rankMap = new HashMap<Integer, Integer>();
		
		// 입력받은 원본배열에 대해 정렬 수행
		Arrays.sort(SortedArr);
		
		// 정렬된 배열을 순회하면서 map에 넣어줌
		int rank = 0;
		for (int value : SortedArr) {
			
			/*
			 *  이 때 만약 앞선 원소가 이미 순위가 매겨졌다면
			 *  중복되면 안되므로, 원소가 중복되지 않을 때만
			 *  map에 원소와 그에 대응되는 순위를 넣어준다.
			 */
			if(!rankMap.containsKey(value)) {
				rankMap.put(value, rank);
				// map에 넣고 난 후, 다음 순위를 가리킬 수 있도록 1++
				rank++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int keyval : OriginArr) {
			// 원본 배열 원소(key)에 대한 value(순위)를 갖고온다.
			int ranking = rankMap.get(keyval);
			sb.append(ranking).append(' ');
		}
		System.out.println(sb);
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("첫째 줄에 N을, \n"
				+ "둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN을 입력하시오.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력받은 N
		int N = Integer.parseInt(br.readLine());
		
		// 좌표압축 메소드 사용하여 정렬 후 출력
		CoordinateCompress(N, br);
	}
}
