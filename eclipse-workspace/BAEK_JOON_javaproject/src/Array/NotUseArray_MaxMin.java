package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N개의 정수가 주어진다. 이때 최솟값과 최댓값을 구하는 프로그램
// 배열을 굳이 쓸 필요X => 입력받은 문자를 즉시 비교하는 코드
public class NotUseArray_MaxMin {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		System.out.println("정수 N을 입력하세요.(1 <= N <= 1,000,000)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력만 받음
		// 첫줄은 N으로 쓰이지 않기 때문에 입력만 받는것으로 처리
		Integer.parseInt(br.readLine());
		
		// 입력받은 값을 StringTokenizer을 사용해 " "공백을 기준으로 구분
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 초기값 max와 min을 막대하게 큰 수로 정의
		int max = -1000001;	// 막대하게 작은수를 max에 할당
		int min = 1000001; 	// 막대하게 큰 수를 min에 할당
		
		//hasMoreTokens()메소드를 활용해 남은 토큰이 존재하면 true반환하게 함
		while(st.hasMoreTokens()) {
			int value = Integer.parseInt(st.nextToken());
			if (value > max) {
				// 받아온 value값이 기존 max값보다 크면 max로 할당(업데이트)
				max = value;
			}
			if (value < min) {
				// 받아온 value값이 기존 min값보다 작으면 min으로 할당(업데이트)
				min = value;
			}
		}
		System.out.println(min + " " + max);
	}

}
