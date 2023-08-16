package combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/* 해빈이가 가진 의상들이 주어졌을때 과연 해빈이는 알몸이 아닌 상태로 의상을 입을 수 있는 경우를 출력하는 프로그램
 * 
 * 한 번 입었던 '조합'은 다시 입지 않는다는 것과, 옷의 종류가 중복되게 입을 수 없다는 것
 * => 조합문제
 * 알몸이 아닌 상태로 며칠까지 가능한지 => 두 종류 모두 안 입는 경우가 있기 때문에 마지막에 1을 빼주어야 함
 * 
 * 종류 k에 대한 옷의 개수가 N개일 때,
 * 경우의 수 = (N1 + 1) × (N2 + 1) × ⋯ × (Nk-1 + 1) × (Nk + 1) - 1
 * 			- 각 종류별 입지 않는 경우를 고려하여 각 종류별 개수 + 1
 * 			- 최종 값에 알몸인 상태(모든 종류를 입지 않은 상태)를 제외해야 하므로 -1 을 빼준다.
 * 
 *  종류별로 개수를 세기 위해,HashMap 클래스 사용
 *  * HashMap<Key, Value> 형식으로, Key에 대해 hash함수를 돌려서 고유한 값을 갖도록 하고, 
 *    해당 값에 대한 데이터를 저장
 *    - 옷 종류로 들어오는 입력값을 해시함수로 돌려서 해당 고유값을 배열에 저장하고 사용 가능
 */
public class CombinationCloth_HashMap {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("첫째 줄에 테스트 케이스(최대 100)를 입력하고,\n"
				+ "각 테스트 케이스의 첫째 줄에는 해빈이가 가진 의상의 수 n(0 ≤ n ≤ 30)를 \n"
				+ "다음 n개에는 해빈이가 가진 의상의 이름과 의상의 종류를 공백으로 구분하여 입력하세요.");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 케이스
		int T = Integer.parseInt(br.readLine());
		
		while(T-- >0) {
			
			// 종류별로 개수를 세기위해 HashMap클래스 사용<종류, 개수>
			HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
			
			// 입력받는 옷의 개수
			int N = Integer.parseInt(br.readLine());
			
			while (N-- >0) {
				
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				// 옷 이름은 필요 없음
				st.nextToken();
				
				// 옷 종류를 입력받음
				String kind = st.nextToken();
				
				/**
				 * 해당 종류의 옷이 해시맵에 있을경우
				 * 해시맵에 저장되어있던 해당 종류의 개수를 +1 증가시킨다.
				 *
				 * 해당 종류의 옷이 해시맵에 없을 경우
				 * 해당 종류와 개수 1을 넣는다.
				 */
				if(hashmap.containsKey(kind)) {
					hashmap.put(kind, hashmap.get(kind)+1);
				} else {
					hashmap.put(kind, 1);
				}
			}
			
			/**
			 * 안 입는 경우를 고려하여 각 종류별 옷의 개수에 +1 해준 값을
			 * 곱해주어야 한다.
			 */
			int result = 1;
			for (int value : hashmap.values()) {
				result *= (value + 1);
			}
			
			// 알몸인 상태를 제외해주어야 하므로 최종값에 -1이 정답.
			System.out.println(result - 1);
		}
	}
}
